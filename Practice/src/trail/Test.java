package trail;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		SessionFactory s = new SessionFactoryChild();
		SessionFactory s1 = new SessionFactoryObject();

		sessionChild session = (sessionChild) s.getFactoryBuilder();

		session.addSessionChild();
		session.mul();

		String hbl = "trial";
		Query query = session.createQuery(hbl);
		
		List<String> list = query.list();
		
	}





}
