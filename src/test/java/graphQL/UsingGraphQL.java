package graphQL;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsingGraphQL {

	public static void main(String[] args) {

		// graphql code
		String q = "query {\r\n"
		+ "country(code:\"IN\")\r\n" 
		+ "{\r\n" + "name\r\n" 
		+ "capital\r\n" 
		+ "}\r\n"
		+ "}\r\n"
		+ "";
		JSONObject payload = new JSONObject();// convert your query into a format which your API going to understand

		payload.put("query", q);
		String requestbody = payload.toString();
		Response response = RestAssured.given().baseUri("https://countries.trevorblades.com/")

				.header("content-type", "application/json").body(requestbody).when().post();
		System.out.println("Status code is" + response.statusCode());
		System.out.println("The entire reponse is" + response.prettyPrint());//convert into pretty format

		String countryname = response.jsonPath().getString("data.country.name");//get the values which we want to
		String countrycapital = response.jsonPath().getString("data.country.capital");
		System.out.println(countryname);
		System.out.println(countrycapital);
	}

}
