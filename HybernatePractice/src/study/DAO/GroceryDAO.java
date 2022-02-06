package study.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.entity.GroceryEntity;

public class GroceryDAO {

	public static void addProduct(GroceryEntity obj) {
		
		Session session = getSession();
		
		Transaction tx= session.beginTransaction();
		
		session.save(obj);
		
		tx.commit();
		
		
	}
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
	
	public static GroceryEntity viewProduct(int id) {
		
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		GroceryEntity obj =  session.find(GroceryEntity.class, id);
		//System.out.println(obj);
		return obj;
		
	}
	public static void changeProperties(int id, String name) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		GroceryEntity obj = session.find(GroceryEntity.class, id);
		
		if(obj!=null)
		{
			obj.setName(name);
		}
		session.save(obj);
		tx.commit();
		
	}
	
	
	
	

}
