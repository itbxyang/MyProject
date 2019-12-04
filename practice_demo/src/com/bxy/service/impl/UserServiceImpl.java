package com.bxy.service.impl;

import java.util.List;

import com.bxy.dao.UserDao;
import com.bxy.dao.impl.UserDaoImpl;
import com.bxy.domain.Employee;
import com.bxy.service.UserService;
/**
 * 
 * @作者：卜向阳
 * @修改日期：
 * @描述：定义一个service层接口的实现类（调用model层的方法）
 *
 */
public class UserServiceImpl implements UserService {

	// 创建一个model层接口实现类对象，并赋值给接口
	private UserDao userdao = new UserDaoImpl();
	
	@Override
	public List<Employee> findAllEmp() {
		// 通过接口调用model层的fandAllEmp();
		return userdao.findAllEmp();
	}

	@Override
	public Employee findEmpById(Integer id) {
		// 通过接口调用model层的fandAllEmpById();
		return userdao.findEmpById(id);
	}

	@Override
	public void updateEmp(Employee emp1) {
		// 通过接口调用model层的updateEmp();
		userdao.updateEmp(emp1);
		
	}

}
