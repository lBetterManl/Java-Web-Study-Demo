package action;
/**
 * �û�Action��
 */
import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDao;
import service.impl.UsersDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// �û���¼����
	public String login() {

		UsersDao udao = new UsersDaoImpl();
		if (udao.usersLogin(user)) {
			// ��session�����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}

	}

	// �û�ע������,ע��ʱ����֤
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
		// �û�������Ϊ��
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "�û�������Ϊ�գ�");
		}
		// ���볤�Ȳ���С��6λ��
		if (user.getPassword().length()<6) {
			this.addFieldError("passwordError", "���볤�Ȳ���С��6λ��");
		}
	}

	//�����Ñ�ģ�ͣ�ʡȥ��дget��set
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
