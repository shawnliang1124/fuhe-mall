package cn.fuhe.mall.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/13 23:55
 * @contact 269882341@qq.com
 * @description  响应结果
 */
@Data
public class GoodSearchRespDto {
    /**
     * 总页数
     */
    private Integer count;

    private List<GoodEntityRespDto> results;
}
