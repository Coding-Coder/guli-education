package com.lxy.vod.controller;

import com.lxy.commonutils.R;
import com.lxy.vod.service.VodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @ApiOperation(value = "上传视频到阿里云")
    @PostMapping("uploadAliyunVideo")
    public R uploadAliyunVideo(MultipartFile file) {
        //返回上传视频id
        String videoId = vodService.uploadAliyunVideo(file);
        return R.ok().data("videoId", videoId);
    }

    @ApiOperation(value = "根据视频id删除阿里云视频")
    @DeleteMapping("removeAliyunVideo/{id}")
    public R removeAliyunVideo(@PathVariable String id) {
        vodService.removeAliyunVideo(id);
        return R.ok();
    }

    //参数多个视频id  List videoIdList
    @ApiOperation(value = "删除多个阿里云视频的方法")
    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList) {
        vodService.removeMoreAliyunVideo(videoIdList);
        return R.ok();
    }
}
