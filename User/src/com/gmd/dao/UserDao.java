package com.gmd.dao;

import com.gmd.bean.User;

public interface UserDao {
	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user);

	/**
	 * �����û�������������û���Ϣ
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean findUser(User user);

	/**
	 * �����û��������û��Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	public boolean findUserByName(String name);
}
