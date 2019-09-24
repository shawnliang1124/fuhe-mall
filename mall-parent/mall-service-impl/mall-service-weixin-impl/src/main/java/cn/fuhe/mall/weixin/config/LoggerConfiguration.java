package cn.fuhe.mall.weixin.config;

import cn.fuhe.mall.weixin.constants.WeixinConstants;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 描述:
 * apollo动态日志级别配置
 *
 * @author Shawn Liang
 * @create 2019-09-09 23:49
 * @package cn.fuhe.mall.member.config
 * @contact https://github.com/shawnliang1124
 */
@Component
@Slf4j
public class LoggerConfiguration implements InitializingBean {
    @Autowired
    private LoggingSystem loggingSystem;

    @ApolloConfig
    private Config config;


    @Override
    public void afterPropertiesSet() throws Exception {
        refreshLoggingLevels();
    }

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent){
        refreshLoggingLevels();
    }

    private void refreshLoggingLevels() {
        Set<String> names = config.getPropertyNames();
        names.forEach(key ->{
            if(containsIgnoreCase(key, WeixinConstants.LOGGER_TAG)){
                String strLevel = config.getProperty(key, "info");
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                loggingSystem.setLogLevel(key.replace(WeixinConstants.LOGGER_TAG, ""), level);
                log.info("{}:{}", key, strLevel);
            }
        });
    }

    /**
     * 将键转换成小写后判断是否存在
     * @param str
     * @param searchStr
     * @return
     */
    private static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        int len = searchStr.length();
        int max = str.length() - len;
        for (int i = 0; i <= max; i++) {
            if (str.regionMatches(true, i, searchStr, 0, len)) {
                return true;
            }
        }
        return false;
    }


}
