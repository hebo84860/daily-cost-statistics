package com.yeapoo.statistics.controller.base;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class BaseSingleResponse<T> extends BaseResponse {
    private static final long serialVersionUID = 6615801944726191334L;

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
