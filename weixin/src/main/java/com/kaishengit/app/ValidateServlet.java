package com.kaishengit.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class ValidateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(name);
		
		PrintWriter out = resp.getWriter();
		if("tom".equals(name)){
			out.print("no");
			System.out.println("该帐号不可用");
		} else {
			out.print("yes");
			System.out.println("该帐号可以使用");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println("post:" + name);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("保存成功");
		out.flush();
		out.close();
	}
	
}
