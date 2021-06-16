package com.lxy.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.lxy.commonutils.R;
import com.lxy.servicebase.exceptionhandler.GuliException;
import com.lxy.vod.service.VodService;
import com.lxy.vod.utils.ConstantVodUtils;
import com.lxy.vod.utils.InitVodClient;
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

    @ApiOperation(value = "根据视频id获取视频凭证")
    @GetMapping("getPlayAuth/{id}")
    public R getPlayAuth(@PathVariable String id) {
        try {
            //创建初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建获取凭证request和response对象
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            //设置播放凭证的有效期(默认值：100秒  取值范围：100~3000)
            request.setAuthInfoTimeout(200L);
            //向request设置视频id
            request.setVideoId(id);
            //调用方法得到凭证
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return R.ok().data("playAuth", playAuth);
        } catch (Exception e) {
            throw new GuliException(20001, "获取凭证失败");
        }
    }
}
