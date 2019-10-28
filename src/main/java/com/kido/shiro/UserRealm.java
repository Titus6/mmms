package com.kido.shiro;

import com.kido.domain.User;
import com.kido.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * 自定义Realm
 * @Auther:taoshuai
 * @Date: 2019/10/24 14:17
 * @Description: com.kido.shiro
 * @version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
    * 功能描述:执行授权逻辑
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串 user:add 授权字符串必须与ShiroConfig文件中保持一致
        //info.addStringPermission("user:add");

        //模拟数据库查询出来的集合数据(人员表，角色表)
        //List<String> list = new ArrayList<>();
        //list.add("user:add");
        //list.add("user:update");


        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        //拿到登录下的第一次参数（执行认证逻辑）
        User user = (User) subject.getPrincipal();
        info.addStringPermission(user.getPerms());
        //info.addStringPermissions(list);两表情况下
        return info;
    }

    /**
    * 功能描述:执行认证逻辑
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");


        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        //查询数据库
        User user = userService.findByName(token.getUsername());

        if (null == user){
            //用户名不存在
            return null;//shiro底层会抛出UnknownAccountException
        }

        //2.判断密码
        //第一个参数 返回给controller中login方法的数据，第二个参数为数据库的密码 数据库的密码返回shiro会自动判断，第三个参数为shiro的名字
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");

    }
}
