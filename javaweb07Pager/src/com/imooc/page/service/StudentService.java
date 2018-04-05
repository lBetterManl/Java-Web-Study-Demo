package com.imooc.page.service;

import com.imooc.page.model.Pager;
import com.imooc.page.model.Student;

public interface StudentService {

	/**
	 * ���ݲ�ѯ��������ѯѧ����ҳ��Ϣ
	 * 
	 * @param searchModel
	 *            ��װ��ѯ����
	 * @param pageNum
	 *            ��ѯ�ڼ�ҳ����
	 * @param pageSize
	 *            ÿҳ��ʾ��������¼
	 * @return ��ѯ���
	 */
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize);
}
