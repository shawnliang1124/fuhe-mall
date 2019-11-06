package cn.fuhe.mall.online.controller;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.GetSmsReqDto;
import cn.fuhe.mall.dto.request.VerifySmsReqDto;
import cn.fuhe.mall.dto.response.GetSmsRespDto;
import cn.fuhe.mall.dto.response.VerifySmsRespDto;
import cn.fuhe.mall.online.service.GetSmsService;
import cn.fuhe.mall.online.service.VerifySmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 20:33
 * @contact 269882341@qq.com
 * @description
 */
@RestController
@Slf4j
public class SmsController {
    @Autowired
    private GetSmsService getSmsCode;

    @Autowired
    private VerifySmsService verifySmsService;

    /**
     * 通过手机号获取短信验证码
     * @param getSmsReqDto
     * @return
     */
    @PostMapping("getSmsCode")
    public BaseResponse<GetSmsRespDto> getSmsCode(@RequestBody @Validated GetSmsReqDto getSmsReqDto){
        return getSmsCode.getSmsCode(getSmsReqDto);
    }

    @PostMapping("verifySmsCode")
    public BaseResponse<VerifySmsRespDto> verifySmsCode(@RequestBody @Validated VerifySmsReqDto verifySmsReqDto){
        return verifySmsService.verifySmsCode(verifySmsReqDto);
    }
}
