package com.lxy.eduservice.service.impl;

import com.lxy.eduservice.entity.EduVideo;
import com.lxy.eduservice.mapper.EduVideoMapper;
import com.lxy.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

}
