package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.domain.auth.entity.SysRoleMenuRelation;
import com.mcp.micro.platform.center.auth.repository.SysRoleMenuRelationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.platform.center.auth.mapper.SysRoleMenuRelationMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台角色菜单关系表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysRoleMenuRelationRepositoryImpl extends ServiceImpl<SysRoleMenuRelationMapper, SysRoleMenuRelation> implements SysRoleMenuRelationRepository {}
