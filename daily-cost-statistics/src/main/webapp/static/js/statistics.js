$(document).ready(function(){
    chooseMethod($("#flag").val());
    setDefaultTime();
    $("#searchButton").off().on().click(function(){
        //var re = /^\d{4}-\d{2}-\d{2}$/;
        chooseMethod($(this).attr("flag"))
    });
});
function chooseMethod(c){
    if (c=="count") {
        $(".li-count").addClass("li-active");
        countProjectCharts();
    }else if(c=="amount") {
        $(".li-amount").addClass("li-active");
        salesProjectAmount();
    }else if(c=="time") {
        $(".li-time").addClass("li-active");
        salesTimeAmount();
    }else if(c=="member") {
        $(".li-member").addClass("li-active");
        countMember();
    }else if(c=="terminal") {
        $(".li-terminal").addClass("li-active");
        countScalePlatform();
    }else if(c=="map") {
        $(".li-map").addClass("li-active");
        salesMap();
    }
}
function countProjectCharts(){
    $(".date-scope").show();
    $("#searchButton").attr("flag","count");
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths: {
            //echarts: 'http://echarts.baidu.com/build/dist'
            echarts: '../../static/js/echarts'
        }
    });

    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line'
        ],
        function (ec) {
            //--- 折柱 ---
            var myChart = ec.init(document.getElementById('main'));
            myChart.showLoading({
                text: '正在努力加载中...'
            });

            var count = 0;
            var xDate = [];
            var yDate = [];
            var paramsJson={};
            if($(".startTime").val()!='')
                paramsJson["startTime"] = $(".startTime").val();
            if($(".endTime").val()!='')
                paramsJson["endTime"] = $(".endTime").val();
            // 同步执行
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../ps/countSalesProject',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify(paramsJson)},
                success: function(data){
                    $.each(data.projects, function(i, e){
                        xDate.push(e.mouth);
                        yDate.push(e.countProject);
                    });
                    count = data.count;
                }

            });
            var option = {
                title: {
                    text: '当前上项目总数：'+ count +' 个'
                },
                tooltip: { trigger: 'axis' },
                legend: {
                    data: [{ name: '项目数' }]
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: xDate,
                        name:'月份'
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} 个'
                        },
                        name:'项目数'
                    }
                ],
                series: [
                    {
                        name: '项目数',
                        type: 'line',
                        data: yDate,
                        markPoint:{
                            data:[
                                {type:"max",name:'上线项目最多'},
                                {type:"min",name:'上线项目最少'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
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
function salesProjectAmount(){
    $(".date-scope").show();
    $("#searchButton").attr("flag","amount");
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
            var count = 0;
            var xDate = [];
            var yDate = [];
            var paramsJson={};
            if($(".startTime").val()!='')
                paramsJson["startTime"] = $(".startTime").val();
            if($(".endTime").val()!='')
                paramsJson["endTime"] = $(".endTime").val();
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../ps/salesProjectAmount',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify(paramsJson)},
                success: function(data){
                    $.each(data.projects, function(i, e){
                        xDate.push(e.mouth);
                        yDate.push(e.amountProject);
                    });
                    count = data.amount;
                }
            });
            var option = {
                title: {
                    text: '当前项目总金额：'+ (count || 0).toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,') + '元'
                },
                tooltip: { trigger: 'axis' },
                legend: {
                    data: [{ name: '总金额' }]
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: xDate,
                        name: '月份'
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: function (value, index) {
                                return toThousands(value).toString()+'元';
                            }
                        },
                        name:'总金额'
                    }
                ],
                series: [
                    {
                        name: '总金额',
                        type: 'line',
                        data: yDate,
                        markPoint:{
                            data:[
                                {type:"max",name:'最大金额'},
                                {type:"min",name:'最小金额'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
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
function salesTimeAmount(){
    $(".date-scope").hide();
    $("#searchButton").attr("flag","time");
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
                url:'../ps/salesTimeAmount',
                type: 'get',
                dataType:'json',
                success: function(data){
                    $.each(data, function(i, e){
                        xDate.push(e.amountProject);
                        yDate.push(e.countProject);
                    });
                }
            });
            var option = {
                title: {
                    text: '各金额销售最快时间'
                },
                tooltip: { trigger: 'axis' },
                legend: {
                    data: [{ name: '用时' }]
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: xDate,
                        name:'额度',
                        axisLabel:{
                            formatter: function (value, index) {
                                return toThousands(value)+'元';
                            }
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: function (value, index) {
                                return toThousands(value).toString()+'分钟';
                            }
                        },
                        name:'最短用时'
                    }
                ],
                series: [
                    {
                        name: '用时',
                        type: 'line',
                        data: yDate,
                        markPoint:{
                            data:[
                                {type:"max",name:'最大耗时'},
                                {type:"min",name:'最少耗时'}
                            ],
                            itemStyle:{
                                normal:{
                                    label:{
                                        show:true,
                                        position:'top',
                                        textStyle:{
                                            fontSize:12,
                                            color:'red'
                                        },
                                        formatter:function(a,b,c){
                                            var f = a.value;
                                            if (f>59 || f<-59) {
                                                return (Math.floor(f / 60)) + "小时" + f % 60 + '分';
                                            } else {
                                                return f+'分';
                                            }
                                        }
                                    }
                                }
                            }
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        },
                        itemStyle:{
                            normal:{
                                label:{
                                    show:true,
                                    position:'top',
                                    textStyle:{
                                        fontSize:12,
                                        //color:'#99CCFF'
                                    },
                                    formatter:function(a,b,c){
                                        var f = a.value;
                                        if (f>59) {
                                            return (Math.floor(f / 60)) + "小时" + f % 60 + '分';
                                        } else {
                                            return f+'分';
                                        }
                                    }
                                }
                            }
                        }
                    }

                ]
            };
            myChart.setOption(option);
            myChart.hideLoading();
        }
    );
}
function countMember(){
    $(".date-scope").show();
    $("#searchButton").attr("flag","member");
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
            var count = 0;
            var xDate1 = [];
            var yDate1 = [];
            var yDate2 = [];
            var paramsJson={};
            if($(".startTime").val()!='')
                paramsJson["startTime"] = $(".startTime").val();
            if($(".endTime").val()!='')
                paramsJson["endTime"] = $(".endTime").val();
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../ps/addMemberNumber',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify(paramsJson)},
                success: function(data){
                    $.each(data, function(i, e){
                        xDate1.push(e.mouth);
                        yDate1 .push(e.countProject);
                    });
                }
            });
            $.ajax({
                url:'../ps/buyersMemberNumber',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify(paramsJson)},
                success: function(data){
                    $.each(data.projects, function(i, e){
                        yDate2.push(e.countProject);
                    });
                    count = data.count;
                }
            });
            var option = {
                title: {
                    text: '当前有购买会员总数：'+ count + '人'
                },
                tooltip: { trigger: 'axis' },
                legend: {
                    data:['会员总数','有购买记录会员']
                },
                toolbox: {
                    show: true,
                    boundaryGap: false,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
               /* calculable: true,*/
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: xDate1,
                        name:'月份'
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} 人'
                        },
                        name:'人数'
                    }
                ],
                series: [
                    {
                        name: '会员总数',
                        type: 'line',
                        data: yDate1,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name: '有购买记录会员',
                        type: 'line',
                        data: yDate2,
                        markPoint: {
                            data: [
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
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
function countScalePlatform(){
    $(".date-scope").show();
    $("#searchButton").attr("flag","terminal");
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
            var xDate1 = [];
            var xDate2 = [];
            var yDate1 = [];
            var yDate2 = [];
            var paramsJson = {};
            if($(".startTime").val()!='')
                paramsJson["startTime"] = $(".startTime").val();
            if($(".endTime").val()!='')
                paramsJson["endTime"] = $(".endTime").val();
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../ps/countScalePlatform',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify(paramsJson)},
                success: function(map){
                    $.each(map.PC, function(i, e){
                        xDate1.push(e.mouth);
                        yDate1 .push(e.scalePlatform);
                    });
                    $.each(map.mobile, function(i, e){
                        xDate2.push(e.mouth);
                        yDate2 .push(e.scalePlatform);
                    });
                }
            });
            var option = {
                title : {
                    text: '每月终端购买比例：'
                },
                tooltip : {
                    trigger: 'axis',
                    formatter: '{b}月<br>{a0}：{c0}%<br>{a1}：{c1}%'
                },
                legend: {
                    data:['PC端','移动端']
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
                        data : xDate1,
                        name : "月份"
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel: {
                            formatter: '{value} %'
                        },
                        name:'百分比'
                    }
                ],
                series : [
                    {
                        name:'PC端',
                        type:'bar',
                        data:yDate1,
                        markPoint : {
                            data : [
                                {type : 'max', name: 'PC最大比例'},
                                {type : 'min', name: 'PC最小比例'}
                            ],
                            itemStyle:{
                                normal:{
                                    label:{
                                        show:true,
                                        position:'top',
                                        textStyle:{
                                            fontSize:12
                                        },
                                        formatter:'{a}\n{b}：{c}%'
                                    }
                                }
                            }

                        }
                    },
                    {
                        name:'移动端',
                        type:'bar',
                        data:yDate2,
                        markPoint : {
                            data : [
                                {type : 'max', name: '移动端最大比例'},
                                {type : 'min', name: '移动端最小比例'}
                            ],
                            itemStyle:{
                                normal:{
                                    label:{
                                        show:true,
                                        position:'top',
                                        textStyle:{
                                            fontSize:12,
                                        },
                                        formatter:'{a}\n{b}：{c}%'
                                    }
                                }
                            }
                        }
                    }
                ]
            };
            myChart.setOption(option);
            myChart.hideLoading();
        }
    );
}


function  salesMap(){
    $(".date-scope").show();
    $("#searchButton").attr("flag","map");
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/map'
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('main'));
            var option;
            myChart.showLoading({
                text: '正在努力加载中...'
            });
            var provinces = [];
            var cities = [];
            var count = 0;
            var paramsJson = {};
            $.ajaxSettings.async = false;
            $.ajax({
                url:'../ps/countSalesMap',
                type: 'get',
                dataType:'json',
                data:{"paramsJson":JSON.stringify({"startTime":$(".startTime").val(), 'endTime':$(".endTime").val()})},
                success: function(map){
                    if (map.code==0) {
                        count = map.count;
                        $.each(map.Pro, function (k, v) {
                            provinces.push({name: k, value: v, selected: true});
                        });
                        $.each(map.City, function (k, v) {
                            cities.push({name: k, value: v});
                        });
                    }else
                        alert(map.msg);
                }
            });
            option =
            {
                title : {
                    text: '总购买数：'+ count
                },
                tooltip : {
                    trigger: 'item',
                    formatter: '{b}：{c}人次'
                },
                toolbox: {
                    show : true,
                    orient: 'vertical',
                    x:'right',
                    y:'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false}
                    }
                },
                series : [
                    {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{b}：{c}人次'
                        },
                        name: '选择器',
                        type: 'map',
                        mapType: 'china',
                        mapLocation: {
                            x: 'left',
                            y: 'top',
                            width: '30%'
                        },
                        roam: true,
                        selectedMode : 'single',
                        itemStyle:{
                            //normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:provinces
                    }
                ],
                animation: false
            };
            var ecConfig = require('echarts/config');
            myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param){
                var selected = param.selected;
                var selectedProvince;
                var name;
                for (var i = 0, l = option.series[0].data.length; i < l; i++) {
                    name = option.series[0].data[i].name;
                    //option.series[0].data[i].selected = selected[name];
                    if (selected[name]) {
                        selectedProvince = name;
                    }
                }
                if (typeof selectedProvince == 'undefined') {
                    option.series.splice(1);
                    option.legend = null;
                    option.dataRange = null;
                    myChart.setOption(option, true);
                    return;
                }
                option.series[1] = {
                    name: '购买次数',
                    type: 'map',
                    mapType: selectedProvince,
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    mapLocation: {
                        x: '35%'
                    },
                    roam: true,
                    data:cities
                };
                option.legend = {
                    x:'right',
                    data:['购买次数']
                };
                option.dataRange = {
                    orient: 'horizontal',
                    x: 'right',
                    min: 0,
                    max: 1000,
                    color:['orange','yellow'],
                    text:['高','低'],           // 文本，默认为数值文本
                    splitNumber:0
                };
                myChart.setOption(option, true);
            })

            myChart.setOption(option);
            myChart.hideLoading();
        }
    );

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
/**
 * 数字千位符格式化
 * @param num
 * @returns {string}
 */
function toThousands(num) {
    var num = (num || 0).toString(), result = '';
    while (num.length > 3) {
        result = ',' + num.slice(-3) + result;
        num = num.slice(0, num.length - 3);
    }
    if (num) { result = num + result; }
    return result;
}
