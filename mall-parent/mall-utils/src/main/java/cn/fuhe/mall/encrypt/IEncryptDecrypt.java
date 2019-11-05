package cn.fuhe.mall.encrypt;

import java.lang.reflect.Field;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 16:43
 * @contact 269882341@qq.com
 * @description    加密解密接口，考虑到之后可能有身份证加密，电话加密等等，增加其拓展性
 */
public interface IEncryptDecrypt {

    /**
     * 加密方法
     *
     * @param declaredFields  反射bean成员变量
     * @param parameterObject Mybatis入参
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public <T> T encrypt(Field declaredFields, T parameterObject) throws IllegalAccessException;

    /**
     * 解密方法
     * @param parameterObject
     * @param <T>
     * @return
     */
    public <T> T decrypt(T parameterObject) throws IllegalAccessException;
}
