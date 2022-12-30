package com.mcp.micro.platform.center.permission.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.mcp.infrastructure.common.domain.dto.auth.UserDto;
import com.mcp.micro.domain.auth.api.AuthApiException;
import com.mcp.micro.domain.auth.api.ResultCode;
import com.mcp.micro.domain.auth.dto.AdminMenu;
import com.mcp.micro.domain.auth.entity.SysAdminUser;
import com.mcp.micro.domain.auth.entity.SysMenu;
import com.mcp.micro.domain.auth.entity.SysRole;
import com.mcp.micro.platform.center.permission.repository.SysAdminRoleRelationRepository;
import com.mcp.micro.platform.center.permission.repository.SysAdminUserRepository;
import com.mcp.micro.platform.center.permission.service.SysAdminCacheService;
import com.mcp.micro.platform.center.permission.service.SysAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: KG
 * @description:
 * @date: Created in 4:37 下午 2020/9/7
 * @modified by:
 */
@Service
public class SysAdminServiceImpl implements SysAdminService {
    @Autowired
    private SysAdminUserRepository sysAdminUserRepository;

    @Autowired
    private SysAdminRoleRelationRepository sysAdminRoleRelationRepository;

    @Autowired
    private SysAdminCacheService sysAdminCacheService;

    @Override
    public UserDto loadUserByUsernameAndClientId(String username, String clientId) {
        SysAdminUser sysAdminUser = sysAdminUserRepository.getByUserNameAndClientId(username, clientId);
        if (sysAdminUser == null) {
            throw new AuthApiException(ResultCode.ADMIN_NO_USER);
        }

        // get roles of the admin user
        List<SysRole> roleList = sysAdminRoleRelationRepository.listSysRolesByAdminId(sysAdminUser.getId());
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(sysAdminUser, userDto);
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            userDto.setRoles(roleStrList);
        }

        return userDto;
    }

    @Override
    public SysAdminUser getUserByIdWithCache(Long userId) {
        // get admin user from cache by user id
        SysAdminUser adminUser = sysAdminCacheService.getAdminUser(userId);

        // cache exists return immediately
        if (adminUser != null) {
            return adminUser;
        }

        adminUser = sysAdminUserRepository.getBaseMapper().selectById(userId);
        // set admin user info to cache
        sysAdminCacheService.setAdminUser(adminUser);

        return adminUser;
    }

    @Override
    public List<SysRole> listSysRolesByAdminId(Long adminId) {
        return sysAdminRoleRelationRepository.listSysRolesByAdminId(adminId);
    }

    @Override
    public List<AdminMenu> getMenusById(Long userId) {
        List<SysMenu> menuList = sysAdminRoleRelationRepository.listMenusByAdminId(userId);

        return buildMenuTree(0L, null, menuList);
    }

    private List<AdminMenu> buildMenuTree(Long parentMenuId, SysMenu parentMenu, List<SysMenu> menuList) {
        return menuList.stream().filter(m -> Objects.equals(parentMenuId, m.getParentId())).map(m -> {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.setMenuId(m.getId());
            adminMenu.setParentId(parentMenuId);
            adminMenu.setParentName(parentMenu != null ? parentMenu.getTitle() : "");//
            adminMenu.setName(m.getTitle());
            adminMenu.setUrl(m.getUrl());
            adminMenu.setPerms("");// todo
            adminMenu.setType(m.getLevel() == 0 ? 0 : 1);
            adminMenu.setIcon(m.getIcon());
            adminMenu.setOrderNum(m.getSort());
            adminMenu.setOpen(false);// todo
            adminMenu.setList(buildMenuTree(m.getId(), m, menuList));

            return adminMenu;
        }).collect(Collectors.toList());
    }
}





