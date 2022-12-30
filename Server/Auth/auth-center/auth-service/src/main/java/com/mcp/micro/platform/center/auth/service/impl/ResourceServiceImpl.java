package com.mcp.micro.platform.center.auth.service.impl;

import com.mcp.components.boot.starters.redis.RedisClientStarterService;
import com.mcp.infrastructure.common.domain.constant.AuthConstant;
import com.mcp.micro.domain.auth.entity.SysResource;
import com.mcp.micro.domain.auth.entity.SysRole;
import com.mcp.micro.domain.auth.entity.SysRoleResourceRelation;
import com.mcp.micro.platform.center.auth.repository.SysResourceRepository;
import com.mcp.micro.platform.center.auth.repository.SysRoleRepository;
import com.mcp.micro.platform.center.auth.repository.SysRoleResourceRelationRepository;
import com.mcp.micro.platform.center.auth.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author: KG
 * @description: 后台资源管理服务实现类
 * @date: Created in 3:56 下午 2020/9/9
 * @modified by:
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private SysResourceRepository sysResourceRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysRoleResourceRelationRepository sysRoleResourceRelationRepository;

    @Autowired
    private RedisClientStarterService redisClientStarterService;

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        Map<String, List<String>> resourceRoleMap = new TreeMap<>();
        List<SysResource> resourceList = sysResourceRepository.list();
        List<SysRole> roleList = sysRoleRepository.list();
        List<SysRoleResourceRelation> relationList = sysRoleResourceRelationRepository.list();
        for (SysResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(SysRoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put(resource.getUrl(), roleNames);
        }

        redisClientStarterService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisClientStarterService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);

        return resourceRoleMap;
    }
}
