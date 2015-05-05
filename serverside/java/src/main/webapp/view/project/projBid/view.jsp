<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="form_div">
    <table cellpadding="0" cellspacing="0" class="form_table">
        <tr class="tr_light">
            <td class="form_label_right">标段编号：</td>
            <td class="form_content">
                ${bean.code}
            </td>
            <td class="form_label_right">标段名称：</td>
            <td class="form_content">
                ${bean.name}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">建设里程：</td>
            <td class="form_content">
                ${bean.buildMileage}
            </td>
        </tr>
        <tr class="tr_light">
            <td class="form_label_right">涉及区（县）：</td>
            <td class="form_content">
                ${bean.belongArea.name}
            </td>
            <td class="form_label_right">开工日期：</td>
            <td class="form_content">
                ${bean.startDate}
            </td>
        </tr>
        <tr class="tr_dark">
            <td class="form_label_right">项目联系人：</td>
            <td class="form_content">
                ${bean.projLink}
            </td>
            <td class="form_label_right">联系电话：</td>
            <td class="form_content">
                ${bean.linkTel}
            </td>
        </tr>
        <tr class="tr_button">
            <td class="form_content" colspan="4" style="text-align: center">
                <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
            </td>
        </tr>
    </table>
</div>