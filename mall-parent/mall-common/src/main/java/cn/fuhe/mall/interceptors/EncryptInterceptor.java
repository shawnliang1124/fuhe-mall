package cn.fuhe.mall.interceptors;

import cn.fuhe.mall.encrypt.IEncryptDecrypt;
import cn.fuhe.mall.annoation.Crypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Properties;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 15:05
 * @contact 269882341@qq.com
 * @description mybatis拦截器，实现对数据库数据的脱敏
 * ConditionalOnProperty注解的作用是表示在配置文件中配置为true才会加载这个类
 */
@Component
@Intercepts({
         @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class)

})
@Slf4j
public class EncryptInterceptor implements Interceptor {

    @Autowired
    private IEncryptDecrypt encryptDecrypt;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("拦截器CryptInterceptor开始工作-->");
        if(invocation.getTarget() instanceof ParameterHandler){
            ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
            PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];
            // 反射获取 参数对像
            Field parameterField =
                    parameterHandler.getClass().getDeclaredField("parameterObject");
            parameterField.setAccessible(true);
            Object parameterObject = parameterField.get(parameterHandler);
            Class<?> parameterObjectClass  = parameterObject.getClass();
            Field[] declaredFields = parameterObjectClass.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Crypt crypt = AnnotationUtils.findAnnotation(declaredFields[i], Crypt.class);
                if(Objects.nonNull(crypt)){
                    final Object encrypt = encryptDecrypt.encrypt(declaredFields[i], parameterObject);
                }
            }

        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
