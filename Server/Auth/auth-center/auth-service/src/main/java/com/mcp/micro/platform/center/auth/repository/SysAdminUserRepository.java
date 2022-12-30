package com.mcp.micro.platform.center.auth.repository;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mcp.micro.domain.auth.entity.SysAdminUser;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysAdminUserRepository extends IService<SysAdminUser> {
    SysAdminUser getByUserNameAndClientId(String username, String clientId);
}
