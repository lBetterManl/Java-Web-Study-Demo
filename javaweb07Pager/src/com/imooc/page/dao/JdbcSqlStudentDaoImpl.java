package com.imooc.page.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.imooc.page.Constant;
import com.imooc.page.model.Pager;
import com.imooc.page.model.Student;
import com.imooc.page.util.JdbcUtil;

/**
 * ʹ��mysql���ݿ�limit�ؼ���ʵ�ַ�ҳ
 * 
 * @author lenjey
 * 
 */
public class JdbcSqlStudentDaoImpl implements StudentDao {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = null;
		// ��Ų�ѯ����
		List<Object> paramList = new ArrayList<Object>();
		
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder(
				"select * from t_student where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from t_student where 1=1 ");

		if (stuName != null && !stuName.equals("")) {
			sql.append(" and stu_name like ?");
			countSql.append(" and stu_name like ?");
			paramList.add("%" + stuName + "%");
		}

		if (gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE) {
			sql.append(" and gender = ?");
			countSql.append(" and gender = ?");
			paramList.add(gender);
		}
		
		// ��ʼ����
		int fromIndex	= pageSize * (pageNum -1);
		
		// ʹ��limit�ؼ��֣�ʵ�ַ�ҳ
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// ������в�ѯ����ѧ������
		List<Student> studentList = new ArrayList<Student>();
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // ��ȡ���ݿ�����
			
			// ��ȡ�ܼ�¼��
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// ��ȡ��ѯ��ѧ����¼
			List<Map<String, Object>> studentResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (studentResult != null) {
				for (Map<String, Object> map : studentResult) {
					Student s = new Student(map);
					studentList.add(s);
				}
			}
			
			//��ȡ��ҳ��
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// ��װpager����
			result = new Pager<Student>(pageSize, pageNum, 
							totalRecord, totalPage, studentList);
			
		} catch (SQLException e) {
			throw new RuntimeException("��ѯ���������쳣��", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // һ��Ҫ�ͷ���Դ
			}
		}
		return result;
	}

}
