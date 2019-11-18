package cn.fuhe.mall.dto.response.online;

import lombok.Data;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:27
 * @contact 269882341@qq.com
 * @description 微信验证码校验响应
 */
@Data
public class WeiXinVerifyRespDto {

    /**
     * 1 代表通过 0代表拒绝
     */
    private String flag;
}
