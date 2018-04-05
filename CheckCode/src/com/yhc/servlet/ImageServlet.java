package com.yhc.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年10月31日 下午9:21:01
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//画一张图片
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(200,150,255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		
		//四位验证码
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r = new Random();
		int len = ch.length,index;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			//r.nextInt(88)获取88以内的数
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			g.drawString(ch[index]+"", (i*15)+3, 18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode", sb.toString());
		//输出图片
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
