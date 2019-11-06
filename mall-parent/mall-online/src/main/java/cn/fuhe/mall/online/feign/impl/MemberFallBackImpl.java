package cn.fuhe.mall.online.feign.impl;

import cn.fuhe.mall.base.Constants;
import cn.fuhe.mall.online.feign.MemberFeign;
import org.springframework.stereotype.Component;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:27
 * @contact 269882341@qq.com
 */
@Component
public class MemberFallBackImpl implements MemberFeign {
    @Override
    public String getTest() {
        return Constants.BUSY_CODE;
    }
}
