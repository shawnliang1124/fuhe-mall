package cn.fuhe.mall.interceptors;

import cn.fuhe.mall.encrypt.IEncryptDecrypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 17:28
 * @contact 269882341@qq.com
 * @description 将数据库敏感字段解密
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args={Statement.class})
})
@Component
@Slf4j
public class DecryptInterceptor implements Interceptor {
    @Autowired
    private IEncryptDecrypt encryptDecrypt;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        if(Objects.isNull(proceed)){
            return null;
        }
        if(proceed instanceof ArrayList){
            ArrayList result = (ArrayList) proceed;
            if(!CollectionUtils.isEmpty(result) ){
                for (int i = 0; i < result.size(); i++) {
                    decryptResult(result.get(i));
                }

            }else{
                decryptResult(result);
            }
        }
        return proceed;
    }

    /**
     * 将结果进行解密
     * @param result
     */
    private void decryptResult(Object result) throws IllegalAccessException {
      encryptDecrypt.decrypt(result);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
