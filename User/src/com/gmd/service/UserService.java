package com.gmd.service;

import com.gmd.bean.User;

public interface UserService {

	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void register(User user);

	/**
	 * �����û�������������û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public boolean login(User user);

	/**
	 * �����û��������û��Ƿ����
	 * 
	 * @return
	 * 
	 */
	public boolean findUserByName(String name);
}
