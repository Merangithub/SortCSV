package com.gmd.service;

import com.gmd.bean.User;

public interface UserService {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void register(User user);

	/**
	 * 根据用户名和密码查找用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean login(User user);

	/**
	 * 根据用户名查找用户是否存在
	 * 
	 * @return
	 * 
	 */
	public boolean findUserByName(String name);
}
