package cn.fuhe.mall.member.mapper;

import cn.fuhe.mall.member.entity.FhMember;
import cn.fuhe.mall.member.entity.FhMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FhMemberMapper {
    long countByExample(FhMemberExample example);

    int deleteByExample(FhMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FhMember record);

    int insertSelective(FhMember record);

    List<FhMember> selectByExample(FhMemberExample example);

    FhMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FhMember record, @Param("example") FhMemberExample example);

    int updateByExample(@Param("record") FhMember record, @Param("example") FhMemberExample example);

    int updateByPrimaryKeySelective(FhMember record);

    int updateByPrimaryKey(FhMember record);
}