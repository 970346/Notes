package com.feng.redis.cache;

import com.feng.redis.utils.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

//自定义Redis缓存
public class RedisCache implements Cache {
    /**
     *  结果：id-----------------------------------------com.feng.redis.dao.UserDao
     *  结论：当前放入缓存的mapper的namespace
     */
    private final String id;
    //必须存在构造函数
    public RedisCache(String id) {
        System.out.println("id-----------------------------------------"+id);
        this.id = id;
    }
    //返回cache的唯一标识
    @Override
    public String getId() {
        return this.id;
    }
    //缓存中放入值
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("key:"+key.toString());
        System.out.println("value:"+value.toString());
        RedisTemplate redisTemplate = getredisTemplate();
//        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //使用redis中的hash类型作为缓存模型
        redisTemplate.opsForHash().put(id.toString(),md5key(key.toString()),value );
    }
    //缓存中获取值
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getredisTemplate();
//        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().get(id.toString(),md5key(key.toString()));
    }

    /**
     * 该方法为mybatis的保留方法，默认没有实现
     */
    @Override
    public Object removeObject(Object key) {
        return null;
    }

    /**
     * 清除缓存
     * 在增删改操作时需要清除缓存
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getredisTemplate();
//        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //清空缓存
        redisTemplate.delete(id.toString());
        System.out.println("清空缓存");
    }

    /**
     * 计算缓存数量
     */
    @Override
    public int getSize() {
        RedisTemplate redisTemplate = getredisTemplate();
//        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //获取hash中key-value数量
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    /**
     * 封装RedisTemplate
     */
    private RedisTemplate getredisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
    /**
     * 通过md5对key进行加密
     */
    public String md5key(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
