package com.yeapoo.statistics.controller;

import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.service.IUserService;
import com.yeapoo.statistics.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by hebo on 2016/3/31.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("nav", ConstantEnum.INDEX.getCodeInt());
        return "index";
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getSession().removeAttribute("user");
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public String login(UserEntity loginUser, String remember, HttpServletRequest request, Model model, HttpServletResponse response){
        String result = "login";
        String errorMsg = "";
        checkRememberMe(loginUser,model, remember, request, response);
        try {
//            logger.info(" login start loginUser={}", loginUser);
            if (StringUtils.isNotBlank(loginUser.getUsername()) && StringUtils.isNotBlank(loginUser.getPassword())){
                if (userService.isPasswordValid(loginUser.getPassword(), loginUser.getUsername())){
                    UserEntity user = userService.getUserEntityByUserName(loginUser.getUsername());
                    if (StringUtils.isNotBlank(remember)){
                        CookieUtil.addCookie(response, ConstantEnum.COOKIE_USERNAME.getValueStr(), loginUser.getUsername().trim());
                    }
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect(ConstantEnum.INDEX.getValueStr());
                }else {
                    errorMsg = "账号或密码错误";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("error", errorMsg);
        return result;
    }

    private void checkRememberMe(UserEntity loginUser, Model model,String remember, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isNotBlank(remember)){
//            CookieUtil.addCookie(response, ConstantEnum.COOKIE_USERNAME.getValueStr(), loginUser.getUsername().trim());
            CookieUtil.addCookie(response, ConstantEnum.COOKIE_REMEMBER.getValueStr(), remember.trim());
        }else if(StringUtils.isNotBlank(loginUser.getUsername()) && StringUtils.isBlank(remember)){
            CookieUtil.delCookie(request, response, ConstantEnum.COOKIE_USERNAME.getValueStr());
            CookieUtil.delCookie(request, response, ConstantEnum.COOKIE_REMEMBER.getValueStr());
        }
        Cookie usernameCookie = CookieUtil.getCookieByName(request, ConstantEnum.COOKIE_USERNAME.getValueStr());
        Cookie rememberCookie = CookieUtil.getCookieByName(request, ConstantEnum.COOKIE_REMEMBER.getValueStr());
        if (usernameCookie!=null){
            model.addAttribute("username", usernameCookie.getValue());
        }
        if (rememberCookie!=null){
            model.addAttribute("remember", rememberCookie.getValue());
        }
    }

}
