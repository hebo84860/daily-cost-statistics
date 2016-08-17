$(document).ready(function(){
    setDefaultTime();
    chooseEcharts($("#flag").val());
    $("#searchButton").off().on().click(function(){
        countCostAmount($(this).attr("flag"))
    });
});

function chooseEcharts(f){
    if (f=="costAmount") {
        $(".li-costAmount").addClass("li-active");
        countCostAmount();
    }
}

function countCostAmount(){
    //$(".date-scope").show();
    $("#searchButton").attr("flag","countAmount");
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line'
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('main'));
            myChart.showLoading({
                text: '正在努力加载中...'
            });
            var xDate = [];
            var yDate = [];
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../cost/countCostAmount',
                type: 'get',
                dataType:'json',
                data:getCountCostParams(),
                success: function(data){
                    if (data.result!=null&& data.result.staticticsVOs.length>0) {
                        $.each(data.result.staticticsVOs, function (i, e) {
                            xDate.push(e.mouth);
                            yDate.push(e.mouthCost);
                        });
                        $("#costAmount").text(data.result.costTotal);
                    }else{
                        xDate.push(getFormatDate(new Date(), 'yyyy-MM-dd'));
                        yDate.push(0);
                        $("#costAmount").text(0);
                    }
                }
            });
            var option = {
                title : {
                    text: '每月消费：'
                },
                tooltip : {
                    trigger: 'axis',
                    formatter: '{b}月<br>{a0}：{c0}元<!--<br>{a1}：{c1}%-->'
                },
                legend: {
                    data:['月消费']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : xDate,
                        name : "月份"
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel: {
                            formatter: '{value} 元'
                        },
                        name:'消费金额'
                    }
                ],
                series : [
                    {
                        name:'月消费',
                        type:'bar',
                        data:yDate,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大月消费'},
                                {type : 'min', name: '最小月消费'}
                            ],
                            itemStyle:{
                                normal:{
                                    label:{
                                        show:true,
                                        position:'top',
                                        textStyle:{
                                            fontSize:12
                                        },
                                        formatter:'{b}：{c}'
                                    }
                                }
                            }

                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '月平均消费'}
                            ]
                        }
                    }
                ]
            };
            myChart.setOption(option);
            myChart.hideLoading();
        }
    );
}

function getCountCostParams(){
    return {
        'costTimeStart' : $(".startTime").val(),
        'costTimeEnd' : $(".endTime").val(),
        'costDetail' : $("#costDetail").val(),
        'costType' : $("#costType").val(),
        'status' : $("#status").val()
    }
}

/**
 * 设置默认时间
 */
function setDefaultTime() {
    var curDate = new Date();
    var startDate = (curDate.getFullYear()-1) + "/" + (curDate.getMonth() + 1)+ '/01';
    $(".startTime").val(getFormatDate(new Date(startDate), 'yyyy-MM-dd'));
    $('.endTime').val(getFormatDate(new Date(), 'yyyy-MM-dd'));
}