package com.qa.restassured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetResponse {
    @Test
    public void extractResponse() {
        Response response = given().
                baseUri("https://restful-booker.herokuapp.com").
                header("x-api-key", "PMAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7").
                when().
                get("/booking/3074").
                then().
                log().all().
                assertThat().statusCode(200).
                extract().response();
    }
}
