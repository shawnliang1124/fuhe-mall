package cn.fuhe.mall.constant;

import org.springframework.http.HttpStatus;

/**
 * 描述:
 * http状态码通用常量
 *
 * @author Shawn Liang
 * @create 2019-09-08 10:22
 * @package cn.fuhe.mall.constant
 * @contact https://github.com/shawnliang1124
 */
public enum HttpEnums {
    /**
     * 200状态码
     */
    OK(HttpStatus.OK.value(),"成功"),

    /**
     * 500状态码
     */
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务器内部错误"),

    /**
     * 404状态码
     */
    NOT_FOUND(HttpStatus.NOT_FOUND.value(),"404 Not Found");

    /**
     * http状态码
     */
    private int code;

    /**
     * 状态码的描述
     */
    private String desc;

    HttpEnums(int code,String desc){
        this.code = code;
        this.desc = desc;
    }



}
