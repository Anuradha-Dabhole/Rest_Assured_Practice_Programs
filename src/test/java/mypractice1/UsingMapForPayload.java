package mypractice1;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;



public class UsingMapForPayload {

	public static void main(String[] args) {
         RestAssured.baseURI="https://reqres.in/";
         //----create a Map----
         Map<String,Object> mp=new LinkedHashMap<String,Object>();
         mp.put("name", "Jack");
         mp.put("job", "QAlead");
         mp.put("salary", "60000f");
         mp.put("is married", true);
         
         String Response= given().log().all().header("content-type","application/json")
       .header("x-api-key","reqres-free-v1")
         .body(mp)
         .when().post("api/users")
         .then().log().all().
         assertThat().statusCode(201)
         .extract().response().asString();
         System.out.println(Response);
        //validate the out of json response value 
       JsonPath js = new JsonPath(Response);
       
     String createdDate=  js.get("createdAt");
     
     String [] s1=createdDate.split("T");
     
     System.out.println(s1[0]);
  
    Assert.assertEquals(s1[0], java.time.LocalDate.now().toString());
    System.out.println("Assertion passed!!");
     
     
     
     
              
	}

}
