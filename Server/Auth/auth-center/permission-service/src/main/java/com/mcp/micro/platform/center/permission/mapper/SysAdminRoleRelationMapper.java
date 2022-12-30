package com.mcp.micro.platform.center.permission.mapper;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.mcp.micro.domain.auth.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcp.micro.domain.auth.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysAdminRoleRelationMapper extends BaseMapper<SysAdminRoleRelation> {
    List<SysRole> listSysRolesByAdminId(Long adminId);

    /**
     * 根据后台用户ID获取菜单
     * @param adminId
     * @return
     */
    List<SysMenu> getMenuList(Long adminId);
}
