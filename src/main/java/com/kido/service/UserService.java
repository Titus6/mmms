package com.kido.service;

import com.kido.domain.User;

/**
 * @Auther:taoshuai
 * @Date: 2019/10/25 15:18
 * @Description: com.kido.service
 * @version: 1.0
 */
public interface UserService {

     User findByName(String name);

     User findById(Integer id);
}
