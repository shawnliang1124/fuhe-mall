package cn.fuhe.mall.dto.response;

import lombok.Data;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 21:16
 * @contact 269882341@qq.com
 * @description 短信校验响应
 */
@Data
public class VerifySmsRespDto {
    /**
     * 是否正确 1正确 0错误
     */
    private boolean isAuth;
}
