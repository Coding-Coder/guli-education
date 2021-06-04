package com.lxy.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.eduservice.entity.EduSubject;
import com.lxy.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-03
 */
public interface EduSubjectService extends IService<EduSubject> {

    //添加课程分类
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
