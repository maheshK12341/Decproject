package Utiliies;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Qa.Facebook.baseP5.BaseC6;

public class Gen extends BaseC6
{
	public static By Emailid=By.id("email");

	// entering usernam and password
	//click
	//verify the title
	
	public static void Click_JS(WebElement ele)
	{
		JavascriptExecutor Js= (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].click();", ele);
	}
	
	
	public static void Switch_frameID(int index,WebElement ele)
	{
		driver.switchTo().frame(index);
		try
		{
			if( ele.isDisplayed())
			{
			Click_JS(ele);
			}
		}
		
		catch(Exception E)
		{
			driver.switchTo().defaultContent();
		}
			}
	
	public static WebElement GetElement(By id)
	{
		return driver.findElement(id);
		
	}
	public static String Getttitle()
	{
	return driver.getTitle();
	}
	
	public static void EnterInput(String Text,WebElement ele)
	
	{
		ele.sendKeys(Text);
	}
	
	public static void main(String[]a)
	{
		Getttitle();
		EnterInput("Testing@gmail.com",GetElement(Emailid));
		
	}

}
