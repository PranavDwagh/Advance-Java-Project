package com.java.miniproject.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.java.miniproject.entity.Hobby;
import com.java.miniproject.entity.User;

public class HybernateDAO {
	
	public static Session getSession()
	{
		//READING the hibernate.cfg.xml  from the classpath 
		  StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
	    // Create MetadataSources
	    MetadataSources sources = new MetadataSources(registry);
	    // Create Metadata
	    Metadata metadata = sources.getMetadataBuilder().build();
	    // Create SessionFactory
	    SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
	   
	    Session session = sessionFactory.openSession(); // start a transaction
		
	    return session;
	}
	
	public static boolean validateUser(User user)
	{
		Session session = getSession();
		
		Query<User> query =   session.createNativeQuery("select * from user_info_tbl a where a.username= :username and a.password= :password");
		
		query.setParameter("username", user.getUserName());
		query.setParameter("password", user.getPassword());
		
		if(query.list().isEmpty())
			return false;
		else
			return true;
		
	//	session.createQuery("from User a where a.userName= :username ");
	}

	public static void addUser(User nuser) {
		
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(nuser);
		
		tx.commit();
		
	}

	public static void addHobby(Hobby hb) {
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(hb);
		
		tx.commit();
		
	}

	public static List<String> viewHobby(int id) {

		Session session = getSession();
		
		String hql = "select a.hobby_hobby from hobby_tbl a where a.hobby_userid = :id";
		
		Query<String> query = session.createNativeQuery(hql); 
		query.setParameter("id", id);
		
		List<String> list = query.list();
		
		return list;
		
		
	}
	
	
	
	

}
