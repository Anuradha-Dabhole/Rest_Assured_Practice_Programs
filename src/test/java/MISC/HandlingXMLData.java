package MISC;

import io.restassured.RestAssured;
import payload.PayloadEx;

import static io.restassured.RestAssured.*;
public class HandlingXMLData 
{
public static void main(String[] args) 
{
RestAssured.baseURI="https://petstore.swagger.io";
String Response=given().log().all().header("content-type","application/xml")
.body(PayloadEx.getXmldada(6))
.when().post("v2/pet")
.then().log().all()
.extract().response().asString();
System.out.println(Response);
	}

}
