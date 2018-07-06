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
		boolean isFileExist = file.exists();// ��ʶuser.txt�ļ��Ƿ����
		if (isFileExist) {// ��������Ѿ�����user.txt�ļ�,��ִ�ж�ȡ����
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
		// ��ȡ������,������
		User user = new User();
		UserService us = new UserServiceImpl();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		String sdate = request.getParameter("birthday");
		// ��string���͵�����ת����date���͵�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			// ʹ��SimpleDateFormat��parse()��������Date
			date = sdf.parse(sdate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setBirthday(date);

		us.register(user);// �����û�ע�᷽��

		if (isFileExist) {// ������ش����Ѿ�����ע����Ϣ�ļ���˵��֮ǰ����ע���������Ҫ���к˶�����ע����û����Ƿ��Ѿ�����
			// �ж��û����Ƿ����
			if (user.getUsername().equals(localUser.getUsername())) {
				response.getWriter().write("ע��ʧ�ܣ����û��Ѵ��ڡ�");
				response.setHeader("refresh", "1;url=" + request.getContextPath() + "/reg.jsp");
			} else {
				// �ַ�ת��
				response.getWriter().write("ע��ɹ���1����ת����ҳ��");
				response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
			}
		} else {
			// �ַ�ת��
			response.getWriter().write("ע��ɹ���1����ת����ҳ��");
			response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
