package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Regression Testing
//First we need to add @Regression tag to required Scenarios
//Next run this class
@CucumberOptions(features= {"src\\test\\resources\\features"},
				 glue= {"gluecode"},
				 tags="@Regression",
				 monochrome=true,
				 plugin= {"pretty","html:target/regressiontestres","rerun:target/failedregressiontests.txt"}	 
				)
public class Runner4 extends AbstractTestNGCucumberTests 
{

}
