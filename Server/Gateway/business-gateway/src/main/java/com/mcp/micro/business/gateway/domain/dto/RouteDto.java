package com.mcp.micro.business.gateway.domain.dto;

import lombok.Data;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:24 上午 2020/8/28
 * @modified by:
 */
@Data
public class RouteDto {
    private String id;

    private String uri;

    private int order;

    private String filters;

    private String predicates;
}
