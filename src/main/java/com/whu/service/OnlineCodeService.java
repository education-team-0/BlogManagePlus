package com.whu.service;

import com.whu.util.ServerTool;
import org.springframework.stereotype.Service;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 20:31
 */
@Service
public class OnlineCodeService {


    /**
     * 初始执行java代码的函数
     * @param codeType
     * @param className
     * @param code
     * @return
     */
    public String runCode(String codeType,String className,String code){
        //type： 代码类型

        //写代码文件
        String codeDir="/root/javaee/online/code";
        ServerTool.write(code,codeDir,className+".java");

        //往服务器写容器内代码运行脚本 start.sh
        String startStr="cd /usr/local/"+codeType.toLowerCase()+"/code;javac "+ className+".java;java "+className;
        String startDir="/root/javaee/online/sh";
        ServerTool.write(startStr,startDir,"start.sh");

        //写启动容器脚本 run.sh
        String runStr="docker run -v /root/javaee/online:/usr/local/"+codeType.toLowerCase()+ " ubuntu:"+codeType.toLowerCase()+" sh /usr/local/"+codeType.toLowerCase()+"/sh/start.sh";
        String runDir="/root/javaee/online";
        ServerTool.write(runStr,runDir,"run.sh");

        //执行run.sh 运行
        String result=ServerTool.execCmd("sh ./online/run.sh");
        return result;

    }


    /**
     * 执行java代码
     * @param className
     * @param code
     * @return
     */
    public String runJavaCode(String className,String code,String codeType){
        //写代码文件
        String codeDir="/root/javaee/online/code";
        ServerTool.write(code,codeDir,className+".java");

        //往服务器写容器内代码运行脚本 start.sh
        String startStr="cd /usr/local/"+codeType+"/code;javac -encoding utf-8 "+ className+".java;java -Dfile.encoding='utf-8' "+className;
        String startDir="/root/javaee/online/sh";
        ServerTool.write(startStr,startDir,"start.sh");

        //写启动容器脚本 run.sh
        String runStr="docker run -v /root/javaee/online:/usr/local/"+codeType+" ubuntu:"+codeType+" sh /usr/local/"+codeType+"/sh/start.sh";
        String runDir="/root/javaee/online";
        ServerTool.write(runStr,runDir,"run.sh");

        //执行run.sh 运行
        String result=ServerTool.execCmd("sh ./online/run.sh");
        return result;

    }


    /**
     * 运行c代码
     * @param code
     * @param codeType
     * @return
     */
    public String runCCode(String code,String codeType){
        //写代码文件
        String codeDir="/root/javaee/online/code";
        ServerTool.write(code,codeDir,"test.c");

        //往服务器写容器内代码运行脚本 start.sh
        String startStr="cd /usr/local/"+codeType+"/code;gcc test.c -o test;./test";
        String startDir="/root/javaee/online/sh";
        ServerTool.write(startStr,startDir,"start.sh");

        //写启动容器脚本 run.sh
        String runStr="docker run -v /root/javaee/online:/usr/local/"+codeType+" ubuntu:"+codeType+" sh /usr/local/"+codeType+"/sh/start.sh";
        String runDir="/root/javaee/online";
        ServerTool.write(runStr,runDir,"run.sh");

        //执行run.sh 运行
        String result=ServerTool.execCmd("sh ./online/run.sh");
        return result;

    }

    /**
     * 运行CPP代码
     * @param code
     * @param codeType
     * @return
     */
    public String runCppCode(String code,String codeType){
        //写代码文件
        String codeDir="/root/javaee/online/code";
        ServerTool.write(code,codeDir,"test2.cpp");

        //往服务器写容器内代码运行脚本 start.sh
        String startStr="cd /usr/local/"+codeType+"/code;g++ test2.cpp -o test2;./test2";
        String startDir="/root/javaee/online/sh";
        ServerTool.write(startStr,startDir,"start.sh");

        //写启动容器脚本 run.sh
        String runStr="docker run -v /root/javaee/online:/usr/local/"+codeType+" ubuntu:c sh /usr/local/"+codeType+"/sh/start.sh";
        String runDir="/root/javaee/online";
        ServerTool.write(runStr,runDir,"run.sh");

        //执行run.sh 运行
        String result=ServerTool.execCmd("sh ./online/run.sh");
        return result;

    }

    public String runPythonCode(String code,String codeType){
        //写代码文件
        String codeDir="/root/javaee/online/code";
        ServerTool.write("# coding=utf-8\n"+code,codeDir,"test.py");

        //往服务器写容器内代码运行脚本 start.sh
        String startStr="cd /usr/local/"+codeType+"/code;python test.py";
        String startDir="/root/javaee/online/sh";
        ServerTool.write(startStr,startDir,"start.sh");

        //写启动容器脚本 run.sh
        String runStr="docker run -v /root/javaee/online:/usr/local/"+codeType+" ubuntu:"+codeType+" sh /usr/local/"+codeType+"/sh/start.sh";
        String runDir="/root/javaee/online";
        ServerTool.write(runStr,runDir,"run.sh");

        //执行run.sh 运行
        String result=ServerTool.execCmd("sh ./online/run.sh");
        return result;

    }


}
