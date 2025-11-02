package MISC;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;

public class FileasInput {

	public static void main(String[] args) {
		
	File f = new File("E:\\Study Material\\My file.txt");
	File f2 = new File("‪E:\\Study Material\\StaticPayloadData07thoct2025.txt");
		RestAssured.baseURI="https://httpbin.org";//post example
		
		String Response=given().log().all()//send the URI
		//header("Content-Type","multipart/form-data")//This tells the server that the request body will be in JSON format.
		.multiPart("File",f.exists())//f=name of the file
		.multiPart("File",f2.exists())
		
		.when().post("/post")//send the endpoint
		
		.then().log().all().extract().response().asString();//validate the response code
	
		System.out.println(Response);
	}//E:/Study Material/My file.txt
}
//E:/Study Material/StaticPayloadData07thoct2025.txt