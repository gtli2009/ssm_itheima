package com.itheima.service;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{


    /**
     * 查找所有用户
     * @return
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据用户id查询详情
     * @param id
     * @return
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 查询用户可以匹配的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 存入用户的角色信息
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;

}
