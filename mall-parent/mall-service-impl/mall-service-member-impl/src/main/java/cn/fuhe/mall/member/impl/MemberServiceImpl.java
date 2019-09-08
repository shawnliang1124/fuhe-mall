package cn.fuhe.mall.member.impl;

import cn.fuhe.mall.member.feign.WeixinFeign;
import cn.fuhe.mall.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 会员服务逻辑实现层
 *
 * @author Shawn Liang
 * @create 2019-09-07 16:00
 * @package cn.fuhe.mall.member.impl
 * @contact https://github.com/shawnliang1124
 */
@RestController
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private WeixinFeign weixinFeign;
    @Override
    public String getMember(String member) {
        String weixin = weixinFeign.getWeixin(member);
        member = "getMember"+weixin;
        return member;
    }
}
