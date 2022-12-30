package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.domain.auth.entity.SysResourceCategory;
import com.mcp.micro.platform.center.auth.mapper.SysResourceCategoryMapper;
import com.mcp.micro.platform.center.auth.repository.SysResourceCategoryRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
@Repository
public class SysResourceCategoryRepositoryImpl extends ServiceImpl<SysResourceCategoryMapper, SysResourceCategory> implements SysResourceCategoryRepository {}
