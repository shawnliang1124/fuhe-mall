package cn.fuhe.mall.online.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:32
 * @contact 269882341@qq.com
 * @description
 */
@Service
@Slf4j
public class WeiXinService extends BaseServiceApi<WeiXinVerifyRespDto> {
    /**
     * 微信校验验证码是否正确
     * @param weiXinVerifyReqDto
     * @return
     */
    public BaseResponse<WeiXinVerifyRespDto> verifyCode(WeiXinVerifyReqDto weiXinVerifyReqDto){
        return setSuccess();
    }
}
