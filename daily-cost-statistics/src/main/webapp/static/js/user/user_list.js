$(document).ready(function() {
    initGrid();
    $("#searchCostList").off().on().click(function(){
        queryUserList();
    });

});


function queryUserList(){
    $("#userList").jqGrid('setGridParam', {
        url : "ajaxQueryUserList",
        datatype : "json",
        mtype : "POST",
        postData : getUserListParams()
    }).trigger("reloadGrid");
}

function initGrid() {
    $("#userList").jqGrid({
        url : "ajaxQueryUserList",
        datatype : "json",
        mtype : "POST",
        colNames : ['编号','用户名','真实姓名','手机号','邮箱','用户等级','第一推荐人','第二推荐人','用户状态','创建时间','创建人',"修改时间","修改人","操作"],
        colModel : [
            {
                name : 'id',
                index : 'id',
                align : 'center',
                sortable:false
                },{
                name : 'username',
                index : 'username',
                align : 'center',
                sortable:false
                },{
                    name : 'realname',
                    index : 'realname',
                    align : 'center',
                    sortable:false
                },{
                    name : 'phone',
                    index : 'phone',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'email',
                    index : 'email',
                    align : 'center',
                    sortable:false
                },{
                    name : 'userRoleStr',
                    index : 'userRoleStr',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'recommendFirstName',
                    index : 'recommendFirstName',
                    align : 'center',
                    sortable:false
                },{
                    name : 'recommendSecondName',
                    index : 'recommendSecondName',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'statusStr',
                    index : 'statusStr',
                    align : 'center',
                    cellattr: addStatusCellAttr,
                    sortable : false
                },{
                    name : 'createTimeStr',
                    index : 'createTimeStr',
                    align : 'center',
                    sortable : false
                },{
                    name : 'createUser',
                    index : 'createUser',
                    align : 'center',
                    sortable : false
                },{
                    name : 'updateTimeStr',
                    index : 'updateTimeStr',
                    align : 'center',
                    hidden : true,
                    sortable : false
                },{
                    name : 'updateUser',
                    index : 'updateUser',
                    align : 'center',
                    sortable : false
                },{
                    name : 'operate',
                    index : 'operate',
                    align : 'center',
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
        postData : getUserListParams(),
        jsonReader : {
            root : "results",               // json中代表实际模型数据的入口
            page : "pagination.page",       // json中代表当前页码的数据
            records : "pagination.records", // json中代表数据行总数的数据
            total:'pagination.total',       // json中代表页码总数的数据
            repeatitems : false             // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
        },
        onPaging : function(pgButton) {
            $("#userList").jqGrid('setGridParam', {
                postData : getUserListParams()
            });
        }
        ,
        gridComplete:function(){  //在此事件中循环为每一行添加
            var ids=jQuery("#userList").jqGrid('getDataIDs');
            var operateClick;
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var rowData = $('#userList').jqGrid('getRowData', id);
                var userId = rowData['id'];
                var status = rowData['status'];
                var statusStr = rowData['statusStr'];
                //显示设为有效/ 无效链接
                if(statusStr=="有效"){
                    operateClick = '<a href="javascript:void(0)" style="color:blue" onclick="modifyuserStatus(' + "'" +
                        userId+ "' ,'" + status + "' ,'" + statusStr + "'" + ')" >设为无效</a>'
                        +" | <a href='javascript:void(0)' onclick='showAddDiv("+id+")' style='color:blue;'>编辑</a>";
                }else{
                    operateClick = '<a href="javascript:void(0)" style="color:blue" onclick="modifyuserStatus(' + "'" +
                        userId+ "' ,'" + status + "' ,'" + statusStr + "'" + ')" >设为有效</a>';
                }

                jQuery("#userList").jqGrid('setRowData', id, {operate: operateClick});
            }
        }
    });
}

function addStatusCellAttr(rowId, val, rawObject, cm, rdata) {
    if (val=='无效') {
        return "style='color:red'";
    }
}

function getUserListParams(){
    return {
        'username' : $("#username").val(),
        'status' : $("#status").val()
    }
}
/**
 * 设置默认时间
 */
function setDefaultTime() {
    $("#userTime").val(getFormatDate(new Date(), 'yyyy-MM-dd'));
    //var curDate = new Date();
    //var startDate = (curDate.getFullYear()-1) + "/" + (curDate.getMonth() + 1);
    //$(".startTime").val(getFormatDate(new Date(startDate), 'yyyy-MM-dd'));
    //$('.endTime').val(getFormatDate(new Date(), 'yyyy-MM-dd'));
}


//修改消费状态
function modifyCostStatus(id, status, validStatusStr) {
    if (validStatusStr=="有效") {
        status = "INVALID";
        layer.prompt({
            title: '设为无效，请填写原因。',
            formType: 2 //prompt风格，支持0-2
        }, function(reason){
            ajaxModifyCostStatus(id, status,reason);
        });
    }else{
        status = "VALID";
        /*gnl = */
        layer.confirm("确认将该记录设为有效？",{btn: ['确定','取消'] },
                function(){
                    ajaxModifyCostStatus(id, status,'');
                    //layer.close(gnl);
                }
        );
    }
}

function ajaxModifyCostStatus(id, status,reason){
    $.ajax({
        url : 'modifyCostStatus',
        type:'post',
        dataType : "json",
        data : {
            id:id,
            status : status,
            reason : reason
        },
        success: function(data){
            if(data.status)
                window.location.reload();
            else
                layer.alert(data.message);
        }
    });
}