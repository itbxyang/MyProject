package com.bxy.service;

import java.util.List;

import com.bxy.domain.Employee;
/**
 * 
 * @���ߣ�������
 * @�޸����ڣ�
 * @����������һ��service��ӿڣ�����model��ķ�����
 *
 */
public interface UserService {

	/**
	 * 
	 * @return
	 * @��������ѯ������Ϣ����ѯ�޸ĺ����Ϣ��
	 */
	public List<Employee> findAllEmp();
	
	/**
	 * 
	 * @param id
	 * @return
	 * @�������ȸ���id��ѯ���ݿ���Ա����Ϣ���ٵ����޸ĵķ���
	 */
	public Employee findEmpById(Integer id);
	
	/**
	 * 
	 * @param emp1
	 * @�������޸�Ա����Ϣ����
	 */
	public void updateEmp(Employee emp1);
}
