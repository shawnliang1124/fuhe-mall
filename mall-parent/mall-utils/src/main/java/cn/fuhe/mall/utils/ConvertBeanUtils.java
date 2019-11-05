package cn.fuhe.mall.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 描述:
 * Do,Dto之间的转换
 *
 * @author Shawn Liang
 * @create 2019-06-16 12:59
 * @package cn.shawn.member.bean
 */
@Slf4j
public class ConvertBeanUtils<Dto,Do> {

    /**
     * dto转换成do
     * @param dto
     * @param doClass
     * @param <Do>
     * @return
     */
    public final static<Do> Do dtoToDo(Object dto,Class<Do> doClass){
        if(dto == null){
            return null;
        }
        if(doClass == null){
            return null;
        }
        try {
            Do newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dto,newInstance);
            return newInstance;
        }  catch (Exception e) {
            log.error("dto转换do异常",e);
            return null;
        }
    }

    /**
     * do转dto
     * @param doObj
     * @param dtoClass
     * @param <Dto>
     * @return
     */
    public final static<Dto> Dto doToDto(Object doObj,Class<Dto> dtoClass){
        if(doObj == null){
            return null;
        }
        if(dtoClass == null){
            return null;
        }
        try {
            Dto dto = dtoClass.newInstance();
            BeanUtils.copyProperties(doObj,dto);
            return dto;
        } catch (Exception e) {
            log.error("do转换dto异常",e);
            return null;
        }
    }


    /**
     * vo转dto
     * @param vo
     * @param dtoClass
     * @param <Dto>
     * @return
     */
    public final static<Dto> Dto voToDto(Object vo,Class<Dto> dtoClass){
        if(vo == null){
            return null;
        }
        if(dtoClass == null){
            return null;
        }
        try {
            Dto dto = dtoClass.newInstance();
            BeanUtils.copyProperties(vo,dto);
            return dto;
        } catch (Exception e) {
            log.error("vo",e);
            return null;
        }
    }
}
