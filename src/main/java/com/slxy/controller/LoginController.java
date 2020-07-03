package com.slxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    /**
     * 登录验证
     */
    @RequestMapping(value = "/user/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "111111".equals(pwd)) {

            //Session赋值
            session.setAttribute("UserName", userName);
            //重定向，防止重复提交
            return "redirect:/main.html";
            // return "dashboard";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }

    }
}
