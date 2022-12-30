package com.mcp.micro.platform.center.auth.mapper;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcp.micro.domain.auth.entity.SysRole;

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
}
