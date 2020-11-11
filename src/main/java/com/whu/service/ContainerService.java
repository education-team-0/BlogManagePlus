package com.whu.service;

import com.whu.util.ServerTool;
import org.springframework.stereotype.Service;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 12:35
 */
@Service
public class ContainerService {

    //根据镜像id启动容器
    public String startContainer(String imageId){

        String containerId= ServerTool.execCmd("sh "+"/root/javaee/online/docker/run.sh");
        return containerId;
    }
}
