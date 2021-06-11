package com.lxy.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxy.eduservice.entity.EduCourse;
import com.lxy.eduservice.entity.frontvo.CourseWebVo;
import com.lxy.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVo getPublishCourseInfo(String courseId);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);
}
