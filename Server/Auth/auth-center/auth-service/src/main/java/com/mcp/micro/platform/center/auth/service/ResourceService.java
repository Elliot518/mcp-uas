package com.mcp.micro.platform.center.auth.service;

import java.util.List;
import java.util.Map;

/**
 * @author: KG
 * @description: 后台资源管理服务
 * @date: Created in 3:54 下午 2020/9/9
 * @modified by:
 */

public interface ResourceService {
    /**
     * Init Roles and Resources
     * @return
     */
    Map<String, List<String>> initResourceRolesMap();
}
