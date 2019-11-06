package cn.fuhe.mall.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 20:23
 * @contact 269882341@qq.com
 * @description 获得手机验证码dto
 */
@Data
public class GetSmsReqDto implements Serializable {
    @NotBlank(message = "手机号不为空")
    @Pattern(regexp = "^[1][3578][0-9]{9}$",message = "手机号格式不匹配")
    private String mobile;
}
