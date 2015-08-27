<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts: {
                url: "${ctx}/projExtend/gridDataCustom.do",
                colNames: ['ID',
                    '填报年份',
                    '项目序号',
                    '项目名称',
                    '项目性质',
                    '项目阶段',
                    '项目类型',
                    '操作'
                ],
                colModel: [
                    {name: 'id', width: 10, align: "center", searchtype: "integer", hidden: true},
                    {name: "year", width: "30", align: "center", searchtype: "integer", sortable: true},
                    {name: "no", width: "30", align: "center", searchtype: "string", sortable: true},
                    {name: "name", width: "80", align: "left", searchtype: "string", sortable: true},
                    {name: "property.name", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "stage.name", width: "25", align: "center", searchtype: "string", sortable: true},
                    {name: "category.name", width: "25", align: "center", searchtype: "string", sortable: true}
                ],
                actModel: [
                    {name: 'operation', width: 60, align: 'center'}
                ],
                pager: '#pager2',
                caption: "项目扩展信息列表",
                shrinkToFit: true,
                gridComplete: function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var rowData = jQuery("#listGrid").jqGrid('getRowData', id);
                        var stageName = rowData["stage.name"];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="填报" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        if (stageName == '未开工') {
                            //判断项目阶段的高亮显示（删除列时注意修改）
                            $("#" + id).find("td:eq(6)").css("background-color", " #f08080");
                        } else if (stageName == '在建') {
                            $("#" + id).find("td:eq(6)").css("background-color", "#add8e6");
                        } else if (stageName == '已完工') {
                            $("#" + id).find("td:eq(6)").css("background-color", "#90ee90");
                        }
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation: opButton});
                    }
                }, rownumbers: true
            },
            userOpts: {
                defaultQuery: { "groupOp": "AND", "rules": [
                    { "field": "填报年份", "op": "eq", "data": ""},
                    { "field": "项目序号", "op": "cn", "data": ""},
                    { "field": "项目名称", "op": "cn", "data": ""},
                    { "field": "项目性质", "op": "cn", "data": ""},
                    { "field": "项目阶段", "op": "cn", "data": ""},
                    { "field": "项目类型", "op": "cn", "data": ""}
                ]},
                queryButton: $("#queryButton"),
                queryDesc: $("#queryConditionDesc")
            },
            isExportExcel: true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        parent.openWindow("查看项目推进信息", "${ctx}/projExtend/view.do?projectId=" + id, false, 800, 550);
    }
    <c:if test="${canEdit}">
    function doEdit(id) {
        parent.openWindow("修改项目推进信息", "${ctx}/projExtend/modify.do?projectId=" + id, true, 800, 550);
    }
    function doDelete(id) {
        doGridDelete("${ctx}/projExtend/delete.do?projectId=" + id);
    }
    </c:if>
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input"
                   readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>