package gluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Shared 
{
	public RequestSpecification req; //related to rest-assured
	public Response res; // related to rest-assured
	public Scenario s; // related to cucumber-java
	
	@Before
	public void mehtod1(Scenario s)
	{
		this.s=s;
	}
	
	@After
	public void mehtod2(Scenario s)
	{
		System.out.println(s.getName()+" is "+s.getStatus().name());
	}
}
