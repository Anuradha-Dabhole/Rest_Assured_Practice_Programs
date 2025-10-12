package mypractice1;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetWithQueryParameter {

	public static void main(String[] args) {

		
		RestAssured.baseURI="https://reqres.in";
		
		String Response=given().log().all().queryParam("page",2)
		.when().get("api/users").then().log().all()
		.assertThat()
		.statusCode(200).extract().response().asString();
		System.out.println(Response);
		
		JsonPath js = new JsonPath(Response);//create an object of the json
		//---Fetch the json data 2nd value of this output---
		String ExpectedSecondFeature="Data Persistence";//String ActualSecondFeature=js.getString("_meta.features[2]");
		String ActualSecondFeature=js.getString("_meta.features[2]");
		Assert.assertEquals(ActualSecondFeature, ExpectedSecondFeature);
		
		//----fetch the last name which is present under the data----
		String expectednm=js.getString("data[0].last_name");
		String actualnm="Lawson";
		Assert.assertEquals(actualnm, expectednm);
		System.out.println("Validation is passed!!");
		
	}

}
