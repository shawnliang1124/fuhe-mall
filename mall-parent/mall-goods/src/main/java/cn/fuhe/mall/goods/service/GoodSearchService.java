package cn.fuhe.mall.goods.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.base.GoodConstants;
import cn.fuhe.mall.dto.request.GoodSearchReqDto;
import cn.fuhe.mall.dto.response.GoodEntityRespDto;
import cn.fuhe.mall.dto.response.GoodSearchRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.goods.es.model.GoodsEsEntity;
import cn.fuhe.mall.goods.es.repostitry.GoodSpuRepository;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/10 14:09
 * @contact 269882341@qq.com
 * @description 商品搜索服务
 */
@Service
public class GoodSearchService  extends BaseServiceApi<GoodSearchRespDto> {
    @Autowired
    private GoodSpuRepository spuRepository;


    /**
     * 根据前端传入的查询参数查询产品列表
     * @param goodSearchReqDto
     * @return
     */
    public BaseResponse<GoodSearchRespDto> queryGoods(GoodSearchReqDto goodSearchReqDto){
        if(goodSearchReqDto == null){
            //为空初始化一个默认的请求dto
            goodSearchReqDto = new GoodSearchReqDto();
        }
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if(!StringUtils.isEmpty(goodSearchReqDto.getKeyword())){
            //添加基本的分词条件
            queryBuilder.withQuery(QueryBuilders.matchQuery("spu_name",goodSearchReqDto.getKeyword()));
            queryBuilder.withQuery(QueryBuilders.matchQuery("description",goodSearchReqDto.getKeyword()));
        }
        //根据类型进行排序
        String type = goodSearchReqDto.getType();
        Integer sortType = goodSearchReqDto.getSortType();
        if(!StringUtils.isEmpty(type)&& sortType != null){
            //按时间排序
            if(StringUtils.equals(type, GoodConstants.TIME)){
                queryBuilder.withSort(SortBuilders.fieldSort("create_time").order(formatSortOrder(sortType)));
            }else{
                queryBuilder.withSort(SortBuilders.fieldSort("").order(formatSortOrder(sortType)));
            }
        }
        //jpa的分页从0开始
        PageRequest pageRequest = PageRequest.of(goodSearchReqDto.getPage() - 1, goodSearchReqDto.getSize());
        queryBuilder.withPageable(pageRequest);
        Page<GoodsEsEntity> pageResult = spuRepository.search(queryBuilder.build());
        return formatSearchResult(pageResult);
    }

    /**
     *
     * @param pageResult
     * @return
     */
    private BaseResponse<GoodSearchRespDto> formatSearchResult(Page<GoodsEsEntity> pageResult) {
        GoodSearchRespDto goodSearchRespDto = new GoodSearchRespDto();
        int totalPages = pageResult.getTotalPages();
        List<GoodsEsEntity> results = pageResult.getContent();
        List<GoodEntityRespDto> goodEntityRespDtos = Lists.newArrayList();
        results.forEach(result ->{
            GoodEntityRespDto goodEntityRespDto = new GoodEntityRespDto();
            goodEntityRespDto.setCreateTime(result.getCreate_time());
            goodEntityRespDto.setUpdateTime(result.getUpdate_time());
            goodEntityRespDto.setSpuModel(result.getSpu_model());
            goodEntityRespDto.setSpuName(result.getSpu_name());
            goodEntityRespDto.setId(result.getId());
            goodEntityRespDto.setDescription(result.getDescription());
            goodEntityRespDtos.add(goodEntityRespDto);
        });
        goodSearchRespDto.setCount(totalPages);
        goodSearchRespDto.setResults(goodEntityRespDtos);
        return setResult(goodSearchRespDto,RespEnum.QUERY_GOODS_SUCCESS);
    }

    /**
     * 返回排序类型
     * @param type
     * @return
     */
    private SortOrder formatSortOrder(Integer type){
            return type.equals(GoodConstants.DESC)? SortOrder.DESC:SortOrder.ASC;
    }
}
