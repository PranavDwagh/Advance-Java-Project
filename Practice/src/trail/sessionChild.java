package trail;

public class sessionChild implements Session {

	@Override
	public Session getSession() {
		
		Session s = new sessionChild();
		
		return s;
	}
	
	public int  addSessionChild()
	{
		System.out.println("In session child");
		return 0;
	}

	
	public static void mul() {
		System.out.println("this is mul in child");
		
	}

	@Override
	public QueryChild createQuery(String q) {
		
		QueryChild query = new QueryChild();
		
		return query;
		
	}

	
}
