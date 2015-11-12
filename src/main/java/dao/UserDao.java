package dao;

import java.io.Serializable;

import org.hibernate.Session;

import config.HibernateConfig;
import entity.User;

public class UserDao {
	
	private Session session;
	
	public User select(int id){
		session = HibernateConfig.getSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}
	
	public int insert(User user){
		session = HibernateConfig.getSession();
		session.beginTransaction();
		Serializable result = session.save(user);
		session.getTransaction().commit();
		return Integer.parseInt(result.toString());
	}
	
	public void delete(User user){
		session = HibernateConfig.getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	public void update(User user){
		session = HibernateConfig.getSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

}
