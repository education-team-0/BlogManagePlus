package com.whu.util;

import java.io.*;

/**
 * @author Hongchao Yang
 * @date 2020-11-05 12:42
 */
public class ServerTool {


    /**
     * 执行linux命令
     * @param command
     * @return
     */
    public static String execCmd(String command){
        String result = null;
        try {
            String[] cmd = new String[]{"/bin/sh", "-c", command};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            result = sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;

    }


    /**
     * 往服务器上写文件
     * @param s  文件内容
     * @param dir  路径
     * @param fileName  文件名
     * @return
     */
    public static String write(String s,String dir,String fileName) {
        File file = new File(dir+"/"+fileName);
        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = s.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return s;
        }
    }


}
