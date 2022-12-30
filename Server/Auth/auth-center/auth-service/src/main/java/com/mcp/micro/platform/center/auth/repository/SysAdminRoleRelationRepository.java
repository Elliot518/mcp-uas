package com.mcp.micro.platform.center.auth.repository;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
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
    List<SysRole> listSysRolesByAdminId(Long adminId);
}
