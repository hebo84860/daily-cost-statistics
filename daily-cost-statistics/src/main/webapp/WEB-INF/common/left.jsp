<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<div class="templatemo-sidebar">
    <header class="templatemo-site-header">
        <div class="square"></div>
        <h1>消费统计</h1>
    </header>
    <%--<div class="profile-photo-container">--%>
        <%--<img src="" alt="Profile Photo" class="img-responsive">--%>
        <%--<div class="profile-photo-overlay"></div>--%>
    <%--</div>--%>
    <!-- Search box -->
    <%--<form class="templatemo-search-form" role="search">--%>
        <%--<div class="input-group">--%>
            <%--<button type="submit" class="fa fa-search"></button>--%>
            <%--<input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">--%>
        <%--</div>--%>
    <%--</form>--%>
    <%-- <div class="mobile-menu-icon">
         <i class="fa fa-bars"></i>
     </div>--%>
    <nav class="templatemo-left-nav">
        <input type="hidden" id="menuInput" value="${nav}">
        <ul class="vertical-nav ">
            <li>
                    <a href="${ctx}/main/index" class="first-menu-index"><i class="fa fa-home fa-fw"></i>首页</a>
            </li>
            <li>
                <a href="${ctx}/cost/toCostList" class="first-menu-index"><i class="fa fa-home fa-fw"></i>消费</a>
            </li>
            <li class="first-menu">
                <a href="${ctx}/cost/toCostStatistics?type=costAmount" class="first-menu-chart"><i class="fa fa-bar-chart fa-fw"></i>统计图表</a>
                <ul class="second-menu-ul" >
                    <li class="li-costAmount"><a href="${ctx}/cost/toCostStatistics?type=costAmount">消费统计</a></li>
                    <li class="li-costDiagram"><a href="${ctx}/cost/toCostStatistics?type=costDiagram">消费分布</a></li>
                    <li class="li-count"><a href="${ctx}/ps/toStatistics?type=count">数量统计</a></li>
                    <%--<li class="li-amount"><a href="${ctx}/ps/toStatistics?type=amount">金额统计</a></li>--%>
                    <%--<li class="li-time"><a href="${ctx}/ps/toStatistics?type=time">销售时间统计</a></li>--%>
                    <%--<li class="li-member"><a href="${ctx}/ps/toStatistics?type=member">会员统计</a></li>--%>
                    <%--<li class="li-terminal"><a href="${ctx}/ps/toStatistics?type=terminal">购买终端统计</a></li>--%>
                    <%--<li class="li-map"><a href="${ctx}/ps/toStatistics?type=map">销售分布图</a></li>--%>
                </ul>
            </li>
            <li> <a href="${ctx}/user/toModify" class="first-menu-modify"><i class="fa fa-sliders fa-fw"></i>修改密码</a></li>
            <%--<li><a href="javascript:void(0)" class="active"><i class="fa fa-database fa-fw"></i>Data Visualization</a></li>
            <li><a href="javascript:void(0)"><i class="fa fa-map-marker fa-fw"></i>Maps</a></li>
            <li><a href="javascript:void(0)"><i class="fa fa-users fa-fw"></i>Manage Users</a></li>--%>
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