package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Select("select * from Member where id= #{id}")
    Member findById(String id);

}
