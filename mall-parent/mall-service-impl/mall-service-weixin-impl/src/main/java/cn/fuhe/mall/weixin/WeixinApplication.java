package cn.fuhe.mall.weixin;

import cn.fuhe.mall.log.PrintLogger;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

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
@EnableApolloConfig
@MapperScan("cn.fuhe.mall.weixin.dao")
//apollo动态调整日志级别，需要的可以直接打开注释
//@Import(PrintLogger.class)
public class WeixinApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class,args);
    }
}
