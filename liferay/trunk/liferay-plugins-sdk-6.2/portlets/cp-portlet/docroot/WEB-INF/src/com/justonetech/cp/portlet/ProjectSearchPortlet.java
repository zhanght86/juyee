
package com.justonetech.cp.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

/**
 * Portlet implementation class ProjectSearchPortlet
 */
public class ProjectSearchPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(ProjectSearchPortlet.class);

	private static String dateFormatPattern = "yyyy-MM-dd";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		}
		catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zzjgdm = Validator.isNull(user) ? "" : user.getScreenName();
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String bjWebid = ParamUtil.getString(renderRequest, "bjWebid");
		String xmmc = ParamUtil.getString(renderRequest, "xmmc");
		Date bjrqStart = ParamUtil.getDate(renderRequest, "bjrqStart", new SimpleDateFormat(dateFormatPattern), null);
		Date bjrqEnd = ParamUtil.getDate(renderRequest, "bjrqEnd", new SimpleDateFormat(dateFormatPattern), null);
		String bjwcbj = ParamUtil.getString(renderRequest, "bjwcbj");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;

		List<Project> projects = ProjectLocalServiceUtil.getProjects(zzjgdm, bjbh, bjWebid, xmmc, bjrqStart, bjrqEnd, bjwcbj, start, end);
		int projectsCount = ProjectLocalServiceUtil.getProjectsCount(zzjgdm, bjbh, bjWebid, xmmc, bjrqStart, bjrqEnd, bjwcbj);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("bjWebid", bjWebid);
		renderRequest.setAttribute("xmmc", xmmc);
		renderRequest.setAttribute("bjrqStart", bjrqStart);
		renderRequest.setAttribute("bjrqEnd", bjrqEnd);
		renderRequest.setAttribute("bjwcbj", bjwcbj);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("projects", projects);
		renderRequest.setAttribute("projectsCount", projectsCount);
		super.doView(renderRequest, renderResponse);
	}

}
