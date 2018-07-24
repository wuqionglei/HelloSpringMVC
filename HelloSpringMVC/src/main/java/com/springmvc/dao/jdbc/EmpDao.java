package com.springmvc.dao.jdbc;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Emp;
/*
 * spring-jdbc 示例
*/
@Repository//扫描Dao
public class EmpDao {
    @Resource
    private JdbcTemplate template;//注入

    //还可以继承 JdbcDaoSupport 来实现

    public void save(Emp emp){
        String sql ="insert into emp(name,salary,age) values(?,?,?)";

        Object[] params = {emp.getName(),emp.getSalary(),emp.getAge()};
        //存储给那个几个values的值.要是Object的。因为有很多不同的类型。
        template.update(sql, params);
    }

}