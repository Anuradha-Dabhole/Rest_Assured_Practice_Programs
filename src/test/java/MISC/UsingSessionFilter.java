package MISC;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import payload.PayloadEx;

public class UsingSessionFilter {

	SessionFilter sc = new SessionFilter();
	
	@BeforeTest
	public SessionFilter captureSessionId()
	{
		sc=new SessionFilter();
		return sc;
	}
	
	@Test
	public void myTest()
	{
		RestAssured.baseURI="https://reqres.in/";//create request
		String Response=  given().log().all().relaxedHTTPSValidation()
				.filter(sc)
				
				
		.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
		.header("x-api-key","reqres-free-v1")
		.body(PayloadEx.Addemp("Arati","QA"))//pass the body
		
		.when().post("api/users")//send the endpoint
		.then().log().all()//validate the response code
		
		.assertThat().statusCode(201)
		.extract().response().asString();//Converts it to a String and stores it in the variable Response
		System.out.println(Response);
	}
	@Test
	public void myTest2()
	{

		RestAssured.baseURI="https://reqres.in/";//delete request
		String Response=  given().log().all().relaxedHTTPSValidation()
				.filter(sc)
				
				
		
		.header("x-api-key","reqres-free-v1")
		
		
		.when().delete("api/users?page=2")//send the endpoint
		.then().log().all()//validate the response code
		
		.assertThat().statusCode(204)
		.extract().response().asString();
		System.out.println(Response);
	}
}
