package com.kaishengit.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/avatar")
public class AvatarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		File file = new File("d:/upload",name);
		if(!file.exists()) {
			resp.sendError(404,"访问资源不存在");
		} else {
			InputStream in = new FileInputStream(file);
			OutputStream out = resp.getOutputStream();
			
			IOUtils.copy(in, out);
			out.flush();
			out.close();
			in.close();
			
		}
		
		
		
		
		
	}
	
	
}
