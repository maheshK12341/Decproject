package StepDefinations7;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Allpages.loginPage;
import Utiliies.GenericC6;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepdefination7 extends loginPage

{
@Given("User should be login page")
public static void User_should_be_loginpage() throws IOException
{
	browserInitzation();
	ExtentCucumberAdapter.addTestStepLog("Application is launched successfully");
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GenericC6.captureScreenShot());
}

@When("^user enters valid usernameParameter \"([^\"]*)\"$")
public static void  userentersvalid_usernameParameter(String username) throws IOException
{

	Enterusername(loginPage.getInputEmail(),username);
	ExtentCucumberAdapter.addTestStepLog("User is able eneterd username "+username );
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GenericC6.captureScreenShot());
}

@And("^user enters valid passwordParameter \"([^\"]*)\"$")
public static void userenters_valid_passwordParameter(String password) throws IOException
{
	Enterpassword(loginPage.getinputpassword(),password);
	ExtentCucumberAdapter.addTestStepLog("User is able eneterd password "+password );
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GenericC6.captureScreenShot());
}

@Then("System should generate the error message")
public static void Systemshould_generate_login_errormessage() throws InterruptedException, IOException
{
	Thread.sleep(5000);
	loginPage.Validatelogin_errormessage(loginPage.expectedText,loginPage.geterrorloginmessage());
	ExtentCucumberAdapter.addTestStepLog("Error message generated successfully and matched" );
	ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(GenericC6.captureScreenShot());
}


@When("user enters valid username {string}")
public static void userenters_valid_username(String username)
{
	Enterusername(loginPage.getInputEmail(),username);
}
	
@And("user enters valid password {string}")
public static void userenters_valid_password(String password)
{
	Enterpassword(loginPage.getinputpassword(),password);
}

@And("Clicks on submit")
public static void Clicksonsubmit()
{
	loginPage.getlogin().click();
}
@And("close the browser")
public static void closebrowser()
{
	browser_close();
}
}
