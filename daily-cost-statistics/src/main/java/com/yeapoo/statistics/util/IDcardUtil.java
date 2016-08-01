package com.yeapoo.statistics.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证工具类
 * Created by hebo on 2016/4/27.
 */
public class IDcardUtil implements Serializable {

    /**
     * 身份证省代码
     */
    public static Map<String, String> proCodes = new HashMap<String, String>();
    public static Map<String, String> cityCodes = new HashMap<String, String>();
    static {
        proCodes.put("11", "北京");
        proCodes.put("12", "天津");
        proCodes.put("13", "河北");
        proCodes.put("14", "山西");
        proCodes.put("15", "内蒙古");
        proCodes.put("21", "辽宁");
        proCodes.put("22", "吉林");
        proCodes.put("23", "黑龙江");
        proCodes.put("31", "上海");
        proCodes.put("32", "江苏");
        proCodes.put("33", "浙江");
        proCodes.put("34", "安徽");
        proCodes.put("35", "福建");
        proCodes.put("36", "江西");
        proCodes.put("37", "山东");
        proCodes.put("41", "河南");
        proCodes.put("42", "湖北");
        proCodes.put("43", "湖南");
        proCodes.put("44", "广东");
        proCodes.put("45", "广西");
        proCodes.put("46", "海南");
        proCodes.put("50", "重庆");
        proCodes.put("51", "四川");
        proCodes.put("52", "贵州");
        proCodes.put("53", "云南");
        proCodes.put("54", "西藏");
        proCodes.put("61", "陕西");
        proCodes.put("62", "甘肃");
        proCodes.put("63", "青海");
        proCodes.put("64", "宁夏");
        proCodes.put("65", "新疆");
        proCodes.put("71", "台湾");
        proCodes.put("81", "香港");
        proCodes.put("82", "澳门");
        proCodes.put("91", "国外");

        /**
         * ==市信息
         */
        cityCodes.put("110101", "东城区");
        cityCodes.put("110102", "西城区");
        cityCodes.put("110105", "朝阳区");
        cityCodes.put("110106", "丰台区");
        cityCodes.put("110107", "石景山区");
        cityCodes.put("110108", "海淀区");
        cityCodes.put("110109", "门头沟区");
        cityCodes.put("110111", "房山区");
        cityCodes.put("110112", "通州区");
        cityCodes.put("110113", "顺义区");
        cityCodes.put("110114", "昌平区");
        cityCodes.put("110115", "大兴区");
        cityCodes.put("110116", "怀柔区");
        cityCodes.put("110117", "平谷区");
        cityCodes.put("110228", "密云县");
        cityCodes.put("110229", "延庆县");

        cityCodes.put("120101", "和平区");
        cityCodes.put("120102", "河东区");
        cityCodes.put("120103", "河西区");
        cityCodes.put("120104", "南开区");
        cityCodes.put("120105", "河北区");
        cityCodes.put("120106", "红桥区");
        cityCodes.put("120110", "东丽区");
        cityCodes.put("120111", "西青区");
        cityCodes.put("120112", "津南区");
        cityCodes.put("120113", "北辰区");
        cityCodes.put("120114", "武清区");
        cityCodes.put("120115", "宝坻区");
        cityCodes.put("120116", "滨海新区");
        cityCodes.put("120221", "宁河县");
        cityCodes.put("120223", "静海县");
        cityCodes.put("120225", "蓟县");

        cityCodes.put("310101", "黄浦区");
        cityCodes.put("310104", "徐汇区");
        cityCodes.put("310105", "长宁区");
        cityCodes.put("310106", "静安区");
        cityCodes.put("310107", "普陀区");
        cityCodes.put("310108", "闸北区");
        cityCodes.put("310109", "虹口区");
        cityCodes.put("310110", "杨浦区");
        cityCodes.put("310112", "闵行区");
        cityCodes.put("310113", "宝山区");
        cityCodes.put("310114", "嘉定区");
        cityCodes.put("310115", "浦东新区");
        cityCodes.put("310116", "金山区");
        cityCodes.put("310117", "松江区");
        cityCodes.put("310118", "青浦区");
        cityCodes.put("310120", "奉贤区");
        cityCodes.put("310230", "崇明县");

        cityCodes.put("500101", "万州区");
        cityCodes.put("500102", "涪陵区");
        cityCodes.put("500103", "渝中区");
        cityCodes.put("500104", "大渡口区");
        cityCodes.put("500105", "江北区");
        cityCodes.put("500106", "沙坪坝区");
        cityCodes.put("500107", "九龙坡区");
        cityCodes.put("500108", "南岸区");
        cityCodes.put("500109", "北碚区");
        cityCodes.put("500110", "綦江区");
        cityCodes.put("500111", "大足区");
        cityCodes.put("500112", "渝北区");
        cityCodes.put("500113", "巴南区");
        cityCodes.put("500114", "黔江区");
        cityCodes.put("500115", "长寿区");
        cityCodes.put("500116", "江津区");
        cityCodes.put("500117", "合川区");
        cityCodes.put("500118", "永川区");
        cityCodes.put("500119", "南川区");
        cityCodes.put("500120", "璧山区");
        cityCodes.put("500151", "铜梁区");
        cityCodes.put("500223", "潼南县");
        cityCodes.put("500226", "荣昌县");
        cityCodes.put("500228", "梁平县");
        cityCodes.put("500229", "城口县");
        cityCodes.put("500230", "丰都县");
        cityCodes.put("500331", "垫江县");
        cityCodes.put("500232", "武隆县");
        cityCodes.put("500233", "忠县");
        cityCodes.put("500234", "开县");
        cityCodes.put("500235", "云阳县");
        cityCodes.put("500236", "奉节县");
        cityCodes.put("500237", "巫山县");
        cityCodes.put("500238", "巫溪县");
        cityCodes.put("500240", "石柱土家族自治县");
        cityCodes.put("500241", "秀山土家族苗族自治县");
        cityCodes.put("500242", "酉阳土家族苗族自治县");
        cityCodes.put("500243", "彭水苗族土家族自治县");


        cityCodes.put("6528","巴音郭楞蒙古自治州");
        cityCodes.put("6532","和田地区");
        cityCodes.put("6522","哈密地区");
        cityCodes.put("6529","阿克苏地区");
        cityCodes.put("6543","阿勒泰地区");
        cityCodes.put("6531","喀什地区");
        cityCodes.put("6542","塔城地区");
        cityCodes.put("6523","昌吉回族自治州");
        cityCodes.put("6530","克孜勒苏柯尔克孜自治州");
        cityCodes.put("6521","吐鲁番地区");
        cityCodes.put("6540","伊犁哈萨克自治州");
        cityCodes.put("6527","博尔塔拉蒙古自治州");
        cityCodes.put("6501","乌鲁木齐市");
        cityCodes.put("6502","克拉玛依市");
        //直辖县
        cityCodes.put("659001","石河子市");
        cityCodes.put("659002","阿拉尔市");
        cityCodes.put("659003","图木舒克市");
        cityCodes.put("659004","五家渠市");

        cityCodes.put("5424","那曲地区");
        cityCodes.put("5425","阿里地区");
        cityCodes.put("5402","日喀则地区");
        cityCodes.put("5426","林芝地区");
        cityCodes.put("5421","昌都地区");
        cityCodes.put("5422","山南地区");
        cityCodes.put("5401","拉萨市");

        cityCodes.put("1507","呼伦贝尔市");
        cityCodes.put("1529","阿拉善盟");
        cityCodes.put("1525","锡林郭勒盟");
        cityCodes.put("1506","鄂尔多斯市");
        cityCodes.put("1504","赤峰市");
        cityCodes.put("1508","巴彦淖尔市");
        cityCodes.put("1505","通辽市");
        cityCodes.put("1509","乌兰察布市");
        cityCodes.put("1522","兴安盟");
        cityCodes.put("1502","包头市");
        cityCodes.put("1501","呼和浩特市");
        cityCodes.put("1503","乌海市");

        cityCodes.put("6328","海西蒙古族藏族自治州");
        cityCodes.put("6327","玉树藏族自治州");
        cityCodes.put("6326","果洛藏族自治州");
        cityCodes.put("6325","海南藏族自治州");
        cityCodes.put("6322","海北藏族自治州");
        cityCodes.put("6323","黄南藏族自治州");
        cityCodes.put("6302","海东地区");
        cityCodes.put("6301","西宁市");

        cityCodes.put("5133","甘孜藏族自治州");
        cityCodes.put("5132","阿坝藏族羌族自治州");
        cityCodes.put("5134","凉山彝族自治州");
        cityCodes.put("5107","绵阳市");
        cityCodes.put("5117","达州市");
        cityCodes.put("5108","广元市");
        cityCodes.put("5118","雅安市");
        cityCodes.put("5115","宜宾市");
        cityCodes.put("5111","乐山市");
        cityCodes.put("5113","南充市");
        cityCodes.put("5119","巴中市");
        cityCodes.put("5105","泸州市");
        cityCodes.put("5101","成都市");
        cityCodes.put("5120","资阳市");
        cityCodes.put("5104","攀枝花市");
        cityCodes.put("5114","眉山市");
        cityCodes.put("5116","广安市");
        cityCodes.put("5106","德阳市");
        cityCodes.put("5110","内江市");
        cityCodes.put("5109","遂宁市");
        cityCodes.put("5103","自贡市");

        cityCodes.put("2311","黑河市");
        cityCodes.put("2327","大兴安岭地区");
        cityCodes.put("2301","哈尔滨市");
        cityCodes.put("2302","齐齐哈尔市");
        cityCodes.put("2310","牡丹江市");
        cityCodes.put("2312","绥化市");
        cityCodes.put("2307","伊春市");
        cityCodes.put("2308","佳木斯市");
        cityCodes.put("2303","鸡西市");
        cityCodes.put("2305","双鸭山市");
        cityCodes.put("2306","大庆市");
        cityCodes.put("2304","鹤岗市");
        cityCodes.put("2309","七台河市");

        cityCodes.put("6209","酒泉市");
        cityCodes.put("6207","张掖市");
        cityCodes.put("6230","甘南藏族自治州");
        cityCodes.put("6206","武威市");
        cityCodes.put("6212","陇南市");
        cityCodes.put("6210","庆阳市");
        cityCodes.put("6204","白银市");
        cityCodes.put("6211","定西市");
        cityCodes.put("6205","天水市");
        cityCodes.put("6201","兰州市");
        cityCodes.put("6208","平凉市");
        cityCodes.put("6229","临夏回族自治州");
        cityCodes.put("6203","金昌市");
        cityCodes.put("6202","嘉峪关市");

        cityCodes.put("5308","普洱市");
        cityCodes.put("5325","红河哈尼族彝族自治州");
        cityCodes.put("5326","文山壮族苗族自治州");
        cityCodes.put("5303","曲靖市");
        cityCodes.put("5323","楚雄彝族自治州");
        cityCodes.put("5329","大理白族自治州");
        cityCodes.put("5309","临沧市");
        cityCodes.put("5334","迪庆藏族自治州");
        cityCodes.put("5306","昭通市");
        cityCodes.put("5301","昆明市");
        cityCodes.put("5307","丽江市");
        cityCodes.put("5328","西双版纳傣族自治州");
        cityCodes.put("5305","保山市");
        cityCodes.put("5304","玉溪市");
        cityCodes.put("5333","怒江傈僳族自治州");
        cityCodes.put("5331","德宏傣族景颇族自治州");

        cityCodes.put("4510","百色市");
        cityCodes.put("4512","河池市");
        cityCodes.put("4503","桂林市");
        cityCodes.put("4501","南宁市");
        cityCodes.put("4502","柳州市");
        cityCodes.put("4514","崇左市");
        cityCodes.put("4513","来宾市");
        cityCodes.put("4509","玉林市");
        cityCodes.put("4504","梧州市");
        cityCodes.put("4511","贺州市");
        cityCodes.put("4507","钦州市");
        cityCodes.put("4508","贵港市");
        cityCodes.put("4506","防城港市");
        cityCodes.put("4505","北海市");

        cityCodes.put("4312","怀化市");
        cityCodes.put("4311","永州市");
        cityCodes.put("4305","邵阳市");
        cityCodes.put("4310","郴州市");
        cityCodes.put("4307","常德市");
        cityCodes.put("4331","湘西土家族苗族自治州");
        cityCodes.put("4304","衡阳市");
        cityCodes.put("4306","岳阳市");
        cityCodes.put("4309","益阳市");
        cityCodes.put("4301","长沙市");
        cityCodes.put("4302","株洲市");
        cityCodes.put("4308","张家界市");
        cityCodes.put("4313","娄底市");
        cityCodes.put("4303","湘潭市");

        cityCodes.put("6108","榆林市");
        cityCodes.put("6106","延安市");
        cityCodes.put("6107","汉中市");
        cityCodes.put("6109","安康市");
        cityCodes.put("6110","商洛市");
        cityCodes.put("6103","宝鸡市");
        cityCodes.put("6105","渭南市");
        cityCodes.put("6104","咸阳市");
        cityCodes.put("6101","西安市");
        cityCodes.put("6102","铜川市");

        cityCodes.put("4418","清远市");
        cityCodes.put("4402","韶关市");
        cityCodes.put("4408","湛江市");
        cityCodes.put("4414","梅州市");
        cityCodes.put("4416","河源市");
        cityCodes.put("4412","肇庆市");
        cityCodes.put("4413","惠州市");
        cityCodes.put("4409","茂名市");
        cityCodes.put("4407","江门市");
        cityCodes.put("4417","阳江市");
        cityCodes.put("4452","云浮市");
        cityCodes.put("4401","广州市");
        cityCodes.put("4415","汕尾市");
        cityCodes.put("4452","揭阳市");
        cityCodes.put("4404","珠海市");
        cityCodes.put("4406","佛山市");
        cityCodes.put("4451","潮州市");
        cityCodes.put("4405","汕头市");
        cityCodes.put("4403","深圳市");
        cityCodes.put("4419","东莞市");
        cityCodes.put("4420","中山市");

        cityCodes.put("2224","延边朝鲜族自治州");
        cityCodes.put("2202","吉林市");
        cityCodes.put("2208","白城市");
        cityCodes.put("2207","松原市");
        cityCodes.put("2201","长春市");
        cityCodes.put("2206","白山市");
        cityCodes.put("2205","通化市");
        cityCodes.put("2203","四平市");
        cityCodes.put("2204","辽源市");

        cityCodes.put("1308","承德市");
        cityCodes.put("1307","张家口市");
        cityCodes.put("1306","保定市");
        cityCodes.put("1302","唐山市");
        cityCodes.put("1309","沧州市");
        cityCodes.put("1301","石家庄市");
        cityCodes.put("1305","邢台市");
        cityCodes.put("1304","邯郸市");
        cityCodes.put("1303","秦皇岛市");
        cityCodes.put("1311","衡水市");
        cityCodes.put("1310","廊坊市");

        cityCodes.put("4228","恩施土家族苗族自治州");
        cityCodes.put("4203","十堰市");
        cityCodes.put("4205","宜昌市");
        cityCodes.put("4206","襄樊市");
        cityCodes.put("4211","黄冈市");
        cityCodes.put("4210","荆州市");
        cityCodes.put("4208","荆门市");
        cityCodes.put("4212","咸宁市");
        cityCodes.put("4213","随州市");
        cityCodes.put("4209","孝感市");
        cityCodes.put("4201","武汉市");
        cityCodes.put("4202","黄石市");
        cityCodes.put("4207","鄂州市");
        //直辖县
        cityCodes.put("429021","神农架林区");
        cityCodes.put("429006","天门市");
        cityCodes.put("429004","仙桃市");
        cityCodes.put("429005","潜江市");

        cityCodes.put("5203","遵义市");
        cityCodes.put("5226","黔东南苗族侗族自治州");
        cityCodes.put("5205","毕节地区");
        cityCodes.put("5227","黔南布依族苗族自治州");
        cityCodes.put("5206","铜仁地区");
        cityCodes.put("5223","黔西南布依族苗族自治州");
        cityCodes.put("5202","六盘水市");
        cityCodes.put("5204","安顺市");
        cityCodes.put("5201","贵阳市");

        cityCodes.put("3706","烟台市");
        cityCodes.put("3713","临沂市");
        cityCodes.put("3707","潍坊市");
        cityCodes.put("3702","青岛市");
        cityCodes.put("3717","菏泽市");
        cityCodes.put("3708","济宁市");
        cityCodes.put("3714","德州市");
        cityCodes.put("3716","滨州市");
        cityCodes.put("3715","聊城市");
        cityCodes.put("3705","东营市");
        cityCodes.put("3701","济南市");
        cityCodes.put("3709","泰安市");
        cityCodes.put("3710","威海市");
        cityCodes.put("3711","日照市");
        cityCodes.put("3703","淄博市");
        cityCodes.put("3704","枣庄市");
        cityCodes.put("3712","莱芜市");

        cityCodes.put("3607","赣州市");
        cityCodes.put("3608","吉安市");
        cityCodes.put("3611","上饶市");
        cityCodes.put("3604","九江市");
        cityCodes.put("3610","抚州市");
        cityCodes.put("3609","宜春市");
        cityCodes.put("3601","南昌市");
        cityCodes.put("3602","景德镇市");
        cityCodes.put("3603","萍乡市");
        cityCodes.put("3606","鹰潭市");
        cityCodes.put("3605","新余市");

        cityCodes.put("4113","南阳市");
        cityCodes.put("4115","信阳市");
        cityCodes.put("4103","洛阳市");
        cityCodes.put("4117","驻马店市");
        cityCodes.put("4116","周口市");
        cityCodes.put("4114","商丘市");
        cityCodes.put("4112","三门峡市");
        cityCodes.put("4107","新乡市");
        cityCodes.put("4104","平顶山市");
        cityCodes.put("4101","郑州市");
        cityCodes.put("4105","安阳市");
        cityCodes.put("4102","开封市");
        cityCodes.put("4108","焦作市");
        cityCodes.put("4110","许昌市");
        cityCodes.put("4109","濮阳市");
        cityCodes.put("4111","漯河市");
        cityCodes.put("4106","鹤壁市");
        //直辖县
        cityCodes.put("419001","济源市");

        cityCodes.put("2102","大连市");
        cityCodes.put("2113","朝阳市");
        cityCodes.put("2106","丹东市");
        cityCodes.put("2112","铁岭市");
        cityCodes.put("2101","沈阳市");
        cityCodes.put("2104","抚顺市");
        cityCodes.put("2114","葫芦岛市");
        cityCodes.put("2109","阜新市");
        cityCodes.put("2107","锦州市");
        cityCodes.put("2103","鞍山市");
        cityCodes.put("2105","本溪市");
        cityCodes.put("2108","营口市");
        cityCodes.put("2110","辽阳市");
        cityCodes.put("2111","盘锦市");

        cityCodes.put("1409","忻州市");
        cityCodes.put("1411","吕梁市");
        cityCodes.put("1410","临汾市");
        cityCodes.put("1407","晋中市");
        cityCodes.put("1408","运城市");
        cityCodes.put("1402","大同市");
        cityCodes.put("1404","长治市");
        cityCodes.put("1406","朔州市");
        cityCodes.put("1405","晋城市");
        cityCodes.put("1401","太原市");
        cityCodes.put("1403","阳泉市");

        cityCodes.put("3415","六安市");
        cityCodes.put("3408","安庆市");
        cityCodes.put("3411","滁州市");
        cityCodes.put("3418","宣城市");
        cityCodes.put("3412","阜阳市");
        cityCodes.put("3413","宿州市");
        cityCodes.put("3410","黄山市");
//        cityCodes.put("110","巢湖市");
        cityCodes.put("3416","亳州市");
        cityCodes.put("3417","池州市");
        cityCodes.put("3401","合肥市");
        cityCodes.put("3403","蚌埠市");
        cityCodes.put("3402","芜湖市");
        cityCodes.put("3406","淮北市");
        cityCodes.put("3404","淮南市");
        cityCodes.put("3405","马鞍山市");
        cityCodes.put("3407","铜陵市");

        cityCodes.put("3507","南平市");
        cityCodes.put("3504","三明市");
        cityCodes.put("3508","龙岩市");
        cityCodes.put("3509","宁德市");
        cityCodes.put("3501","福州市");
        cityCodes.put("3506","漳州市");
        cityCodes.put("3505","泉州市");
        cityCodes.put("3503","莆田市");
        cityCodes.put("3502","厦门市");
        cityCodes.put("3511","丽水市");

        cityCodes.put("3301","杭州市");
        cityCodes.put("3303","温州市");
        cityCodes.put("3302","宁波市");
        cityCodes.put("3309","舟山市");
        cityCodes.put("3310","台州市");
        cityCodes.put("3307","金华市");
        cityCodes.put("3308","衢州市");
        cityCodes.put("3306","绍兴市");
        cityCodes.put("3304","嘉兴市");
        cityCodes.put("3305","湖州市");

        cityCodes.put("3209","盐城市");
        cityCodes.put("3203","徐州市");
        cityCodes.put("3206","南通市");
        cityCodes.put("3208","淮安市");
        cityCodes.put("3205","苏州市");
        cityCodes.put("3213","宿迁市");
        cityCodes.put("3207","连云港市");
        cityCodes.put("3210","扬州市");
        cityCodes.put("3201","南京市");
        cityCodes.put("3212","泰州市");
        cityCodes.put("3202","无锡市");
        cityCodes.put("3204","常州市");
        cityCodes.put("3211","镇江市");

        cityCodes.put("6403","吴忠市");
        cityCodes.put("6405","中卫市");
        cityCodes.put("6404","固原市");
        cityCodes.put("6401","银川市");
        cityCodes.put("6402","石嘴山市");

        //直辖县
        cityCodes.put("469003","儋州市");
        cityCodes.put("469005","文昌市");
        cityCodes.put("469027","乐东黎族自治县");
        cityCodes.put("469030","琼中黎族苗族自治县");
        cityCodes.put("469007","东方市");
        cityCodes.put("469006","万宁市");
        cityCodes.put("469023","澄迈县'");
        cityCodes.put("469025","白沙黎族自治县");
        cityCodes.put("469002","琼海市");
        cityCodes.put("469026","昌江黎族自治县");
        cityCodes.put("469024","临高县");
        cityCodes.put("469028","陵水黎族自治县");
        cityCodes.put("469022","屯昌县");
        cityCodes.put("469021","定安县");
        cityCodes.put("469029","保亭黎族苗族自治县");
        cityCodes.put("469001","五指山市");

        cityCodes.put("4602","三亚市");
        cityCodes.put("4601","海口市");
    }


}
