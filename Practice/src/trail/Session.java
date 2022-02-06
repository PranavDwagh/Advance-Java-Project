package trail;

public interface Session {

	public Session getSession();
	
	public static void mul()
	{
		System.out.println("Static mul in interface");
	}
	
	public Query createQuery(String q);
	
	
}
