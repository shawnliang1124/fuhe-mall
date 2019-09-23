package cn.fuhe.mall.weixin.service;

import cn.fuhe.mall.weixin.dao.WxUserDao;
import cn.fuhe.mall.weixin.entity.WxUser;
import cn.fuhe.mall.weixin.service.IWeixinService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private WxUserDao wxUserDao;
    @Override
    public String getWeixin(String wx) {
        wx = "weixin";
        return wx;
    }

    @Override
    public Map<String, Object> testMap() {
        Map<String, Object> data = Maps.newHashMap();
        List<WxUser> wxUsers = wxUserDao.selectList(null);
        wxUsers.forEach(user ->{
            data.put(user.getId()+"",user.toString());
        });
        return data;
    }


}
