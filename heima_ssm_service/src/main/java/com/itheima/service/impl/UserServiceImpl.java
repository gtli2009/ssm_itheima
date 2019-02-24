package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findUsername(username);
        //根据SpringSecurity创建的User对象返回UserDetail，User对象继承了UserDetail
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 1 ? true : false, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 根据用户，返回用户角色描述
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

}
