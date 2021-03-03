##Springboot整合Redis
Spring Boot Data(数据) Redis中提供了RedisTemplate和StringRedisTemplate，其中StringRedisTemplate是RedisTemplate的子类，
两个方法基本一致，不同之处主要体现在操作的数据类型不同，RedisTemplate中的两个泛型都是Object，意味着存储的key和value都可以是一个对象，
而StringRedisTemplate的两个泛型都是String，意味着StringRedisTemplate的key和value都只能是字符串。
注意：使用RedisTemplate默认是将对象序列化到Redis中，所以放入对象必须实现对象序列化接口
###环境准备
####1.导入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
####2.编写配置文件
```yaml
spring:
  redis:
    host: 192.168.48.135
    port: 6379
    database: 0
```
####3.编写测试类
