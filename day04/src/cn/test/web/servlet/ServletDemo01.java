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
		response.setHeader("content-disposition", "attachment;filename=123.jpg"); // ��tomcat��conf�ļ�web.xml�����ҵ���Ӧ�﷨

		InputStream in = this.getServletContext().getResourceAsStream(
				"/123.jpg");
		int len = 0;
		byte buffer[] = new byte[1024];

		OutputStream out = response.getOutputStream();
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
	}

	// ��ʱˢ��
	private void test4(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3;url='http://www.sina.com'");

		String data = "ddddddddd";
		response.getOutputStream().write(data.getBytes());
	}

	// ͨ��content-typeͷ�ֶΣ����������ַ�ʽ��������
	private void test3(HttpServletResponse response) throws IOException {
		response.setHeader("content-type", "image/jpeg"); // ��tomcat��conf�ļ�web.xml�����ҵ���Ӧ�﷨

		InputStream in = this.getServletContext().getResourceAsStream(
				"/123.jpg");
		int len = 0;
		byte buffer[] = new byte[1024];

		OutputStream out = response.getOutputStream();
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
	}

	// ѹ���������
	private void test2(HttpServletResponse response) throws IOException {
		String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("ԭʼ���ݴ�С��" + data.getBytes().length);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(data.getBytes());
		gout.close();

		byte gzip[] = bout.toByteArray(); // �õ�ѹ����Ļ�����
		System.out.println("ѹ����Ĵ�С��" + gzip.length);

		// ֪ͨ��������ݲ��õ�ѹ����ʽ
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", gzip.length + "");
		response.getOutputStream().write(gzip);
	}

	// ��location��302ʵ�������ض���
	public void test1(HttpServletResponse response) {
		response.setStatus(302);
		response.setHeader("location", "/day04/1.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
