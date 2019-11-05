package cn.fuhe.mall.aop;

import cn.fuhe.mall.enums.RespEnum;
import cn.fuhe.mall.exception.BizException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 13:11
 * @contact 269882341@qq.com
 * @description AOP统一处理
 */
@Aspect
@Component
@Slf4j
public class GlobalAspect {

    /**
     * 拦截controller下的所有方法
     */
    @Around("execution(public * cn.fuhe.mall..*.*Controller.*(..))")
    public Object handlerValidated(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        //获得对应的目标方法
        Method method = methodSignature.getMethod();
        Parameter[] parameters = method.getParameters();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Map<String, Object> map = getNameAndValue(joinPoint,parameters);
        log.info("请求url为：{}，请求入参为：{}",request.getRequestURL(), JSON.toJSONString(map));
        //判断参数校验是否通过
        isParamsLegal(joinPoint);
        Object result = joinPoint.proceed();
        if(result == null){
            return "";
        }
        log.info("返回参数是：{}", JSON.toJSONString(result));
        return result;
    }

    private void isParamsLegal(ProceedingJoinPoint joinPoint) {
        Object[] paramValues = joinPoint.getArgs();
        for (int i = 0; i < paramValues.length; i++) {
            if(paramValues[i] instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) paramValues[i];
                FieldError fieldError = bindingResult.getFieldError();
                if(fieldError!=null){
                    String defaultMessage = fieldError.getDefaultMessage();
                    if(!StringUtils.isEmpty(defaultMessage)){
                        throw new BizException(RespEnum.RESP_ERROR.getCode(),defaultMessage);
                    }
                }
            }
        }


    }

    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return
     */
    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint, Parameter[] parameters) {
        Map<String, Object> param = new HashMap<>(8);

        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < parameters.length; i++) {
           if(parameters[i].isAnnotationPresent(RequestBody.class)){
               param.put(paramNames[i], paramValues[i]);
               break;
           }
        }
        return param;
    }



}
