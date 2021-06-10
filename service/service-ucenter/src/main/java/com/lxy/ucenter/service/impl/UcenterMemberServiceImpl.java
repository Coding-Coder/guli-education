package com.lxy.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxy.commonutils.utils.JwtUtils;
import com.lxy.commonutils.utils.MD5;
import com.lxy.servicebase.exceptionhandler.GuliException;
import com.lxy.ucenter.entity.UcenterMember;
import com.lxy.ucenter.entity.vo.RegisterVo;
import com.lxy.ucenter.mapper.UcenterMemberMapper;
import com.lxy.ucenter.service.UcenterMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-09
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //登录的方法
    @Override
    public String login(UcenterMember member) {
        //获取登录手机号和密码
        String mobile = member.getMobile();
        String password = member.getPassword();

        //手机号和密码非空判断
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new GuliException(20001, "登录失败，账号或密码为空！");
        }

        //判断手机号是否正确
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        if (mobileMember == null) {//没有这个手机号
            throw new GuliException(20001, "登录失败，账号或密码有误！");
        }

        //判断密码
        //加密方式 MD5，因为存储到数据库密码肯定加密的,把输入的密码进行加密，再和数据库密码进行比较
        if (!MD5.encrypt(password).equals(mobileMember.getPassword())) {
            throw new GuliException(20001, "登录失败，账号或密码有误！");
        }

        //判断用户是否禁用
        if (mobileMember.getIsDisabled()) {
            throw new GuliException(20001, "登录失败,用户已禁用！");
        }

        //登录成功,生成token字符串,使用jwt工具类
        return JwtUtils.generateJwtToken(mobileMember.getId(), mobileMember.getNickname());
    }

    //注册的方法
    @Override
    public void register(RegisterVo registerVo) {
        //获取注册的数据
        String code = registerVo.getCode(); //验证码
        String mobile = registerVo.getMobile(); //手机号
        String nickname = registerVo.getNickname(); //昵称
        String password = registerVo.getPassword(); //密码

        //非空判断
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(code) || StringUtils.isEmpty(nickname)) {
            throw new GuliException(20001, "注册失败，注册数据不全！");
        }
        //判断验证码,获取redis验证码
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)) {
            throw new GuliException(20001, "注册失败，验证码有误！");
        }

        //判断手机号是否重复，表里面存在相同手机号不进行添加
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count > 0) {
            throw new GuliException(20001, "注册失败，手机号已被注册！");
        }

        //数据添加数据库中
        UcenterMember member = new UcenterMember()
                .setMobile(mobile)
                .setNickname(nickname)
                .setPassword(MD5.encrypt(password))//密码进行加密
                .setIsDisabled(false)//用户不禁用
                .setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        baseMapper.insert(member);
    }
}
