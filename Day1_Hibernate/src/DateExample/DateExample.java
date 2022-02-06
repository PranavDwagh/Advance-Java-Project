package DateExample;

import java.sql.Date;
import java.util.GregorianCalendar;

public class DateExample {
	
	
	public static void main(String[] args) {
		
		GregorianCalendar gc= new GregorianCalendar();
		long timeissecs = gc.getTimeInMillis();
		
		GregorianCalendar republicDay = new GregorianCalendar(2022, 0, 26);
		
		java.sql.Date date = new Date(republicDay.getTimeInMillis());
		
		System.out.println(date);
		
	}

	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2022, 01, 03);
	
		Date d = new Date(cal.getTimeInMillis());
		System.out.println(d);
		
	}
	
	
}
