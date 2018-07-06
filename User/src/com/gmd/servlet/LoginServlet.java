package com.gmd.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmd.bean.User;
import com.gmd.service.UserService;
import com.gmd.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证用户名和密码
		// TODO 自行完成
		// 从本地文件读取用户注册时保存的数据
		User u = null;
		File file = new File("c://user.txt");
		InputStream in;
		boolean isFileExist = file.exists();
		try {
			in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			u = (User) objIn.readObject();
			objIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!isFileExist) {
			request.setAttribute("msg", "您还没有注册，请先注册！");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		} else if (u.getUsername().equals(username) && u.getPassword().equals(password)) {// 如果从浏览器中获取的数据跟本地磁盘中保存的数据一致则执行以下代码
			// 封装数据。将获取的参数封装为javabean对象
			User user = new User(username, password);
			// 调用服务层业务逻辑
			UserService us = new UserServiceImpl();
			boolean flag = us.login(user);
			// 分发转向
			if (flag) {
				request.getSession().setAttribute("u", user);// 如果登录成功，就把user对象放到session对象
																// 中
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "该用户不存在，或者密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
