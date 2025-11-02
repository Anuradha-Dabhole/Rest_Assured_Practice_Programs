package MISC;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UsingRelaxedHTTPSValidation {

	public static void main(String[] args) {
		String result = given()
	            .log().all()
	            .relaxedHTTPSValidation()   // Accepts invalid/self-signed SSL certs
	        .when()
	            .get("https://self-signed.badssl.com/")
	        .then()
	            .log().all()
	            .extract()
	            .asString();

	        System.out.println(result);
}

}
