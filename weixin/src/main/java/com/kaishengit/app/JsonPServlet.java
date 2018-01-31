package com.kaishengit.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

@WebServlet("/load.js")
public class JsonPServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodName = req.getParameter("m");
		
		User user = new User(1001,"jack", 23,"beijing");
		
		String json = new Gson().toJson(user);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(methodName + "(" + json + ")");//sayHello({"name":jack,"age":23});
		
		out.flush();
		out.close();
		
		
	
	}
	
}
