<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%
	String staticServerURL = PropsUtil.get("static.server.url");
	request.setAttribute("staticServerURL", staticServerURL);
	String reportServerURL = PropsUtil.get("report.server.url");
	request.setAttribute("reportServerURL", reportServerURL);
	String defaultDateFormatPattern = PropsUtil
			.get("default.date.format.pattern");
	request.setAttribute("defaultDateFormatPattern",
			defaultDateFormatPattern);
	String defaultTimeFormatPattern = PropsUtil
			.get("default.time.format.pattern");
	request.setAttribute("defaultTimeFormatPattern",
			defaultTimeFormatPattern);
%>
<script type="text/javascript" src="/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/jquery/jquery-1.12.4.min.js'>"+"<"+"/script>");
</script> 

<%@page import="com.justonetech.cp.util.PortletKeys"%>
<%@page import="com.justonetech.cp.contract.model.*"%> 