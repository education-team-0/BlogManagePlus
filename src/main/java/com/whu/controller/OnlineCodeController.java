package com.whu.controller;

import com.whu.entity.Code;
import com.whu.entity.Response;
import com.whu.service.OnlineCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 20:28
 * 在线运行代码
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/online")
public class OnlineCodeController {

    @Autowired
    OnlineCodeService onlineCodeService;

    @RequestMapping("/run")
    public Response runCode(@RequestBody Code code){
        String result=onlineCodeService.runCode(code.getCodeType(),code.getClassName(),code.getCode());
        return new Response().success(result);
    }


    @RequestMapping("/run/java")
    public Response runJavaCode(@RequestBody Code code){
        String result=onlineCodeService.runJavaCode(code.getClassName(),code.getCode(),code.getCodeType());
        return new Response().success(result);
    }

    @RequestMapping("/run/c")
    public Response runCCode(@RequestBody Code code){
        String result=onlineCodeService.runCCode(code.getCode(),code.getCodeType());
        return new Response().success(result);
    }

    @RequestMapping("/run/cpp")
    public Response runCppCode(@RequestBody Code code){
        String result=onlineCodeService.runCppCode(code.getCode(),code.getCodeType());
        return new Response().success(result);
    }

    @RequestMapping("/run/python")
    public Response runPythonCode(@RequestBody Code code){
        String result=onlineCodeService.runPythonCode(code.getCode(),code.getCodeType());
        return new Response().success(result);
    }




}
