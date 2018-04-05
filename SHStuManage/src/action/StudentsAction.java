package action;

import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import service.StudentsDao;
import service.impl.StudentsDaoImpl;
import entity.Students;

/**
 * ѧ��Action��
 * @author Administrator
 *
 */
public class StudentsAction extends SuperAction implements ModelDriven<Students>{
	
	private static final long serialVersionUID = 1L;
	private Students s = new Students();
	
	//��ѯ����ѧ���Ķ���
	public String query()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//�Ž�session��
		if(list!=null && list.size()>0)
		{
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//ɾ��ѧ���Ķ���
	public String delete()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);//���ø�ɾ������
		return "delete_success";
	}
	
	//���ѧ��
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
	
	//�޸�ѧ���Ķ���
	public String modify()
	{
		//��ô��ݹ�����ѧ�����
		String sid = request.getParameter("sid"); 
		StudentsDao sdao = new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//�����ڻỰ��
		session.setAttribute("modify_students", s);		
		return "modify_success";
	}
	
	//�����޸ĺ��ѧ���Ķ���
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
