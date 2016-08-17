$(document).ready(function(){
    $('#startTime').datetimepicker({
        lang:"ch",           //语言选择中文
        format:"Y-m-d",      //格式化日期
        timepicker:false,    //关闭时间选项
        //yearStart：2000,     //设置最小年份
        //yearEnd:2050,        //设置最大年份
        todayButton:false    //关闭选择今天按钮
    })
    $('#endTime').datetimepicker({
        lang:"ch",           //语言选择中文
        format:"Y-m-d",      //格式化日期
        timepicker:false,    //关闭时间选项
        //yearStart：2000,     //设置最小年份
        //yearEnd:2050,        //设置最大年份
        todayButton:false    //关闭选择今天按钮
    })
    $('#costTime').datetimepicker({
        lang:"ch",           //语言选择中文
        format:"Y-m-d",      //格式化日期
        timepicker:false,    //关闭时间选项
        //yearStart：2000,     //设置最小年份
        //yearEnd:2050,        //设置最大年份
        todayButton:false    //关闭选择今天按钮
    })
});
/**
 * 时间控件格式化
 */

/**
 *转换日期对象为日期字符串
 * @author Jack.Zhang
 * @param l long值
 * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss
 * @return 符合要求的日期字符串
 */
function getFormatDate(date, pattern) {
    if (date == undefined) {
        date = new Date();
    }
    if (pattern == undefined) {
        pattern = "yyyy-MM-dd hh:mm:ss";
    }
    return date.format(pattern);
}

/**
 * Date的扩展程序
 * @author Jack.Zhang
 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};