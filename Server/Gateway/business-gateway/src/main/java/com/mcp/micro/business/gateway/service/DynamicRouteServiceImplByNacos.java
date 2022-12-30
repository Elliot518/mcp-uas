package com.mcp.micro.business.gateway.service;

import com.mcp.micro.business.gateway.config.NacosGatewayProperties;
import com.mcp.micro.business.gateway.domain.dto.RouteDto;
import com.mcp.micro.business.gateway.domain.mapper.RouteMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author: KG
 * @description:
 * @date: Created in 3:08 下午 2020/8/27
 * @modified by:
 */

@Component
public class DynamicRouteServiceImplByNacos implements CommandLineRunner {

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    private NacosGatewayProperties nacosGatewayProperties;

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener (){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosGatewayProperties.getAddress());
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), nacosGatewayProperties.getTimeout());
            System.out.println(content);
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    try {
                        List<RouteDto> routeList = JSON.parseArray(configInfo, RouteDto.class);

                        // transform
                        List<RouteDefinition> routeDefinitions = RouteMapper.mapFromSourceList(routeList);

                        routeDefinitions.forEach(definition->{
                            dynamicRouteService.update(definition);
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        dynamicRouteByNacosListener();

    }

}








