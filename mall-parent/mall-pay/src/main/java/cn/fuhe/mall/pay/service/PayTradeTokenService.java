package cn.fuhe.mall.pay.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.base.Constants;
import cn.fuhe.mall.dto.request.pay.PayTradeTokenReqDto;
import cn.fuhe.mall.dto.response.pay.PayTradeTokenRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.pay.dao.PayDao;
import cn.fuhe.mall.pay.entity.FhPay;
import cn.fuhe.mall.twitter.SnowflakeIdUtils;
import cn.fuhe.mall.utils.RedisUtils;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 23:39
 * @contact 269882341@qq.com
 * @description
 */
@Service
@Slf4j
public class PayTradeTokenService extends BaseServiceApi<PayTradeTokenRespDto> {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private PayDao payDao;

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse createPayTradeToken(PayTradeTokenReqDto payTradeTokenReqDto){
        FhPay fhPay =  formatPay(payTradeTokenReqDto);
        int result = payDao.addOrUpdatePay(fhPay);
        if(result < 0){
            return setResult(RespEnum.CREATE_PAY_TOKEN_FAIL);
        }
        String token = Constants.PAY_KEY_PREFIX + RandomUtil.randomStringUpper(Constants.PAY_KEY_LENGTH);
        //10分钟有效期
        redisUtils.getStringRedisTemplate().opsForValue().set(token,fhPay.getPayId()+"",Constants.PAY_KEY_EXPIRED , TimeUnit.MINUTES);
        return setResult(new PayTradeTokenRespDto(token),RespEnum.CREATE_PAY_TOKEN_SUCCESS);
    }

        private FhPay formatPay(PayTradeTokenReqDto payTradeTokenReqDto) {
            FhPay fhPay = new FhPay();
            Date now = new Date();
            fhPay.setCreatedTime(now);
            fhPay.setUpdatedTime(now);
            fhPay.setUserId(payTradeTokenReqDto.getUserId());
            fhPay.setOrderId(payTradeTokenReqDto.getOrderId());
            fhPay.setPayAmount(payTradeTokenReqDto.getOrderAmount());
            fhPay.setPayId(SnowflakeIdUtils.nextId());
            return fhPay;
        }
}
