package cn.fuhe.mall.member.dao;

import cn.fuhe.mall.member.entity.FhMember;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:43
 * @contact 269882341@qq.com
 * @description .
 */
public interface UserDao {
    /**
     * 根据用户手机号查询用户是否存在
     *
     * @param phone
     * @return
     */
    FhMember queryMemberByPhone(String phone);

    /**
     * 新增一个会员记录
     * @param fhMember
     * @return
     */
    int insertMemberRecord(FhMember fhMember);
}
