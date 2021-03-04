package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//For Smoke Testing in api testing
@CucumberOptions(features= {"src\\test\\resources\\features"},
				 glue= {"gluecode"},
				 tags="@smoketest",
				 monochrome=true,
				 plugin= {"pretty","html:target/smoketestres","rerun:target/failedsmolketest.txt"}	 
				)
public class Runner1 extends AbstractTestNGCucumberTests 
{
}
