package com.qa.restassured;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecification {

    @Test
    public void ValidateStatusCode() {
        RequestSpecification requestSpecification = given()
        .baseUri("https://restful-booker.herokuapp.com")
        .header("x-api-key", "PMAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
        .given(requestSpecification)
        .when()
        .get("/booking/1010")
        .then()
        .log().all()
        .assertThat().statusCode(200);

    }
}
