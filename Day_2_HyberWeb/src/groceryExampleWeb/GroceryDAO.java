package groceryExampleWeb;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GroceryDAO {

	// DAO class commi=unicate to DataBase
	
	
	public void addGrocery(Grocery gr) {
		
		Session session = getSession();
		
		Transaction tr =session.beginTransaction();
		
		session.save(gr);
		
		tr.commit();
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

	public void changeProperties(int id, String desc) {
		
		Session session = getSession();
		Transaction tr = session.beginTransaction();
		
		Grocery gr = session.find(Grocery.class, id);
		
		gr.setDesc(desc);
		
		tr.commit();
		
	}

	public void deleteProduct(int id) {

		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		Grocery gr = session.find(Grocery.class, id);
		
		if(gr != null)
		{
			session.delete(gr);
		}
		tx.commit();
	}

	public Grocery showDetails(int id) {
		
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		
		Grocery gr = session.find(Grocery.class, id);
		
		return gr;
		
	}
	
}
