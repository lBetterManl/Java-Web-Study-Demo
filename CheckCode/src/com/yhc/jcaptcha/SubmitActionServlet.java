package com.yhc.jcaptcha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年10月31日 下午9:48:55
 */
public class SubmitActionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException
		  {
		    String userCaptchaResponse = request.getParameter("japtcha");
		    response.setContentType("text/html;charset=utf-8");
		    boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
		    if (captchaPassed)
		      response.getWriter().write("验证成功！");
		    else {
		      response.getWriter().write("验证失败！！！");
		    }
		    response.getWriter().write("<br/><a href='jcaptcha.jsp'>Try again</a>");
		  }
}
