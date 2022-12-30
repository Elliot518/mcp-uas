package com.mcp.micro.platform.center.permission.controller;

import com.mcp.infrastructure.common.domain.constant.AuthConstant;
import com.mcp.infrastructure.common.domain.dto.auth.UserDto;
import com.mcp.infrastructure.common.domain.exception.ApiException;
import com.mcp.infrastructure.common.domain.helper.AuthHelper;
import com.mcp.micro.domain.auth.api.ResultCode;
import com.mcp.micro.domain.auth.dto.AdminMenu;
import com.mcp.micro.domain.auth.dto.AdminUserDto;
import com.mcp.micro.domain.auth.entity.SysAdminUser;
import com.mcp.micro.domain.auth.entity.SysMenu;
import com.mcp.micro.platform.center.permission.service.SysAdminService;
import com.mcp.micro.platform.center.permission.repository.SysAdminRoleRelationRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: KG
 * @description:
 * @date: Created in 4:05 下午 2020/9/11
 * @modified by:
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SysAdminService sysAdminService;

    @Autowired
    private SysAdminRoleRelationRepository sysAdminRoleRelationRepository;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "/user-tree")
    @ResponseBody
    public UserDto getUserTree(@RequestParam String username, @RequestParam String clientId) {
        return sysAdminService.loadUserByUsernameAndClientId(username, clientId);
    }

    @ApiOperation(value = "获取用户信息带菜单")
    @GetMapping(value = "/user-menu")
    @ResponseBody
    public AdminUserDto getAdminInfo() {
        // get current user
        String userTokenStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        UserDto userDto = AuthHelper.convertUserFromTokenHeader(userTokenStr);
        SysAdminUser adminUser = sysAdminService.getUserByIdWithCache(Optional.ofNullable(userDto).map(UserDto::getId).orElse(null));

        if (adminUser == null) {
            throw new ApiException(ResultCode.ADMIN_NO_CURRENT_USER);
        }

        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setUsername(adminUser.getUsername());
        adminUserDto.setIcon(adminUserDto.getIcon());

        // get menu list by admin id
        List<SysMenu> menuList = sysAdminRoleRelationRepository.listMenusByAdminId(adminUser.getId());
        adminUserDto.setMenus(menuList);

        return adminUserDto;
    }

    /*
    @ApiOperation(value = "获取Admin用户菜单")
    @GetMapping(value = "/admin-user-menu")
    @ResponseBody
    public R getAdminUserMenu() {

        // get current user
        String userTokenStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        UserDto userDto = AuthHelper.convertUserFromTokenHeader(userTokenStr);
        SysAdminUser adminUser = sysAdminService.getUserByIdWithCache(Optional.ofNullable(userDto).map(UserDto::getId).orElse(null));

        if (adminUser == null) {
            throw new ApiException(ResultCode.ADMIN_NO_CURRENT_USER);
        }

        List<AdminMenu> amL = sysAdminService.getMenusById(adminUser.getId());

        //log.info("Admin Menu List: {}", JsonUtils.toJSONString(amL));

        return R.ok().put("menuList", amL).put("permissions", Collections.EMPTY_LIST);
    }
    */
}







