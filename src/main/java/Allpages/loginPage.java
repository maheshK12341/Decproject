package Allpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.Qa.Facebook.baseP5.BaseC6;

public class loginPage extends  BaseC6
{

	private static By inputEmail=By.xpath("//input[@id='email']");
	private static By inputpassword=By.xpath("//input[@id='pass']");
	private static By buttonsubmit=By.xpath("//button[text()='Log in']");
	
	private static By errorloginmessage=By.xpath("//h1");
	
	public static String expectedText="Complete a challenge to verify you’re a human";
	
	public static String geterrorloginmessage()
	{
		return driver.findElement(errorloginmessage).getText();
	}
	
	public static void Validatelogin_errormessage(String ExpectedText,String actualText)
	{
		SoftAssert sa= new SoftAssert();
	
		sa.assertEquals(ExpectedText, actualText, "Error message is not matched");
		sa.assertAll();
	}
	
	public static WebElement getInputEmail()
	{
		
		return driver.findElement(inputEmail);
		
	}
	
	public static WebElement getinputpassword()
	{
		
		return driver.findElement(inputpassword);
		
	}
	
	public static WebElement getlogin()
	{
		
		return driver.findElement(buttonsubmit);
	}
		
	public static void Enterusername(WebElement getInputEmail,String inputUsername)
	{
		getInputEmail.sendKeys(inputUsername);;
	}
	
	
	
	public static void Enterpassword(WebElement getinputpassword,String inputpassword)
	{
		getinputpassword.sendKeys(inputpassword);
	}
	
	public static void login(WebElement getInputEmail, WebElement getinputpassword , WebElement getlogin, String username,String password)
	{
		getInputEmail.sendKeys(username);
		getinputpassword.sendKeys(password);
		getlogin().click();
		
	}
	

}
