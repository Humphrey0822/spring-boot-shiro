package com.ouyeel.xplat.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping({"/","/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) {
        logger.info("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息
        String exception = (String) request.getAttribute("shiroLoginFailure");
        logger.error("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountExeption --> 账号不存在：");
                msg = "UnknownAccountExeption --> 账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)){
                logger.info("IncorrectCredentailsException --> 密码不正确：");
                msg = "IncorrectCredentailsException --> 密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -->" + exception);
            }
        }
        map.put("msg", msg);
        return "/login";
    }

}
