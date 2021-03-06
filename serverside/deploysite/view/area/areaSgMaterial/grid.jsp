<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        var conf = {
            gridOpts:{
                url:"${ctx}/areaSgMaterial/gridDataCustom.do",
                colNames:['ID',
            	'序号',            	          	
            	'材料齐全情况',            	          	
            	'份数',            	          	
            	'创建时间',            	          	
            	'创建用户名',            	          	
            	'更新时间',            	          	
            	'更新用户名',            	          	
            	'应交份数',            	          	
            	'实交份数',            	          	
                '操作'
                ],
                colModel:[
                				{name:'id', width:10, align:"center", searchtype:"integer",hidden:true},
{name:"no",width:"88",align:"center",searchtype:"string",sortable:true},
{name:"isFull",width:"88",align:"center",searchtype:"integer",sortable:true,formatter:booleanFormat},
{name:"num",width:"88",align:"center",searchtype:"string",sortable:true},
{name:"createTime",width:"88",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"createUser",width:"88",align:"center",searchtype:"string",sortable:true},
{name:"updateTime",width:"88",align:"center",searchtype:"datetime",sortable:true,formatter:'date',formatoptions:{srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
{name:"updateUser",width:"88",align:"center",searchtype:"string",sortable:true},
{name:"yjNum",width:"88",align:"center",searchtype:"string",sortable:true},
{name:"sjNum",width:"88",align:"center",searchtype:"string",sortable:true}
                ],
                actModel:[
                    {name:'operation', width:40, align:'center'}
                ],
                pager: '#pager2',
                caption:"区县施工材料列表",
                shrinkToFit:true,
                gridComplete:function () {  //在此事件中循环为每一行添加修改和删除链接
                    var ids = jQuery("#listGrid").jqGrid('getDataIDs');
                    for (var i = 0; i < ids.length; i++) {
                        var id = ids[i];
                        var opButton = '<input type="button" value="查看" onclick="doView(' + id + ')" class="button_normal"/> ';
                        <c:if test="${canEdit}">
                        opButton += '<input type="button" value="编辑" onclick="doEdit(' + id + ')" class="button_normal"/> ';
                        opButton += '<input type="button" value="删除" onclick="doDelete(' + id + ')" class="button_normal"/>';
                        </c:if>
                        jQuery("#listGrid").jqGrid('setRowData', ids[i], { operation:opButton});
                    }
                }, rownumbers:true
            },
            userOpts:{
                defaultQuery:{ "groupOp":"AND", "rules":[
            	{ "field":"序号", "op":"cn", "data":""},            	    
            	{ "field":"材料齐全情况", "op":"cn", "data":""},            	    
            	{ "field":"份数", "op":"cn", "data":""},            	    
                { "field":"创建时间", "op":"bw", "data":""},            	    
            	{ "field":"创建用户名", "op":"cn", "data":""},            	    
                { "field":"更新时间", "op":"bw", "data":""},            	    
            	{ "field":"更新用户名", "op":"cn", "data":""},            	    
            	{ "field":"应交份数", "op":"cn", "data":""},            	    
            	{ "field":"实交份数", "op":"cn", "data":""}            	    
                ]},
                queryButton:$("#queryButton"),
                queryDesc:$("#queryConditionDesc")
            },
            isExportExcel:true
        };
        gridinit($("#listGrid"), conf);
    });
    function doView(id) {
        openWindow("查看区县施工材料", "${ctx}/areaSgMaterial/view.do?id=" + id, false);
    }
    <c:if test="${canEdit}">
    function doAdd() {
        openWindow("添加区县施工材料", "${ctx}/areaSgMaterial/add.do", true);
    }
    function doEdit(id) {
        openWindow("修改区县施工材料", "${ctx}/areaSgMaterial/modify.do?id=" + id, true);
    }    
    function doDelete(id) {
        doGridDelete("${ctx}/areaSgMaterial/delete.do?id=" + id);
    }
    </c:if>
    
    //custom formatter
    //function customeFormat(cellvalue, options, rowObject) {
    //    return cellvalue == "true"?"是":"否";
    //}
</script>

<div class="title_Search">
    <div class="gridQueryArea">
        <div style="float:left;padding-left: 5px">
            <input type="button" name="queryButton" id="queryButton" value="查询" class="btn_Search"/>
        </div>
        <div style="float:left;padding-left: 10px" id="conditionsDesc">
            <input type="text" name="queryConditionDesc" id="queryConditionDesc" value="" class="title_input" readonly="true"/>
        </div>
        <div style="float:right;padding-right: 10px">
        <c:if test="${canEdit}">
            <input type="button" value="添加" class="button_add"
                   onclick="doAdd()"/>
        </c:if>
        </div>
    </div>
</div>
<div class="gridQueryTable">
    <table id="listGrid"></table>
    <div id="pager2"></div>
</div>