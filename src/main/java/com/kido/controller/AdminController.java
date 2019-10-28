package com.kido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther:taoshuai
 * @Date: 2019/10/25 15:56
 * @Description: com.kido.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/demo")
    public String demo(){
        return "/user/add";
    }
}
