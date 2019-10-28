package com.kido.service.impl;

import com.kido.domain.User;
import com.kido.mapper.UserMapper;
import com.kido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Auther:taoshuai
 * @Date: 2019/10/25 15:20
 * @Description: com.kido.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
