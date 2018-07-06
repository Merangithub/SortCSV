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
		// ��֤�û���������
		// TODO �������
		// �ӱ����ļ���ȡ�û�ע��ʱ���������
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
			request.setAttribute("msg", "����û��ע�ᣬ����ע�ᣡ");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		} else if (u.getUsername().equals(username) && u.getPassword().equals(password)) {// �����������л�ȡ�����ݸ����ش����б��������һ����ִ�����´���
			// ��װ���ݡ�����ȡ�Ĳ�����װΪjavabean����
			User user = new User(username, password);
			// ���÷����ҵ���߼�
			UserService us = new UserServiceImpl();
			boolean flag = us.login(user);
			// �ַ�ת��
			if (flag) {
				request.getSession().setAttribute("u", user);// �����¼�ɹ����Ͱ�user����ŵ�session����
																// ��
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "���û������ڣ������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
