package cn.fuhe.mall.encrypt;

import cn.fuhe.mall.annoation.Crypt;
import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 14:39
 * @contact 269882341@qq.com
 * @description 电话加密
 */
@Component
public class EncryptUtils {
    @Value("${mall.key:mallgoods}")
    private String key;
    /**
     * 字段加密
     * @param property
     * @return
     */
    public String encryptProperty(String property){
       return SecureUtil.des(key.getBytes()).encryptHex(property);
    }

    /**
     * 字段解密
     * @param data
     * @return
     */
    public String decryptProperty(String data){
        return SecureUtil.des(key.getBytes()).decryptStr(data);
    }

    /**
     * 对字段进行加密
     * @param declaredFields
     * @param parameterObject
     * @param <T>
     * @return
     */
    public <T> T encrypt(Field[] declaredFields, T parameterObject) throws IllegalAccessException {
        for(Field field:declaredFields){
            Crypt crypt = field.getAnnotation(Crypt.class);
            if(Objects.isNull(crypt)){
                continue;
            }
            //对单个字段进行加密
            encrypt(field,parameterObject);
        }
        return parameterObject;
    }


    /**
     * 对单个字段进行加密
     * @param field
     * @param parameterObject
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public <T> T encrypt(Field field, T parameterObject) throws IllegalAccessException {
        field.setAccessible(true);
        Object object = field.get(parameterObject);
        if(object instanceof String){
            String value = this.encryptProperty((String) object);
            field.set(parameterObject,value);
        }
        return parameterObject;
    }

    public <T> T decrypt(T result) throws IllegalAccessException {
        Class<?> resultClass = result.getClass();
        Field[] declaredFields = resultClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            Crypt crypt = AnnotationUtils.findAnnotation(declaredField, Crypt.class);
            if(Objects.isNull(crypt)){
                continue;
            }
            //对单个字段解密
            decrypt(declaredField,result);
        }
        return result;
    }

    private <T> void decrypt(Field declaredField, T result) throws IllegalAccessException {
        declaredField.setAccessible(true);
        Object  obj = declaredField.get(result);
        if(obj instanceof String){
            String decryptResult = this.decryptProperty((String) obj);
            declaredField.set(result,decryptResult);
        }
    }
}


