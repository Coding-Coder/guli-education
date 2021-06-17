package com.lxy.ucenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxy.ucenter.entity.UcenterMember;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author lxy
 * @since 2021-06-09
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {
    //查询某一天注册人数
    Integer countRegisterDay(String day);
}
