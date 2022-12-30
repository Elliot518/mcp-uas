package com.mcp.micro.business.gateway.repository;

import com.mcp.micro.business.gateway.entity.SysRoleResourceRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台角色资源关系表 服务类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysRoleResourceRelationRepository extends IService<SysRoleResourceRelation> {
    /**
     * get role resource relations by company id
     * @param companyId
     * @return
     */
    List<SysRoleResourceRelation> listRoleResourceRelationsByCompanyId(String companyId);
}
