package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.platform.center.auth.mapper.SysMenuMapper;
import com.mcp.micro.platform.center.auth.repository.SysMenuRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.SysMenu;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysMenuRepositoryImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuRepository {}
