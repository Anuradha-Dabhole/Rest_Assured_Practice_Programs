package mypractice1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class MyTest1 {

	public static void main(String[] args) throws Exception {
        
	RestAssured.baseURI="https://reqres.in";
	
	 Response res=  given().log().all()//don't want to print each and everything in "when" so write the log.all && send the request
	 .header("x-api-key", "reqres-free-v1") //passing api keys-values
	.when().get("api/users/2")//passing the endpoint
	
	.then().log().all()//display the JSON format & check the response time means validate
	.assertThat().statusCode(200).extract().response();
	String resString=res.asString();//convert into string format
	
	System.out.println(resString);
	
	
	long resTime=res.getTime();
	
	if(resTime>5000)
	{
		throw new Exception("Time limit exceeded");
		
	}
	else
	{
		System.out.println("Withthin Threshold time");
	}
	
	}

}
