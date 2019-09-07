package cn.fuhe.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述:
 * Eureka服务端启动类
 *
 * @author Shawn Liang
 * @create 2019-09-07 15:24
 * @package cn.fuhe.mall
 * @contact https://github.com/shawnliang1124
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
