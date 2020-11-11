package com.whu.config;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;

import java.net.URI;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 12:21
 */
public class DockerConfig {
    public static DockerClient getDockerClient(){
        DockerClient docker= DefaultDockerClient.builder().uri(URI.create("81.68.205.41:2375")).build();
        return docker;
    }

}
