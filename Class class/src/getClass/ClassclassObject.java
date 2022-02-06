package getClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassclassObject {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//Class obj = java.lang.Thread.class;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the class");
		
		String str = sc.next();
		
		Class obj = Class.forName(str);
		
		String str2 = new String();
		System.out.println(obj.newInstance());
		
		showInfo(obj);
		
	}
	
	public static void showInfo(Class obj)
	{
		Field  [] feild =  obj.getFields();
		
		for (Field f : feild)
		{
			System.out.println(f.getName());
			System.out.println(f.getType());
			
			int modifier = obj.getModifiers();
			
			System.out.println(Modifier.toString(modifier)+"-->");
		}
		
	}
	
	
	
}
