package com.mcp.micro.business.gateway.repository.impl;

import com.mcp.micro.business.gateway.entity.SysRole;
import com.mcp.micro.business.gateway.mapper.SysRoleMapper;
import com.mcp.micro.business.gateway.repository.SysRoleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysRoleRepositoryImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleRepository {
    @Override
    public List<SysRole> listRolesByCompanyId(String companyId) {
        return null;
    }
}