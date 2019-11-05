package cn.fuhe.mall.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 16:03
 * @contact 269882341@qq.com
 * @description 用于mybatis的加密解密配置
 */
@Configuration
@ConfigurationProperties(prefix = "crypt",ignoreInvalidFields = false)
@PropertySource("classpath:crypt.properties")
@Data
@Component
public class CryptProperty {
}
