package com.kido;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan(basePackages = {"com.kido.listenter.*"})
@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement//只有这个才能开启@Transactional这个注解  只需要加入spring-boot-starter-jdbc这个依赖即可
@MapperScan(basePackages = {"com.kido.mapper"})//配置扫描mapper类，这样才能@Autowired扫描到
@EnableScheduling//定时器任务
public class WisdomparkApplication {
    public static void main(String[] args){
        SpringApplication.run(WisdomparkApplication.class, args);
        System.out.println("启动后进入");
    }
}
