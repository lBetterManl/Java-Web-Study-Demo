package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDao;

public class UsersDaoImpl implements UsersDao{

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		//事务对象
		Transaction tx = null;
		String hql = "";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			@SuppressWarnings("unchecked")
			List<Users> list = query.list();
			if(list.size()>0){
				tx.commit();
				return true;
			} else{
				tx.commit();
				return false;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			tx.rollback();
			return false;
			
		} finally{
			if(tx!=null)
			{
				tx = null;
			}
		}
		
	}
	
}
