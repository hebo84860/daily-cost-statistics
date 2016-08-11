package com.yeapoo.statistics.constant;

/**
 * @Author: 何波
 * @Description: 常量枚举
 * @datetime:
 *
 **/
public enum ConstantEnum {

    USER_STATUS_0(0, "会员正常状态", ""),
    USER_STATUS_1(1, "会员停用状态", ""),
    PAYMENT_PLATFORM_0(0, "PC", ""),
    PAYMENT_PLATFORM_1(1, "mobile", ""),
    INDEX(1, "index", ""),
    STATISTICS(2, "statistics", ""),
    MODIFY_PASSWORD(3, "密码修改", ""),
    COOKIE_USERNAME(2, "username", ""),
    COOKIE_FLAG(2, "123", ""),
    COOKIE_REMEMBER(2, "remember123", ""),

    SUPER_ADMIN(2, "SUPER_ADMIN", "超级管理员"),
    ;

    private Object code;

    private Object value;

    private String desc;

    ConstantEnum(Object code, Object value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }


    /**
     * @Description: 获取code byte类型值,请确保该值可转换为byte值，否则会类型转换异常
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Byte getCodeByte() {
        return Integer.valueOf(code.toString()).byteValue();
    }


    /**
     * @Description: 获取code int类型值,请确保该值可转换为int值，否则会类型转换异常
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:51:11
     **/
    public Integer getCodeInt() {
        return Integer.valueOf(code.toString());
    }

    /**
     * @Description: 获取code String类型值
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:53:36
     **/
    public String getCodeStr() {
        return code.toString();
    }
    /**
     * @Description:  获取value byte类型值,请确保该值可转换为byte值，否则会类型转换异常
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Byte getValueByte() {
        return Integer.valueOf(value.toString()).byteValue();
    }

    /**
     * @Description:  获取value int类型值,请确保该值可转换为int值，否则会类型转换异常
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:53:08
     **/
    public Integer getValueInt() {
        return Integer.valueOf(value.toString());
    }

    /**
     * @Description: 获取value String类型值
     * @return
     * @Author:  何波
     * @datetime:2015年5月19日下午3:53:21
     **/
    public String getValueStr() {
        return value.toString();
    }

    public Object getCode() {
        return code;
    }


    public Object getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
