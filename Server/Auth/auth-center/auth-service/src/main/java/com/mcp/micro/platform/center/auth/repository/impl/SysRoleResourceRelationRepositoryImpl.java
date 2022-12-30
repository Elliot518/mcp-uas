package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.domain.auth.entity.SysRoleResourceRelation;
import com.mcp.micro.platform.center.auth.mapper.SysRoleResourceRelationMapper;
import com.mcp.micro.platform.center.auth.repository.SysRoleResourceRelationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台角色资源关系表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysRoleResourceRelationRepositoryImpl extends ServiceImpl<SysRoleResourceRelationMapper, SysRoleResourceRelation> implements SysRoleResourceRelationRepository {
    @Override
    public List<SysRoleResourceRelation> listRoleResourceRelationsByCompanyId(String companyId) {
        return null;
    }
}
