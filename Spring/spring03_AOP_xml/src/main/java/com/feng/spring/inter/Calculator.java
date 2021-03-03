package com.feng.spring.inter;

/**
 * 接口一般不加入到容器中，但是也可以加入到容器中，spring不会对接口做操作
 */
public interface Calculator {
    public int add(int i, int j);
    public int sub(int i, int j);
    public int mul(int i, int j);
    public int div(int i, int j);
}
