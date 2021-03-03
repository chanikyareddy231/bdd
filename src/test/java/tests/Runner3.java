package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//For re Testing
@CucumberOptions(features= {"@target/failedrealtests.txt"},
				 monochrome=true,
				 plugin= {"pretty","html:target/retestres","rerun:target/failedretests.txt"}	 
				)
public class Runner3 extends AbstractTestNGCucumberTests 
{

}
