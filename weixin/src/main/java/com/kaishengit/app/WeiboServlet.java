package com.kaishengit.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.kaishengit.dao.MessageDao;
import com.kaishengit.entity.Message;

@WebServlet("/weibo")
public class WeiboServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MessageDao dao = new MessageDao();
		String maxId = req.getParameter("maxId");
		List<Message> messList = null;
		
		
		if(StringUtils.isNotEmpty(maxId)) {
			messList = dao.findAllByMaxId(Integer.parseInt(maxId));
		} else {
			messList = dao.findAll();
		}
		
		String json = new Gson().toJson(messList);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	
	}
	
}
