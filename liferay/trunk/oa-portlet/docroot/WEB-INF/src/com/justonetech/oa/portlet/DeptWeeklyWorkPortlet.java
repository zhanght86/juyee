package com.justonetech.oa.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.model.DeptWorkItem;
import com.justonetech.oa.service.DeptWorkItemLocalServiceUtil;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DeptWeeklyWorkPortlet
 */
public class DeptWeeklyWorkPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(OfficeSupplyApplicationPortlet.class);
	private static String timeFormatPattern = PropsUtil.get("default.date.format.pattern");
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		long userId = PortalUtil.getUserId(renderRequest);
		String userName = PortalUtil.getUserName(userId, "");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<DeptWork> deptWorks = Collections.emptyList();
		try {
			deptWorks = DeptWorkLocalServiceUtil.findByUserName(userName, start, end);
		} catch (SystemException e) {
			log.error("findByUserNam(" + userName + "," + start + "," + end + ")错误：" + e.getMessage());
		}
		int deptWorkCount = 0;
		try {
			deptWorkCount = DeptWorkLocalServiceUtil.countByUserName(userName);
		} catch (SystemException e) {
			log.error("countByUserNam(" + userName + ")错误：" + e.getMessage());
		}
		renderRequest.setAttribute("deptWorks", deptWorks);
		renderRequest.setAttribute("deptWorkCount", deptWorkCount);
		super.doView(renderRequest, renderResponse);
	}

	public void saveDeptWork(ActionRequest request, ActionResponse response) throws SystemException, PortalException,
			ParseException {
		String type = ParamUtil.getString(request, "type");
		String status = null;
		if(type.equals("submit")){
			status = "提交";
		}else{
			status = "填写";
		}
		long deptWorkId = ParamUtil.getLong(request, "deptWorkId");
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormatPattern);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "");
		String deptName = ParamUtil.getString(request, "deptName");
		String startdate = ParamUtil.getString(request, "startDate");
		Date startDate = sdf.parse(startdate);
		String enddate = ParamUtil.getString(request, "endDate");
		Date endDate = sdf.parse(enddate);
		Date now = new Date();
		DeptWork deptWork = null;
		if (Validator.isNotNull(deptWorkId)) {
			deptWork = DeptWorkLocalServiceUtil.getDeptWork(deptWorkId);
			deptWork.setModifiedTime(now);
		} else {
			deptWork = DeptWorkLocalServiceUtil.createDeptWork(CounterLocalServiceUtil.increment());
			deptWork.setCreateTime(now);
			deptWork.setModifiedTime(now);
		}
		deptWork.setDeptName(deptName);
		deptWork.setUserId(userId);
		deptWork.setUserName(userName);
		deptWork.setDeptName(deptName);
		deptWork.setStartDate(startDate);
		deptWork.setEndDate(endDate);
		deptWork.setStatus(status);
		DeptWorkLocalServiceUtil.updateDeptWork(deptWork);

		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);
		for (DeptWorkItem deptWorkItem : deptWorkItems) {
			DeptWorkItemLocalServiceUtil.deleteDeptWorkItem(deptWorkItem);
		}

		String rowIndexes = request.getParameter("rowIndexes");
		String[] indexOfRows = rowIndexes.split(",");
		for (int i = 0; i < indexOfRows.length; i++) {
			DeptWorkItem deptWorkItem = DeptWorkItemLocalServiceUtil.createDeptWorkItem(CounterLocalServiceUtil
					.increment());
			int sortNo = ParamUtil.getInteger(request, "sortNo" + indexOfRows[i]);
			String dutyPerson = ParamUtil.getString(request, "dutyPerson" + indexOfRows[i]);
			String mainWork = ParamUtil.getString(request, "mainWork" + indexOfRows[i]);
			String content = ParamUtil.getString(request, "content" + indexOfRows[i]);
			String schedule = ParamUtil.getString(request, "schedule" + indexOfRows[i]);
			String agentPerson = ParamUtil.getString(request, "agentPerson" + indexOfRows[i]);
			deptWorkItem.setDeptWorkId(deptWork.getDeptWorkId());
			deptWorkItem.setSortNo(sortNo);
			deptWorkItem.setDutyPerson(dutyPerson);
			deptWorkItem.setMainWork(Boolean.parseBoolean(mainWork));
			deptWorkItem.setSchedule(schedule);
			deptWorkItem.setContent(content);
			deptWorkItem.setAgentPerson(agentPerson);
			DeptWorkItemLocalServiceUtil.updateDeptWorkItem(deptWorkItem);
		}
	}

	public void editDeptWeeklyWork(ActionRequest request, ActionResponse response) throws IOException,
			PortletException, PortalException, SystemException {
		Long deptWorkId = ParamUtil.getLong(request, "deptWorkId");
		DeptWork deptWork = DeptWorkLocalServiceUtil.getDeptWork(deptWorkId);
		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);
		request.setAttribute("deptWork", deptWork);
		request.setAttribute("deptWorkItems", deptWorkItems);
	}

	public void deleteDeptWeeklyWork(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long deptWorkId = ParamUtil.getLong(request, "deptWorkId");
		DeptWorkLocalServiceUtil.deleteDeptWork(deptWorkId);
		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);
		for (DeptWorkItem deptWorkItem : deptWorkItems) {
			DeptWorkItemLocalServiceUtil.deleteDeptWorkItem(deptWorkItem);
		}
	}

	public void viewDeptWeeklyWork(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		Long deptWorkId = ParamUtil.getLong(request, "deptWorkId");
		System.out.println("===================="+deptWorkId);
		DeptWork deptWork = DeptWorkLocalServiceUtil.getDeptWork(deptWorkId);
		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);
		request.setAttribute("deptWork", deptWork);
		request.setAttribute("deptWorkItems", deptWorkItems);
	}
}
