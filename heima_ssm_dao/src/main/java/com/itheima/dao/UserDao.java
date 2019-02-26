package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface UserDao {
    /**
     * 登陆验证
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column ="id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "statusStr",column = "statusStr"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.RoleDao.findByRoles")),
    })
    UserInfo findUsername(String username)throws Exception;

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;

    /**
     * 保存用户信息
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;

    /**
     * 根据id查询详情
     * @param id
     * @return
     */

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column ="id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "statusStr",column = "statusStr"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.RoleDao.findByRoles"))
    })
    UserInfo findById(String id)throws Exception;

    /**
     * 查询可以关联用户表的角色信息
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from  users_role where userId =#{userId})")
    List<Role> findOtherRoles(String userId)throws Exception;

    /**
     * 存入用户的角色信息
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId,@Param("roleId")String roleId)throws Exception;
}
