package com.justonetech.biz.controller.project;

import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.*;
import com.justonetech.biz.domain.ProjBid;
import com.justonetech.biz.domain.ProjBidArea;
import com.justonetech.biz.domain.ProjInfo;
import com.justonetech.biz.domain.ProjInfoArea;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.utils.enums.ProjBidType;
import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.utils.*;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCode;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SimpleQueryManager;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * note:项目基本信息管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class ProjInfoController extends BaseCRUDActionController<ProjInfo> {
    private Logger logger = LoggerFactory.getLogger(ProjInfoController.class);

    @Autowired
    private SysUserManager sysUserManager;

    @Autowired
    private SysCodeManager sysCodeManager;

    @Autowired
    private ConfigManager configManager;

    @Autowired
    private DocumentManager documentManager;

    @Autowired
    private SimpleQueryManager simpleQueryManager;

    @Autowired
    private ProjBidAreaService projBidAreaService;

    @Autowired
    private SysCodeDetailService sysCodeDetailService;

    @Autowired
    private ProjInfoService projInfoService;

    @Autowired
    private ProjInfoAreaService projInfoAreaService;

    @Autowired
    private ProjBidService projBidService;

    /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
        //判断是否有编辑权限
        model.addAttribute("canEdit", sysUserManager.hasPrivilege(PrivilegeCode.PROJ_INFO_EDIT));
        model.addAttribute("TYPE_STAGE", ProjBidType.TYPE_STAGE.getCode());
        model.addAttribute("TYPE_NODE", ProjBidType.TYPE_NODE.getCode());

        return "view/project/projInfo/grid";
    }

    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters  .
     * @param columns  .
     * @param page     .
     * @param rows     .
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from ProjInfo order by id desc";

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = projInfoService.findByPage(pageModel, query);

            //输出显示
            String json = GridJq.toJSON(columns, pageModel);
            sendJSON(response, json);

        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
        }
    }

    /**
     * 新增录入页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String add(Model model) {
        ProjInfo projInfo = new ProjInfo();
        //如需增加其他默认值请在此添加
        Calendar c = Calendar.getInstance();
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(c.get(Calendar.YEAR) + "");
        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("bean", projInfo);

        return "view/project/projInfo/input";
    }

    /**
     * 修改显示页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String modify(Model model, Long id) {
        ProjInfo projInfo = projInfoService.get(id);
        String yearSelectOptions = DateTimeHelper.getYearSelectOptions(projInfo.getYear() + "");
        //处理其他业务逻辑
        model.addAttribute("yearSelectOptions", yearSelectOptions);
        model.addAttribute("bean", projInfo);
        model.addAttribute("areas", projInfo.getBelongAreaNames());

        return "view/project/projInfo/input";
    }

    /**
     * 查看页面
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String view(Model model, Long id) {
        ProjInfo projInfo = projInfoService.get(id);

        model.addAttribute("bean", projInfo);
        model.addAttribute("areas", projInfo.getBelongAreaNames());
        return "view/project/projInfo/view";
    }

    /**
     * 查看标段信息
     *
     * @param id    .
     * @param model .
     * @return .
     */
    @RequestMapping
    public String viewBid(Model model, Long id, String typeCode) {
        ProjInfo projInfo = projInfoService.get(id);

        List<ProjBid> ret = new ArrayList<ProjBid>();
        Set<ProjBid> projBids = projInfo.getProjBids();
        for (ProjBid projBid : projBids) {
            if (JspHelper.getString(typeCode).equals(JspHelper.getString(projBid.getTypeCode()))) {
                ret.add(projBid);
            }
        }
        model.addAttribute("projBids", ret);
        model.addAttribute("areas", projInfo.getBelongAreaNames());

        return "view/project/projInfo/viewBid";
    }

    /**
     * 保存操作
     *
     * @param response .
     * @param entity   .
     * @param request  .
     * @throws Exception .
     */
    @SuppressWarnings("unchecked")
    @RequestMapping
    public void save(HttpServletResponse response, @ModelAttribute("bean") ProjInfo entity, HttpServletRequest request) throws Exception {
        try {
            ProjInfo target;
            if (entity.getId() != null) {
                target = projInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                        "name",
//                        "year",
                        "no",
                        "buildMileage",
                        "location",
                        "startDate",
//                        "intro",
                        "jsDept",
                        "sgDept",
                        "sgDeptPerson",
                        "sgDeptTel",
                        "jlDept",
                        "jlDeptPerson",
                        "jlDeptTel"
                });

            } else {
                target = entity;
            }

            String year = request.getParameter("year");
            String projProperty = request.getParameter("ProjProperty");
            String projStage = request.getParameter("ProjStage");
            String projCategory = request.getParameter("ProjCategory");
            String[] areaIds = request.getParameterValues("ProjBelongArea");
            String intro = request.getParameter("intro");
            target.setYear(Integer.valueOf(year));
            target.setProperty(sysCodeDetailService.get(Long.valueOf(projProperty)));
            target.setStage(sysCodeDetailService.get(Long.valueOf(projStage)));
            target.setCategory(sysCodeDetailService.get(Long.valueOf(projCategory)));
            target.setIntro(intro);
            projInfoService.save(target);

            //保存区县前删除保存过的信息
            for (ProjInfoArea projInfoArea : target.getProjInfoAreas()) {
                projInfoAreaService.delete(projInfoArea);
            }
            Set<SysCodeDetail> areas = new HashSet<SysCodeDetail>();
            if (areaIds != null && areaIds.length > 0) {
                for (String areaId : areaIds) {
                    if (!StringHelper.isEmpty(areaId)) {
                        SysCodeDetail sysCodeDetail = sysCodeDetailService.get(Long.valueOf(areaId));
                        ProjInfoArea projInfoArea = new ProjInfoArea();
                        projInfoArea.setBelongArea(sysCodeDetail);
                        projInfoArea.setProject(target);
                        projInfoAreaService.save(projInfoArea);
                        areas.add(sysCodeDetail);
                    }
                }
            }

            //添加和修改项目时判断如果下面没有标段则自动创建一个形象进度标段，并且默认标段的所属区县与项目一致
            Set<ProjBid> projBids = target.getProjBids();
            if (null == projBids || projBids.size() == 0) {
                ProjBid projBid = new ProjBid();
                projBid.setTypeCode(ProjBidType.TYPE_NODE.getCode());
                projBid.setName(target.getName());
                projBid.setCode("1");
                projBid.setProject(target);
                projBidService.save(projBid);

                for (SysCodeDetail area : areas) {
                    ProjBidArea projBidArea = new ProjBidArea();
                    projBidArea.setBelongArea(area);
                    projBidArea.setBid(projBid);
                    projBidAreaService.save(projBidArea);
                }
            }
        } catch (Exception e) {
            log.error("error", e);
            super.processException(response, e);
            return;
        }
        sendSuccessJSON(response, "保存成功");
    }

    /**
     * 删除操作
     *
     * @param response .
     * @param id       .
     * @throws Exception .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        projInfoService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}