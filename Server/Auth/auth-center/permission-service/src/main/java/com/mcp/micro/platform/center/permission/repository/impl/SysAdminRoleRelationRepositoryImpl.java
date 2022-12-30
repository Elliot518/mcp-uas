package com.mcp.micro.platform.center.permission.repository.impl;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.mcp.micro.platform.center.permission.repository.SysAdminRoleRelationRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.SysMenu;
import com.mcp.micro.domain.auth.entity.SysRole;
import com.mcp.micro.platform.center.permission.mapper.SysAdminRoleRelationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysAdminRoleRelationRepositoryImpl extends ServiceImpl<SysAdminRoleRelationMapper, SysAdminRoleRelation> implements SysAdminRoleRelationRepository {
    @Override
    public List<SysRole> listSysRolesByAdminId(Long adminId) {
        return this.baseMapper.listSysRolesByAdminId(adminId);
    }

    @Override
    public List<SysMenu> listMenusByAdminId(Long adminId) {
        return this.baseMapper.getMenuList(adminId);
    }

    @Override
    public int deleteByAdminId(Long adminId) {
        return this.baseMapper.delete(new QueryWrapper<SysAdminRoleRelation>()
                .eq("admin_id", adminId)
        );
    }
}

