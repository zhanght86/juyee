<%@page
	import="com.justonetech.cp.contract.service.ContractLocalServiceUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/init.jsp"%>
<%
	String contractId = ParamUtil.getString(request, "bjbh");
	Contract contract = ContractLocalServiceUtil.getContract(contractId);
	request.setAttribute("contract", contract);
%>
<portlet:renderURL var="viewURL"/>
<liferay-ui:header title="查看详细信息" backURL="${viewURL}" />
<style type="text/css">
table {
	width: 100%
}

tr.head  td {
	background-color: #63B8FF;
	text-align: center;
	font-size: 16px;
	color: white;
	font-family: "宋体";
	font-weight: bold;
}

tr.body td.title {
	width: 20%;
	background-color: #D1EEEE;
	text-align: center;
}

tr.body td.content {
	width: 30%;
}

td.content span {
	font-weight: bold;
	color: #104E8B;
}
</style>
<!-- 设计施工一体化 -->
<table border="2">
	<tr class="head">
		<td colspan="4">项目信息</td>
	</tr>
	<tr class="body">
		<td class="title">报建编号:</td>
		<td class="content">${contract.bjbh}</td>
		<td class="title">所在地区:</td>
		<td class="content">${contract.szdq}</td>
	</tr>
	<tr class="body">
		<td class="title">项目名称:</td>
		<td class="content" colspan="3">${contract.xmmc}</td>
	</tr>
	<tr class="body">
		<td class="title">建设单位:</td>
		<td class="content" colspan="3">${contract.jsdw}</td>
	</tr>
	<tr class="body">
		<td class="title">建设地点:</td>
		<td class="content" colspan="3">${contract.jsdd}</td>
	</tr>
	<tr class="body">
		<td class="title">立项批文:</td>
		<td class="content">${contract.lxpw}</td>
		<td class="title">批准文号:</td>
		<td class="content">${contract.pzwh}</td>
	</tr>
	<tr class="body">
		<td class="title">单位性质:</td>
		<td class="content">${contract.dwxz}</td>
		<td class="title">资金来源构成:</td>
		<td class="content">${contract.zjlygc}</td>
	</tr>
	<tr class="body">
		<td class="title">总投资(万元):</td>
		<td class="content">${contract.ztz}</td>
		<td class="title">总建筑面积(㎡):</td>
		<td class="content">${contract.zjzmj}</td>
	</tr>
	<tr class="body">
		<td class="title">项目分类:</td>
		<td class="content">${contract.xmfl}</td>
		<td class="title">建设规模:</td>
		<td class="content">${contract.jsgm}</td>
	</tr>
	<tr class="head">
		<td colspan="4">合同信息报送编号:${contract.contractId}</td>
	</tr>
	<tr class="body">
		<td class="title">标段号:</td>
		<td class="content" colspan="3">${contract.bdh}</td>
	</tr>
	<tr class="body">
		<td class="title">发包方式:</td>
		<td class="content">${contract.fbfs}</td>
		<td class="title">承包方式:</td>
		<td class="content">${contract.cbfs}</td>
	</tr>
	<tr class="body">
		<td class="title">合同名称:</td>
		<td class="content" colspan="3">${contract.htmc}</td>
	</tr>
	<tr class="body">
		<td class="title">发包单位:</td>
		<td class="content" colspan="3">${contract.fbdw}</td>
	</tr>
	<tr class="body" style="border-top: 2px solid;">
		<td class="title">设计单位:</td>
		<td class="content" colspan="3">${contract.sjdw}</td>
	</tr>
	<tr class="body">
		<td class="title">设计负责人:</td>
		<td class="content">${contract.sjfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型:</td>
		<td class="content">${contract.sjfzrzjlx}</td>
		<td class="title">证件号:</td>
		<td class="content">${contract.sjfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察单位:</td>
		<td class="content" colspan="3">${contract.kcdwmc}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察负责人:</td>
		<td class="content">${contract.kcfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body">
		<td class="title">证件类型:</td>
		<td class="content">${contract.kcfzrzjlx}</td>
		<td class="title">证件号:</td>
		<td class="content">${contract.kcfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">施工单位:</td>
		<td class="content" colspan="3">${contract.sgdwmc}</td>
	</tr>
	<tr class="body">
		<td class="title">施工负责人:</td>
		<td class="content">${contract.sgfzr}</td>
		<td class="title"></td>
		<td class="content"></td>
	</tr>
	<tr class="body" style="border-bottom: 2px solid;">
		<td class="title">证件类型:</td>
		<td class="content">${contract.sgfzrzjlx}</td>
		<td class="title">证件号:</td>
		<td class="content">${contract.sgfzrzjh}</td>
	</tr>
	<tr class="body">
		<td class="title">设计项目类别:</td>
		<td class="content">${contract.sjxmlb}</td>
		<td class="title">设计工程类别:</td>
		<td class="content">${contract.sjgclb}</td>
	</tr>
	<tr class="body">
		<td class="title">设计工程规模:</td>
		<td class="content" colspan="3">${contract.sjgcgm}</td>
	</tr>
	<tr class="body">
		<td class="title">施工项目类别:</td>
		<td class="content">${contract.sgxmlb}</td>
		<td class="title">施工工程类别:</td>
		<td class="content">${contract.sggclb}</td>
	</tr>
	<tr class="body">
		<td class="title">施工工程规模:</td>
		<td class="content" colspan="3">${contract.sggcgm}</td>
	</tr>
	<tr class="body">
		<td class="title">开竣工日期:</td>
		<td class="content" colspan="3"><fmt:formatDate
				value="${contract.kgrq}" pattern="yyyy-MM-dd" /> 至 <fmt:formatDate
				value="${contract.jgrq}" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr class="body">
		<td class="title">合同价(万元):</td>
		<td class="content">${contract.htj}</td>
		<td class="title">设计费(万元):</td>
		<td class="content">${contract.sjf}</td>
	</tr>
	<tr class="body">
		<td class="title">勘察费(万元):</td>
		<td class="content" colspan="3">${contract.kcf}</td>
	</tr>
	<tr class="body">
		<td class="title">建安造价(万元):</td>
		<td class="content" colspan="3">${contract.jazj}</td>
	</tr>
	<tr class="body">
		<td class="title">暂列金额(万元):</td>
		<td class="content" colspan="3">${contract.zlje}</td>
	</tr>
	<tr class="body">
		<td class="title">暂估价(万元):</td>
		<td class="content">${contract.zgj}</td>
		<td class="title">安全防护<br>文明施工措施费(万元):
		</td>
		<td class="content">${contract.aqfhwmsgcsf}</td>
	</tr>
	<tr class="body">
		<td class="title">合同签订日期:</td>
		<td class="content"><fmt:formatDate value="${contract.htqdrq}"
				pattern="yyyy-MM-dd" /></td>
		<td class="title">合同起止日期<br>(合同有效期):
		</td>
		<td class="content">${contract.htqzrq}</td>
	</tr>
	<tr class="body">
		<td class="title">采用合同示范文本:</td>
		<td class="content" colspan="3">${contract.cyhtsfwb}</td>
	</tr>
	<tr class="body">
		<td class="title">附注及其他说明:</td>
		<td class="content" colspan="3">${contract.fzjqtsm}</td>
	</tr>
	<tr class="body" style="border-top: 2px solid;">
		<td class="title">是否注销:</td>
		<td class="content" colspan="3">${contract.sfzx}</td>
	</tr>
	<tr class="body">
		<td class="title">注销时间:</td>
		<td class="content" colspan="3"><fmt:formatDate
				value="${contract.zxsj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr class="body">
		<td class="title">注销说明:</td>
		<td class="content" colspan="3">${contract.zxsm}</td>
	</tr>
</table>
