package cn.fuhe.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 * 会员启动类
 *
 * @author Shawn Liang
 * @create 2019-09-07 23:38
 * @package cn.fuhe.mall.member
 * @contact https://github.com/shawnliang1124
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.fuhe.mall.member.feign" )
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);
    }
}
