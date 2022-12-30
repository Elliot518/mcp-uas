package com.mcp.micro.platform.center.auth.config;

import com.mcp.infrastructure.common.domain.config.AbstractSwaggerConfig;
import com.mcp.infrastructure.common.domain.config.SwaggerApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : KG
 * description:
 * create date: 5:29 PM 2019/12/26
 * modified by:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {

    @Override
    protected SwaggerApiInfo getApiInfo() {
        SwaggerApiInfo swaggerApiInfo = new SwaggerApiInfo();
        swaggerApiInfo.setBasePackage("com.mcp.micro.platform.center.auth.controller");
        swaggerApiInfo.setTitle("auth-center API");
        swaggerApiInfo.setDescription("swagger-ui API for auth-center");
        swaggerApiInfo.setServiceUrl("http://www.micro-component.com");
        swaggerApiInfo.setVersion("1.0");
        return swaggerApiInfo;
    }

    @Bean
    @Override
    public Docket createRestApi() {
       return super.createRestApi();
    }
}
