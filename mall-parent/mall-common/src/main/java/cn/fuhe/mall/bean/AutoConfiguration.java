//package cn.fuhe.mall.bean;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * 描述:
// * 需要注入spring容器的bean
// *
// * @author Shawn Liang
// * @create 2019-09-10 21:36
// * @package cn.fuhe.mall.bean
// * @contact https://github.com/shawnliang1124
// */
//@Configuration
//public class AutoConfiguration {
//    /**
//     * 将HikariCP整合至spring当中
//     * @return
//     */
//    @Bean
//    @ConditionalOnMissingBean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//}
