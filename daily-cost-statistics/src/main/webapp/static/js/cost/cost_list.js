$(document).ready(function() {
    initGrid();
    setDefaultTime();
    $("#searchCostList").off().on().click(function(){
        queryCostList();
    });
    $("#addCost").off().on().click(function(){
        showAddDiv();
    });
    $("#saveOrUpdateCost").off().on().click(function(){
        saveOrUpdateCost();
    });
    $("#hideAddDiv").off().on().click(function(){
        hideAddDiv();
    });

});

function saveOrUpdateCost(){
    var url_ = 'ajaxAddOrUpdateCost';
    var costAmount = $("#costAmount").val();
    var costPhone = $("#costPhone").val();
    if(!costAmount){
        alert("请填写消费金额！");
        return false;
    }
    var reg = /^(1)\d{10}$/;
    if(costPhone && !reg.test(costPhone)){
        alert("请填写正确的手机号");
        return false;
    }
    $.ajax({
        url:url_,
        type:'post',
        dataType: "json",
        data:{
            'costType':$("#costTypeAdd").val(),
            costDetail:$("#costDetailAdd").val(),
            costUserName:$("#costUserName").val(),
            costPhone:costPhone,
            costAmount:costAmount,
            costTimeStr:$("#startTime").val(),
            description:$("#description").val(),
            id:$("#addId").val()
        },
        success:function(data){
            console.info(data);
            alert(data.message);
            if(data.status==true){
                hideAddDiv();
                window.location.href=window.location.href;
            }
        }
    });
}

function showAddDiv(id){

    $('#dialogCost').dialog({
        title: '新增消费记录',
        width: 600,
        height: 299,
        modal: 'true'
    });
}

function hideAddDiv(){
    $('#dialogCost').dialog("close");
}

function queryCostList(){
    $("#costList").jqGrid('setGridParam', {
        url : "ajaxQueryCostList",
        datatype : "json",
        mtype : "POST",
        postData : getCostListParams()
    }).trigger("reloadGrid");
}

function initGrid() {
    $("#costList").jqGrid({
        url : "ajaxQueryCostList",
        datatype : "json",
        mtype : "POST",
        colNames : ['编号','消费详情','消费金额','消费者','消费时间','消费描述','消费记录状态','消费记录类型','创建时间','创建人',"修改时间","修改人"],
        colModel : [
            {
                name : 'id',
                index : 'id',
                align : 'center',
                sortable:false
                }, {
                name : 'costDetailStr',
                index : 'costDetailStr',
                align : 'center',
                //width :220,
                sortable:false
            },{
                name : 'costAmount',
                index : 'costAmount',
                align : 'center',
                sortable:false
            }, {
                name : 'costUserName',
                index : 'costUserName',
                align : 'center',
                sortable:false
            }, {
                name : 'costTimeStr',
                index : 'costTimeStr',
                align : 'center',
                sortable:false
            }, {
                name : 'description',
                index : 'description',
                align : 'center',
                sortable : false
            },{
                name : 'statusStr',
                index : 'statusStr',
                align : 'center',
                sortable : false
            },{
                name : 'costTypeStr',
                index : 'costTypeStr',
                align : 'center',
                sortable : false
            },{
                name : 'createTimeStr',
                index : 'createTimeStr',
                align : 'center',
                sortable:false
            }, {
                name : 'createBy',
                index : 'createBy',
                align : 'center',
                sortable:false
            }, {
                name : 'updateTimeStr',
                index : 'updateTimeStr',
                align : 'center',
                sortable:false
            }, {
                name : 'updateBy',
                index : 'updateBy',
                align : 'center',
                //hidden : true,
                sortable:false
            }
        ],
        rowNum:10,            //每页显示记录数
        autowidth: true,      //自动匹配宽度
        pager: '#pager',      //表格数据关联的分页条，html元素
        rowList:[10,20,50,200],   //分页选项，可以下拉选择每页显示记录数
        viewrecords: true,    //显示总记录数
        height:'auto',//高度，表格高度。可为数值、百分比或'auto'
        //autoheight: true,     //设置高度
        gridview:true,        //加速显示
        multiselect : false,
        sortable:true,        //可以排序
        sortname: 'createDate',  //排序字段名
        sortorder: "desc",    //排序方式：倒序
        caption : "消费记录列表",
        postData : getCostListParams(),
        jsonReader : {
            root : "results",               // json中代表实际模型数据的入口
            page : "pagination.page",       // json中代表当前页码的数据
            records : "pagination.records", // json中代表数据行总数的数据
            total:'pagination.total',       // json中代表页码总数的数据
            repeatitems : false             // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
        },
        onPaging : function(pgButton) {
            $("#distributionList").jqGrid('setGridParam', {
                postData : getCostListParams()
            });
        }
        ,
        gridComplete:function(){  //在此事件中循环为每一行添加
            var ids=jQuery("#costList").jqGrid('getDataIDs');
            var operateClick;
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var rowData = $('#distributionList').jqGrid('getRowData', id);
                var distributionRuleId = rowData['id'];
                var validStatus = rowData['validStatus'];
                var validStatusStr = rowData['validStatusStr'];
                //显示设为有效/ 无效链接
                if(validStatusStr=="有效"){
                    operateClick = '<a href="javascript:void(0)" style="color:blue" onclick="disableDistribution(' + "'" +
                        distributionRuleId+ "' ,'" + validStatus + "' ,'" + validStatusStr + "'" + ')" >设为无效</a>'
                        +" | <a href='javascript:void(0)' onclick='showAddDiv("+id+")' style='color:blue;'>编辑</a>";
                }else{
                    operateClick = '<a href="javascript:void(0)" style="color:blue" onclick="disableDistribution(' + "'" +
                        distributionRuleId+ "' ,'" + validStatus + "' ,'" + validStatusStr + "'" + ')" >设为有效</a>';
                }

                jQuery("#distributionList").jqGrid('setRowData', id, {operate: operateClick});
            }
        }
    });
}

function getCostListParams(){
    return {
        'costDetail' : $("#costDetail").val(),
        'costType' : $("#costType").val()
    }
}
/**
 * 设置默认时间
 */
function setDefaultTime() {
    var curDate = new Date();
    var startDate = (curDate.getFullYear()-1) + "/" + (curDate.getMonth() + 1);
    $("#startTime").val(getFormatDate(new Date(startDate), 'yyyy-MM-dd'));
    //$('.endTime').val(getFormatDate(new Date(), 'yyyy-MM-dd'));
}