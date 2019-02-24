package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    /**
     * 根据用户Id查找中间表Roleid，在查找roles
     *
     * @param id
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    List<Role> findByRoles(String id);


}
