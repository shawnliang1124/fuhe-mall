package cn.fuhe.mall.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/17 22:34
 * @contact 269882341@qq.com
 * @description  支付服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(value = "cn.fuhe.mall")
@EnableFeignClients
public class PayApp {

    public static void main(String[] args) {
        SpringApplication.run(PayApp.class,args);
    }
}
