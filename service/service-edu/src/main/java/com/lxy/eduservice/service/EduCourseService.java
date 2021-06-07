package com.lxy.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.eduservice.entity.EduCourse;
import com.lxy.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
public interface EduCourseService extends IService<EduCourse> {

    //添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
