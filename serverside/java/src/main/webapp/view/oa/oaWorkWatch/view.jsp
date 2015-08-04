<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
                        <tr class="tr_light">
          <td class="form_label">上报科室：</td>
          <td class="form_content">&nbsp;
                      ${bean.reportDept}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">上报人用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.reportUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">科室分管领导：</td>
          <td class="form_content">&nbsp;
                      ${bean.reportPerson}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">上报开始时间：</td>
          <td class="form_content">&nbsp;
                      ${bean.beginDate}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">上报结束时间：</td>
          <td class="form_content">&nbsp;
                      ${bean.endDate}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">附件ID(预留)：</td>
          <td class="form_content">&nbsp;
                      ${bean.documentId}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">状态：</td>
          <td class="form_content">&nbsp;
                      ${bean.status}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主任审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.zrOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">主任审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.zrAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">主任审核用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.zrAuditUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">科长审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.kzOpinion}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">科长审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.kzAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">科长审核用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.kzAuditUser}                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">办公室审核意见：</td>
          <td class="form_content">&nbsp;
                      ${bean.bgsOpinion}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">办公室审核时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.bgsAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">办公室审核用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.bgsAuditUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">创建时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">创建用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.createUser}                    </td>
        </tr>
                        <tr class="tr_light">
          <td class="form_label">更新时间：</td>
          <td class="form_content">&nbsp;
                      <fmt:formatDate value="${bean.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            
                    </td>
        </tr>
                                <tr class="tr_dark">
          <td class="form_label">更新用户名：</td>
          <td class="form_content">&nbsp;
                      ${bean.updateUser}                    </td>
        </tr>
                <tr class="tr_button">
            <td class="form_label"></td>
            <td class="form_content">
                <input type="button" value="关闭" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>