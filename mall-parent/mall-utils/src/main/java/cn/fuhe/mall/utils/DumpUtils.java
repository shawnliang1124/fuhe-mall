package cn.fuhe.mall.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/5 11:42
 * @contact 269882341@qq.com
 * @description 异常日志打印类
 */
@Slf4j
public class DumpUtils {

    public static void printErrorLogs(Throwable ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        //将异常日志输出到PrintWriter对象中
        ex.printStackTrace(pw);
        StringBuffer buffer = sw.getBuffer();
        log.error(buffer.toString());
    }
}
