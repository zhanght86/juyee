<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<script type="text/javascript">
    //查看信息
    function viewInfo(id) {
        openFullWindow("${ctx}/site/infoView.do?id=" + id, 1024, 768);
    }
</script>
<table width="240" border="0" cellpadding="0" cellspacing="0" class="ggl">
    <tr>
        <td height="150">
            <table width="220" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td class="ggltext" align="left">
                        &nbsp; &nbsp;<a href="javascript:void(0)" onclick="loadMainPage('${ctx}/oaPublicInfo/grid.do?typeCode=txl','通讯录');">通讯录</a>
                    </td>
                </tr>
                <tr>
                    <td class="ggltext" align="left">
                        &nbsp; &nbsp;<a href="javascript:void(0)" onclick="loadMainPage('${ctx}/oaPublicInfo/grid.do?typeCode=policy','法律法规');">法律法规</a>
                    </td>
                </tr>
                <tr>
                    <td class="ggltext" align="left">
                        &nbsp; &nbsp;<a href="javascript:void(0)">表格下载</a>
                        <%--<a href="javascript:void(0)" onclick="loadMainPage('${ctx}/oaPublicInfo/grid.do','表格下载');">表格下载</a>--%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>