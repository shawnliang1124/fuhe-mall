package cn.fuhe.mall.base;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/4 18:28
 * @contact 269882341@qq.com
 * @description 常量
 */
public class Constants {
    public static final String BUSY_CODE = "服务降级，请稍后重试";

    public static final String CHARSET = "UTF-8";

    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";

    /**
     * 短信验证码的redis前缀
     */
    public static final String SMS_PREFIX = "SMS_";

    /**
     * 短信验证码有效期
     */
    public static final Long EXPIRED_TIME = 65L;

    /**
     * 短信验证码模板
     */
    public static final String SMS_TEMPLATE = "您的验证码是：{0}。请不要把验证码泄露给其他人。";

    /**
     * 第三方短信平台短信发送成功的响应码
     */
    public static final String SMS_SUCCESS = "2";

    /**
     * 起始页
     */
    public static final Integer BEGIN_PAGE = 1;

    /**
     * 默认的页大小
     */
    public static final Integer PAGE_SIZE = 10;

    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String DATE_TYPE_ONE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 支付项目pay的key长度
     */
    public static final int PAY_KEY_LENGTH = 12;

    /**
     * 前缀
     */
    public static final String PAY_KEY_PREFIX = "pay_";

    public static final long PAY_KEY_EXPIRED = 10L;
}
