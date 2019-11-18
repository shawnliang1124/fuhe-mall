package cn.fuhe.mall.dto.request.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:47
 * @contact 269882341@qq.com
 * @description 注册请求类
 */
@Data
public class RegisterReqDto implements Serializable {
    @NotBlank(message = "手机号不为空")
    @Pattern(regexp = "^[1][3578][0-9]{9}$",message = "手机号格式不匹配")
    private String phone;

    @NotBlank(message = "姓名不为空")
    private String name;

    @NotBlank(message = "邮箱不为空")
    private String email;

    @NotBlank(message = "密码不为空")
    private String password;

    @NotBlank(message = "注册验证码不可为空")
    private String registerCode;
}
