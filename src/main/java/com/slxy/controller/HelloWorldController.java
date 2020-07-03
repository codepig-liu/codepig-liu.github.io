package com.slxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWorldController {


    @ResponseBody
    @RequestMapping("/hello")
    public String getHelloWorld()
    {
        return  "Hello World;";
    }


    @RequestMapping("/success")
    public String getSuccess(Map<String,Object> map)
    {
        map.put("hello","你好，，，，helloworld;");
        return "success";
    }
}
