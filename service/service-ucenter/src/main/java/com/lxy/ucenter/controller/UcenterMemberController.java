package com.lxy.ucenter.controller;


import com.lxy.commonutils.R;
import com.lxy.commonutils.ordervo.UcenterMemberOrder;
import com.lxy.commonutils.utils.JwtUtils;
import com.lxy.ucenter.entity.UcenterMember;
import com.lxy.ucenter.entity.vo.RegisterVo;
import com.lxy.ucenter.service.UcenterMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author lxy
 * @since 2021-06-09
 */
@RestController
@RequestMapping("/educenter/member")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation("登录")
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token", token);
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    @ApiOperation("根据token获取用户信息")
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo", member);
    }

    @ApiOperation("根据token获取用户信息")
    @GetMapping("getMemberInfoByHeaderStr")
    public R getMemberInfo2(@RequestHeader String token) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(token);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo", member);
    }

    @ApiOperation("根据用户id获取用户信息")
    @PostMapping("getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id) {
        UcenterMember member = memberService.getById(id);
        //把member对象里面值复制给UcenterMemberOrder对象
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(member, ucenterMemberOrder);
        return ucenterMemberOrder;
    }

    @ApiOperation("查询某一天注册人数(day:yyyy-MM-dd)")
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day) {
        Integer count = memberService.countRegisterDay(day);
        return R.ok().data("countRegister", count);
    }
}

