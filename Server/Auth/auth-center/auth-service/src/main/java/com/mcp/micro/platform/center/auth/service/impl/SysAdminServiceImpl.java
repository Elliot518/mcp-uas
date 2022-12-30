package com.mcp.micro.platform.center.auth.service.impl;

import com.mcp.infrastructure.common.domain.dto.auth.UserDto;
import com.mcp.micro.domain.auth.api.AuthApiException;
import com.mcp.micro.domain.auth.api.ResultCode;
import com.mcp.micro.platform.center.auth.repository.SysAdminUserRepository;
import com.mcp.micro.platform.center.auth.repository.SysAdminRoleRelationRepository;
import cn.hutool.core.collection.CollUtil;

import com.mcp.micro.domain.auth.entity.SysRole;
import com.mcp.micro.platform.center.auth.service.SysAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcp.micro.domain.auth.entity.SysAdminUser;

import java.util.List;
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
}
