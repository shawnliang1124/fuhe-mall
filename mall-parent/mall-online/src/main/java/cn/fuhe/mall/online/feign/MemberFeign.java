package cn.fuhe.mall.online.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:23
 * @contact 269882341@qq.com
 */
@FeignClient(name="MALL-MEMBER")
public interface MemberFeign {
    @GetMapping("/test")
     String getTest();
}
