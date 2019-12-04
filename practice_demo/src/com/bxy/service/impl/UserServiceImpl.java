package com.bxy.service.impl;

import java.util.List;

import com.bxy.dao.UserDao;
import com.bxy.dao.impl.UserDaoImpl;
import com.bxy.domain.Employee;
import com.bxy.service.UserService;
/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ��service��ӿڵ�ʵ���ࣨ����model��ķ�����
 *
 */
public class UserServiceImpl implements UserService {

	// ����һ��model��ӿ�ʵ������󣬲���ֵ���ӿ�
	private UserDao userdao = new UserDaoImpl();
	
	@Override
	public List<Employee> findAllEmp() {
		// ͨ���ӿڵ���model���fandAllEmp();
		return userdao.findAllEmp();
	}

	@Override
	public Employee findEmpById(Integer id) {
		// ͨ���ӿڵ���model���fandAllEmpById();
		return userdao.findEmpById(id);
	}

	@Override
	public void updateEmp(Employee emp1) {
		// ͨ���ӿڵ���model���updateEmp();
		userdao.updateEmp(emp1);
		
	}

}
