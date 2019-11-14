package cn.fuhe.mall.dto.response;

import lombok.Data;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 20:25
 * @contact 269882341@qq.com
 * @description 获取短信验证码响应dto
 */
@Data
public class GetSmsRespDto  {
    /**
     * 短信验证码
     */
    private String smsCode;
}
