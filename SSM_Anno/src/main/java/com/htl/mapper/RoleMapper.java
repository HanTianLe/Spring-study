package com.htl.mapper;

import com.htl.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    //查询所有角色
    @Select("select * from sys_role")
    List<Role> findAll();

    //新建角色
    @Insert("insert into sys_role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    //根据 用户 id 查询角色
    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{id}")
    List<Role> findRoleByUserId(int id);

    //删除sys_user_role关系表数据（先）
    @Delete("delete from sys_user_role where roleId=#{roleId}")
    void deleteUserRoleRel(int roleId);

    //删除sys_role表数据（后）
    @Delete("delete from sys_role where id=#{roleId}")
    void deleteRole(int roleId);
}
