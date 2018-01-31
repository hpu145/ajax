package com.kaishengit.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.kaishengit.entity.User;

@WebServlet("/users.xml")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 数据库中查询对应user集合
		List<User> users = Lists.newArrayList(new User(1001,"jack",23,"jiaozuo"),new User(1002,"tom",23,"开封"),new User(1003,"rose",34,"新乡"));
		// 设置响应头
		resp.setContentType("text/xml;charset=UTF-8");
		// 处理客户端中文乱码问题
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<users>");
		for(User user : users) {
			out.println("<user id=\"" + user.getId() + "\">");
			out.println("<name>" + user.getName() + "</name>");
			out.println("<address>" + user.getAddress() + "</address>");
			out.println("</user>");
		}
		out.println("</users>");
		
		out.flush();
		out.close();
		
	}
	
}
