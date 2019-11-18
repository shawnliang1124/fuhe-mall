package cn.fuhe.mall.pay.dao.impl;

import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.exception.BizException;
import cn.fuhe.mall.pay.dao.PayDao;
import cn.fuhe.mall.pay.entity.FhPay;
import cn.fuhe.mall.pay.mapper.FhPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 23:53
 * @contact 269882341@qq.com
 * @description
 */
@Repository
public class PayDaoImpl implements PayDao {
    @Autowired
    private FhPayMapper fhPayMapper;

    @Override
    public int addOrUpdatePay(FhPay fhPay) {
        Integer id = Optional.ofNullable(fhPay).orElseThrow(() -> new BizException(RespEnum.DATABASE_ERROR)).getId();
        if(id == null){
           return fhPayMapper.updateByPrimaryKeySelective(fhPay);
        }
        return fhPayMapper.insertSelective(fhPay);
    }
}
