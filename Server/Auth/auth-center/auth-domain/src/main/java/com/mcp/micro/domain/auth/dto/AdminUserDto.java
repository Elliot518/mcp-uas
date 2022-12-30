package com.mcp.micro.domain.auth.dto;

import com.mcp.micro.domain.auth.entity.SysMenu;
import lombok.Data;

import java.util.List;

/**
 * @author: KG
 * @description: Admin User Dto include Menu List
 * @date: Created in 1:46 下午 2020/9/25
 * @modified by:
 */
@Data
public class AdminUserDto {
    private String username;

    private String icon;

    private List<SysMenu> menus;
}
