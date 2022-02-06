package manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestManyToMany {
	public static void main(String[] args) {

		Session session = getSession();
		
		Transaction tx  = session.beginTransaction();
		
		SubscriptionEntity se = new SubscriptionEntity();
		se.setSubscriptionName("Horror");
		
		SubscriptionEntity se2 = new SubscriptionEntity();
		se2.setSubscriptionName("pranav");
		
		SubscriptionEntity se3 = new SubscriptionEntity();
		se3.setSubscriptionName("entertainment");
		
		
		Set<SubscriptionEntity> set1 = new HashSet<SubscriptionEntity>();
		set1.add(se);
		set1.add(se2);
	
		Set<SubscriptionEntity> set2 = new HashSet<SubscriptionEntity>();
		set1.add(se3);
		set1.add(se2);
		ReaderEntity re = new ReaderEntity();
		re.setEmail("pranav@");
		re.setName("pranav");
		re.setSubcription(set2);
		
		ReaderEntity re2 = new ReaderEntity();
		re2.setEmail("pranav2@");
		re2.setName("pranav");
		re.setSubcription(set1);
		
		session.save(re);
		session.save(re2);
		
		/*
		ReaderEntity re = session.find(ReaderEntity.class, 18);
		
		session.delete(re);*/
		
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
