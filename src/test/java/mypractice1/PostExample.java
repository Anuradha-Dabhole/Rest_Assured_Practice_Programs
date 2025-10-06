package mypractice1;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import payload.PayloadEx;

import static io.restassured.RestAssured.*;

public class PostExample {

	public static void main(String[] args) {
           
		
		RestAssured.baseURI="https://reqres.in/";//post example
		String Response=given().log().all()//send the URI
		.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
		.header("x-api-key","reqres-free-v1")
		.body(PayloadEx.Addemp("Harry","qalead"))//pass the body
		
		.when().post("api/users")//send the endpoint
		.then().log().all()//validate the response code
		
		.assertThat().statusCode(201).header("content-type","application/json")
		.extract().response().asString();//Converts it to a String and stores it in the variable Response
		System.out.println(Response);
	}

}
