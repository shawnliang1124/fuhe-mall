package cn.fuhe.mall.exception;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.utils.DumpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 11:35
 * @contact 269882341@qq.com
 * @description
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

    /**
     * 全局异常捕获
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public BaseResponse handlerException(Exception ex, HttpServletRequest request){
        log.error("请求地址是：{}，异常信息是：{}",request.getRequestURL().toString(),ex.getMessage());
        DumpUtils.printErrorLogs(ex);
        BaseResponse baseResponse = new BaseResponse(RespEnum.RESP_ERROR.getCode(), RespEnum.RESP_ERROR.getMsg(),
                RespEnum.RESP_ERROR.getStatus());
        baseResponse.setData("系统内部异常");
        return baseResponse;
    }


    /**
     * 业务异常捕获
     */
    @ExceptionHandler(value=BizException.class)
    @ResponseBody
    public BaseResponse handlerBizException(BizException ex, HttpServletRequest request){
        log.error("请求地址是：{}，异常信息是：{}",request.getRequestURL().toString(),ex.getMsg());
        DumpUtils.printErrorLogs(ex);
        BaseResponse baseResponse = new BaseResponse(ex.getCode(), ex.getMsg(),
                RespEnum.RESP_ERROR.getStatus());
        baseResponse.setData( ex.getMsg());
        return baseResponse;
}

}
