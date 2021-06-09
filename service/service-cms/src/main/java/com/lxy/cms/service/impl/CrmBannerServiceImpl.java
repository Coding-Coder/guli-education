package com.lxy.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.cms.entity.CrmBanner;
import com.lxy.cms.mapper.CrmBannerMapper;
import com.lxy.cms.service.CrmBannerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-09
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    //查询所有banner
    //value：缓存名
    //key:缓存的key 使用单引号自定义字符串作为缓存的key值;最终redis中的key为banner::selectIndexList
    //使用单引号指定分割符，最终会拼接为一个字符串:@Cacheable(key = "#page+'-'+#pageSize")
    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {
        //根据sort进行升序排列，显示排列之后前5条记录
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        //last方法，拼接sql语句
        wrapper.last("limit 5");
        return baseMapper.selectList(wrapper);
    }
}
