package com.mcp.micro.platform.center.permission.service;

import com.mcp.micro.domain.auth.entity.SysAdminUser;

/**
 * @author: KG
 * @description: System Administrator Cache Service
 * @date: Created in 6:02 下午 2020/9/24
 * @modified by:
 */

public interface SysAdminCacheService {
    /**
     * delete admin user from cache
     * @param adminId
     */
    void delAdminUser(Long adminId);

    /**
     * get admin user from cache
     * @param adminId
     * @return
     */
    SysAdminUser getAdminUser(Long adminId);

    /**
     * set admin user in cache
     * @param admin
     */
    void setAdminUser(SysAdminUser admin);
}
