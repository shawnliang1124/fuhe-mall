package cn.fuhe.mall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

/**
 * @author shawnLiang
 * 会员服务启动类
 */
@SpringBootApplication
@MapperScan("cn.fuhe.mall.member.mapper")
@EnableFeignClients
@EnableEurekaClient
@ComponentScan("cn.fuhe.mall")
@Order(value=-1)
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class,args);
    }
}
