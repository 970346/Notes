package com.feng.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
    //基本类型直接使用property标签赋值
    private String lastName;
    private Integer age;
    private String gender;
    private String email;
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private Car car;

    private List<Book> books;

    private Map<String,Object> map;

    private Properties properties;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                ", books=" + books +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public Person() {
        System.out.println("person被创建");
    }

    public Person(String lastName, Integer age, String gender) {
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        System.out.println("三个参数的构造器。。。age");
    }

    public Person(String lastName, String email, String gender) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        System.out.println("三个参数的构造器。。。email");
    }

    public Person(String lastName, Integer age, String gender, String email) {
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Person(Car car) {
        this.car = car;
    }
}
