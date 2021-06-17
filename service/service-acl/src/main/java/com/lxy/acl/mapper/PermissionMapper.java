package com.lxy.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxy.acl.entity.Permission;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author lxy
 * @since 2021-06-17
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(String userId);
}
