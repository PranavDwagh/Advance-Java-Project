package study.entity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HiberApp {

	public static void main(String[] args) {

		Session session = getSession();
		
		/*Transaction trx = session.beginTransaction();
		
		StudentEntity obj = new StudentEntity(1, "pranav");
		StudentEntity obj2 = new StudentEntity(2, "pooja");
		StudentEntity obj3 = new StudentEntity(3, "amit");
		StudentEntity obj4 = new StudentEntity(4, "sumit");
		
		session.save(obj);
		session.save(obj2);
		session.save(obj3);
		session.save(obj4);
		
		trx.commit();*/
		
		//update(session);
		
		//delete(session);
		
		//List<StudentEntity> list = getAllRows(session);
		
		//list.forEach(System.out::println);
		
		List<StudentEntity> list = getRecord(session);
		list.forEach(e->System.out.println(e));
		
		/*List<StudentEntity> list = getNative(session);
		list.forEach(e->System.out.println(e));*/
		
	}	
	
	public static List<StudentEntity> getAllRows(Session session)
	{
		String hbl = "from study.entity.StudentEntity";  
		Query<StudentEntity> query =session.createQuery(hbl);
		
		List<StudentEntity> list = query.list();
		
		return list;
	}
	
	public static List<StudentEntity> getRecord(Session session)
	{
		// createquery...we have to use hbl queries
		// in createquery we are using table properties(attributes) in query
		
		//Query<StudentEntity> query = session.createQuery("from study.entity.StudentEntity as s where s.rollNumber < :maxroll ");
		String hbl1 = "from study.entity.StudentEntity as s where s.rollNo< 10";
		String hbl = "select s.rollNo from study.entity.StudentEntity as s where s.rollNo< :maxroll";
		Query<StudentEntity> query = session.createQuery(hbl);
		query.setParameter("maxroll", 10);
		
		List<StudentEntity> list = query.list();
		
		return list;
	}
	
	public static List<StudentEntity> getNative(Session session)
	{
		//native query....we can use sql level queries directly
		
		//in nativequery we will use table fields in queries same as sql queries
		
		String hql ="select * from iet_student where roll_no < :maxno";
		
		Query<StudentEntity> query = session.createNativeQuery(hql, StudentEntity.class);
		query.setParameter("maxno", 9);
		List<StudentEntity> list = query.list();
		
		return list;
		
	}
	//String sql = "update iet_student set name= pranav where id =10";
	
	private static void update(Session session) {
		
		Transaction tx = session.beginTransaction();
		StudentEntity obj = session.find(StudentEntity.class, 1);
		obj.setName("don");
		tx.commit();
	}
	
	private static void delete(Session session)
	{
		Transaction t = session.beginTransaction();
		StudentEntity obj = session.find(StudentEntity.class, 10);
		//select * from iet_student where id = 2;
		if(obj != null)
		{
			session.delete(obj);
		}
		t.commit();
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
