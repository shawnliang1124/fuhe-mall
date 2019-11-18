package cn.fuhe.mall.goods.controller;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.dto.request.good.GoodSearchReqDto;
import cn.fuhe.mall.dto.response.good.GoodSearchRespDto;
import cn.fuhe.mall.goods.service.GoodSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/14 0:08
 * @contact 269882341@qq.com
 * @description
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodSearchService goodSearchService;

    @PostMapping("search")
    public BaseResponse<GoodSearchRespDto> queryGoodsByWords(@Validated @RequestBody GoodSearchReqDto goodSearchReqDto, BindingResult bindingResult){
        return goodSearchService.queryGoods(goodSearchReqDto);
    }
}
