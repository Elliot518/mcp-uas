package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.mcp.micro.platform.center.auth.mapper.SysAdminRoleRelationMapper;
import com.mcp.micro.platform.center.auth.repository.SysAdminRoleRelationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.SysRole;
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
}
