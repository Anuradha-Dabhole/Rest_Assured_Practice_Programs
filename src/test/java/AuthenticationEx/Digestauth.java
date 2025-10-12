package AuthenticationEx;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Digestauth {
public static void main(String[] args) {
RestAssured.baseURI="https://httpbin.org/digest-auth";
String Response=given().log().all().auth().digest("user","passwd")
.when().get("/auth/user/passwd")
.then().log().all().assertThat().statusCode(200)
.extract().response().asString();
System.out.println(Response);
	}

}
