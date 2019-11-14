package cn.fuhe.mall.utils;

import cn.fuhe.mall.constants.UtilsConstants;
import cn.fuhe.mall.bean.singleton.EncryptorSingleton;
import com.google.common.collect.Maps;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Map;

/**
 * 描述:
 * 关键配置脱敏
 *
 * @author Shawn Liang
 * @create 2019-09-10 7:38
 * @package cn.fuhe.mall.utils
 * @contact https://github.com/shawnliang1124
 */
public class JasterUtils {


    public static Map<String,Object> getJasterMap(Map<String,Object> data){
        Map<String, Object> map = Maps.newHashMap();
        data.forEach((k,v) ->{
            StandardPBEStringEncryptor encryptor = EncryptorSingleton.getINSTANCE();
            String encrypt = encryptor.encrypt((String) v);
            map.put(k,encrypt);
        });
        return map;
    }


    public static void main(String[] args) {
        StandardPBEStringEncryptor standardPBEStringEncryptor =EncryptorSingleton.getINSTANCE();
        /*配置文件中配置如下的算法*/
        standardPBEStringEncryptor.setAlgorithm(UtilsConstants.ALGORITHM);
        /*配置文件中配置的password*/
        standardPBEStringEncryptor.setPassword(UtilsConstants.PASSWORD);
        String name = standardPBEStringEncryptor.encrypt("root");
        String password =standardPBEStringEncryptor.encrypt("ljj19951124");
        System.out.println("name="+name);
        System.out.println("pwd="+password);


    }
}
