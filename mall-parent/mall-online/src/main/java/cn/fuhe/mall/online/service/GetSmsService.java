package cn.fuhe.mall.online.service;

import cn.fuhe.mall.base.BaseResponse;
import cn.fuhe.mall.base.BaseServiceApi;
import cn.fuhe.mall.base.Constants;
import cn.fuhe.mall.dto.request.GetSmsReqDto;
import cn.fuhe.mall.dto.response.GetSmsRespDto;
import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.exception.BizException;
import cn.fuhe.mall.utils.DumpUtils;
import cn.fuhe.mall.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 20:21
 * @contact 269882341@qq.com
 * @description 对接第三方短信服务
 */
@Service
@Slf4j
public class GetSmsService extends BaseServiceApi<GetSmsRespDto> {
    @Autowired
    private RedisUtils redisUtils;

    private static RequestConfig config;


    static {

        config = RequestConfig.custom().setSocketTimeout(10000).build();
    }

    /**
     * 短信URL
     */
    @Value("${sms.api:http://106.ihuyi.com/webservice/sms.php?method=Submit}")
    private String smsApi;

    @Value("${sms.apiId:C11907688}")
    private String appId;

    @Value("${sms.apiKey:b4a949dcac36ef5fabba32490cc85510}")
    private String appKey;


    /**
     * 通过手机号获取短信验证码
     *
     * @param getSmsReqDto
     * @return
     */
    public BaseResponse<GetSmsRespDto> getSmsCode(GetSmsReqDto getSmsReqDto) {

        String smsCode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String mobile = getSmsReqDto.getMobile();
       // sendSms(mobile, smsCode);
        String key = Constants.SMS_PREFIX + mobile;
        String result = redisUtils.getString(key);
        if (!StringUtils.isEmpty(result)) {
            log.info("短信验证码仍在有效期内。。电话是：{}", mobile);
            return setResult(RespEnum.GET_SMS_FAIL);
        }
        redisUtils.setString(key, smsCode, Constants.EXPIRED_TIME);
        GetSmsRespDto smsRespDto = new GetSmsRespDto();
        smsRespDto.setSmsCode(smsCode);
        return setResult(smsRespDto, RespEnum.GET_SMS_SUCCESS);
    }

    /**
     * 调用第三方服务发送短信
     *
     * @param mobile
     * @param smsCode
     */
    private void sendSms(String mobile, String smsCode) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(smsApi);
        httpPost.setConfig(config);
        String template = MessageFormat.format(Constants.SMS_TEMPLATE, smsCode);
        List<NameValuePair> params = formatParams(mobile, template);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, Constants.CHARSET));
            httpPost.setHeader("ContentType", Constants.CONTENT_TYPE);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            Document doc = DocumentHelper.parseText(result);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if (!StringUtils.equals(Constants.SMS_SUCCESS, code)) {
                log.info("短信平台返回信息是：{}",msg);
                throw new BizException(RespEnum.SEND_SMS_FAIL);
            }
        } catch (Exception e) {
            log.error("发送短信异常:{}", e.getMessage());
            DumpUtils.printErrorLogs(e);
            throw new BizException(RespEnum.SEND_SMS_FAIL);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                DumpUtils.printErrorLogs(e);
                throw new BizException(RespEnum.SEND_SMS_FAIL);
            }
        }
    }

    private List<NameValuePair> formatParams(String mobile, String template) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("account", appId));
        params.add(new BasicNameValuePair("password", appKey));
        params.add(new BasicNameValuePair("mobile", String.valueOf(mobile)));
        params.add(new BasicNameValuePair("content", template));
        return params;
    }
}
