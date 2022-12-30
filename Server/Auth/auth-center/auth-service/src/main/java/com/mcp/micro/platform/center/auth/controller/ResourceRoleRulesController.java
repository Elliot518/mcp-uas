package com.mcp.micro.platform.center.auth.controller;

import com.mcp.infrastructure.common.domain.helper.ResponseHelper;
import com.mcp.infrastructure.common.domain.response.BaseResponse;
import com.mcp.micro.platform.center.auth.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description: 刷新权限缓存
 * @date: Created in 2:14 下午 2020/9/10
 * @modified by:
 */
@RestController
@RequestMapping("/resource-roles")
@Slf4j
public class ResourceRoleRulesController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/refresh")
    public BaseResponse<String> refresh(){
        log.info("Refresh resources and roles of cache...");
        resourceService.initResourceRolesMap();

        return ResponseHelper.success("Ok");
    }
}

