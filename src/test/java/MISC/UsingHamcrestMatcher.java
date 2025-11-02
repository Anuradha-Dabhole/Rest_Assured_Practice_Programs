package MISC;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsingHamcrestMatcher {
public static void main(String[] args) 
{
String Response=RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
given().log().all()
.when().get("posts/1")

.then().log().all()
.body("userId", equalTo(1))
.body("title",notNullValue())
.body("title", startsWith("sun"))
.body("title", endsWith("cto"))
.body("id", greaterThan(0))
.body("id", lessThan(17))
.body("title", containsString("aut"))
//.body("Body", hasItem("suscipit"))
.extract().response().asString();
System.out.println(Response);

	}

}
