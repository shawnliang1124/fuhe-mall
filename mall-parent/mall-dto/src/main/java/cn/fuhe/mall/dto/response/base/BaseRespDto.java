package cn.fuhe.mall.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:12
 * @contact 269882341@qq.com
 * @description  响应基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRespDto<T> implements Serializable {
    private String respCode;

    private String respMsg;

    private T t;




}
