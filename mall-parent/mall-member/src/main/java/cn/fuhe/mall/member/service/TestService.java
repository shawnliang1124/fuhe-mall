package cn.fuhe.mall.member.service;

import cn.fuhe.mall.member.entity.FhMember;
import cn.fuhe.mall.member.mapper.FhMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 17:58
 * @contact 269882341@qq.com
 */
@Service
public class TestService {
    @Autowired
    private FhMemberMapper fhMemberMapper;

    public FhMember test(){
        FhMember fhMember = fhMemberMapper.selectByPrimaryKey(1);
        return fhMember;
    }

}
