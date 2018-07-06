package com.gmd.dao.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.gmd.bean.User;
import com.gmd.dao.UserDao;

public class UserDaoImpl implements UserDao {

	/*
	 * 此处代码利用流，将user序列化到本地。
	 * 
	 * @see com.gmd.dao.UserDao#addUser(com.gmd.bean.User)
	 */
	public void addUser(User user) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("c://user.txt"));
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean findUser(User user) {
		if (user.getUsername().equals("") && user.getPassword().equals(""))
			return false;
		return true;
	}

	public boolean findUserByName(String name) {
		return false;

	}

}
