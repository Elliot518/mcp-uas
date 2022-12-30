package com.mcp.micro.platform.center.auth.component;

import com.mcp.micro.platform.center.auth.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: KG
 * @description: Resources and Roles Relations Initialization Component
 * @date: Created in 5:23 下午 2020/9/9
 * @modified by:
 */
@Slf4j
@Component
public class ResourceRoleRulesHolder {

    @Autowired
    private ResourceService resourceService;

    @PostConstruct
    public void initResourceRolesMap(){
        log.info("Resources and Roles Map init...");
        resourceService.initResourceRolesMap();
    }
}

