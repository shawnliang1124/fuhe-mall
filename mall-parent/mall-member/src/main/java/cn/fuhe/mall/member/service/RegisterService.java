package cn.fuhe.mall.member.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.dto.request.RegisterReqDto;
import cn.fuhe.mall.dto.request.WeiXinVerifyReqDto;
import cn.fuhe.mall.dto.response.RegisterRespDto;
import cn.fuhe.mall.dto.response.WeiXinVerifyRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.member.dao.UserDao;
import cn.fuhe.mall.member.entity.FhMember;
import cn.fuhe.mall.member.feign.WeiXinFeign;
import cn.fuhe.mall.utils.ConvertBeanUtils;
import cn.fuhe.mall.utils.SafetyUtils;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 19:00
 * @contact 269882341@qq.com
 * @description 注册逻辑层
 */
@Service
@Slf4j
public class RegisterService extends BaseServiceApi<RegisterRespDto> {
    @Autowired
    private UserDao userDao;

    @Autowired
    private WeiXinFeign weixinFeign;

    @Transactional
    public BaseResponse register(RegisterReqDto reqDto){
        FhMember fhMember = userDao.queryMemberByPhone(reqDto.getPhone());
        if(fhMember != null){
            log.info(fhMember.toString());
           return setResult(RespEnum.USER_EXIST);
        }
        //校验验证码是否正确
        WeiXinVerifyReqDto weiXinVerifyReqDto = new WeiXinVerifyReqDto(reqDto.getPhone(), reqDto.getRegisterCode());
        BaseResponse<WeiXinVerifyRespDto> response = weixinFeign.verifyRegCode(weiXinVerifyReqDto);
        if(response.getStatus().equals(HttpStatus.INTERNAL_SERVER_ERROR.value())){
           return setResult(RespEnum.VERIFY_FAIL);
        }

        //校验通过的情况，使用sha256算法进行加密
        String oldPwd = reqDto.getPassword();
        String salt = UUID.randomUUID().toString();
        String newPwd = SafetyUtils.encryptPasswordSha256(oldPwd, salt);

        //往数据表插入数据
        FhMember doMember = formatFhMember(newPwd,reqDto,salt);
        int result = userDao.insertMemberRecord(doMember);
        return result > 0 ?setSuccess():setFail();
    }

    /**
     * 封装信息
     * @param newPwd
     * @param reqDto
     * @param salt
     * @return
     */
    private FhMember formatFhMember(String newPwd, RegisterReqDto reqDto,String salt) {
        FhMember doMember = ConvertBeanUtils.dtoToDo(reqDto, FhMember.class);
        doMember.setPassword(newPwd);
        Date date = new Date();
        doMember.setCreateTime(date);
        doMember.setUpdateTime(date);
        doMember.setSalt(salt);
        return doMember;
    }
}
