package com.lxy.vod.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    //上传视频到阿里云
    String uploadAliyunVideo(MultipartFile file);
}
