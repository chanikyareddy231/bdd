package gluecode;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class StepDefs1 

{
	
	//Aggregation
	public Shared sh;

	public StepDefs1(Shared sh) //argument should be passing by pico-container
	{
		this.sh=sh;
	}
	
	@Given("register end point like {string}")
	public void method3(String u) 
	{
	    RestAssured.baseURI=u;
	}

	@Given("define HTTP request")
	public void mehtod4() 
	{
	    sh.req=RestAssured.given();
	}

	@When("submit request via get method to Restfull service")
	public void mehtod5() 
	{
	    sh.res=sh.req.get();
	}

	@Then("status code is {string} and content type is {string}")
	public void mehtod6(String sc,String ct) 
	{
		int esc=Integer.parseInt(sc);
	    if(sh.res.getStatusCode()==esc && sh.res.getHeader("Content-Type").contains(ct))
	    {
	    	sh.s.log("Test passed");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	sh.s.log("Test failed");
	    	Assert.assertTrue(false);
	    }
	}

	@When("submit request for id {string} via get method to Restfull service")
	public void method7(String x)
	{
	    sh.res=sh.req.get(x);
	}

	@Then("status code is {string} and id is {string} in json response")
	public void method8(String x, String y) 
	{
		int esc=Integer.parseInt(x);
	    if(sh.res.getStatusCode()==esc && sh.res.jsonPath().getString("id").equals(y))
	    {
	    	sh.s.log("Test passed");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	sh.s.log("Test failed");
	    	Assert.assertTrue(false);
	    }
	}
}
