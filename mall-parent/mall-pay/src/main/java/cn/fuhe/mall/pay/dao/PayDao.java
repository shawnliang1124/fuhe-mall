package cn.fuhe.mall.pay.dao;

import cn.fuhe.mall.pay.entity.FhPay;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 23:51
 * @contact 269882341@qq.com
 * @description
 */
public interface PayDao {
    /**
     * 根据支付交易的实体新增或者更新，id为空则新增，不为空为更新
     * @param fhPay
     * @return
     */
    int addOrUpdatePay(FhPay fhPay);
}
