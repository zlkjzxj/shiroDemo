package com.walle.shiroDemo.controller;

import com.walle.shiroDemo.model.User;
import org.apache.jasper.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Test {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    /**
     * 登录提交方法
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();

        //登录验证
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            Session session = subject.getSession();
            session.setAttribute("user", user);
            return "index";
        } catch (UnknownAccountException e) {
            logger.error("账户不存在");
        } catch (DisabledAccountException e) {
            logger.error("账户存在问题");
        } catch (AuthenticationException e) {
            logger.error("密码错误");
        } catch (Exception e) {
            logger.error("登陆异常", e);
        }
        return "login";
    }

    /**
     * 需要登录权限认证的方法
     *
     * @return
     */
    @RequestMapping("/admin")
    public @ResponseBody
    String admin() {
        return "admin success";
    }

    /**
     * 退出登录方法
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    /**
     * 退出登录方法
     */
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 权限控制
     */
    @RequestMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit success";
    }
}
