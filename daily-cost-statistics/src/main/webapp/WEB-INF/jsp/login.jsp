<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>
    <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(document).ready(function(){
            $("#username").off().on().blur(function(){
                if($('#username').val()==''){
                    $("#usernameMsg").show();
                }
            }).focus(function(){
                $("#usernameMsg").hide();
            })
            $("#password").off().on().blur(function(){
                if($('#password').val()==''){
                    $("#passwordMsg").show();
                }
            }).focus(function(){
                $("#passwordMsg").hide();
            })
        });

        function validate(){
            var username = $("#username").val();
            var password = $("#password").val();
            if(username==''){
                $("#usernameMsg").show();
            }
            if(password==''){
                $("#passwordMsg").show();
            }

            if(username!='' && password!=''){
                $("#login").submit();
            }
        }

    </script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    [endif]-->
</head>
<body class="light-gray-bg">
<div class="templatemo-content-widget templatemo-login-widget white-bg">
    <header class="text-center">
        <%--<div class="square"></div>--%>
        <h1>消费统计</h1>
    </header>
    <div id="login-error" style="color: red;text-align:center;">${error}</div>
    <form action="${ctx}/main/login" id="login" method="post" class="templatemo-login-form">
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>
                <input id="username" type="text" name="username" class="form-control" placeholder="请输入您的账号" value="${username}">
            </div>
            <span id="usernameMsg" style="color: red; display: none;">请输入您的账号</span>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>
                <input id="password" type="password" name="password" class="form-control" placeholder="请输入您的密码">
            </div>
            <span id="passwordMsg" style="color: red;display: none;">请输入您的密码</span>
        </div>
        <div class="form-group">
            <div class="checkbox squaredTwo">
                <input type="checkbox" <c:if test="${remember==1}">checked</c:if> id="c1"  name="remember" value="1"/>
                <label for="c1"><span></span>记住账号</label>
            </div>
        </div>
        <div class="form-group">
            <button type="button" onclick="validate()" class="templatemo-blue-button width-100">登录</button>
        </div>
    </form>
</div>
<div class="templatemo-content-widget templatemo-login-widget templatemo-register-widget white-bg">
    <p>还没有账号？ <strong><a href="${ctx}/user/toAdd" class="blue-text">马上注册!</a></strong></p>
</div>

</body>
</html>
