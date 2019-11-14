package cn.fuhe.mall.online;

import cn.fuhe.mall.bean.AutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 16:41
 * @contact 269882341@qq.com
 * @description 微信启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(value="cn.fuhe.mall.online.feign")
@ComponentScan(value = "cn.fuhe.mall" ,
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {AutoConfiguration.class})
        }
)
@Slf4j
public class OnlineApp {

    public static void main(String[] args) {
        SpringApplication.run(OnlineApp.class,args);
    }
}
