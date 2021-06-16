package com.lxy.eduservice.entity.chapter;

import lombok.Data;

/**
 * <p>
 * 课程小节
 * </p>
 *
 * @author lxy
 * @since 2021-06-07
 */
@Data
public class VideoVo {

    private String id;

    private String title;

    /**
     * 视频id
     */
    private String videoSourceId;
}
