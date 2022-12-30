package com.mcp.micro.platform.center.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: KG
 * @description: Permission Service Application
 * @date: Created in 11:18 下午 2020/9/11
 * @modified by:
 */
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.mcp.micro.platform.center.permission.mapper")
public class PermissionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PermissionServiceApplication.class, args);
    }
}
