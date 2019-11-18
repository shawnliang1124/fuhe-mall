package cn.fuhe.mall.pay.mapper;

import cn.fuhe.mall.pay.entity.FhPay;
import cn.fuhe.mall.pay.entity.FhPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FhPayMapper {
    long countByExample(FhPayExample example);

    int deleteByExample(FhPayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FhPay record);

    int insertSelective(FhPay record);

    List<FhPay> selectByExample(FhPayExample example);

    FhPay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FhPay record, @Param("example") FhPayExample example);

    int updateByExample(@Param("record") FhPay record, @Param("example") FhPayExample example);

    int updateByPrimaryKeySelective(FhPay record);

    int updateByPrimaryKey(FhPay record);
}