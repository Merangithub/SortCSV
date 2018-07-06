package com.gmd.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmd.bean.User;
import com.gmd.service.UserService;
import com.gmd.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User localUser = null;
		File file = new File("c://user.txt");
		boolean isFileExist = file.exists();// 标识user.txt文件是否存在
		if (isFileExist) {// 如果本地已经存在user.txt文件,则执行读取操作
			InputStream in;
			try {
				in = new FileInputStream(file);
				ObjectInputStream objIn = new ObjectInputStream(in);
				localUser = (User) objIn.readObject();
				objIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 获取表单数据,并设置
		User user = new User();
		UserService us = new UserServiceImpl();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		String sdate = request.getParameter("birthday");
		// 把string类型的日期转换成date类型的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			// 使用SimpleDateFormat的parse()方法生成Date
			date = sdf.parse(sdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setBirthday(date);

		us.register(user);// 调用用户注册方法

		if (isFileExist) {// 如果本地磁盘已经存在注册信息文件，说明之前有人注册过，则需要进行核对正在注册的用户名是否已经存在
			// 判断用户名是否存在
			if (user.getUsername().equals(localUser.getUsername())) {
				response.getWriter().write("注册失败！该用户已存在。");
				response.setHeader("refresh", "1;url=" + request.getContextPath() + "/reg.jsp");
			} else {
				// 分发转向
				response.getWriter().write("注册成功！1秒跳转到主页。");
				response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
			}
		} else {
			// 分发转向
			response.getWriter().write("注册成功！1秒跳转到主页。");
			response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
