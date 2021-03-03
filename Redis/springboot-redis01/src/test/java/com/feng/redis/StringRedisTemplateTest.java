package com.feng.redis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest(classes = SpringbootRedis01Application.class)
@RunWith(SpringRunner.class)
class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 操作redis中的key
     */
    @Test
    public void testkey(){
//        //删除一个key
//        stringRedisTemplate.delete("name");
//        //判断某个key是否存在
//        Boolean key = stringRedisTemplate.hasKey("name");
//        System.out.println(key);
//        //判断key所对应值得类型
//        DataType name = stringRedisTemplate.type("name");
//        System.out.println(name);
//        //获取redis中所有的key
//        Set<String> keys = stringRedisTemplate.keys("*");
//        keys.forEach(Key -> System.out.println("key="+Key));
        /*
          获取key的超时时间
          返回值：
              -1：永不超时   -2：key不存在
         */
//        Long expire = stringRedisTemplate.getExpire("name");
//        System.out.println(expire);
//        //随机获取key
//        String randomKey = stringRedisTemplate.randomKey();
//        System.out.println(randomKey);
//        //修改key的名字，要求key必须存在，否则报错
//        stringRedisTemplate.rename("age","AGE");
//        //移动key
//        stringRedisTemplate.move("name",2);
    }
    /**
     * 操作redis中的字符串
     */
    @Test
    public void testString(){
//        //设置一个key-value
//        stringRedisTemplate.opsForValue().set("name","张三");
//        //获取一个key-value
//        String name = stringRedisTemplate.opsForValue().get("name");
//        System.out.println("name="+name);
//        //设置超时时间，第三个参数为时间，第四个参数为时间的单位
//        stringRedisTemplate.opsForValue().set("code","555",120, TimeUnit.SECONDS);
//        //追加内容
//        stringRedisTemplate.opsForValue().append("name","666");
//        String code = stringRedisTemplate.opsForValue().get("code");
//        System.out.println(code);

    }
    /**
     * 操作redis中的list类型
     */
    @Test
    public void testlist(){
//        //创建一个列表，并放入一个元素
        stringRedisTemplate.opsForList().leftPush("names","小陈");
//        //创建一个列表，并放入多个元素
//        stringRedisTemplate.opsForList().leftPushAll("books","c++","java","c");
//        //创建一个列表，并放入过个元素
//        ArrayList<String> list = new ArrayList<>();
//        list.add("111");
//        list.add("222");
//        stringRedisTemplate.opsForList().leftPushAll("num",list);
        //遍历一个列表
//        List<String> books = stringRedisTemplate.opsForList().range("books", 0, -1);
//        books.forEach(book -> System.out.println(book));
    }
    /**
     * 操作redis中的set
     */
    @Test
    public void testset(){
        //创建一个set并放入多个元素
        stringRedisTemplate.opsForSet().add("sets","张三","李四","小王");
        //查看set中的值
        Set<String> sets = stringRedisTemplate.opsForSet().members("sets");
        sets.forEach(set -> System.out.println(set));
        Long size = stringRedisTemplate.opsForSet().size("sets");
        System.out.println(size);
    }
    /**
     * 操作redis中的zset
     */
    @Test
    public void testzset(){
        //创建
        stringRedisTemplate.opsForZSet().add("zsets","张三",100);
        //遍历所有
        Set<String> zsets = stringRedisTemplate.opsForZSet().range("zsets", 0, -1);
        zsets.forEach(value -> System.out.println(value));
        //获取指定区间的set
        Set<ZSetOperations.TypedTuple<String>> zsets1 = stringRedisTemplate.opsForZSet().rangeByScoreWithScores("zsets", 0, 100);
        zsets1.forEach(set -> {
            System.out.println(set.getValue());
            System.out.println(set.getScore());
        });


    }
    /**
     * 操作redis中的hash
     */
    @Test
    public void testhash(){
//        //创建一个hash类型，并放入key-value
//        stringRedisTemplate.opsForHash().put("maps","name","张三");
//        //获取hash中某个key的值
//        Object o = stringRedisTemplate.opsForHash().get("maps", "name");
//        System.out.println(o);
//        //创建一个hash类型，并放入多个key-value
//        Map<String,String> map = new HashMap<>();
//        map.put("name","李四");
//        map.put("age","12");
//        map.put("sex","男");
//        stringRedisTemplate.opsForHash().putAll("Maps",map);
        //获取所有的value
        List<Object> maps = stringRedisTemplate.opsForHash().values("Maps");
        maps.forEach(mapss -> System.out.println(mapss));
        //获取所有的key
        Set<Object> maps1 = stringRedisTemplate.opsForHash().keys("Maps");
        maps1.forEach(maps11 -> System.out.println(maps11));

    }
}
