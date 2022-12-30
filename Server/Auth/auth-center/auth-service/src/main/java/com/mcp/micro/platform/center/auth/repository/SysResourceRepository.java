package com.mcp.micro.platform.center.auth.repository;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mcp.micro.domain.auth.entity.SysResource;

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
