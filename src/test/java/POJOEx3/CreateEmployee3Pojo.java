package POJOEx3;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateEmployee3Pojo {
	public static void main(String[] args) throws JsonProcessingException {
		EmployeeAddress3Pojo emp = new EmployeeAddress3Pojo();
		emp.setState("Maharashtra");
		emp.setCity("Kolhapur");
		emp.setPincode(41609);

		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("ICICI");
		banks.add("SBI");

		Empoyee3pojo emp1 = new Empoyee3pojo();
		emp1.setName("Arati");
		emp1.setJob("QA");
		emp1.setSalary(20000f);
		emp1.setIsmarried(false);
        emp1.setEmpAddress(emp);
        emp1.setBanks(banks);
        
        
        
        ObjectMapper n1 = new ObjectMapper();
        
       String JoinRequest= n1.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

RestAssured.baseURI="https://reqres.in/";//post example
String Response1=given().log().all()//send the URI
.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
.header("x-api-key","reqres-free-v1")
.body(JoinRequest)//pass the body

.when().post("api/users")//send the endpoint
.then().log().all()//validate the response code

.assertThat().statusCode(201)
.extract().response().asString();//Converts it to a String and stores it in the variable Response
System.out.println(JoinRequest);
System.out.println(Response1);
        
	}

}
