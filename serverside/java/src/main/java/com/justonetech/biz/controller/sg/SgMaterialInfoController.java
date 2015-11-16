package com.justonetech.biz.controller.sg;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

import com.justonetech.core.controller.BaseCRUDActionController;
import com.justonetech.core.orm.hibernate.Page;
import com.justonetech.core.ui.grid.Grid;
import com.justonetech.core.utils.ReflectionUtils;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.utils.StringHelper;
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.SgMaterialInfoService;
import com.justonetech.biz.domain.SgMaterialInfo;

import com.justonetech.biz.manager.DocumentManager;
import com.justonetech.biz.utils.Constants;
import com.justonetech.biz.daoservice.DocDocumentService;
import com.justonetech.biz.manager.ConfigManager;
import com.justonetech.system.daoservice.SysCodeDetailService;
import com.justonetech.system.domain.SysCodeDetail;
import com.justonetech.system.manager.SysCodeManager;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import com.justonetech.system.manager.SimpleQueryManager;

import com.justonetech.system.tree.ZTreeBranch;
import com.justonetech.system.tree.ZTreeNode;
import com.justonetech.system.manager.SysUserManager;
import com.justonetech.system.utils.PrivilegeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * note:施工材料信息
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class SgMaterialInfoController extends BaseCRUDActionController<SgMaterialInfo> {
    private Logger logger = LoggerFactory.getLogger(SgMaterialInfoController.class);
    
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
    private DocDocumentService docDocumentService;

    @Autowired
    private SgMaterialInfoService sgMaterialInfoService;
    
    /**
     * 树+列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String init(Model model) {
         return "view/sg/sgMaterialInfo/init";
    }

    /**
     * 树显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String tree(Model model, HttpServletRequest request) {
    
        //判断是否有编辑权限
        model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
        
        //上下移动使用
        model.addAttribute("clazz", SgMaterialInfo.class.getName());

        return "view/sg/sgMaterialInfo/tree";
    }

    /**
     * 获取树数据
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String treeData(String type, String id, String icon, Model model) {
        ZTreeBranch treeBranch = new ZTreeBranch();
        treeBranch.setIcons(icon.split(","));

        if (StringUtils.isEmpty(id)) {
            treeBranch.addTreeNode(treeBranch.getRootNode("施工材料信息树"));
        } else if (StringUtils.equals(id, "root")) {
            String hql = "from SgMaterialInfo where parent.id is null order by treeId asc";
            List<SgMaterialInfo> nodeList = sgMaterialInfoService.findByQuery(hql);
            for (SgMaterialInfo data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getMaterialName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        } else if (StringUtils.equals(type, "data")) {
            String hql = "from SgMaterialInfo where parent.id=" + id + " order by treeId asc";
            List<SgMaterialInfo> nodeList = sgMaterialInfoService.findByQuery(hql);
            for (SgMaterialInfo data : nodeList) {
                ZTreeNode treeNode = new ZTreeNode();
                treeNode.setId(String.valueOf(data.getId()));
                treeNode.setName(data.getMaterialName());
                treeNode.setIsLeaf(data.getIsLeaf());
                treeNode.setIcon("1");
                treeNode.setType("data");
                treeBranch.addTreeNode(treeNode);
            }
        }
        model.addAttribute("msg", treeBranch.toJsonString(true));
        return "common/msg";
    }

   /**
     * 列表显示页面
     *
     * @param model .
     * @return .
     */
    @RequestMapping
    public String grid(Model model) {
      //判断是否有编辑权限
      model.addAttribute("canEdit",sysUserManager.hasPrivilege(PrivilegeCode.SYS_SAMPLE_EDIT));
            
      return "view/sg/sgMaterialInfo/grid";
    }
    
    /**
     * 获取列表数据
     *
     * @param response .
     * @param filters .
     * @param columns .
     * @param page .
     * @param rows .     
     */
    @RequestMapping
    public void gridDataCustom(HttpServletResponse response, String filters, String columns, int page, int rows, HttpSession session) {
        try {
            Page pageModel = new Page(page, rows, true);
            String hql = "from SgMaterialInfo order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = sgMaterialInfoService.findByPage(pageModel, query);

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
    public String add(Model model, String parentId) {
        SgMaterialInfo sgMaterialInfo = new SgMaterialInfo();

        //如需增加其他默认值请在此添加
        if (!StringHelper.isEmpty(parentId) && "root".equals(parentId)) {
           sgMaterialInfo.setParent(sgMaterialInfoService.get(Long.valueOf(parentId)));
        }
        model.addAttribute("bean", sgMaterialInfo);

        return "view/sg/sgMaterialInfo/input";
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
        SgMaterialInfo sgMaterialInfo = sgMaterialInfoService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", sgMaterialInfo);
        
        return "view/sg/sgMaterialInfo/input";
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
        SgMaterialInfo sgMaterialInfo = sgMaterialInfoService.get(id);
        
        model.addAttribute("bean", sgMaterialInfo);        
        return "view/sg/sgMaterialInfo/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") SgMaterialInfo entity, HttpServletRequest request) throws Exception {
        try {
            SgMaterialInfo target;
            if (entity.getId() != null) {
                target = sgMaterialInfoService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                  "no",              
                                                                  "type",              
                                                                  "materialName",              
                                                                  "auditReq",              
                                                                  "isLeaf",              
                                                                  "treeId",              
                                                                  "createTime",              
                                                                  "createUser",              
                                                                  "updateTime",              
                                                                  "updateUser"              
                                                });

            } else {
                target = entity;
            }
            sgMaterialInfoService.save(target);

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
     * @param id  .
     * @throws Exception  .
     */
    @RequestMapping
    public void delete(HttpServletResponse response, Long id) throws Exception {
        sgMaterialInfoService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}