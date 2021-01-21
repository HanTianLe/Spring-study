package com.htl.mapper;

import com.htl.domain.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> findAll();
    //向 sys_user表中存储数据，并返回当前保存用户的id
    void save(User user);
    //向 sys_user_role关系表中存储多条数据
    void saveUserRoleRel(int userId, int roleIds);
    //删除sys_user_role关系表数据（先）
    void deleteUserRoleRel(int userId);
    //删除sys_user表数据（后）
    void deleteUser(int userId);
    //用户登录
    User findByUsernameAndPassword(String username, String password);
}
