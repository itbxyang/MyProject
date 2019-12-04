package com.bxy.service;

import java.util.List;

import com.bxy.domain.Employee;
/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个service层接口（调用model层的方法）
 *
 */
public interface UserService {

	/**
	 * 
	 * @return
	 * @描述：查询所有信息（查询修改后的信息）
	 */
	public List<Employee> findAllEmp();
	
	/**
	 * 
	 * @param id
	 * @return
	 * @描述：先根据id查询数据库中员工信息，再调用修改的方法
	 */
	public Employee findEmpById(Integer id);
	
	/**
	 * 
	 * @param emp1
	 * @描述：修改员工信息方法
	 */
	public void updateEmp(Employee emp1);
}
