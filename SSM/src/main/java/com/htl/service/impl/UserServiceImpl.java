package com.htl.service.impl;

import com.htl.domain.Role;
import com.htl.domain.User;
import com.htl.mapper.RoleMapper;
import com.htl.mapper.UserMapper;
import com.htl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    //UserMapper注入
    @Autowired
    private UserMapper userMapper;

    //RoleMapper注入
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有用户
     * @return userList
     */
    public List<User> list() {
        List<User> userList = userMapper.findAll();
        //封装userList中的每一个User的roles数据
        for (User user:userList){
            //获得user的id
            int id = user.getId();
            //将id作为参数 查询当前userId对应的Role集合数据
            List<Role> roles = roleMapper.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    /**
     * 新建用户的保存操作
     * @param user
     * @param roleIds
     */
    public void save(User user, int[] roleIds) {
        //第一步 向sys_user表中存储数据，并返回当前保存用户的id。
        userMapper.save(user);
        int userId = user.getId();
        //第二步 向sys_user_role关系表中存储多条数据。
        for (int roleId:roleIds){
            userMapper.saveUserRoleRel(userId,roleId);
        }
    }

    /**
     * 删除用户操作
     * @param userId
     */
    public void delete(int userId) {
        //1、删除sys_user_role关系表数据（先）
        userMapper.deleteUserRoleRel(userId);
        //2、删除sys_user表数据（后）
        userMapper.deleteUser(userId);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        try {
            User user = userMapper.findByUsernameAndPassword(username,password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}