package com.lxy.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxy.commonutils.R;
import com.lxy.eduservice.entity.EduCourse;
import com.lxy.eduservice.entity.vo.CourseInfoVo;
import com.lxy.eduservice.entity.vo.CoursePublishVo;
import com.lxy.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "课程列表(基本实现)")
    @GetMapping
    public R getCourseList() {
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list", list);
    }

    //TODO:完善条件查询带分页
    //current 当前页
    //limit 每页记录数
    @ApiOperation(value = "分页查询课程列表")
    @GetMapping("/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit) {
        // 创建page对象
        Page<EduCourse> pageCourse = new Page<>(current, limit);

        // 调用方法实现分页
        // 调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        courseService.page(pageCourse, null);

        long total = pageCourse.getTotal();//总记录数
        List<EduCourse> records = pageCourse.getRecords(); //数据list集合

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "添加课程基本信息的方法")
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", id);
    }

    @ApiOperation(value = "根据课程id查询课程基本信息")
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    @ApiOperation(value = "修改课程信息")
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    @ApiOperation(value = "根据课程id查询课程确认信息")
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse", coursePublishVo);
    }

    @ApiOperation(value = "课程最终发布(修改课程状态)")
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        //为null的属性，会跳过，不会被拼接到最终的sql中
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");//设置课程发布状态
        courseService.updateById(eduCourse);
        return R.ok();
    }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        courseService.removeCourse(courseId);
        return R.ok();
    }
}

