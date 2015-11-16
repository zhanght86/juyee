<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    var formId = "bean";
    $(function () {
        //页面验证初始化
        var validateCondition = [
            //{name:"year", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"bjbh", rule:"validate[required,maxSize[50]]"},            
            //{name:"projectName", rule:"validate[required,maxSize[200]]"},            
            //{name:"buildName", rule:"validate[required,maxSize[200]]"},            
            //{name:"hYear", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"hNum", rule:"validate[required,custom[integer],maxSize[4]"},            
            //{name:"applyPerson", rule:"validate[required,maxSize[50]]"},            
            //{name:"applyMatter", rule:"validate[required,maxSize[200]]"},            
            //{name:"applyNum", rule:"validate[required,maxSize[50]]"},            
            //{name:"materialPerson", rule:"validate[required,maxSize[200]]"},            
            //{name:"materialPersonPhone", rule:"validate[required,maxSize[50]]"},            
            //{name:"materialPersonAddress", rule:"validate[required,maxSize[200]]"},            
            //{name:"receivePerson", rule:"validate[required,maxSize[200]]"},            
            //{name:"receivePersonPhone", rule:"validate[required,maxSize[50]]"},            
            //{name:"status", rule:"validate[required,custom[integer],maxSize[2]"},            
            //{name:"csOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"fhOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"shOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"fgldOpinion", rule:"validate[required,maxSize[1000]]"},            
            //{name:"zxldOpinion", rule:"validate[required,maxSize[1000]]"},                    
        ];
        validateInit(validateCondition, formId);
    });

    //保存操作
    function save(buttonName, status) {
        if (!validateForm(formId)) {
            return;
        }
        if ("" != buttonName) {
            $("#status").val(status);
            if (confirm("是否确定执行 " + buttonName + " 操作？")) {
                saveAjaxData("${ctx}/sgPermit/save.do", formId);
            }
        } else {
            saveAjaxData("${ctx}/sgPermit/save.do", formId);
        }
    }
</script>
<form:form commandName="bean">
    <form:hidden path="id"/>
    <form:hidden path="year"/>
    <form:hidden path="status"/>
    <input type="hidden" name="projectType" value="${bean.projectType.id}">

    <div class="form_div">
        <table cellpadding="0" cellspacing="0" class="form_table">
            <tr class="tr_dark">
                <td class="form_label_right" style="width: 20%;" nowrap>报建编号：</td>
                <td class="form_content" style="width: 80%;">
                    <form:input path="bjbh" cssClass="input_text_long"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">项目名称：</td>
                <td class="form_content">
                    <form:input path="projectName" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">建设单位：</td>
                <td class="form_content">
                    <form:input path="buildName" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_content" colspan="2">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                    沪交管收字（<form:input path="hjgYear" cssClass="input_number" cssStyle="text-align: center;"/> ）
                    第<form:input path="hjgNum" cssClass="input_number" cssStyle="text-align: center;"/>号
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请人：</td>
                <td class="form_content">
                    <form:input path="applyPerson" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">申请事项：</td>
                <td class="form_content">
                    <form:input path="applyMatter" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">申请号：</td>
                <td class="form_content">
                    <form:input path="applyNum" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <table cellpadding="0" cellspacing="0" class="table_thin_line" border="1" style="width: 100%;">
                        <tr class="tr_header">
                            <td style="width: 5%;">序号</td>
                            <td style="width: 50%;">申请材料名称</td>
                            <td style="width: 20%;">材料齐全情况</td>
                            <td style="width: 8%;">份数</td>
                            <td style="width: 15%;">附件</td>
                        </tr>
                        <c:forEach items="${applyList}" var="map">
                            <c:set value="upLoad${map.no}" var="upLoadNo"/>
                            <tr class="tr_dark">
                                <td>${map.no}
                                    <input type="hidden" name="no" value="${map.no}">
                                </td>
                                <td style="text-align: left;">&nbsp;${map.materialName}</td>
                                <td>
                                    有<input type="radio" name="isFull${map.no}" value="1"
                                            <c:if test="${map.isFull=='true'}">checked="checked"</c:if>>
                                    无<input type="radio" name="isFull${map.no}" value="0"
                                            <c:if test="${map.isFull=='false'}">checked="checked"</c:if>>
                                </td>
                                <td>
                                    <input type="text" name="num${map.no}" class="input_number" value="${map.num}"
                                           style="text-align: center;">
                                </td>
                                <td>${map[upLoadNo]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>

            <tr class="tr_dark">
                <td class="form_label_right">材料提交人：</td>
                <td class="form_content">
                    <form:input path="materialPerson" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">材料提交人联系电话：</td>
                <td class="form_content">
                    <form:input path="materialPersonPhone" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">材料提交人联系地址：</td>
                <td class="form_content">
                    <form:input path="materialPersonAddress" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_light">
                <td class="form_label_right">收件人：</td>
                <td class="form_content">
                    <form:input path="receivePerson" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_dark">
                <td class="form_label_right">收件人联系电话：</td>
                <td class="form_content">
                    <form:input path="receivePersonPhone" cssClass="input_text" cssStyle="width: 90%;"/>
                </td>
            </tr>
            <tr class="tr_button" style="text-align: center;">
                <td class="form_content" colspan="2" style="text-align: center;">
                    <input type="button" value="提交" class="button_confirm"
                           onclick="save(this.value,'${STATUS_SUBMIT}')">&nbsp;
                    <input type="button" value="保存" class="button_confirm" onclick="save('','${STATUS_EDIT}')">&nbsp;
                    <input type="button" value="取消" class="button_cancel" onclick="closeWindow()">
                </td>
            </tr>
        </table>
    </div>
</form:form>