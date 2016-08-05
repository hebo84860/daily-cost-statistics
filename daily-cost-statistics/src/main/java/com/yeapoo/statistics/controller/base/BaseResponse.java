package com.yeapoo.statistics.controller.base;

import com.yeapoo.statistics.constant.CodeEnum;

import java.io.Serializable;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class BaseResponse implements Serializable{
    private static final long serialVersionUID = 6467856098619703259L;
    /**
     * 结果状态
     */
    private boolean status = true;
    /**
     * 返回信息
     */
    private String message;

    /**
     * 状态码
     */
    private CodeEnum code = CodeEnum.SUCCESS;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CodeEnum getCode() {
        return code;
    }

    public void setCode(CodeEnum code) {
        if (code !=null && !code.equals(CodeEnum.SUCCESS)) {
            this.setStatus(false);
        }
        this.code = code;
    }
}
