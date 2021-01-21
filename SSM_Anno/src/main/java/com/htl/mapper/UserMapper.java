package com.htl.mapper;

import com.htl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    @Select("select * from sys_user")
    List<User> findAll();

    //向 sys_user表中存储数据，并返回当前保存用户的id。
    //useGeneratedKeys设置为 true 时，表示如果插入的表id以自增列为主键，
    //则允许 JDBC 支持自动生成主键，并可将自动生成的主键id返回。
    //useGeneratedKeys参数只针对 insert 语句生效，默认为 false。
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert(value = "insert into sys_user values(#{id},#{username},#{email},#{password},#{phoneNum})")
    void save(User user);

    //向sys_user_role关系表中存储多条数据
    @Insert("insert into sys_user_role values(#{param1},#{param2})")
    void saveUserRoleRel(int userId, int roleIds);

    //删除sys_user_role关系表数据（先）
    @Delete("delete from sys_user_role where userId=#{userId}")
    void deleteUserRoleRel(int userId);

    //删除sys_user表数据（后）
    @Delete("delete from sys_user where id=#{userId}")
    void deleteUser(int userId);

    //用户登录
    @Select("select * from sys_user where username=#{arg0} and password=#{arg1}")
    User findByUsernameAndPassword(String username, String password);

}
