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
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回的类型
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
