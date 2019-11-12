package cn.fuhe.mall.goods.es.repostitry;

import cn.fuhe.mall.goods.es.model.GoodsEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/10 14:05
 * @contact 269882341@qq.com
 * @description ES的搜索相关
 */
@Repository
public interface GoodSpuRepository extends ElasticsearchRepository<GoodsEsEntity,Integer> {
}
