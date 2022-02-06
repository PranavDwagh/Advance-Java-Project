package trail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestPerson {
	public static void main(String[] args) {

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person();
		p.setPersonName("pranav");
		
		PersonDetail pd = new PersonDetail();
		pd.setJob("IT");
		pd.setZipcode("431109");
		p.setpDetail(pd);
		session.save(p);
		
		/*Person p1 = session.find(Person.class, 1);
		
		session.delete(p1);
		*/
		
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
