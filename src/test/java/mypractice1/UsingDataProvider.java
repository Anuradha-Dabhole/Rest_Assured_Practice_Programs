package mypractice1;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.PayloadEx;

public class UsingDataProvider {

	@DataProvider(name="booksdata")
public Object[] [] getData()
{
	return new Object[][]
			{
		{"Selenium java","shdsd","7746"},{"Coding","fhd","56473"},{"python","egdf","654783"}
			};
			
}
	
	@Test(dataProvider="booksdata")
	public void addbook(String bookname,String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";//send the base uri
		String Response=given().log().all().header("Content-Type","application/json").//in the json format
				body(PayloadEx.getBookDetails1(bookname,isbn, aisle)).
				when().log().all().post("Library/Addbook.php")//pass the end point(resources)
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
				
	}
	
}
