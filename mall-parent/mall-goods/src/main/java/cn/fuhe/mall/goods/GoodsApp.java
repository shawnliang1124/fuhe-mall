package cn.fuhe.mall.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/10 13:30
 * @contact 269882341@qq.com
 * @description
 */
@EnableFeignClients
@EnableEurekaClient
@ComponentScan("cn.fuhe.mall")
@Order(value=-1)
public class GoodsApp {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class,args);
    }
}

