package com.qa.restassured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetStatus {
    @org.testng.annotations.Test
    public void validateStatusCode() {
        given()
        .baseUri("https://restful-booker.herokuapp.com")
        .header("x-api-key", "PMAK-659d4181012352002a6c4278-ec8e0bbf0d1f186092ed3ddf6dac9ecae0")
        .when()
        .get("/booking/342")
        .then()
        .log().all() //output entire response in console
        .assertThat()
        .statusCode(200);
    }
}
