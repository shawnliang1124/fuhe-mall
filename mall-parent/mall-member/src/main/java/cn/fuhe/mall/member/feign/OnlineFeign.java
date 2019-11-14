package cn.fuhe.mall.member.feign;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.VerifySmsReqDto;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.VerifySmsRespDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import cn.fuhe.mall.member.feign.impl.OnlineFeignFallBackImpl;
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
@FeignClient(value = "mall-online" , fallback = OnlineFeignFallBackImpl.class)
public interface OnlineFeign {
    /**
     * 调用online服务，校验手机号和验证码是否正确
     * @param weiXinVerifyReqDto
     * @return
     */
    @PostMapping("/verifyCode")
    BaseResponse<WeiXinVerifyRespDto> verifyRegCode(@RequestBody WeiXinVerifyReqDto weiXinVerifyReqDto);

    /**
     * 调用online服务，校验手机号和短信验证码是否正确
     * @param verifySmsReqDto
     * @return
     */
    @PostMapping("/verifySmsCode")
    BaseResponse<VerifySmsRespDto> verifySmsCode(@RequestBody VerifySmsReqDto verifySmsReqDto);
}
