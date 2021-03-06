package cn.fuhe.mall.goods.es.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/10 13:37
 * @contact 269882341@qq.com
 * @description  商品的ES实体类
 */

@Document(indexName = "goodspu", type = "goodspu", shards = 1, replicas = 0)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsEsEntity {

    private Integer id;

    private String spu_name;

    private String spu_model;

    private String description;

    private Date create_time;

    private Date update_time;


}
