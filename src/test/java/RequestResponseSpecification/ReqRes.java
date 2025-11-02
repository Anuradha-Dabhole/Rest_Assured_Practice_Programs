package RequestResponseSpecification;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.PayloadEx;

public class ReqRes {

	public static void main(String[] args) {
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.setContentType(ContentType.JSON).setRelaxedHTTPSValidation()
				.setBody(PayloadEx.Addemp("Harry","Manager"))
				.build();
		
		RequestSpecification respec = given().log().all().spec(req);
		
		ResponseSpecification res = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(201)
                .build();
		
		String Response=respec.header("x-api-key" ,"reqres-free-v1").body(PayloadEx.Addemp("Harry","Lead QA"))
		.when().post("api/users").then().log().all().spec(res).extract().response().asString();
		System.out.println(Response);
	}

}
