package com.springmvc.test;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Employee;
 
public class JDBCTest {
	
	private ApplicationContext ctx= null;
	private JdbcTemplate jdbcTemplate = null;
//	private EmployeeDao employee;
 
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
 
	/**
	 * 执行 INSERT,UPDATE,DELETE
	 */
	@Test
	public void testUpdate() {
		String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "Jack", 5);
	}
	/**
	 * 测试批量更新操作
	 * 最后一个参数是 Object[] 的 List 类型：因为修改一条记录需要一个 Object 数组，修改多条记录就需要一个 List 来存放多个数组。
	 */
	@Test
	public void testBatchUpdate() {
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(?,?,?)";
		
		List<Object[]> batchArgs = new ArrayList<>();
		
		batchArgs.add(new Object[]{"AA", "aa@atguigu.com", 1});
		batchArgs.add(new Object[]{"BB", "bb@atguigu.com", 2});
		batchArgs.add(new Object[]{"CC", "cc@atguigu.com", 3});
		batchArgs.add(new Object[]{"DD", "dd@atguigu.com", 3});
		batchArgs.add(new Object[]{"EE", "ee@atguigu.com", 2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 注意：不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
	 * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 * 1、其中的 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
	 * 2、使用 SQL中的列的别名完成列名和类的属性名的映射，例如 last_name lastName
	 * 3、不支持级联属性。 JdbcTemplate 只能作为一个 JDBC 的小工具, 而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id, last_name lastName,email,dept_id as \"department.id\" FROM employees WHERE ID = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		//在将数据装入对象时需要调用set方法。
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		
		System.out.println(employee);
	}
	
	/**
	 * 一次查询多个对象
	 * 注意：调用的不是 queryForList 方法
	 */
	@Test
	public void testQueryForList() {
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);
		
		System.out.println(employees);
	}
	/**
	 * 获取单个列的值或做统计查询
	 * 使用 queryForObject(String sql, Class<Long> requiredType) 
	 */
	@Test
	public void testQueryForObject2() {
		String sql = "SELECT count(id) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		
		System.out.println(count);
	}	
}