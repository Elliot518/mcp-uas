package com.mcp.micro.platform.center.auth.service;

import com.mcp.infrastructure.common.domain.dto.auth.UserDto;

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
}
