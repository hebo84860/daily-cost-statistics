package com.yeapoo.statistics.constant;

/**
 * @Author: 何波
 * @Description: 常量枚举
 * @datetime:
 *
 **/
public enum CodeEnum {
    SUCCESS(0, "操作成功"),
    SYSTEM_ERROR(1, "服务器错误，请稍后！"),
    PARAMS_ERROR(2, "参数错误，请重试"),
    ACCOUNT_EXIST(3, "该用户名已经存在"),
    INVITE_CODE_ERROR(9, "用户注册邀请码错误，请重新确认"),
    ACCOUNT_ERROR(4, "账号不存在"),
    ACCOUNT_PASSWORD_ERROR(5, "密码错误"),
    SAVE_FAIL(6, "保存失败"),
    UPDATE_FAIL(7, "修改失败"),
    LOGIN_ERROR(8, "登录错误，请重新登录！")
    ;

    private Object code;

    private Object value;

    CodeEnum(Object code, Object value) {
        this.code = code;
        this.value = value;
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
}
