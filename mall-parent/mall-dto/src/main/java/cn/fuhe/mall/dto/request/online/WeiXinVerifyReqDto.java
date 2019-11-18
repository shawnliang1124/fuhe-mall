package cn.fuhe.mall.dto.request.online;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:26
 * @contact 269882341@qq.com
 * @description     微信验证码校验dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeiXinVerifyReqDto implements Serializable {
    @NotBlank(message = "手机号不可为空")
    private String phone;

    @NotBlank(message = "校验码不可为空")
    private String code;
}
