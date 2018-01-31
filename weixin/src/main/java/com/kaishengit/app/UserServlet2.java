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
import com.google.gson.Gson;
import com.kaishengit.entity.User;

@WebServlet("/users.json")
public class UserServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = Lists.newArrayList(new User(1001,"jack", 23, "China"),new User(1002,"jack", 23, "China"),new User(1003,"jack", 23, "China"));
		String json = new Gson().toJson(users);
		
		//设置相应头
		resp.setContentType("application/json;charset=UTF-8");
		//设置相应中文乱码
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	
	
	
	
	
}
