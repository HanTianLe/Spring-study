package com.htl.mapper;

import com.htl.domain.Role;

import java.util.List;

public interface RoleMapper {
    //查询所有角色
    List<Role> findAll();
    //新建角色
    void save(Role role);
    //根据 用户 id 查询角色
    List<Role> findRoleByUserId(int id);
    //删除sys_user_role关系表数据（先）
    void deleteUserRoleRel(int roleId);
    //删除sys_role表数据（后）
    void deleteRole(int roleId);
}
