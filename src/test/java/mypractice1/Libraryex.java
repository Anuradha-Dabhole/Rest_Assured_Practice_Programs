package mypractice1;

import static io.restassured.RestAssured.given;


import org.testng.Assert;

import payload.PayloadEx;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class LibraryEx {

public static void main(String[] args) 
{
	
	String ExpectedMessage="successfully added";
	RestAssured.baseURI="http://216.10.245.166";//send the base uri
	String isbn=Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0,4);
	Integer aisle=1000 + new java.util.Random().nextInt(9000);
	
	String ExpectedID = isbn + aisle.toString();
	
	String Response=given().log().all().header("Content-Type","application/json").//in the json format
	body(PayloadEx.getBookDetails(isbn, aisle)).
	when().post("Library/Addbook.php")//pass the end point(resources)
	.then().log().all().assertThat().statusCode(200)
	.extract().response().asString();
	
	 JsonPath js= new JsonPath(Response);//JavaScript Object Notation used for validate the response body
	  String Actualmessage=js.getString("Msg");//fetch the msg from  the postman response body
	 //-----msg validation with the help of assertion------
	Assert.assertEquals(Actualmessage, ExpectedMessage);//hard assert terminate the program and soft assert not terminate the program
	
	//----id validation----
	  String ActualID=js.getString("ID");//fetch id from postman response body
	  
	  Assert.assertEquals(ActualID, ExpectedID);
	  
	  System.out.println("Test case pass!!");

	}

}
