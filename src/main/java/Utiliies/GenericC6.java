package Utiliies;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Qa.Facebook.baseP5.BaseC6;



public class GenericC6 extends  BaseC6
{
	
	//take a screenshot in selenium
	public static String captureScreenShot() throws IOException 
	{
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		//we are Takescreenshot as interface and Cast the WebDriver instance to TakesScreenshot
			
		File scrfile=tc.getScreenshotAs(OutputType.FILE);
			
		
		File destfile=new File("D://KPHP//"+"ScreenCaptue"+System.currentTimeMillis()+".png");
		
		FileUtils.copyFile(scrfile, destfile);
		//FileHandler.copy(scrfile, destfile);
		
		return destfile.getAbsolutePath();
	}	
	
	
	
	
	//added genric method for Drag and Drop ---Mahesh 08/12/25
			public static void DragandDrop(By Source,By destination)
			{
				Actions Act= new Actions(driver);
				Act.dragAndDrop(getElement(Source), getElement(destination)).build().perform();
			}
			
			public static void Explict_WebElementClick(int time,By link)
			{
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));

		    	wait.until(ExpectedConditions.elementToBeClickable(getElement(link)));
			}
			
			//added generic method for scroll to page end
			public static void page_downtillend()
			{
				Actions Act= new Actions(driver);
				//window--control
				//Mac--cammnd
				Act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
				
			}
			
			//added generic method for scroll to page up
			public static void page_downtillup()
			{
				Actions Act= new Actions(driver);
				//window--control
				//Mac--cammnd
				Act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
				
			}
			//added generic method for scroll to element and click
			public static void Scroll_viewandclick(By link)
			{
				Actions Act= new Actions(driver);
				Act.scrollToElement(getElement(link)).build().perform();
				Act.click(getElement(link)).build().perform();
				
			}
			//added generic method for ShiftKeysandsendkeys
			public static void ShiftKeysandsendkeys(By inputID,String text)
			{
				Actions Act= new Actions(driver);
			Act.keyDown(Keys.SHIFT).sendKeys(getElement(inputID)).sendKeys(text).build().perform();
		
			}
			
			public static void copyandpaste(By input) throws InterruptedException
			{
				getElement(input).click();
				Thread.sleep(4000);
				Actions actions = new Actions(driver);

		        // Select all text in the source input (Ctrl + A)
		        actions.keyDown(Keys.CONTROL)
		               .sendKeys("a")
		               .keyUp(Keys.CONTROL)
		               .build().perform();

		        // Copy the selected text (Ctrl + C)
		        actions.keyDown(Keys.CONTROL)
		               .sendKeys("c")
		               .keyUp(Keys.CONTROL)
		               .build().perform();
		
		        actions.keyDown(Keys.TAB);
		        
		        actions.keyDown(Keys.CONTROL)
	            .sendKeys("v")
	            .keyUp(Keys.CONTROL)
	            .build().perform();
		        
			}
			
			
			//added generic method for rightlcick
			public static void Rightclick(By Source)
			{
				Actions Act= new Actions(driver);
				Act.contextClick(getElement(Source)).build().perform();
			}
			
			// added generic method for mouse over  --Mahesh 08/12/25
			public static void MouseOver(By parentMenu, By Childmenu) 
			{
				Actions Act= new Actions(driver);

				Act.moveToElement(getElement(parentMenu)).build().perform();
				
				getElement(Childmenu).click();	
			}
		
			// added generic method for returning webelement   --Mahesh 09/12/25
			public static WebElement getElement(By locator)
			{
				return driver.findElement(locator);
			}
			
			public static void alerts_accept()
			{
				driver.switchTo().alert().accept();
			}
			public static void alerts_cancel()
			{
				driver.switchTo().alert().dismiss();
			}
			public static String getalertsText()
			{
				return driver.switchTo().alert().getText();
			}
			
			public static void Send_alerts(String text)
			{
				driver.switchTo().alert().sendKeys(text);
			}

}
