package cn.fuhe.mall.base;

import cn.fuhe.mall.enums.RespEnum;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author Shawn Liang
 * @create 2019-09-08 10:19
 * @package cn.fuhe.mall.base
 * @contact https://github.com/shawnliang1124
 */
@Component
public class BaseServiceApi<T> {

    public BaseResponse setSuccess(){
        return setResult(RespEnum.RESP_SUCCESS);
    }

    public BaseResponse setFail(){
        return setResult(RespEnum.RESP_ERROR);
    }

    public BaseResponse setResult(RespEnum respEnum){
        return new BaseResponse(respEnum.getCode(),respEnum.getMsg(),respEnum.getStatus());
    }

    public BaseResponse<T> setResult(T t,RespEnum respEnum){
        BaseResponse baseResponse = this.setResult(respEnum);
        baseResponse.setData(t);
        return baseResponse;
    }
}
