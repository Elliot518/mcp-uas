package com.mcp.micro.platform.center.permission.repository.impl;


import com.mcp.micro.platform.center.permission.repository.SysAdminUserRepository;
import com.mcp.micro.platform.center.permission.mapper.SysAdminUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.SysAdminUser;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysAdminUserRepositoryImpl extends ServiceImpl<SysAdminUserMapper, SysAdminUser> implements SysAdminUserRepository {
    @Override
    public SysAdminUser getByUserNameAndClientId(String username, String clientId) {
        return this.baseMapper.selectOne(new QueryWrapper<SysAdminUser>()
                .eq("username", username)
                .eq("company_id", clientId)
        );
    }
}
