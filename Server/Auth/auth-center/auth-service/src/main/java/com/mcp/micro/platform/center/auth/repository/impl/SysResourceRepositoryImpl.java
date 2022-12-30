package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.platform.center.auth.repository.SysResourceRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.SysResource;
import com.mcp.micro.platform.center.auth.mapper.SysResourceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysResourceRepositoryImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceRepository {
    @Override
    public List<SysResource> listResourcesByCompanyId(String companyId) {
        return null;
    }
}
