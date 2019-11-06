package cn.fuhe.mall.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 21:12
 * @contact 269882341@qq.com
 * @description 校验短信验证码实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifySmsReqDto implements Serializable {
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不为空")
    @Pattern(regexp = "^[1][3578][0-9]{9}$",message = "手机号格式不匹配")
    private String mobile;

    /**
     * 短信验证码
     */
    @NotBlank(message = "短信验证码不为空")
    @Length(min = 6 ,max = 6 , message = "短信验证码格式错误")
    private String smsCode;
}
