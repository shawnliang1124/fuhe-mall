package cn.fuhe.mall.weixin.impl;

import cn.fuhe.mall.weixin.service.IWeixinService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 微信逻辑实现层
 *
 * @author Shawn Liang
 * @create 2019-09-07 23:24
 * @package cn.fuhe.mall.weixin.impl
 * @contact https://github.com/shawnliang1124
 */
@RestController
public class WeixinServiceImpl implements IWeixinService{

    @Override
    public String getWeixin(String wx) {
        wx = "weixin";
        return wx;
    }
}
