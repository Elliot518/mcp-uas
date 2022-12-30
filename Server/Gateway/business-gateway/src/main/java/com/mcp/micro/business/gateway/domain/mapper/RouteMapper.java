package com.mcp.micro.business.gateway.domain.mapper;

import com.mcp.micro.business.gateway.domain.dto.RouteDto;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:32 上午 2020/8/28
 * @modified by:
 */
@Slf4j
public class RouteMapper {
    public static RouteDefinition mapFromSource(RouteDto routeDto) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(routeDto.getId());
        routeDefinition.setOrder(routeDto.getOrder());
        try {
            URI uri = new URI(routeDto.getUri());
            routeDefinition.setUri(uri);
        } catch (URISyntaxException e) {
            log.info("URI transform error: ", e);
        }

        List<FilterDefinition> filters = JSON.parseArray(routeDto.getFilters(), FilterDefinition.class);
        routeDefinition.setFilters(filters);

        List<PredicateDefinition> predicates = JSON.parseArray(routeDto.getPredicates(), PredicateDefinition.class);
        routeDefinition.setPredicates(predicates);

        return  routeDefinition;
    }

    public static List<RouteDefinition> mapFromSourceList(List<RouteDto> routeDtoList) {
        List<RouteDefinition> routeDefinitionList = new ArrayList<>();
        for (RouteDto routeDto : routeDtoList) {
            RouteDefinition routeDefinition = mapFromSource(routeDto);
            routeDefinitionList.add(routeDefinition);
        }

        return routeDefinitionList;
    }
}
