package gluecode;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class StepDefs2 
{
	//Aggregation
	public Shared sh;

	public StepDefs2(Shared sh) //argument should be passing by pico-container
	{
		this.sh=sh;
	}
	
	@When("submit request via post with {string},{string},{string},and {string} to service")
	public void meythod9(String x, String y, String z, String w) 
	{
		//Put data to be posted in json format as pairs for request body
		JSONObject jo=new JSONObject(); //related to java-json jar
		jo.put("userId",x);
		jo.put("id",y);
		jo.put("title",z);
		jo.put("body",w);
	    sh.req.header("Content-Type","application/json");
	    sh.req.body(jo.toString());
	    sh.res=sh.req.post();
	}

	@Then("status code is {string} as per {string} and content type is {string}")
	public void method10(String x, String y, String z)
	{
		int esc=Integer.parseInt(x);
		int asc=sh.res.getStatusCode();
		String ect=z;
		String act=sh.res.getContentType();
	    if(asc==esc && act.contains(ect))
	    {
	    	sh.s.log("Test passed for criteria "+y);
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	sh.s.log("Test failed for criteria "+y);
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("validate the restful service")
	public void method11(DataTable dt)
	{
	    List<Map<String,String>> l=dt.asMaps();
	    //Do not skip 1st row because that row values are working as keys in maps 
	    for(int i=0;i<l.size();i++)
	    {
	    	//create request
	    	sh.req=RestAssured.given();
	    	//put data to be posted in JSON format as pairs for request body
	    	JSONObject jo=new JSONObject();
			jo.put("userId",l.get(i).get("uid"));
			jo.put("id",l.get(i).get("id"));
			jo.put("title",l.get(i).get("title"));
			jo.put("body",l.get(i).get("body"));
			sh.req.header("Content-Type","application/json");
		    sh.req.body(jo.toString());
		    //submit request through POST method
		    sh.res=sh.req.post();
		    //validate response
		    int esc=Integer.parseInt(l.get(i).get("sc"));
		    int asc=sh.res.getStatusCode();
		    if(asc==esc)
		    {
		    	sh.s.log("Test passed for criteria "+l.get(i).get("criteria"));
		    	Assert.assertTrue(true);
		    }
		    else
		    {
		    	sh.s.log("Test failed for criteria "+l.get(i).get("criteria"));
		    	Assert.assertTrue(false);
		    }    	
	    }
	}
}
