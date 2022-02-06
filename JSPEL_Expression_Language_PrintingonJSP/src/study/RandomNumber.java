package study;

import java.util.Random;

public class RandomNumber {
	
	int uppercap;
	
	@Override
	public String toString() {
		return "the upper cap is" + uppercap;
	}
	
	public RandomNumber(int uc)
	{
		uppercap =uc;
	}
	
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int rn = r.nextInt(uppercap);
		return rn;
	}

}
