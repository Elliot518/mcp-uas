package com.mcp.micro.platform.center.permission.service;

import com.mcp.infrastructure.common.domain.dto.auth.UserDto;
import com.mcp.micro.domain.auth.dto.AdminMenu;
import com.mcp.micro.domain.auth.entity.SysAdminUser;
import com.mcp.micro.domain.auth.entity.SysRole;

import java.util.List;

/**
 * @author: KG
 * @description: System Administrator Service
 * @date: Created in 11:54 上午 2020/9/7
 * @modified by:
 */

public interface SysAdminService {
    /**
     * Get user information
     * @param username
     * @return
     */
    UserDto loadUserByUsernameAndClientId(String username, String clientId);

    SysAdminUser getUserByIdWithCache(Long userId);

    /**
     * 获取指定用户的角色列表
     * @param adminId
     * @return
     */
    List<SysRole> listSysRolesByAdminId(Long adminId);

    List<AdminMenu> getMenusById(Long userId);
}
