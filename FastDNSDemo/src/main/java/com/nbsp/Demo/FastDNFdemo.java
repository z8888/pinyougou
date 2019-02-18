package com.nbsp.Demo;

import org.csource.fastdfs.*;

public class FastDNFdemo {
    public static void main(String[] args) throws Exception {
        // 加载配置文件，需要转译斜杠
        ClientGlobal.init("D:\\work\\Code\\FastDNSDemo\\src\\main\\resources\\fdfs_client.conf");
        // 创建管理者
        TrackerClient client=new TrackerClient();

        // 连接管理者服务端
        TrackerServer connection = client.getConnection();
        // 生名存储服务器
        StorageServer server=null;
        // 生名存储服务器的客户端
        StorageClient storageClient=new StorageClient(connection,server);
        // 上传文件
        String[] pngs = storageClient.upload_file("E:\\Java视频\\53. 品优购资源V1.3\\03. 品优购资源V1.3\\静态原型\\静态原型\\运营商管理后台\\img\\avatar.png", "png", null);
        for (String str : pngs) {
            System.out.println(str);
        }
    }
}
