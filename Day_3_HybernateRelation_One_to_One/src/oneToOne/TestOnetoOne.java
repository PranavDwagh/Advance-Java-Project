package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestOnetoOne {
	public static void main(String[] args) {
		
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		/*Employee e1 = new Employee();
	
		e1.setName("pooja");
		e1.setEmail("pooja@");
		
		Address a1 = new Address();
		
		
		a1.setCity("pune");
		a1.setPincode(411041);
		a1.setEmployee(e1);
		e1.setAddress(a1);
		
	//	session.save(a1);
		session.save(e1);*/
		
		Employee emp = session.find(Employee.class, 2);
		
		session.delete(emp);
		
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
	
	
}
