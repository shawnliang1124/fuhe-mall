package cn.shawn.weixin.service;

import cn.shawn.weixin.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:30
 * @contact 269882341@qq.com
 */
@Service
public class WeixinTest {
    @Autowired
    private MemberFeign memberFeign;

    public String weixinTest(){
      return memberFeign.getTest();
    }

}
