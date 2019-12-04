package com.bxy.dao;

import java.util.List;

import com.bxy.domain.Employee;

/**
 * 
 * 	声明：严格按照MVC三层模式编码
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个model层接口
 *
 */

public interface UserDao {

	/**	 
	 *  
	 * @param emp1
	 * @描述：修改员工信息方法
	 */
	public void updateEmp(Employee emp1);
	
	/** 
	 * 
	 * @param id
	 * @return
	 * @描述：先根据id查询数据库中员工信息，再调用修改的方法
	 */
	public Employee findEmpById(Integer id);
	
	/**
	 * 
	 * @return
	 * @描述：查询所有信息（查询修改后的信息）
	 */
	public List<Employee> findAllEmp();
	
	
	
	
}
