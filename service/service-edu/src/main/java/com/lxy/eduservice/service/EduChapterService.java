package com.lxy.eduservice.service;

import com.lxy.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
public interface EduChapterService extends IService<EduChapter> {
    //课程大纲列表,根据课程id进行查询
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);

    //根据课程id删除章节
    void removeChapterByCourseId(String courseId);
}
