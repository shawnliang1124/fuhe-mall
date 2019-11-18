package cn.fuhe.mall.pay.mapper;

import cn.fuhe.mall.pay.entity.FhPayLog;
import cn.fuhe.mall.pay.entity.FhPayLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FhPayLogMapper {
    long countByExample(FhPayLogExample example);

    int deleteByExample(FhPayLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FhPayLog record);

    int insertSelective(FhPayLog record);

    List<FhPayLog> selectByExample(FhPayLogExample example);

    FhPayLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FhPayLog record, @Param("example") FhPayLogExample example);

    int updateByExample(@Param("record") FhPayLog record, @Param("example") FhPayLogExample example);

    int updateByPrimaryKeySelective(FhPayLog record);

    int updateByPrimaryKey(FhPayLog record);
}