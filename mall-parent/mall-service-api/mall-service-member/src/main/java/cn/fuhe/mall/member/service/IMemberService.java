package cn.fuhe.mall.member.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述: MemberServce接口
 *
 * @author Shawn Liang
 * @create 2019-09-07 15:53
 * @package cn.fuhe.mall.member.service
 * @contact https://github.com/shawnliang1124
 */
public interface IMemberService {
    @GetMapping("/testMember")
    String getMember(String member);
}
