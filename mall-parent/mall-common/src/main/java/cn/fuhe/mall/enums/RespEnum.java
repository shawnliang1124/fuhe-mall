package cn.fuhe.mall.enums;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:07
 * @contact 269882341@qq.com
 * @description 统一返回码
 */
public enum  RespEnum {
    RESP_SUCCESS("0000","请求成功",200),
    RESP_ERROR("9999","请求异常",500),
    USER_EXIST("10090","用户已存在",500),

    GET_SMS_SUCCESS("10190","获取短信验证码成功",200),
    GET_SMS_FAIL("10191","短信验证码仍在有效期",500),
    SEND_SMS_FAIL("10192","三方短信验证码发送失败",500),
    VERIFY_SUCCESS("10200","验证码校验成功",200),
    VERIFY_FAIL("10291","验证码校验失败",500),
    VERIFY_DIFFERENT("10292","短信验证码不一致",500),

    QUERY_GOODS_SUCCESS("10300","查询商品成功",200)
    ;


    private String code;

    private String msg;

    private Integer status;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getStatus() {
        return status;
    }



    RespEnum(String code, String msg, Integer status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }
}
