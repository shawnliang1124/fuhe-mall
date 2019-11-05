package cn.fuhe.mall.bean;

import cn.fuhe.mall.interceptors.DecryptInterceptor;
import cn.fuhe.mall.interceptors.EncryptInterceptor;
import com.google.common.collect.Lists;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 15:15
 * @contact 269882341@qq.com
 * @description 需要注入Spring容器的类
 */
@Configuration
public class AutoConfiguration {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private EncryptInterceptor encryptInterceptor;

    @Autowired
    private DecryptInterceptor decryptInterceptor;

    /**
     * 重写mybatis的sqlSessionFactory。加上自定义的拦截器
     * @return
     * @throws Exception
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        List<Interceptor> interceptors = Lists.newArrayList();
        interceptors.add(encryptInterceptor);
        interceptors.add(decryptInterceptor);
        factoryBean.setPlugins(interceptors.toArray(new Interceptor[interceptors.size()]));
        return factoryBean.getObject();
    }
}
