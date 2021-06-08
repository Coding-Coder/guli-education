package com.lxy.eduservice.controller;


import com.lxy.commonutils.R;
import com.lxy.eduservice.client.VodClient;
import com.lxy.eduservice.entity.EduVideo;
import com.lxy.eduservice.service.EduVideoService;
import com.lxy.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    //注入vodClient
    @Autowired
    private VodClient vodClient;

    @ApiOperation(value = "添加小节")
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    @ApiOperation(value = "删除小节")
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        // 根据小节id获取视频id，调用方法实现视频删除
        EduVideo eduVideo = videoService.getById(id);
        // 视频id
        String videoSourceId = eduVideo.getVideoSourceId();
        // 判断小节里面是否有视频id
        if (StringUtils.isNotBlank(videoSourceId)) {
            // 根据视频id，远程调用实现视频删除
            R result = vodClient.removeAliyunVideo(videoSourceId);
            if (result.getCode() == 20001) {
                throw new GuliException(20001, "删除视频失败，熔断器...");
            }
        }
        // 最后删除小节
        videoService.removeById(id);
        return R.ok();
    }

    // TODO:修改小节
}

