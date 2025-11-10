package POJOEx4;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import payload.PayloadEx;

public class CreateEmpAddress {
	public static void main(String args[])
	{
		Employee4 emp2=new Employee4();
	{
	
	emp2.setName("Arati");
	emp2.setJob("QA");
	emp2.setSalary(20000f);
	emp2.setMarried(false);
	
	Employee4 emp3=new Employee4();
	emp3.setName("Anu");
	emp3.setJob("Manager");
	emp3.setSalary(30000f);
	emp3.setMarried(false);
	
	Employee4 emp4=new Employee4();
	emp4.setName("Kedar");
	emp4.setJob("QA Analyst");
	emp4.setSalary(40000f);
	emp4.setMarried(false);
	List<Employee4>li=new ArrayList<Employee4>();
	li.add(emp4);
	li.add(emp3);
	li.add(emp2);
	ObjectMapper n1 = new ObjectMapper();
    
    String JoinRequest = null;
	try {
		JoinRequest = n1.writerWithDefaultPrettyPrinter().writeValueAsString(li);
	} catch (JsonProcessingException e) {
				e.printStackTrace();
	}

	RestAssured.baseURI="https://reqres.in/";//post example
	String Response=given().log().all()//send the URI
	.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
	.header("x-api-key","reqres-free-v1")
	.body(JoinRequest)//pass the body
	
	.when().post("api/users")//send the endpoint
	.then().log().all()//validate the response code
	
	.assertThat().statusCode(201).header("content-type","application/json")
	.extract().response().asString();//Converts it to a String and stores it in the variable Response
	System.out.println(Response);
	 
	
	}
	}
}
