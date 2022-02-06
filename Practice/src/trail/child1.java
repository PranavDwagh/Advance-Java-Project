package trail;

public class child1 implements SessionFactory {

	

	@Override
	public Session getFactoryBuilder() {
		
		Session s = new sessionChild();	
		
		return s;
	}

	
	
	




}
