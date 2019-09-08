package cn.fuhe.mall.member.feign;

import cn.fuhe.mall.weixin.service.IWeixinService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 描述:
 * 微信feign客户端调用
 *
 * @author Shawn Liang
 * @create 2019-09-07 23:34
 * @package cn.fuhe.mall.member.feign
 * @contact https://github.com/shawnliang1124
 */
@FeignClient(name = "mall-weixin" )
public interface WeixinFeign extends IWeixinService {
}
