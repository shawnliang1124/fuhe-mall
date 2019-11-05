package cn.fuhe.mall.member.feign;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import cn.fuhe.mall.member.feign.impl.WeiXinFeignFallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:24
 * @contact 269882341@qq.com
 * @description
 */
@FeignClient(value = "mall-weixin" , fallback = WeiXinFeignFallBackImpl.class)
public interface WeiXinFeign {
    /**
     * 调用微信服务，校验手机号和验证码是否正确
     * @param weiXinVerifyReqDto
     * @return
     */
    @PostMapping("/verifyCode")
    BaseResponse<WeiXinVerifyRespDto> verifyRegCode(@RequestBody WeiXinVerifyReqDto weiXinVerifyReqDto);
}
