package com.mcp.micro.platform.center.auth.repository;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mcp.micro.domain.auth.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysRoleRepository extends IService<SysRole> {
    /**
     * get roles by company id
     * @param companyId
     * @return
     */
    List<SysRole> listRolesByCompanyId(String companyId);
}
