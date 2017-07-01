<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<div class="templatemo-sidebar">
    <header class="templatemo-site-header">
        <div class="square"></div>
        <h1>消费统计</h1>
    </header>
    <nav class="templatemo-left-nav">
        <input type="hidden" id="menuInput" value="${nav}">
        <ul class="vertical-nav ">
            <li>
                    <a href="${ctx}/main/index" class="first-menu-index"><i class="fa fa-home fa-fw"></i>首页</a>
            </li>
            <%--<li>--%>
                <%--<a href="${ctx}/cost/toCostList" class="first-menu-index"><i class="fa fa-home fa-fw"></i>消费</a>--%>
            <%--</li>--%>
            <li class="first-menu">
                <a href="${ctx}/user/toUserList?type=toUserList" class="first-menu-chart"><i class="fa fa-bar-chart fa-fw"></i>会员管理</a>
                <ul class="second-menu-ul" >
                    <li class="li-toUserList"><a href="${ctx}/user/toUserList?type=toUserList">会员列表</a></li>
                    <%--<li class="li-costAmount"><a href="${ctx}/cost/toCostStatistics?type=costAmount">消费统计</a></li>--%>
                    <%--<li class="li-costDiagram"><a href="${ctx}/cost/toCostStatistics?type=costDiagram">消费分布</a></li>--%>
                </ul>
            </li>
            <li> <a href="${ctx}/user/toModify" class="first-menu-modify"><i class="fa fa-sliders fa-fw"></i>修改密码</a></li>
            <li><a href="${ctx}/main/logout"><i class="fa fa-eject fa-fw"></i>退出</a></li>
        </ul>
    </nav>

    <script type="text/javascript" src="${ctx}/static/js/jquery/second-menu.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".vertical-nav").verticalnav({speed: 400,align: "left"});

            chooseFirstMenu();

        });
        function chooseFirstMenu(){
            var nav = $("#menuInput").val();
            if(nav==1){
                $(".first-menu-index").addClass('active');
            }else if(nav==2){
                $(".first-menu-chart").addClass('active');
            }else if(nav==3){
                $(".first-menu-modify").addClass('active');
            }
        }
    </script>

</div>