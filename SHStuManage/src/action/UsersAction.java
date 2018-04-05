package action;
/**
 * 用户Action类
 */
import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDao;
import service.impl.UsersDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// 用户登录动作
	public String login() {

		UsersDao udao = new UsersDaoImpl();
		if (udao.usersLogin(user)) {
			// 在session保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}

	// 用户注销方法,注销时不验证
	@SkipValidation
	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		// 用户名不能为空
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		// 密码长度不能小于6位！
		if (user.getPassword().length()<6) {
			this.addFieldError("passwordError", "密码长度不能小于6位！");
		}
	}

	//创建用戶模型，省去再写get、set
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
