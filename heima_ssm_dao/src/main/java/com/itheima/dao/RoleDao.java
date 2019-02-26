package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {
    /**
     * 根据用户Id查找中间表Roleid，在查找roles
     *
     * @param
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionByRoleId")),
    })
    List<Role> findByRoles(String userId)throws Exception;

    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from role")
    List<Role> findAll()throws Exception;

    /**
     * 保存角色
     *
     * @param role
     */
    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;

    /**
     * 根据roleId查询Role
     *
     * @param roleId
     * @return
     */
    @Select("select * from role where id =#{roleId}")
    Role findRoleById(String roleId)throws Exception;

    /**
     * 根据roleid查询可以使用的权限
     *
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from  role_permission where roleId =#{roleId})")
    List<Permission> findOtherPermissions(String roleId)throws Exception;

    /**
     * 给Role添加权限
     * @param roleId
     * @param permissionId
     */
    @Insert("insert into role_permission values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId")String roleId,@Param("permissionId")String permissionId)throws Exception;
}
