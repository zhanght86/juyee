package com.justonetech.biz.controller.oa;

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
import com.justonetech.core.security.user.BaseUser;
import com.justonetech.core.security.util.SpringSecurityUtils;
import com.justonetech.core.utils.FormatUtils;
import com.justonetech.biz.core.orm.hibernate.GridJq;
import com.justonetech.biz.core.orm.hibernate.QueryTranslateJq;
import com.justonetech.biz.daoservice.OaReceiveService;
import com.justonetech.biz.domain.OaReceive;

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
 * note:收文管理
 * author: system
 * create date:
 * modify date:
 */
@Controller
public class OaReceiveController extends BaseCRUDActionController<OaReceive> {
    private Logger logger = LoggerFactory.getLogger(OaReceiveController.class);
    
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
    private OaReceiveService oaReceiveService;

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
            
      return "view/oa/oaReceive/grid";
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
            String hql = "from OaReceive order by id desc";
            //增加自定义查询条件

            //执行查询
            QueryTranslateJq queryTranslate = new QueryTranslateJq(hql, filters);
            String query = queryTranslate.toString();
            session.setAttribute(Constants.GRID_SQL_KEY, query);
            pageModel = oaReceiveService.findByPage(pageModel, query);            

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
        OaReceive oaReceive = new OaReceive();

        //如需增加其他默认值请在此添加
        model.addAttribute("bean", oaReceive);

        return "view/oa/oaReceive/input";
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
        OaReceive oaReceive = oaReceiveService.get(id);

        //处理其他业务逻辑
        model.addAttribute("bean", oaReceive);
        
        return "view/oa/oaReceive/input";
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
        OaReceive oaReceive = oaReceiveService.get(id);
        
        model.addAttribute("bean", oaReceive);        
        return "view/oa/oaReceive/view";
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
    public void save(HttpServletResponse response, @ModelAttribute("bean") OaReceive entity, HttpServletRequest request) throws Exception {
        try {
            OaReceive target;
            if (entity.getId() != null) {
                target = oaReceiveService.get(entity.getId());
                ReflectionUtils.copyBean(entity, target, new String[]{
                                                "code",                                      
                                                                "fileCode",                                      
                                                                "title",                                      
                                                                "sourceDept",                                      
                                                                "receiveDate",                                      
                                                                "deptName",                                      
                                                                "writtenDate",                                      
                                                                "limitDate",                                      
                                                                "fs",                                      
                                                                "ys",                                      
                                                                "startDeptId",                                      
                                                                "dealPersons",                                      
                                                                "dealDepts",                                      
                                                                "createTime",                                      
                                                                "createUser",                                      
                                                                "updateTime",                                      
                                                                "updateUser"                                      
                                                });

            } else {
                target = entity;
            }
            oaReceiveService.save(target);

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
        oaReceiveService.delete(id);

        sendSuccessJSON(response, "删除成功");
    }

}