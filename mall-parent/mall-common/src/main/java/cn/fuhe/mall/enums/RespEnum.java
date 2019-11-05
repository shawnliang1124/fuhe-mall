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
    VERIFY_FAIL("10091","验证码校验失败",500),
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





    private RespEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    RespEnum(String code, String msg, Integer status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }
}
