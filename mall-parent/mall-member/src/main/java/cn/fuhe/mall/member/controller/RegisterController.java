package cn.fuhe.mall.member.controller;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.RegisterReqDto;
import cn.fuhe.mall.dto.response.RegisterRespDto;
import cn.fuhe.mall.member.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:42
 * @contact 269882341@qq.com
 * @description 注册逻辑层
 */
@RestController
@Slf4j
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("register")
    public BaseResponse<RegisterRespDto> register(@RequestBody @Validated RegisterReqDto reqDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
        }
        return  registerService.register(reqDto);
    }

}
