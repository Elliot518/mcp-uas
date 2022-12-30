package com.mcp.micro.platform.center.auth.config;

import com.mcp.components.boot.starters.redis.config.BaseRedisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:10 下午 2020/9/8
 * @modified by:
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig extends BaseRedisConfig {
}
