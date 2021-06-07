package com.lxy.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程章节
 * </p>
 *
 * @author lxy
 * @since 2021-06-07
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    //表示小节
    private List<VideoVo> children = new ArrayList<>();
}
