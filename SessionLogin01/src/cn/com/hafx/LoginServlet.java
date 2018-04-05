package cn.com.hafx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class LoginServlet
 *
 */
@WebListener
public class LoginServlet extends HttpServlet implements HttpSessionListener {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -2080934157550504694L;

	/**
	 * 日志
	 */
	private static Log log = LogFactory.getLog(LoginServlet.class);

	/**
	 * 用户和Session绑定关系
	 */
	public static final Map<String, HttpSession> USER_SESSION = new HashMap<String, HttpSession>();

	/**
	 * seeionId和用户的绑定关系
	 */
	public static final Map<String, String> SESSIONID_USER = new HashMap<String, String>();

	/**
	 * 实现HttpSessionListener接口监听 监听session的创建事件
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();

		log.info("创建session sessionId= " + sessionId);
	}

	/**
	 * 实现HttpSessionListener接口监听 监听session的销毁事件
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionId = se.getSession().getId();

		// 当前session销毁时删除当前session绑定的用户信息
		// 同时删除当前session绑定用户的HttpSession
		USER_SESSION.remove(SESSIONID_USER.remove(sessionId));

		log.info("销毁session sessionId= " + sessionId);
	}

	/**
	 * 用户登录
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求命令
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		String uri = servletPath.substring(1, servletPath.lastIndexOf(".do"));

		try {
			// 登录
			if ("login".equals(uri)) {
				HttpSession session = request.getSession();
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");

				if (userName != null && !"".equals(userName.trim())) {
					// 登录成功
					if (login(userName, password)) {
						// 处理用户登录(保持同一时间同一账号只能在一处登录)
						userLoginHandle(request);

						// 添加用户与HttpSession的绑定
						USER_SESSION.put(userName.trim(), session);

						// 添加sessionId和用户的绑定
						SESSIONID_USER.put(session.getId(), userName);

						log.info("用户[" + userName + "] 已上线...");

						session.setAttribute("userName", userName);
						session.removeAttribute("userMsg");

						// 重定向到首页
						response.sendRedirect("main.jsp");
					}
					// 登录失败
					else {
						log.info("用户[" + userName + "] 登录失败...");

						request.setAttribute("msg", "登录失败，请重新登录！");

						// response.sendRedirect("login.jsp");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} else {
					log.info("用户[" + userName + "] 登录失败...");

					request.setAttribute("msg", "登录失败，请重新登录！");

					// response.sendRedirect("login.jsp");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			// 重新登陆
			else if ("reLogin".equals(uri)) {
				HttpSession session = request.getSession();
				String userName = (String) session.getAttribute("userName");
				if (session != null) {
					// 销毁相关session
					// USER_SESSION.remove(SESSIONID_USER.remove(session.getId()));
					session.invalidate();
				}
				if (userName != null && !"".equals(userName)) {
					log.info("用户[" + userName + "] 已下线...");
				}
				// 重定向到登录页面
				response.sendRedirect("login.jsp");
			}
			// ajax校验
			else if ("getUserMsg".equals(uri)) {
				HttpSession session = request.getSession();

				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");

				PrintWriter out = response.getWriter();
				out.print(session.getAttribute("userMsg"));
			}
		} catch (Exception e) {
			log.error(e.getClass() + e.getMessage());
			PrintWriter out = response.getWriter();
			out.print("服务器内部错误！");
		}
	}

	/**
	 * 
	 * Description:用户登录时的处理 <br>
	 * 
	 * @param request
	 * @see
	 */
	private void userLoginHandle(HttpServletRequest request) {
		// 当前登录的用户
		String userName = request.getParameter("userName");

		// 当前sessionId
		// String sessionId = request.getSession().getId();

		// 删除当前sessionId绑定的用户，用户--HttpSession
		// USER_SESSION.remove(SESSIONID_USER.remove(sessionId));

		// 删除当前登录用户已绑定的HttpSession
		HttpSession session = USER_SESSION.remove(userName);
		if (session != null) {
			// 删除已登录的sessionId绑定的用户
			SESSIONID_USER.remove(session.getId());

			session.removeAttribute("userName");
			session.setAttribute("userMsg", "您的账号已经在另一处登录，您被迫下线！");
		}
	}

	/**
	 * 
	 * Description: 模拟DB登录判断<br>
	 * 
	 * @param userName
	 *            用户
	 * @param password
	 *            密码
	 * @return
	 * @see
	 */
	private boolean login(String userName, String password) {
		return ("yhc".equals(userName) && "123456".equals(password));
	}

}
