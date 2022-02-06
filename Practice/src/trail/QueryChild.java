package trail;

import java.util.ArrayList;
import java.util.List;

public class QueryChild implements Query {

	@Override
	public Query getQuery() {
		
		Query query = new QueryChild();
		
		return query;
	}

	@Override
	public List<String> list() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		return list;
	}
	
}
