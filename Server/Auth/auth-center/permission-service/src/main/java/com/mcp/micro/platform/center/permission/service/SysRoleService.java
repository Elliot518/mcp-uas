package com.mcp.micro.platform.center.permission.service;

import java.util.List;

/**
 * @author: KG
 * @description: Role Service
 * @date: Created in 10:07 下午 2020/10/16
 * @modified by:
 */

public interface SysRoleService {
    /**
     * 更新用户角色关系
     * @param adminId
     * @param roleIds
     * @return
     */
    Boolean updateRole(Long adminId, List<Long> roleIds);
}
