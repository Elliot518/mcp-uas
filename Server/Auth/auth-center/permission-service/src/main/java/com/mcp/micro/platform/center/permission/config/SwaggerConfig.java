package com.mcp.micro.platform.center.permission.config;

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
        swaggerApiInfo.setBasePackage("com.mcp.micro.platform.center.permission.controller");
        swaggerApiInfo.setTitle("permission-service API");
        swaggerApiInfo.setDescription("swagger-ui API for permission-service");
        swaggerApiInfo.setServiceUrl("http://www.microcomponent.net");
        swaggerApiInfo.setVersion("1.0");
        return swaggerApiInfo;
    }

    @Bean
    @Override
    public Docket createRestApi() {
        return super.createRestApi();
    }
}
