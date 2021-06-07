package com.lxy.eduservice.service.impl;

import com.lxy.eduservice.entity.EduCourseDescription;
import com.lxy.eduservice.mapper.EduCourseDescriptionMapper;
import com.lxy.eduservice.service.EduCourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription> implements EduCourseDescriptionService {

}
