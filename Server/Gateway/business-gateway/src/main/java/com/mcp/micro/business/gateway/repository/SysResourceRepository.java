package com.mcp.micro.business.gateway.repository;

import com.mcp.micro.business.gateway.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author KG
 * @since 2020-09-02
 */
public interface SysResourceRepository extends IService<SysResource> {
    /**
     * get resources by company id
     * @param companyId
     * @return
     */
    List<SysResource> listResourcesByCompanyId(String companyId);
}
