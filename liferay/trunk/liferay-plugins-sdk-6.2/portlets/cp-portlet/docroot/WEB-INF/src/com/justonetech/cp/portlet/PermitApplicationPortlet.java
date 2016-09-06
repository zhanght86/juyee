package com.justonetech.cp.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PermitApplicationPortlet
 */
public class PermitApplicationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/permit-application/select-contract.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh", "");
			String bdh = ParamUtil.getString(renderRequest, "bdh", "");
			String htmc = ParamUtil.getString(renderRequest, "htmc", "");
			String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm", "");
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("bdh", bdh);
			renderRequest.setAttribute("htmc", htmc);
			renderRequest.setAttribute("zzjgdm", zzjgdm);
			List<Contract> ybssgzbContracts = new ArrayList<Contract>();
			int ybssgzbContractsCount = 0;
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			ybssgzbContracts = ContractLocalServiceUtil.getYbssgzbContracts(zzjgdm, bjbh, bdh, htmc, start, end);
			ybssgzbContractsCount = ContractLocalServiceUtil.getYbssgzbContractsCount(zzjgdm, bjbh, bdh, htmc);
			renderRequest.setAttribute("ybssgzbContracts", ybssgzbContracts);
			renderRequest.setAttribute("ybssgzbContractsCount", ybssgzbContractsCount);
		} else if (Validator.equals(mvcPath, "/portlet/permit-application/edit-permit.jsp")) {

			// String projectId = ParamUtil.getString(renderRequest,
			// "projectId", "");
			// long contractId = ParamUtil.getLong(renderRequest, "contractId",
			// 0);
			// long permitId = ParamUtil.getLong(renderRequest, "permitId", 0);
			// Project project = null;
			// Contract contract = null;
			// Permit permit = null;
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			Long permitId = ParamUtil.getLong(renderRequest, "permitId");
			String bdh = ParamUtil.getString(renderRequest, "bdh");
			String contractId = ParamUtil.getString(renderRequest, "contractId");
			int sqbz = ParamUtil.getInteger(renderRequest, "sqbz", 1);
			renderRequest.setAttribute("sqbz", sqbz);
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("permitId", permitId);
			renderRequest.setAttribute("bdh", bdh);
			Project project = null;
			ProjectProfile projectProfile = null;
			Contract contract = null;
			try {
				if (permitId != 0) {
					projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
					renderRequest.setAttribute("xmmc", projectProfile.getGcmc());
				} else {
					project = ProjectLocalServiceUtil.getProject(bjbh);
					renderRequest.setAttribute("xmmc", project.getXmmc());
				}
				if (Validator.isNotNull(contractId)) {
					contract = ContractLocalServiceUtil.getContract(contractId);
					renderRequest.setAttribute("contract", contract);
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (sqbz == 1) {

			} else if (sqbz == 2) {
//				ParticipationUnitLocalServiceUtil
				if (Validator.isNotNull(permitId)) {
					ParticipationUnit participationUnit = null;
//					participationUnit
				}

			} else if (sqbz == 3) {
				List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
				renderRequest.setAttribute("unitProjects", unitProjects);
			} else if (sqbz == 4) {

			}
			// try {
			// project = ProjectLocalServiceUtil.getProject(projectId);
			// contract = ContractLocalServiceUtil.getContract(contractId);
			// permit = PermitLocalServiceUtil.getPermit(permitId);
			//
			// sqbz = permit.getSqbz();
			// }
			// catch (PortalException | SystemException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			// String bdh = ParamUtil.getString(renderRequest, "bdh");
			// String htmc = ParamUtil.getString(renderRequest, "htmc");
			// List<Contract> contracts = new ArrayList<Contract>();
			// int contractsCount = 0;
			// renderRequest.setAttribute("contracts", contracts);
			// renderRequest.setAttribute("contractsCount", contractsCount);
		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;

		List<Permit> permits = new ArrayList<Permit>();
		int permitsCount = 0;
		permits = PermitLocalServiceUtil.getPermits(zzjgdm, bjbh, wssqbh, gcmc, start, end);
		permitsCount = PermitLocalServiceUtil.getPermitsCount(zzjgdm, bjbh, wssqbh, gcmc);
		renderRequest.setAttribute("permits", permits);
		renderRequest.setAttribute("permitsCount", permitsCount);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		super.doView(renderRequest, renderResponse);
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException {
		String jsdwmc = ParamUtil.getString(request, "jsdwmc");
		String jsdwxz = ParamUtil.getString(request, "jsdwxz");
		String jsdwdz = ParamUtil.getString(request, "jsdwdz");
		String gcmc = ParamUtil.getString(request, "gcmc");
		String jsdd = ParamUtil.getString(request, "jsdd");
		String jsgcgm = ParamUtil.getString(request, "jsgcgm");
		String fwjzmj = ParamUtil.getString(request, "fwjzmj");
		String htjg = ParamUtil.getString(request, "htjg");
		int htgq = ParamUtil.getInteger(request, "htgq");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String jsdwlxdh = ParamUtil.getString(request, "jsdwlxdh");
		String jsdwlxr = ParamUtil.getString(request, "jsdwlxr");
		String jsdwsjh = ParamUtil.getString(request, "jsdwsjh");
		String jsydpzwjhfdccqzbh = ParamUtil.getString(request, "jsydpzwjhfdccqzbh");
		String jsgcghxkzbh = ParamUtil.getString(request, "jsgcghxkzbh");
		String xckgqk = ParamUtil.getString(request, "xckgqk");
		Long permitId = ParamUtil.getLong(request, "permitId");
		String bjbh = ParamUtil.getString(request, "bjbh");
		String bdh = ParamUtil.getString(request, "bdh");
		int sqbz = ParamUtil.getInteger(request, "sqbz");
		ProjectProfile projectProfile = null;
		Permit permit = null;
		if (permitId != 0) {
			projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			permit = PermitLocalServiceUtil.getPermit(permitId);
		} else {
			projectProfile = ProjectProfileLocalServiceUtil.createProjectProfile(CounterLocalServiceUtil.increment());
			permit = PermitLocalServiceUtil.createPermit(projectProfile.getPermitId());
		}
		projectProfile.setJsdwmc(jsdwmc);
		projectProfile.setJsdwxz(jsdwxz);
		projectProfile.setJsdwdz(jsdwdz);
		projectProfile.setGcmc(gcmc);
		projectProfile.setJsdd(jsdd);
		projectProfile.setJsgcgm(jsgcgm);
		projectProfile.setFwjzmj(fwjzmj);
		projectProfile.setHtjg(htjg);
		projectProfile.setHtgq(htgq);
		projectProfile.setFddbr(fddbr);
		projectProfile.setJsdwlxdh(jsdwlxdh);
		projectProfile.setJsdwlxr(jsdwlxr);
		projectProfile.setJsdwsjh(jsdwsjh);
		projectProfile.setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
		projectProfile.setXckgqk(xckgqk);
		ProjectProfileLocalServiceUtil.updateProjectProfile(projectProfile);
		permit.setBjbh(bjbh);
		permit.setSqbz(sqbz);
		permit.setBdh(bdh);
		PermitLocalServiceUtil.updatePermit(permit);
	}

	public void saveUnitProjects(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException {
		Long permitId = ParamUtil.getLong(request, "permitId");
		List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (UnitProject unitProject : unitProjects) {
			UnitProjectLocalServiceUtil.deleteUnitProject(unitProject);
		}
		String bjbh = ParamUtil.getString(request, "bjbh");
		String[] gcbhs = ParamUtil.getParameterValues(request, "gcbh");
		String[] gcmcs = ParamUtil.getParameterValues(request, "gcmc");
		String[] jsnrs = ParamUtil.getParameterValues(request, "jsnr");
		for (int i = 0; i < gcbhs.length - 1; i++) {
			UnitProject unitProject = UnitProjectLocalServiceUtil
					.createUnitProject(CounterLocalServiceUtil.increment());
			unitProject.setBjbh(bjbh);
			unitProject.setPermitId(permitId);
			unitProject.setGcbh(gcbhs[i]);
			unitProject.setGcmc(gcmcs[i]);
			unitProject.setJsnr(jsnrs[i]);
			UnitProjectLocalServiceUtil.addUnitProject(unitProject);
		}
	}
}
