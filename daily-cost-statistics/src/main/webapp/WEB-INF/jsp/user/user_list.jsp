<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会员列表</title>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">
    <link href="${ctx}/static/css/index.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${ctx}/static/js/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/jqGrid/css/ui.jqgrid.css"/>
    <!--时间控件样式-->
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery.datetimepicker.css">
    <%--<link rel="stylesheet" type="text/css" href="${ctx}/static/js/layer/skin/layer.css">--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/index.css">
    <!--时间控件样式-->

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <%--<script src="${ctx}/static/js/jquery-ui-1.8.10.custom.min.js" type="text/javascript"></script>--%>
    <script src="${ctx}/static/js/jquery-ui-1.8.11/js/jquery-ui-1.8.11.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/layer/layer.js" type="text/javascript"></script>
    <script src="${ctx}/static/jqGrid/src/i18n/grid.locale-cn.js" type="text/javascript"></script>
    <script src="${ctx}/static/jqGrid/js/jquery.jqGrid.src.js" type="text/javascript"></script>
    <!--时间控件-->
    <script type="text/javascript" src="${ctx}/static/js/jquery/jquery.datetimepicker.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script><!--时间初始化-->
    <!--时间控件-->
    <script src="${ctx}/static/js/user/user_list.js" type="text/javascript"></script>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row" style="height: 650px">
    <%@ include file="../../common/left.jsp"%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">首页 &gt; 会员列表</h2>
                <div class="row form-group">
                    <div class="col-lg-6 col-md-6 form-group">
                        <%--<label for="username">当前用户名称</label>--%>
                            <span>用户名：</span>
                            <input type="text" id="username" value="" />
                            <%--<span>消费详情：</span>
                            <select id="costDetail" style="width:170px">
                                <option value="" selected>全部</option>
                                <c:forEach items="${costDetailEnum}" var="item">
                                    <c:if test="${item.code!=''}">
                                        <option value="${item}">${item.cnName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>--%>
                    </div>
                    <div class="col-lg-6 col-md-6 form-group">
                        <span>记录状态：</span>
                        <select id="status" style="width:170px">
                            <option value="">全部</option>
                            <c:forEach items="${statusEnum}" var="item">
                                <option value="${item}">${item.cnName}</option>
                            </c:forEach>
                        </select>
                        <div class="form-group text-right">
                            <input type="button" id="searchUserList" value="查询" class="templatemo-blue-button"/>
                            <%--<input type="button" id="addCost" value="新增" class="templatemo-blue-button"/>--%>
                        </div>
                    </div>
                </div>
                <div class="content" style="margin-top:5px;">
                    <table id="userList"></table>
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
