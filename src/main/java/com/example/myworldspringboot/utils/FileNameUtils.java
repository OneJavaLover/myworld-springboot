package com.example.myworldspringboot.utils;

import java.util.UUID;

public class FileNameUtils {
    //获取文件后缀
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //生成新的文件名
    public static String getFileName(String fileOriginName){
        return UUID.randomUUID()+FileNameUtils.getSuffix(fileOriginName);
    }
}
