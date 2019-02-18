package com.pinyougou.manaager.controller;

import com.nbsp.utils.FastDFSClient;
import com.pinyougou.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("upload")
    public Result UploadFile(MultipartFile file){

        String fileName = file.getOriginalFilename(); // 获取文件的全名称
        String suffix = fileName.substring(fileName.indexOf(".")); // 截取文件后缀
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
            String returnName = fastDFSClient.uploadFile(file.getBytes(), suffix);
           String url=file_server_url+returnName;
            System.out.println(url);
           return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"上传失败");
        }
    }
}
