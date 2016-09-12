package com.justonetech.cp.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.complete.model.Complete;
import com.justonetech.cp.complete.service.CompleteLocalServiceUtil;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CompleteApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(CompleteApplicationPortlet.class);
	private static String dateFormatPattern = PropsUtil
			.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zzjgdm = Validator.isNull(user) ? "" : user.getScreenName();
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zt = ParamUtil.getString(renderRequest, "zt");
		int defaultDelta = GetterUtil.getInteger(PropsUtil
				.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<Complete> completes = new ArrayList<Complete>();
		int completesCount = 0;

		completes = CompleteLocalServiceUtil.getCompletes(zzjgdm, bjbh, wssqbh,
				gcmc, start, end);
		completesCount = CompleteLocalServiceUtil.getCompletesCount(zzjgdm,
				bjbh, wssqbh, gcmc);

		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gemc", gcmc);
		renderRequest.setAttribute("zt", zt);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("completes", completes);
		renderRequest.setAttribute("completesCount", completesCount);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath,
				"/portlet/complete-application/select-project.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
			String xmmc = ParamUtil.getString(renderRequest, "xmmc");
			Date bjrqStart = ParamUtil.getDate(renderRequest, "bjrqStart",
					new SimpleDateFormat(dateFormatPattern), null);
			Date bjrqEnd = ParamUtil.getDate(renderRequest, "bjrqEnd",
					new SimpleDateFormat(dateFormatPattern), null);
			String bjwcbj = ParamUtil.getString(renderRequest, "bjwcbj");
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("wssqbh", wssqbh);
			renderRequest.setAttribute("xmmc", xmmc);
			renderRequest.setAttribute("bjrqStart", bjrqStart);
			renderRequest.setAttribute("bjrqEnd", bjrqEnd);
			renderRequest.setAttribute("bjwcbj", bjwcbj);
			int projectsCount = 0;
			int defaultDelta = GetterUtil.getInteger(PropsUtil
					.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta",
					defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			List<Project> projects = ProjectLocalServiceUtil.getProjects("",
					bjbh, wssqbh, xmmc, bjrqStart, bjrqEnd, bjwcbj, start, end);
			projectsCount = ProjectLocalServiceUtil.getProjectsCount("", bjbh,
					wssqbh, xmmc, bjrqStart, bjrqEnd, bjwcbj);
			renderRequest.setAttribute("projects", projects);
			renderRequest.setAttribute("projectsCount", projectsCount);
		} else if (Validator.equals(mvcPath,
				"/portlet/complete-application/edit-complete.jsp")) {
		}
		super.render(renderRequest, renderResponse);
	}

}