package com.mcp.micro.domain.auth.request;

import lombok.Data;

import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 11:16 下午 2020/10/16
 * @modified by:
 */
@Data
public class UpdRolesReq {
    private Long adminId;

    private List<Long> roleIds;
}

