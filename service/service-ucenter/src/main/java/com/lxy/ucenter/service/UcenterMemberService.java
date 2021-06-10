package com.lxy.ucenter.service;

import com.lxy.ucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.ucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-09
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    //登录的方法
    String login(UcenterMember member);

    //注册的方法
    void register(RegisterVo registerVo);
}
