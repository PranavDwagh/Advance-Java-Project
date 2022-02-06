package cal;
public class MyCalculator implements Calculator{

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}

	@Override
	public float div(int a, int b) {
		
		return a/b;
	}
}

