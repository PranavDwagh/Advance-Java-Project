package staticBlock;

public class StacticBlockEx {
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("staticBlock.StaticBlock");
//		Class.forName("StaticBlock");            // both are ok

		StaticBlock.staticBlockMethod();          // Static method can be called with classname
		


	}
}


class StaticBlock {
	
	static {
		System.out.println("This is static block");
	}
	
	public static void staticBlockMethod()
	{
		System.out.println("Method of static block class");
	}
	
}
