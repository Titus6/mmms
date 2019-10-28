package com.kido.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *shiro配置类
 *  @Auther:taoshuai
 * @Date: 2019/10/24 14:13
 * @Description: com.kido.shiro
 * @version: 1.0
 */
@Configuration
public class ShiroConfig {

    /**
    * 功能描述:创建ShiroFilterFactoryBean
    */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器
        /**
        *   Shiro内置过滤器，可以实现权限相关的拦截器
         *      常用的过滤器
         *          anon:无需认证（登陆）可以访问
         *          authc:必须认证才可以访问
         *          user：如果使用rememberMe的功能可以直接访问
         *          perms：该资源必须得到资源权限才可以访问
         *          role：该资源必须得到角色权限才可以访问
        */
        //LinkedHashMap 保持顺序
        Map<String,String> filterMap = new LinkedHashMap<>();
/*        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");*/

        filterMap.put("/user/index","anon");
        filterMap.put("/user/login","anon");


        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        //perms[user:add]固定写法
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        //拦截资源必须放在最后面 亲测
        filterMap.put("/user/*","authc");

        //修改调整的登陆页面
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }



    /**
     * 功能描述:创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }



    /**
     * 功能描述:创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
    * 功能描述:配置ShiroDialect,用于thymeleaf和shiro标签配合使用
    */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
