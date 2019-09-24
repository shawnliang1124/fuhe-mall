package cn.fuhe.mall.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 日志输出测试类
 *
 * @author Shawn Liang
 * @create 2019-09-09 23:55
 * @package cn.fuhe.mall.log
 * @contact https://github.com/shawnliang1124
 */
@Component
@Slf4j
public class PrintLogger implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        Executors.newSingleThreadExecutor().submit(() ->{
            while (true) {
                log.info("我是info级别日志");
                log.error("我是error级别日志");
                log.warn("我是warn级别日志");
                log.debug("我是debug级别日志");
                TimeUnit.SECONDS.sleep(1);
            }
        });
    }

}
