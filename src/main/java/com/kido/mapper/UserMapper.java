package com.kido.mapper;

import com.kido.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Auther:taoshuai
 * @Date: 2019/10/25 15:09
 * @Description: com.kido.mapper
 * @version: 1.0
 */
@Repository
public interface UserMapper {

     User findByName(String name);

     User findById(Integer id);
}
