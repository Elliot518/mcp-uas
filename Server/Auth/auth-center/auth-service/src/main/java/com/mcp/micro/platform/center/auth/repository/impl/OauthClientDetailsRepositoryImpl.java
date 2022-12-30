package com.mcp.micro.platform.center.auth.repository.impl;


import com.mcp.micro.platform.center.auth.repository.OauthClientDetailsRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcp.micro.domain.auth.entity.OauthClientDetails;
import com.mcp.micro.platform.center.auth.mapper.OauthClientDetailsMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KG
 * @since 2020-08-17
 */
@Repository
public class OauthClientDetailsRepositoryImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements OauthClientDetailsRepository {}
