package POJOEx;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import payload.PayloadEx;

public class CreateEmpolyee {

	public static void main(String[] args) throws JsonProcessingException {
		Empoyee1pojo emp=new Empoyee1pojo();//create the object of the 1st class
		emp.setName("Arati");
		emp.setJob("QA lead");
		emp.setIsmarried(false);
		emp.setSalary(150000f);
		//----This is a process of the converting the object into the JSON----//
ObjectMapper obj = new ObjectMapper();//helps you to read and write the JSON
String empJSON=obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);//serialization here

RestAssured.baseURI="https://reqres.in/";//post example
String Response=given().log().all()//send the URI
.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
.header("x-api-key","reqres-free-v1")
.body(empJSON)//pass the body

.when().post("api/users")//send the endpoint
.then().log().all()//validate the response code

.assertThat().statusCode(201)
.extract().response().asString();//Converts it to a String and stores it in the variable Response
System.out.println(Response);
//----converting the java object into the
Empoyee1pojo empobj=obj.readValue(Response,Empoyee1pojo.class);
String name1=empobj.getName();
String job1=empobj.getJob();
float sal1=empobj.getSalary();
boolean married1=empobj.isIsmarried();


System.out.println(name1+"  "+job1+" "+sal1+"  "+"  "+married1);






	}

}
