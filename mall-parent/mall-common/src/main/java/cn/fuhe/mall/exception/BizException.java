package cn.fuhe.mall.exception;

import cn.fuhe.mall.enums.RespEnum;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:05
 * @contact 269882341@qq.com
 * @description 自定义异常
 */
public class BizException extends RuntimeException {
    private String code;
    private String msg;

    public BizException(){

    }

    public BizException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public BizException(RespEnum respEnum){
        this.code = respEnum.getCode();
        this.msg = respEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
