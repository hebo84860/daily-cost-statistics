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
    <link href="${ctx}/static/css/index.css" rel="stylesheet">
    <!--时间控件样式-->
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery.datetimepicker.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/index.css">

    <script type="text/javascript" src="${ctx}/static/js/jquery/jquery.js"></script>
    <!--图表控件-->
    <script type="text/javascript" src="${ctx}/static/js/echarts/echarts.js"></script>
    <%--<script type="text/javascript" src="${ctx}/static/js/echarts.common.min.js"></script>--%>
    <!--时间控件-->
    <script type="text/javascript" src="${ctx}/static/js/jquery/jquery.datetimepicker.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/statistics.js"></script>
</head>

<body>
<div class="templatemo-flex-row">
    <%@ include file="../common/left.jsp"%>
    <!-- Main content -->
    <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
            <div class="templatemo-content-widget white-bg">
                <h2 class="margin-bottom-10">数据图表</h2>
                <h4>P2P项目于 <fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd HH:mm"/> 首次上线</h4>
                <div class="panel panel-default no-border">
                    <%--<div class="panel-heading border-radius-10" style="height:50px;background-color:#99CCFF">--%>
                        <%--<nav class="templatemo-top-nav col-lg-12 col-md-12">--%>
                            <%--<ul class="text-uppercase">--%>
                                <%--<li class="li-a"><a id="i1" href="javascript:void(0)" class="li-i active">数量统计</a></li>--%>
                                <%--<li class="li-a"><a id="i2" href="javascript:void(0)" class="li-i">金额统计</a></li>--%>
                                <%--<li class="li-a"><a id="i3" href="javascript:void(0)" class="li-i">销售时间统计</a></li>--%>
                                <%--<li class="li-a"><a id="i4" href="javascript:void(0)" class="li-i">会员统计</a></li>--%>
                                <%--<li class="li-a"><a id="i5" href="javascript:void(0)" class="li-i">购买终端统计</a></li>--%>
                            <%--</ul>--%>
                        <%--</nav>--%>
                    <%--</div>--%>
                    <br/>
                        <input type="hidden" id="flag" value="${type}"/>
                    <div class="date-scope">
                        <label>时间段：</label>
                        <input type="text" value="" class="cssInput startTime" id="startTime"/>
                        <span >至</span>
                        <input type="text" value="" class="cssInput endTime" id="endTime"  style="wheight: 20px;"/>
                        <input type="button" flag="b1" class="button button-primary button-pill button-small" id="searchButton" value="查询" style="background-color: #99CCFF"/>
                    </div>
                    <div class="panel-body" id="main" style="height:500px;border:1px solid #ccc;padding:10px;" >

                    </div>
                </div>

            </div>
            <%@ include file="../common/footer.jsp"%>
        </div>
    </div>
</div>
</body>
</html>