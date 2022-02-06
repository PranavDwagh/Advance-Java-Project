package study;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.entity.StudentEntity;

public class HibernateDAO {
	
	public void addStudent(int roll, String name)
	{
		Session session = getSession();
		Transaction t = session.beginTransaction();
		StudentEntity entity = new StudentEntity(roll, name);
		session.save(entity);
		t.commit();
		session.close();
	}
	
	public List<StudentEntity> getAllRows()
	{
		
		return null;
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


}
