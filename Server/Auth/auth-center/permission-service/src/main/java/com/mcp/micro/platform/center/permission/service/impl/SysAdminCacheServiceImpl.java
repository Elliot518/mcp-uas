package com.mcp.micro.platform.center.permission.service.impl;

import com.mcp.components.boot.starters.redis.RedisClientStarterService;
import com.mcp.micro.domain.auth.entity.SysAdminUser;
import com.mcp.micro.platform.center.permission.service.SysAdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: KG
 * @description:
 * @date: Created in 6:15 下午 2020/9/24
 * @modified by:
 */
@Service
public class SysAdminCacheServiceImpl implements SysAdminCacheService {

    @Autowired
    private RedisClientStarterService redisClientStarterService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Override
    public void delAdminUser(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        redisClientStarterService.del(key);
    }

    @Override
    public SysAdminUser getAdminUser(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        return (SysAdminUser) redisClientStarterService.get(key);
    }

    @Override
    public void setAdminUser(SysAdminUser admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getId();
        redisClientStarterService.set(key, admin, REDIS_EXPIRE);
    }
}

