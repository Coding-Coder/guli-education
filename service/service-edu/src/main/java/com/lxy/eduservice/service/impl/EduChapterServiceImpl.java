package com.lxy.eduservice.service.impl;

import com.lxy.eduservice.entity.EduChapter;
import com.lxy.eduservice.mapper.EduChapterMapper;
import com.lxy.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

}
