package com.yeapoo.statistics.constant;

import org.springframework.util.StringUtils;

/**
 *
 * Created by hebo on 2016/8/1.
 */
public enum CostDetail {
    NULL("",""),
    FOOD("1","饮食"),
    AMUSEMENT("2","娱乐"),
    SHOPPING("3","购物"),
    HOUSE_RENT("4","房租"),
    OTHERS("5","其他"),;


    private String code;
    private String cnName;

    private CostDetail(String code, String cnName) {
        this.code = code;
        this.cnName = cnName;

    }

    public String getCnName() {
        return cnName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    public static CostDetail getByCode(String code) {
        if(StringUtils.isEmpty(code)) {
            return null;
        }
        for(CostDetail ro : CostDetail.values()) {
            if(ro.getCode().equals(code)) {
                return ro;
            }
        }
        return null;
    }

    public static CostDetail getByName(String cnName) {
        if(StringUtils.isEmpty(cnName)) {
            return null;
        }
        for(CostDetail ro : CostDetail.values()) {
            if(ro.getCnName().equals(cnName)) {
                return ro;
            }
        }
        return null;
    }

}
