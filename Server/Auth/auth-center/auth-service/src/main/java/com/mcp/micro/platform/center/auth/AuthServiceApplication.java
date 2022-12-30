package com.mcp.micro.platform.center.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: KG
 * @description: OAuth2 Authentication Center
 * @date: Created in 5:07 下午 2020-/8/7
 * @modified by:
 */
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.mcp.micro.platform.center.auth.mapper")
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
