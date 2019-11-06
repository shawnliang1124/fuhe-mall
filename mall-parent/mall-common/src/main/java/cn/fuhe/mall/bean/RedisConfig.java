package cn.fuhe.mall.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author shawnLiang
 * @github https://github.com/shawnliang1124
 * @date 2019/11/6 20:45
 * @contact 269882341@qq.com
 * @description 重写redis的配置
 */
@Component
public class RedisConfig {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }


    /**
     * 使用自定义的fastjson序列化方式设置redis的序列化方式
     * @param redisConnectionFactory
     * @param fastJson2JsonRedisSerializer
     * @return
     * @throws Exception
     */
    @Bean
    public RedisTemplate initRedisTemplate(RedisConnectionFactory redisConnectionFactory, RedisSerializer fastJson2JsonRedisSerializer) throws Exception {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
