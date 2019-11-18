package cn.fuhe.mall.dto.response.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 23:48
 * @contact 269882341@qq.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayTradeTokenRespDto {

    /**
     * 加密后的token，防止前端参数篡改
     */
    private String token;


}
