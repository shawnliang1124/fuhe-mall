package cn.fuhe.mall.bean.singleton;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * 描述:
 * 敏感信息bean 工厂
 *
 * @author Shawn Liang
 * @create 2019-09-10 8:01
 * @package cn.fuhe.mall.bean.factory
 * @contact https://github.com/shawnliang1124
 */
public class EncryptorSingleton {
    private static volatile StandardPBEStringEncryptor INSTANCE ;

    private EncryptorSingleton(){}

    public static StandardPBEStringEncryptor getINSTANCE(){
        if(INSTANCE == null){
            synchronized (EncryptorSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = EncryptorHolder.ENCRYPTOR;
                }
            }
        }
        return INSTANCE;
    }

    public static class EncryptorHolder{
        private static final StandardPBEStringEncryptor ENCRYPTOR =
                new StandardPBEStringEncryptor();
    }
}
