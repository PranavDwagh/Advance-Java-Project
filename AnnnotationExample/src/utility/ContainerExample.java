package utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import annotation.RedSticker;

public class ContainerExample {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class csobj = new Myutility().getClass();
		
		Method [] method = csobj.getMethods();
		
		for(Method m : method)
		{
			if(m.isAnnotationPresent(RedSticker.class))
			{
				System.out.println(new Date());
				m.invoke(new Myutility(), null);
			}
			else
			{
				m.invoke(new Myutility(), null);
			}
		}
		
		
		
	}
}
