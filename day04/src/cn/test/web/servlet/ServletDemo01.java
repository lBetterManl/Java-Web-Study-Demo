package cn.test.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo01 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	private void test5(HttpServletResponse response) throws IOException {
		response.setHeader("content-disposition", "attachment;filename=123.jpg"); // 在tomcat的conf文件web.xml里面找到相应语法

		InputStream in = this.getServletContext().getResourceAsStream(
				"/123.jpg");
		int len = 0;
		byte buffer[] = new byte[1024];

		OutputStream out = response.getOutputStream();
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
	}

	// 定时刷新
	private void test4(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3;url='http://www.sina.com'");

		String data = "ddddddddd";
		response.getOutputStream().write(data.getBytes());
	}

	// 通过content-type头字段，控制以哪种方式处理数据
	private void test3(HttpServletResponse response) throws IOException {
		response.setHeader("content-type", "image/jpeg"); // 在tomcat的conf文件web.xml里面找到相应语法

		InputStream in = this.getServletContext().getResourceAsStream(
				"/123.jpg");
		int len = 0;
		byte buffer[] = new byte[1024];

		OutputStream out = response.getOutputStream();
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
	}

	// 压缩数据输出
	private void test2(HttpServletResponse response) throws IOException {
		String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("原始数据大小：" + data.getBytes().length);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(data.getBytes());
		gout.close();

		byte gzip[] = bout.toByteArray(); // 得到压缩后的火数据
		System.out.println("压缩后的大小：" + gzip.length);

		// 通知浏览器数据采用的压缩格式
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", gzip.length + "");
		response.getOutputStream().write(gzip);
	}

	// 用location和302实现请求重定向
	public void test1(HttpServletResponse response) {
		response.setStatus(302);
		response.setHeader("location", "/day04/1.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
