package com.yeapoo.statistics.controller.vo;

import java.io.Serializable;

/**
 *
 * Created by hebo on 2016/3/30.
 */
public class PlatformScaleVO implements Serializable{

    private Double scale;
    /**
     * 支付平台(0:PC端,1:移动端)
     */
    private String paymentPlatform;
    private String mouth;

    @Override
    public String toString() {
        return "PlaformScaleVO{" +
                "scale=" + scale +
                ", paymentPlatform='" + paymentPlatform + '\'' +
                ", mouth='" + mouth + '\'' +
                '}';
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }
}
