package cn.fuhe.mall.twitter;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/18 22:48
 * @contact 269882341@qq.com
 * @description  使用雪花算法生成全局id
 */
public class SnowflakeIdUtils {

    private static SnowflakeIdWorker idWorker;
    static {
        // 使用静态代码块初始化 SnowflakeIdWorker
        idWorker = new SnowflakeIdWorker(1, 1);
    }

    public static String nextStringId() {
        return nextId() + "";
    }

    public static long nextId() {
        return idWorker.nextId();
    }
}
