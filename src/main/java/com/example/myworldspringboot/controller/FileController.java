package com.example.myworldspringboot.controller;

import com.example.myworldspringboot.utils.FileNameUtils;
import com.example.myworldspringboot.utils.FileUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("/api")
public class FileController {
    @Value("${web.upload-path}")
    private String path;

    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file")MultipartFile file){
        //保存文件的路径
        String localPath = "/root/photo";
//        String localPath = "E:/desktop";
        //获取文件名字
        String fileName = file.getOriginalFilename();

        //上传失败提示
        String warning = " ";
        String newFileName = FileUtils.upload(file,localPath,fileName);
        if (newFileName != null){
            warning = "上传成功";
        }else {
            warning = "上传失败";
        }
        System.out.println(warning);
        return warning;

//        String newFileName = FileNameUtils.getFileName(fileName);
//        try{
//            Client client = Client.create();
//            WebResource webResource = client.resource(localPath + newFileName);
//            webResource.put(file.getBytes());
//            System.out.println("上传成功");
//        }catch (Exception e){
//            System.out.println(e);
//            System.out.println("上传失败");
//        }
//        return "";
    }
}
