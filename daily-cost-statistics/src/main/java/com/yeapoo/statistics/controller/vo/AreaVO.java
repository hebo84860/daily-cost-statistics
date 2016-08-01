package com.yeapoo.statistics.controller.vo;

import java.io.Serializable;

/**
 * Created by yea on 2016/4/27.
 */
public class AreaVO implements Serializable{

    private Integer count;
    /**
     * 地区代码（省市）
     */
    private String areaCode;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
