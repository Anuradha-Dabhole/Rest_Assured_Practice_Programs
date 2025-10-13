package AuthenticationEx;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import payload.PayloadEx;

public class Fakerclass {

public static void main(String[] args) {

	Faker fake = new Faker();
	String Name=fake.name().fullName();
	String mail=fake.internet().emailAddress();
	String num=fake.phoneNumber().cellPhone();
	long salary=fake.number().randomNumber();
	
	Map<String,Object> m1= new LinkedHashMap<>();
	m1.put("name",Name);
	m1.put("internet",mail);
	m1.put("phoneNumber", num);
	m1.put("number", salary);
	
	RestAssured.baseURI="https://reqres.in/";//post example
	
	String Response=given().log().all()//send the URI
			
	.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
	.header("x-api-key","reqres-free-v1")
	.body(m1)//pass the body
	
	.when().post("api/users")//send the endpoint
	.then().log().all()//validate the response code
	
	.assertThat().statusCode(201)
	.extract().response().asString();//Converts it to a String and stores it in the variable Response
	System.out.println(Response);
	
	
	}

}
