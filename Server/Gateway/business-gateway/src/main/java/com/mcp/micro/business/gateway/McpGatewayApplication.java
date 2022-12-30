package com.mcp.micro.business.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: KG
 * @description:
 * @date: Created in 2:58 下午 2020/8/4
 * @modified by:
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.mcp.micro.business.gateway.mapper")
public class McpGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(McpGatewayApplication.class, args);
    }
}
