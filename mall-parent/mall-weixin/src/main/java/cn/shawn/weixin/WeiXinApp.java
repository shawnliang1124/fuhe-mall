package cn.shawn.weixin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 16:41
 * @contact 269882341@qq.com
 * @description 微信启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value="cn.shawn.weixin.feign")
@Slf4j
public class WeiXinApp {

    public static void main(String[] args) {
        SpringApplication.run(WeiXinApp.class,args);
    }
}
