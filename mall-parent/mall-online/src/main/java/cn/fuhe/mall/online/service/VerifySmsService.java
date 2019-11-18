package cn.fuhe.mall.online.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.base.Constants;
import cn.fuhe.mall.dto.request.online.VerifySmsReqDto;
import cn.fuhe.mall.dto.response.online.VerifySmsRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 23:20
 * @contact 269882341@qq.com
 * @description  校验短信验证码逻辑层
 */
@Service
@Slf4j
public class VerifySmsService extends BaseServiceApi<VerifySmsRespDto> {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 校验短信验证码是否正确
     * @param verifySmsReqDto
     * @return
     */
    public BaseResponse<VerifySmsRespDto> verifySmsCode(VerifySmsReqDto verifySmsReqDto, BindingResult bindingResult) {
        VerifySmsRespDto respDto = new VerifySmsRespDto();
        respDto.setAuth(false);
        String value = redisUtils.getString(Constants.SMS_PREFIX + verifySmsReqDto.getMobile());
        if(StringUtils.isEmpty(value)){
            return setResult(respDto, RespEnum.VERIFY_FAIL);
        }
        if(!StringUtils.equals(value,verifySmsReqDto.getSmsCode())){
            return setResult(respDto, RespEnum.VERIFY_DIFFERENT);
        }
        //短信验证码一致
        respDto.setAuth(true);
        return setResult(respDto,RespEnum.VERIFY_SUCCESS);
    }
}
