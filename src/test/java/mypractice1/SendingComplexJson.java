package mypractice1;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import payload.PayloadEx;

public class SendingComplexJson {

	public static void main(String[] args) {
        Map<String,Object> mp= new LinkedHashMap<String,Object>();
		mp.put("name","Harry");
		mp.put("job","QA lead");
		mp.put("location","Delhi");
		mp.put("saraly","50000");
 
		 Map<String,Object> mp2= new LinkedHashMap<String,Object>();
			mp2.put("name","tom");
			mp2.put("job","QA analyst");
			mp2.put("location","Mumbai");
			mp2.put("saraly","80000");
              
			 Map<String,Object> mp3= new LinkedHashMap<String,Object>();
				mp3.put("name","John");
				mp3.put("job","QA manager");
				mp3.put("location","pune");
				mp3.put("saraly","40000");
				
				
				List<Map> li=new ArrayList<Map>();
				li.add(mp);
				li.add(mp2);
				li.add(mp3);
				
				
				
				RestAssured.baseURI="https://reqres.in/";//post example
				String Response=given().log().all()//send the URI
				.header("content-type","application/json")//This tells the server that the request body will be in JSON format.
				.header("x-api-key","reqres-free-v1")
				.body(li)//pass the body
				
				.when().post("api/users")//send the endpoint
				.then().log().all()//validate the response code
				
				.assertThat().statusCode(201)
				.extract().response().asString();//Converts it to a String and stores it in the variable Response
				System.out.println(Response);

	}

}
