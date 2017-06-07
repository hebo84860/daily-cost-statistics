package com.yeapoo.statistics.constant;

//import org.springframework.util.StringUtils;

/**
 * 记录状态
 * Created by hebo on 2016/8/1.
 */
public enum Status {

    CHECK_PENDING("1", "待审核"),
    VALID("2", "有效"),
    INVALID("3", "无效");

    private String code;
    private String cnName;

    private Status(String code, String cnName) {
        this.code = code;
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }


}
