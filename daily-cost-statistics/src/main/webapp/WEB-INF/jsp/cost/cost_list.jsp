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
    <%--<link type="text/css" rel="stylesheet" href="${ctx}/static/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>--%>
    <link href="${ctx}/static/jqGrid/css/ui.jqgrid.css" rel="stylesheet"/>

    <script src="${ctx}/static/js/jquery/jquery.js" type="text/javascript"></script>
    <script src="${ctx}/static/jqGrid/js/jquery-1.7.2.min.js" type="javascript"> </script>
    <%--<script src="${ctx}/static/jquery-ui-1.8.10.custom.min.js"></script>--%>
    <script src="${ctx}/static/jqGrid/src/i18n/grid.locale-cn.js" type="javascript"></script>
    <script src="${ctx}/static/jqGrid/js/jquery.jqGrid.src.js" type="javascript"></script>
    <script src="${ctx}/static/js/cost/cost_list.js" type="javascript"></script>

</head>
<body>
<!-- Left column -->
<div class="templatemo-flex-row" style="height: 650px">
    <%@ include file="../../common/left.jsp"%>
    <!-- Main content -->
    <div class="breadnav"><span>首页</span> > 配送规则管理 </div>

    <div class="infor1">
        <div class="product message">
            <div class="main">
                <div class="part">
                    <span>消费详情：</span>
                    <select id="costDetail" style="width:170px">
                        <c:forEach items="${costDetailEnum}" var="item">
                            <option value="${item.code}">${item.cnName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="click">
        <a href="javascript:void(0);"><div class="button" <%--onclick="query()"--%>>查询</div></a>
        <a href="javascript:void(0);"><div class="button" onclick="showAddDiv()">新增</div></a>
    </div>

    <div class="content1" style="margin-top:80px;">
        <table id="costList"></table>
        <div id="pager"></div>
    </div>

</div>

<%--<div id="dialog1" class="content content1" style="display:none; ">--%>
    <%--<input type="text" id="id2" style="display:none"/>--%>
    <%--<table width="100%" style="width: 560px ">--%>
        <%--<tr height="35">--%>
            <%--<input type="hidden" id="addId"/>--%>
            <%--<td align="right">快递公司：</td>--%>
            <%--<td>--%>
                <%--<select id="expressName" style="width:170px">--%>
                    <%--<#list expressEnum as val>--%>
                        <%--<#if val.cnName!=''> <option value="${val}" <#if val=='SF_EXPRESS'>selected</#if>>${val.cnName}</option></#if>--%>
                    <%--</#list>--%>
                <%--</select>--%>
            <%--</td>--%>
            <%--<td align="right">是否有效：</td>--%>
            <%--<td>--%>
                <%--<select id="validStatus" style="width:170px">--%>
                    <%--<#list validStatusEnum as val>--%>
                        <%--<#if val.cnName!=''>--%>
                            <%--<option value="${val}" <#if val=='VALID'>selected</#if>>${val.cnName}</option>--%>
                        <%--</#if>--%>
                    <%--</#list>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr height="35">--%>
            <%--<td align="right">所属地区：</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="areaNameAdd" maxlength=3/>--%>
            <%--</td>--%>
            <%--<td align="right">最晚送到日：</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="maxArriveDay" />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr height="35">--%>
            <%--<td align="right">结算价：</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="expressFee" maxlength="6"/>--%>
            <%--</td>--%>
            <%--<td align="right">流向类型：</td>--%>
            <%--<td>--%>
                <%--<select id="flowType" style="width:170px">--%>
                    <%--<#list flowTypeEnum as val>--%>
                        <%--<#if val.cnName!=''>--%>
                            <%--<option value="${val}"  <#if val=='TWO_WAY'>selected</#if> >${val.cnName}</option>--%>
                        <%--</#if>--%>
                    <%--</#list>--%>
                <%--</select>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr height="35">--%>
            <%--<td align="right">目的地：</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="destinationProNames" maxlength=200 placeholder="目的省"/>--%>
            <%--</td>--%>
            <%--<td colspan="2"> <input type="text" id="destinationCityNames" style="width: 260px;" maxlength=200 placeholder="目的市" /></td>--%>
        <%--</tr>--%>
        <%--<tr height="35">--%>
            <%--<td align="right">发件地：</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="fromProNames" maxlength=200 placeholder="发件省"/>--%>
                <%--<input type="hidden" id="sendFromProIds" />--%>
            <%--</td>--%>
            <%--<td colspan="2">--%>
                <%--<input type="text" id="fromCityNames" style="width: 260px;" maxlength=200 placeholder="发件市" />--%>
                <%--<input type="hidden" id="sendFromCityIds" />--%>
            <%--</td>--%>
        <%--<tr height="35">--%>
            <%--<td align="right"></td>--%>
            <%--<td colspan="3">--%>
                <%--<span style="color: yellowgreen">目的地/发件地多个用英文逗号“,”分开, 只填一个ALL 标识不限制</span>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr height="35">--%>
            <%--<td colspan=4 align="center">--%>
                <%--<div class="click" style="margin:0 160px">--%>
                    <%--<a href="javascript:void(0);" onclick="saveOrUpdateDistributionRule();"><div class="button">保存</div></a>--%>
                    <%--<a href="javascript:void(0);" onclick="hideAddDiv();"><div class="button">取消</div></a>--%>
                <%--</div>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>

<!-- JS -->
<%--<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> --%> <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<%--<script type="text/javascript" src="js/templatemo-script.js"></script>  --%>      <!-- Templatemo Script -->
</body>
</html>
