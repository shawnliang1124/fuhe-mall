package cn.fuhe.mall.dto.request.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 23:43
 * @contact 269882341@qq.com
 * @description
 */
@Data
public class PayTradeTokenReqDto implements Serializable {
    /**
     * 订单系统传入的订单Id
     */
    private String orderId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 订单实付金额
     */
    private BigDecimal orderAmount;

}
