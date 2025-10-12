package AuthenticationEx;

import io.restassured.RestAssured;
import payload.PayloadEx;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthentication {

	public static void main(String[] args) {
		RestAssured.baseURI="https://gorest.co.in";
		
		
		
		String token="Bearer 9226bc7adf96465128571e49ad3b328269965db03deb135bf81f91b8f1683210";
		
		
		
	String Response=	given().log().all().header("Authorization",token).header("content-type","application/json")
		.body(PayloadEx.Gorestpayload())
		.when().post("public/v2/users")
		.then().log().all()
        .assertThat().statusCode(201)
        .extract().response().asString();
	System.out.println("This is response"+Response);
		
		
	}
}
