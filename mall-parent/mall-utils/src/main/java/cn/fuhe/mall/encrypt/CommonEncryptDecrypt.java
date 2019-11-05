package cn.fuhe.mall.encrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 16:46
 * @contact 269882341@qq.com
 * @description 公共的加密解密方法
 */
@Component
public class CommonEncryptDecrypt implements IEncryptDecrypt {
    @Autowired
    private EncryptUtils encryptUtils;

    @Override
    public <T> T encrypt(Field declaredField, T parameterObject) throws IllegalAccessException {
        return encryptUtils.encrypt(declaredField,parameterObject);
    }

    @Override
    public <T> T decrypt(T parameterObject) throws IllegalAccessException {
        return encryptUtils.decrypt(parameterObject);
    }
}
