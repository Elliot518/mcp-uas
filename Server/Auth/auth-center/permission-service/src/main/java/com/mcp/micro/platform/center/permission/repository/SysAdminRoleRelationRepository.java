package com.mcp.micro.platform.center.permission.repository;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.mcp.micro.domain.auth.entity.SysMenu;
import com.mcp.micro.domain.auth.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysAdminRoleRelationRepository extends IService<SysAdminRoleRelation> {
    /**
     * 根据后台用户ID获取角色列表
     * @param adminId
     * @return
     */
    List<SysRole> listSysRolesByAdminId(Long adminId);

    /**
     * 根据后台用户ID获取菜单列表
     * @param adminId
     * @return
     */
    List<SysMenu> listMenusByAdminId(Long adminId);

    /**
     * 根据adminId删除角色关系
     * @param adminId
     */
    int deleteByAdminId(Long adminId);
}
