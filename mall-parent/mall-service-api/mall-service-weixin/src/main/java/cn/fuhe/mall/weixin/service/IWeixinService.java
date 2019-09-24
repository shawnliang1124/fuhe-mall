package cn.fuhe.mall.weixin.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 描述:
 * 微信服务层接口
 *
 * @author Shawn Liang
 * @create 2019-09-07 15:55
 * @package cn.fuhe.mall.weixin.service
 * @contact https://github.com/shawnliang1124
 */
public interface IWeixinService {
    @GetMapping("/wxTest")
    String getWeixin(@RequestParam("wx") String wx);

    @GetMapping("mapTest")
    Map<String,Object> testMap();
}
