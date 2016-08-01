package com.yeapoo.statistics.intercept;

import com.yeapoo.statistics.entity.UserEntity;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by hebo on 2016/3/31.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private String loginUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect(this.getLoginUrl());
            return false;
        }
        return true;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
