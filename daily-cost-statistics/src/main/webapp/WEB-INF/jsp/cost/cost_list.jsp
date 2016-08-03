<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>消费列表</title>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">
    <link href="${ctx}/static/css/index.css" rel="stylesheet">
    <%--<link type="text/css" rel="stylesheet" href="${ctx}/js/resources/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>--%>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/jqGrid/css/ui.jqgrid.css"/>

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/static/jqGrid/src/i18n/grid.locale-cn.js"></script>
    <script src="${ctx}/static/jqGrid/js/jquery.jqGrid.src.js"></script>
    <script src="${ctx}/static/js/cost/cost_list.js" type="text/javascript"></script>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row" style="height: 650px">
    <%@ include file="../../common/left.jsp"%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">首页 &gt; 消费列表</h2>
                <div class="row form-group">
                    <div class="col-lg-6 col-md-6 form-group">
                        <%--<label for="username">当前用户名称</label>--%>
                            <span>消费详情：</span>
                            <select id="costDetail" style="width:170px">
                                <c:forEach items="${costDetailEnum}" var="item">
                                    <option value="${item.code}">${item.cnName}</option>
                                </c:forEach>
                            </select>
                    </div>
                    <div class="col-lg-6 col-md-6 form-group">
                        <div class="form-group text-right">
                            <input type="button" id="submitButton" value="查询" class="templatemo-blue-button"/>
                            <input type="button" id="resetButton" value="新增" class="templatemo-white-button"/>
                        </div>
                    </div>
                </div>
                <div class="content" style="margin-top:5px;">
                    <table id="costList"></table>
                    <div id="pager"></div>
                </div>
            </div>
        </div>
        <%@ include file="../../common/footer.jsp"%>
    </div>


</div>

<!-- JS -->
<%--<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> --%> <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<%--<script type="text/javascript" src="js/templatemo-script.js"></script>  --%>      <!-- Templatemo Script -->
</body>
</html>
