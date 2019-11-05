package cn.fuhe.mall.member.feign.impl;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.member.feign.WeiXinFeign;
import org.springframework.stereotype.Component;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:35
 * @contact 269882341@qq.com
 * @description
 */
@Component
public class WeiXinFeignFallBackImpl implements WeiXinFeign {
    @Override
    public BaseResponse<WeiXinVerifyRespDto> verifyRegCode(WeiXinVerifyReqDto weiXinVerifyReqDto) {
        BaseResponse<WeiXinVerifyRespDto> serviceApi = new BaseResponse<>();
        serviceApi.setCode(RespEnum.RESP_ERROR.getCode());
        serviceApi.setMsg(RespEnum.RESP_ERROR.getMsg());
        return serviceApi;
    }
}
