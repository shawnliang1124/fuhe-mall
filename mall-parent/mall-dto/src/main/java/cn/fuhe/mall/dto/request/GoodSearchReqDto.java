package cn.fuhe.mall.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/10 14:10
 * @contact 269882341@qq.com
 * @description  商品搜索dto
 */
@Data
public class GoodSearchReqDto implements Serializable {

    /**
     * 页码数  从1开始
     */
    private Integer page;

    /**
     * 页大小
     */
    private Integer size;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 排序方式
     */
    private String type;


}
