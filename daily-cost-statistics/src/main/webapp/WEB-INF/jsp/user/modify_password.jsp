<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改密码</title>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">
    <link href="${ctx}/static/css/index.css" rel="stylesheet">

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/user/modify-password.js" type="text/javascript"></script>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row" style="height: 650px">
    <%@ include file="../../common/left.jsp"%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">修改密码</h2>
                <div class="row form-group">
                    <div class="col-lg-6 col-md-6 form-group">
                        <label for="username">当前用户名称</label>
                        <input id="username" type="text" class="form-control span-prompt" readonly value="${sessionScope.user.username}">
                        <span class="red-display-none">请填写用户名称</span>
                    </div>
                    <div class="col-lg-6 col-md-6 form-group">
                        <label for="realname">真实姓名</label>
                        <input type="text" class="form-control span-prompt" readonly id="realname" value="${sessionScope.user.realname}">
                        <span class="red-display-none">请填写真实姓名</span>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6 col-md-6 form-group">
                        <label for="oldPassword">请输入当前密码</label>
                        <input type="password" class="form-control " id="oldPassword" placeholder="">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6 col-md-6 form-group">
                        <label for="password">输入新密码</label>
                        <input type="password" class="form-control span-prompt" id="password">
                        <span class="red-display-none">请填写新用户密码</span>
                    </div>
                    <div class="col-lg-6 col-md-6 form-group">
                        <label for="confirmPassword">确认新密码</label>
                        <input type="password" class="form-control span-prompt" id="confirmPassword">
                        <span class="red-display-none">两次密码输入不一致</span>
                    </div>
                </div>
                <div class="form-group text-right">
                    <input type="button" id="submitButton" value="确认修改" class="templatemo-blue-button"/>
                    <input type="button" id="resetButton" value="返回" class="templatemo-white-button"/>
                </div>
            </div>
            <%@ include file="../../common/footer.jsp"%>
        </div>
    </div>
</div>

<!-- JS -->
<%--<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> --%> <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<%--<script type="text/javascript" src="js/templatemo-script.js"></script>  --%>      <!-- Templatemo Script -->
</body>
</html>
