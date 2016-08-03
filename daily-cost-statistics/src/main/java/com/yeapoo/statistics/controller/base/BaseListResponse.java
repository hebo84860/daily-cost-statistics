package com.yeapoo.statistics.controller.base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class BaseListResponse<T> extends BaseResponse {
    private static final long serialVersionUID = 6799028957446036533L;

    private List<T> results = new ArrayList<T>();

    private Pagination pagination = new Pagination();

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
