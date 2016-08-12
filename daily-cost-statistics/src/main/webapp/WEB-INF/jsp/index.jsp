<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目统计</title>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
</head>

<body>
<div class="templatemo-flex-row">
    <%@ include file="../common/left.jsp"%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
            <div class="row text-right"  >
                <span class="user-name" style="margin-right: 10px;">您好：${sessionScope.user.username}</span>
                <br/>
                <a href="${ctx}/main/logout" style="margin-right: 60px">注销</a>
            </div>
        </div>
        <div class="templatemo-content-container" style=" height:660px;line-height:660px;text-align:center;overflow:hidden;" >
            <h1>欢迎登陆消费后台管理系统</h1>
            </div>
            <%@ include file="../common/footer.jsp"%>
    </div>
</div>
</body>
</html>