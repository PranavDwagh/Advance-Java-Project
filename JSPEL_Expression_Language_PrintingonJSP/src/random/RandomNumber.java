package random;
import java.util.Random;

public class RandomNumber {
		
	private int upper;
	
	public RandomNumber(int uc)
	{
		upper = uc ;
	}
	
	public int getRandomNumber()
	{
		Random rn = new Random();
		int random = rn.nextInt(upper);
		
		return random;
	}
	
	public String toString()
	{
		return "The random number is "+upper;
	}
	
	public int getUpper()
	{
		return upper;
	}
	public void setUpper(int uc)
	{
		upper = uc;
	}
}
