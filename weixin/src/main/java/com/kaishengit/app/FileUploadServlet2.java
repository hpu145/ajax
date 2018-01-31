package com.kaishengit.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.kaishengit.exception.ServiceException;

@WebServlet("/file/upload2")
@MultipartConfig
public class FileUploadServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 1.设置文件上传路径
		File saveDir = new File("d:/upload");

		if (!saveDir.exists()) {
			saveDir.mkdir();
		}

		// 2.设置文件上传的临时路径
		File tempDir = new File("d:/temp");
		if (!tempDir.exists()) {
			tempDir.mkdir();
		}

		// 3.判断是否设置了enctype属性为mutilpart/form-data
		if (ServletFileUpload.isMultipartContent(req)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 4.1设置临时文件夹
			factory.setRepository(tempDir);
			// 4.2设置缓冲区大小
			factory.setSizeThreshold(10 * 1024);

			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			// 5 设置上传文件的最大大小
			servletFileUpload.setSizeMax(10 * 1024 * 1024);

			try {
				// 6 获取所有表单元素（普通表单元素、上传文件元素）,包装成FIleItem的对象集合
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
					// 7 判断表单元素是普通元素还是文件元素
					if (item.isFormField()) {
						// 普通元素
						// System.out.println(item.getName());// 无用
						System.out.println(item.getFieldName()); // name属性
						System.out.println(item.getString("UTF-8")); // 表单元素值

					} else {
						// 文件元素
						System.out.println(item.getName());// 获取上传文件的名称
						System.out.println(item.getFieldName()); // name属性
						// System.out.println(item.getString("UTF-8")); //
						// 对于文件元素来说无用

						// 8 获得上传文件并存储
						String fileName = item.getName(); // 1.jpg
						String newName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf(".")); // A45d-45df.jpg
						// item.write(new File(saveDir, newName));

						InputStream inputStream = item.getInputStream();
						FileOutputStream outputStream = new FileOutputStream(new File(saveDir, newName));

						IOUtils.copy(inputStream, outputStream);

						// byte[] buffer = new byte[1024];
						// int len = -1;
						//
						// while((len = inputStream.read(buffer)) != -1) {
						// outputStream.write(buffer, 0, len);
						// }

						outputStream.flush();
						outputStream.close();
						inputStream.close();

						Map<String,Object> map = new HashMap<>();
//						map.put("state", "success");
//						map.put("data", "http://localhost:8080/avatar?name="+ newName);
						map.put("success", true);
						map.put("file_path", "http://localhost:8080/avatar?name="+ newName);
						
						
						
						resp.setCharacterEncoding("UTF-8");
						resp.setContentType("application/json;charset=UTF-8");
						PrintWriter out = resp.getWriter();
						out.print(new Gson().toJson(map));
						
						out.flush();
						out.close();
					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			throw new ServiceException("form表单enctype属性设置错误");
		}
	}

}
