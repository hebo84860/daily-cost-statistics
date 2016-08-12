<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户注册</title>
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/templatemo-style.css" rel="stylesheet">
    <link href="${ctx}/static/css/index.css" rel="stylesheet">

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/layer/layer.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/user/add_user.js" type="text/javascript"></script>
</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row">
    <%--<%@ include file="../../common/left.jsp"%>--%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">注册会员</h2>
                    <div class="row form-group">
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="username">账号名称</label>
                            <input id="username" type="text" class="form-control span-prompt" placeholder="字母开头,数字或下划线（5-16位）。" >
                            <span class="red-display-none">请填写用户名称,字母开头数字或下划线（5-16位）。</span>
                            <span class="red-display-none" id="usernameExist">抱歉！该用户名已经存在，请重新填写！</span>
                        </div>
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="realname">真实姓名</label>
                            <input type="text" class="form-control span-prompt" id="realname">
                            <span class="red-display-none">请填写真实姓名</span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="nickname">用户昵称</label>
                            <input type="text" class="form-control span-prompt" id="nickname">
                            <span class="red-display-none">请填写用户昵称</span>
                        </div>
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="email">个人邮箱</label>
                            <input type="text" class="form-control" id="email"<%-- placeholder="admin@company.com"--%>>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="password">用户密码</label>
                            <input type="password" class="form-control span-prompt" id="password" placeholder="字母开头数字或下划线（6-18位）。">
                            <span class="red-display-none">请填写用户密码,字母开头数字或下划线（6-18位）。</span>
                        </div>
                        <div class="col-lg-6 col-md-6 form-group">
                            <label for="confirmPassword">确认密码</label>
                            <input type="password" class="form-control span-prompt" id="confirmPassword">
                            <span class="red-display-none">两次密码输入不一致</span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-12 has-warning form-group">
                            <label class="control-label" for="inviteCode">邀请码</label>
                            <input type="text" class="form-control span-prompt" id="inviteCode">
                            <span class="red-display-none">请填写用户注册邀请码</span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-12 form-group">
                            <label class="control-label" for="comment">备注</label>
                            <textarea class="form-control" id="comment" rows="3" cols=""></textarea>
                        </div>
                    </div>
                    <div class="form-group text-right">
                        <input type="button" id="submitButton" value="提交" class="templatemo-blue-button"/>
                        <input type="button" id="resetButton" value="返回" class="templatemo-white-button"/>
                    </div>
            </div>
            <%--<%@ include file="../../common/footer.jsp"%>--%>
        </div>
    </div>
</div>

</body>
</html>
