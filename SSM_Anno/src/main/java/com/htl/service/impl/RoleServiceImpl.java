package com.htl.service.impl;

import com.htl.domain.Role;
import com.htl.mapper.RoleMapper;
import com.htl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    //RoleMapper注入
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> list() {
        List<Role> roleList = roleMapper.findAll();
        return roleList;
    }

    /**
     * 新建角色
     * @param role
     */
    public void save(Role role) {
        roleMapper.save(role);
    }

    /**
     * 删除角色操作
     * @param roleId
     */
    public void delete(int roleId) {
        //1、删除sys_user_role关系表数据（先）
        roleMapper.deleteUserRoleRel(roleId);
        //2、删除sys_role表数据（后）
        roleMapper.deleteRole(roleId);
    }

}