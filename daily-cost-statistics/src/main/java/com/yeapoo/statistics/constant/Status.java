package com.yeapoo.statistics.constant;

//import org.springframework.util.StringUtils;

/**
 * 记录状态
 * Created by hebo on 2016/8/1.
 */
public enum Status {

    VALID("有效"),
    INVALID("无效");

    private String cnName;

    private Status(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }


}
