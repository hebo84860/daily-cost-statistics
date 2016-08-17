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
                            <span>消费类型：</span>
                            <select id="costType" style="width:170px">
                                <option value="" selected>全部</option>
                                <c:forEach items="${costTypeEnum}" var="item">
                                    <option value="${item}">${item.cnName}</option>
                                </c:forEach>
                            </select>
                            <span>消费详情：</span>
                            <select id="costDetail" style="width:170px">
                                <option value="" selected>全部</option>
                                <c:forEach items="${costDetailEnum}" var="item">
                                    <c:if test="${item.code!=''}">
                                        <option value="${item}">${item.cnName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                    </div>
                    <div class="col-lg-6 col-md-6 form-group">
                        <span>记录状态：</span>
                        <select id="status" style="width:170px">
                            <c:forEach items="${statusEnum}" var="item">
                                <option value="${item}">${item.cnName}</option>
                            </c:forEach>
                            <option value="">全部</option>
                        </select>
                        <div class="form-group text-right">
                            <input type="button" id="searchCostList" value="查询" class="templatemo-blue-button"/>
                            <input type="button" id="addCost" value="新增" class="templatemo-blue-button"/>
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


    <div id="dialogCost" class="content content1" style="display:none; ">
        <input type="text" id="id2" style="display:none"/>
        <table width="100%" style="width: 560px ">
            <tr height="35">
                <input type="hidden" id="addId"/>
                <td align="right">消费类型：</td>
                <td>
                    <select id="costTypeAdd" style="width:170px">
                       <c:forEach items="${costTypeEnum}" var="item">
                           <option value="${item}">${item.cnName}</option>
                       </c:forEach>
                    </select>
                </td>
                <td align="right">消费详情：</td>
                <td>
                    <select id="costDetailAdd" style="width:170px">
                        <c:forEach items="${costDetailEnum}" var="item">
                            <c:if test="${item.code!=''}">
                                <option value="${item}">${item.cnName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr height="35">
                <td align="right">有效状态：</td>
                <td>
                    <select id="statusAdd" style="width:170px">
                        <c:forEach items="${statusEnum}" var="item">
                            <option value="${item}">${item.cnName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">消费时间：</td>
                <td>
                    <input type="text" id="costTime" class="cssInput" readonly/>
                </td>
            </tr>
            <tr height="35">
                <td align="right">消费金额：</td>
                <td>
                    <input type="text" id="costAmount" class="cssInput" maxlength="10"/>
                </td>
                <td align="right">消费预算：</td>
                <td>
                    <input type="text" id="costBudget" class="cssInput" maxlength="10"/>
                </td>
            </tr>
            <tr height="35">
                <td align="right">消费者：</td>
                <td>
                    <input type="text" id="costUserName" class="cssInput" maxlength=30/>
                </td>
                <td align="right">消费者手机号：</td>
                <td>
                    <input type="text" id="costPhone" class="cssInput" maxlength=11/>
                </td>
            </tr>
            <tr height="35">
                <td align="right">消费描述：</td>
                <td colspan="3">
                    <textarea  id="description"  style="width:360px;height:70px;" cols="80" rows="4" ></textarea>
                </td>
            </tr>
            <tr height="35">
                <td align="right"></td>
                <td colspan="3">
                    <span style="color: yellowgreen">消费预算默认消费金额值，看修改。消费描述120字以内。</span>
                </td>
            </tr>
            <tr height="35">
                <td colspan=4 align="center">
                    <div class="click" style="margin:0 160px">
                        <a href="javascript:void(0);" id="saveOrUpdateCost"><div class="button">保存</div></a>
                        <a href="javascript:void(0);" id="hideAddDiv"><div class="button">取消</div></a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>

<!-- JS -->
<%--<script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script> --%> <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
<%--<script type="text/javascript" src="js/templatemo-script.js"></script>  --%>      <!-- Templatemo Script -->
</body>
</html>
