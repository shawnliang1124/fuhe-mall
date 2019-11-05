package cn.fuhe.mall.utils;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:48
 * @contact 269882341@qq.com
 * @description     安全相关的工具类
 */
@Slf4j
public class SafetyUtils {

    /**
     * 旧密码和随机盐值进行加密
     * @param oldPwd
     * @param salt
     * @return
     */
    public static String encryptPasswordSha256(String oldPwd , String salt){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(salt).append(oldPwd);
        String sha256 = DigestUtil.sha256Hex(stringBuffer.toString());
        return sha256;
    }
}
