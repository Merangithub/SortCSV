package com.gmd.service.impl;

import com.gmd.bean.User;
import com.gmd.dao.UserDao;
import com.gmd.dao.impl.UserDaoImpl;
import com.gmd.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	public void register(User user) {
		userDao.addUser(user);
	}

	public boolean login(User user) {

		return userDao.findUser(user);

	}

	public boolean findUserByName(String name) {
		boolean b = userDao.findUserByName(name);

		return b;
	}

}
