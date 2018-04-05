package action;

import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import service.StudentsDao;
import service.impl.StudentsDaoImpl;
import entity.Students;

/**
 * 学生Action类
 * @author Administrator
 *
 */
public class StudentsAction extends SuperAction implements ModelDriven<Students>{
	
	private static final long serialVersionUID = 1L;
	private Students s = new Students();
	
	//查询所有学生的动作
	public String query()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null && list.size()>0)
		{
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除学生的动作
	public String delete()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);//调用给删除方法
		return "delete_success";
	}
	
	//添加学生
	public String add() throws Exception{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDao sdao = new StudentsDaoImpl();
		sdao.addStudents(s);
		return "add_success";
	
	}
	
	//修改学生的动作
	public String modify()
	{
		//获得传递过来的学生编号
		String sid = request.getParameter("sid"); 
		StudentsDao sdao = new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);		
		return "modify_success";
	}
	
	//保存修改后的学生的动作
	public String save() throws Exception
	{
		s.setSname(request.getParameter("sid"));
		System.out.println(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDao sdao = new StudentsDaoImpl();
		sdao.updateStudents(s);
		return "save_success";
	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.s;
	}

}
