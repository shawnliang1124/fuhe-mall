package cn.fuhe.mall.dto.response;

import lombok.Data;

import java.util.Date;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/13 23:57
 * @contact 269882341@qq.com
 * @description  商品响应实体dto
 */
@Data
public class GoodEntityRespDto {
    private Integer id;

    private String spuName;

    private String spuModel;

    private String description;

    private Date createTime;

    private Date updateTime;


}
