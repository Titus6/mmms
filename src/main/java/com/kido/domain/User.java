package com.kido.domain;

import lombok.Data;

/**
 * @Auther:taoshuai
 * @Date: 2019/10/25 15:07
 * @Description: com.kido.domain
 * @version: 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String perms;
}
