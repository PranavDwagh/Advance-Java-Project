package oneToMany;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestEmpAcc {
	public static void main(String[] args) {

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		/*Employee emp = new Employee();
		emp.setEmail("wagh@");
		emp.setName("pranav");
		
		Account acc1 = new Account();
		acc1.setAccountNo("account 1");
		
		Account acc2 = new Account();
		acc2.setAccountNo("account 2");
		
		Account acc3 = new Account();
		acc3.setAccountNo("account 3");
		
		Employee emp2 = new Employee();
		
		emp2.setName("pranav2");
		emp2.setEmail("pranav@");
		
		Set<Account> set1 = new HashSet<Account>();
		set1.add(acc1);
		set1.add(acc2);
		
		Set<Account> set2 = new HashSet<Account>();
		set2.add(acc3);
		set2.add(acc2);
		emp.setAccount(set1);
		emp2.setAccount(set2);
		
		session.save(emp);
		session.save(emp2);*/
		
		Employee e = session.find(Employee.class, 13);
		
		session.delete(e);
		
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
