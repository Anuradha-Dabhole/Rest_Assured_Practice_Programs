package mypractice1;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class UsingStaticPayload {

	public static void main(String[] args) throws IOException {
		 RestAssured.baseURI="https://reqres.in/";
		String Response= given().log().all().header("content-type","application/json")
			       .header("x-api-key","reqres-free-v1")
			         .body(new String (Files.readAllBytes(Paths.get("E:/Study Material/StaticPayloadData07thoct2025.txt"))))
			         .when().post("api/users")
			         .then().log().all().
			         assertThat().
			         statusCode(201).
			         extract().
			         response().
			         asString();
		System.out.println(Response);
	}
	}



