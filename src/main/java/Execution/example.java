package Execution;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class example {

	public static void submit()
	{
		System.out.println("login method");
	}
	
	public static void main(String[] args)
	{
		String Expectedresult="Welcome to home page";
		String actualresult="Welcome to home pag";
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(Expectedresult, actualresult, "Error message is not matched");
		submit();
		sa.assertAll();

	}

}
