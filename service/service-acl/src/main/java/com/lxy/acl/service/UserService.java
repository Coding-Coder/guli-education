package com.lxy.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.acl.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-17
 */
public interface UserService extends IService<User> {

    // 从数据库中取出用户信息
    User selectByUsername(String username);
}
