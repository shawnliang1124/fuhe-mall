package cn.fuhe.mall.pay.controller;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.pay.PayTradeTokenReqDto;
import cn.fuhe.mall.pay.service.PayTradeTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/19 0:52
 * @contact 269882341@qq.com
 * @description
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayTradeTokenService payTradeTokenService;

    @PostMapping("/createToken")
    public BaseResponse createPayTradeToken(@RequestBody @Validated PayTradeTokenReqDto payTradeTokenReqDto, BindResult bindResult){
        return payTradeTokenService.createPayTradeToken(payTradeTokenReqDto);
    }
}
