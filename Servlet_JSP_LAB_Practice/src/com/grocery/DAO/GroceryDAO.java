package com.grocery.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.grocery.pojo.Grocery;

public class GroceryDAO {
	
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
	
	public static void addGrocery(Grocery obj)
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		// redirect somewhere TODO
	}
	
	public static Grocery viewGrocery(int id)
	{
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		Grocery obj = session.find(Grocery.class, id);
		
		return obj;
	}
	
	
	
	

}
