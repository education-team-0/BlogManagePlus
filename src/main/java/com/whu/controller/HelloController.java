package com.whu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 9:21
 * 测试
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/test")
    public String test(){
        return "demo/hello";
    }

    @RequestMapping("/*")
    public String test2(){
        return "hello";
    }

    @RequestMapping("/**/*")
    public String test3(){
        return "demo/hello";
    }


}
