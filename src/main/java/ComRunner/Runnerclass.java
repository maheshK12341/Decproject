package ComRunner;

import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"features7/login7.feature"},
                 glue =     {"StepDefinations7"},
                 plugin =    { "pretty","html:target/cucumber-reports",
    		     "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    		     "rerun:target/failedrerun.txt"},
                	tags="@sanity",        	
                  monochrome = true )

public class Runnerclass extends AbstractTestNGCucumberTests
{
	

}