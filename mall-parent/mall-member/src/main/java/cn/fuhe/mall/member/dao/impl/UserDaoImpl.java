package cn.fuhe.mall.member.dao.impl;

import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.exception.BizException;
import cn.fuhe.mall.member.dao.UserDao;
import cn.fuhe.mall.member.entity.FhMember;
import cn.fuhe.mall.member.entity.FhMemberExample;
import cn.fuhe.mall.member.mapper.FhMemberMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:00
 * @contact 269882341@qq.com
 * @description
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private FhMemberMapper fhMemberMapper;


    @Override
    public FhMember queryMemberByPhone(String phone) {
        if(StringUtils.isEmpty(phone)){
            throw new BizException(RespEnum.RESP_ERROR);
        }
        FhMemberExample example = new FhMemberExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<FhMember> fhMembers = fhMemberMapper.selectByExample(example);
        return CollectionUtils.isEmpty(fhMembers)?null:fhMembers.get(0) ;
    }

    @Override
    public int insertMemberRecord(FhMember fhMember) {
        if(fhMember == null){
            throw new BizException(RespEnum.RESP_ERROR);
        }
        int result = fhMemberMapper.insertSelective(fhMember);
        return result;
    }
}
