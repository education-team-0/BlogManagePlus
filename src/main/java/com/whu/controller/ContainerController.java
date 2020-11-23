package com.whu.controller;

import com.whu.service.ContainerService;
import com.whu.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 12:34
 * 测试容器服务
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContainerController {

    @Autowired
    ContainerService containerService;

    @RequestMapping("/container/start")
    public Response startContainer(){
        String imageId="";
        String containerId=containerService.startContainer(imageId);
        return new Response().success(containerId);
    }


}
