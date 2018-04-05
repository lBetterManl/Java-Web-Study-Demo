package service;

import java.util.List;

import entity.Students;

/**
 * ѧ����ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface StudentsDao {

	//��ѯ����ѧ������
	public List<Students> queryAllStudents();
	
	//����ѧ����Ų�ѯѧ������
	public Students queryStudentsBySid(String sid);
	
	//���ѧ������
	public boolean addStudents(Students s);
	
	//�޸�ѧ������
	public boolean updateStudents(Students s);
	
	//ɾ��ѧ������
	public boolean deleteStudents(String sid); 
}
