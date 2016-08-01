package com.yeapoo.statistics.constant;

/**
 * 消费类型
 * Created by hebo on 2016/8/1.
 */
public enum CostType {

    GROUP("团体"),
    PERSONAL("个人")
    ;

    private String cnName;

    private CostType(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
