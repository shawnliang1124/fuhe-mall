package cn.fuhe.mall.pay.mapper;

import cn.fuhe.mall.pay.entity.FhPayChannel;
import cn.fuhe.mall.pay.entity.FhPayChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FhPayChannelMapper {
    long countByExample(FhPayChannelExample example);

    int deleteByExample(FhPayChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FhPayChannel record);

    int insertSelective(FhPayChannel record);

    List<FhPayChannel> selectByExample(FhPayChannelExample example);

    FhPayChannel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FhPayChannel record, @Param("example") FhPayChannelExample example);

    int updateByExample(@Param("record") FhPayChannel record, @Param("example") FhPayChannelExample example);

    int updateByPrimaryKeySelective(FhPayChannel record);

    int updateByPrimaryKey(FhPayChannel record);
}