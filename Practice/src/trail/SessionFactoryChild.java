package trail;

public class SessionFactoryChild implements SessionFactory{

	@Override
	public Session getFactoryBuilder() {
		
		Session s = new sessionChild();
		sessionChild d = new sessionChild();
		
		
		return s;
	
	}

	
	
	



}
