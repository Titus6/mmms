package com.kido.controller;

import com.kido.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Auther:taoshuai
 * @Date: 2019/10/24 15:37
 * @Description: com.kido.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {



    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public  String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public  String login(){
        return "/login";
    }

    /**
    * 功能描述:登录逻辑处理
    */
    @RequestMapping("/login")
    public String login(String name, String password, Model model){
        /**
        * 功能描述:使用shiro编写认证操作
        */
        //1。获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //3.执行登录方法
        try{
            subject.login(token);
            //登录成功，跳转到index页面
            return "redirect:/user/index";
        }catch (UnknownAccountException e){
            //登录失败 用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            //登录失败 密码错误
            model.addAttribute("msg","密码错误");
            return "/login";
        }
    }

    @RequestMapping("/noAuth")
    public  String noAuth(){
        return "/noAuth";
    }


}
