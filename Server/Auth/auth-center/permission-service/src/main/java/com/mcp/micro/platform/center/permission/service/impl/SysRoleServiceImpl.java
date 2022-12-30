package com.mcp.micro.platform.center.permission.service.impl;

import com.mcp.micro.domain.auth.entity.SysAdminRoleRelation;
import com.mcp.micro.platform.center.permission.repository.SysAdminRoleRelationRepository;
import com.mcp.micro.platform.center.permission.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:08 下午 2020/10/16
 * @modified by:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysAdminRoleRelationRepository sysAdminRoleRelationRepository;

    @Override
    public Boolean updateRole(Long adminId, List<Long> roleIds) {
        if (roleIds == null) {
            return false;
        }

        // first delete old user role relation
        sysAdminRoleRelationRepository.deleteByAdminId(adminId);

        // build new user role relation
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<SysAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                SysAdminRoleRelation roleRelation = new SysAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }

            return sysAdminRoleRelationRepository.saveBatch(list);
        }

        return true;
    }
}










