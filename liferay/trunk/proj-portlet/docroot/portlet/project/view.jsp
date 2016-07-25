<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/init.jsp"%>

<c:set var="contentPath" value="${request.contextPath}/portlet/project" />
<portlet:renderURL var="viewURL" />
<portlet:renderURL var="add">
	<portlet:param name="mvcPath" value="${contentPath }/edit-project.jsp" />
</portlet:renderURL>
<portlet:actionURL var="deleteProjectsURL" name="deleteProjects">
	<portlet:param name="redirect" value="${viewURL}" />
</portlet:actionURL>
<aui:form action="${viewURL }" name="fm">
	<aui:nav-bar>
		<aui:nav>
			<aui:nav-item href="<%=add%>" iconCssClass="icon-plus" label="添加" />
		</aui:nav>
		<aui:nav-bar-search cssClass="pull-right">
			<div class="form-search">
				<liferay-ui:input-search />
			</div>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<aui:button-row>
		<aui:button disabled="<%=true%>" name="deleteProjectsBtn" value="删除"
			onClick='<%=renderResponse.getNamespace() + "deleteProjects();"%>' />
	</aui:button-row>
	<liferay-ui:search-container emptyResultsMessage="没有找到项目。"
		rowChecker="<%=new RowChecker (renderResponse)%>">
		<liferay-ui:search-container-results results="${projects}"
			total="${projectCount}" />
		<liferay-ui:search-container-row className="Project" modelVar="proj"
			keyProperty="projectId">
			<liferay-ui:search-container-column-text name="项目名称"
				property="projName" />
			<liferay-ui:search-container-column-text name="所属区县"
				property="belongCounty" />
			<liferay-ui:search-container-column-text name="项目状态"
				property="projStatus" />
			<liferay-ui:search-container-column-text name="业态类别"
				property="industryCategory" />
			<liferay-ui:search-container-column-text name="工可批复总投资(亿元)"
				property="gkpfTotle" />
			<liferay-ui:search-container-column-text name="action">

				<portlet:renderURL var="view">
					<portlet:param name="projectId" value="${proj.projectId}" />
					<portlet:param name="mvcPath"
						value="${contentPath }/view-project.jsp" />
				</portlet:renderURL>
				<portlet:actionURL var="del" name="doDelete">
					<portlet:param name="projectId" value="${proj.projectId}" />
				</portlet:actionURL>
				<portlet:actionURL var="edit" name="editProject">
					<portlet:param name="projectId" value="${proj.projectId}" />
					<portlet:param name="mvcPath"
						value="${contentPath }/edit-project.jsp" />
				</portlet:actionURL>
				<liferay-ui:icon-menu>
					<liferay-ui:icon image="view" url="${view}" />
					<liferay-ui:icon image="edit" url="${edit}" />
					<liferay-ui:icon-delete image="delete" url="${del}" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
<aui:script>
	Liferay.Util.toggleSearchContainerButton('#<portlet:namespace />deleteProjectsBtn', '#<portlet:namespace /><%=searchContainerReference.getId("searchContainer")%>SearchContainer', document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
	
	Liferay.provide(
			window,
			'<portlet:namespace />deleteProjects',
			function(projectIds) {
				if(confirm("确定要删除所选数据吗？")){
					if(!projectIds){
						projectIds = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					}
					location.href="<%=deleteProjectsURL%>&<portlet:namespace/>projectIds="+ projectIds;
				}
			},
			['liferay-util-list-fields']
		);
</aui:script>
	


































