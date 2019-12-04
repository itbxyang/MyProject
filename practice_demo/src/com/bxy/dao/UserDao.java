package com.bxy.dao;

import java.util.List;

import com.bxy.domain.Employee;

/**
 * 
 * 	�������ϸ���MVC����ģʽ����
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ��model��ӿ�
 *
 */

public interface UserDao {

	/**	 
	 *  
	 * @param emp1
	 * @�������޸�Ա����Ϣ����
	 */
	public void updateEmp(Employee emp1);
	
	/** 
	 * 
	 * @param id
	 * @return
	 * @�������ȸ���id��ѯ���ݿ���Ա����Ϣ���ٵ����޸ĵķ���
	 */
	public Employee findEmpById(Integer id);
	
	/**
	 * 
	 * @return
	 * @��������ѯ������Ϣ����ѯ�޸ĺ����Ϣ��
	 */
	public List<Employee> findAllEmp();
	
	
	
	
}
