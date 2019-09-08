package cn.fuhe.mall.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 * 微信服务启动类
 *
 * @author Shawn Liang
 * @create 2019-09-07 23:42
 * @package cn.fuhe.mall.weixin
 * @contact https://github.com/shawnliang1124
 */
@SpringBootApplication
@EnableEurekaClient
public class WeixinApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class,args);
    }
}
