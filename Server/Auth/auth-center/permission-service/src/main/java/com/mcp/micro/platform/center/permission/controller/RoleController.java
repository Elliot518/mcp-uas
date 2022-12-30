package com.mcp.micro.platform.center.permission.controller;

import com.mcp.micro.domain.auth.request.UpdRolesReq;
import com.mcp.micro.platform.center.permission.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: KG
 * @description: 角色管理相关接口
 * @date: Created in 11:00 下午 2020/10/16
 * @modified by:
 */
@RestController
@Api(tags = "角色管理接口")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("给用户分配角色")
    @PostMapping(value = "/role/{adminId}")
    @ResponseBody
    public Boolean updateRole(@RequestBody UpdRolesReq req) {
        return sysRoleService.updateRole(req.getAdminId(), req.getRoleIds());
    }
}
