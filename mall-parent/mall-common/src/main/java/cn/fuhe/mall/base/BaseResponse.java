package cn.fuhe.mall.base;

import lombok.Data;

/**
 * 描述:
 * 返回层的基类
 *
 * @author Shawn Liang
 * @create 2019-09-08 10:17
 * @package cn.fuhe.mall.base
 * @contact https://github.com/shawnliang1124
 */
@Data
public class BaseResponse<T> {
    /**
     * 返回码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回的类型
     */
    private T data;

    /**
     * 状态码
     */
    private Integer status;

    public BaseResponse() {

    }

    public BaseResponse(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }


    public BaseResponse(String code, String msg, Integer status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public BaseResponse(String code, String msg, T data, Integer status) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }
}
