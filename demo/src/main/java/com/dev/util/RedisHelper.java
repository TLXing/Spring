package com.dev.util;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class RedisHelper {

    @Resource
    RedisTemplate<String,String> redis;

    static RedisTemplate<String,String> redisTemplate;

    @PostConstruct
    public void init(){
        redisTemplate = redis;
    }
    /**
     * String
     */
    /**
     *
     * @param key
     * @param value
     */
    public static void setString(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     *
     * @param key
     * @param value
     * @param timeout
     */
    public static void setString(String key, String value, Duration timeout){
        redisTemplate.opsForValue().set(key,value,timeout);
    }

    public static void setString(String key,Object o){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(o));
    }
    public static void setString(String key,Object o,Duration timeout){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(o),timeout);
    }

    public static String getString(String key){
       return redisTemplate.opsForValue().get(key);
    }

    public static <T> T getObject(String key,Class<T> clazz){

        String str = redisTemplate.opsForValue().get(key);

        T t = null;

        if(!str.isEmpty())
            t = JSON.parseObject(str.toString(),clazz);

        return t;
    }


    /**
     * Hash
     */

    /**
     * List
     */

    /**
     * Set
     */

    /**
     * Sorted Set
     */


    public static long getExpire(String key){
        return redisTemplate.getExpire(key);
    }
    public static long getExpire(String key,TimeUnit unit){
        return redisTemplate.getExpire(key,unit);
    }

    public static Boolean expire(String key,long timeout, TimeUnit unit){
        return redisTemplate.expire(key,timeout, unit);
    }

    public static Boolean expire(String key, Date date){
        return redisTemplate.expireAt(key,date);
    }


}
