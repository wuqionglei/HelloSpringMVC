package com.springmvc.model;

import java.io.Serializable;
/*
 *spring-jdbc 示例
 */
public class Emp implements Serializable{

    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    
    //定义为封装类。在数据库中为null。封装类可以接受，但是int就不能了。
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}