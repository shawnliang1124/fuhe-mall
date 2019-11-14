package cn.fuhe.mall.online.controller;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import cn.fuhe.mall.online.service.WeiXinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:31
 * @contact 269882341@qq.com
 */
@RestController
@Slf4j
public class WeixinController {


    @Autowired
    private WeiXinService weiXinService;



    @PostMapping("verifyCode")
    public BaseResponse<WeiXinVerifyRespDto> verifyCode(@RequestBody @Validated WeiXinVerifyReqDto weiXinVerifyReqDto){
        return weiXinService.verifyCode(weiXinVerifyReqDto);
    }
}
