package com.qa.restassuredexamples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestSpecificationExampleTest {

    @Test
    public void validateGetBookingDetailsByInvalidIdUsingRestAssuredAssertion() {
         RestAssured.given()
        .baseUri("https://restful-booker.herokuapp.com")
        .header("x-api-key", "PMAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
        .when()
        .get("/booking/4023")
        .then()
        .log().ifValidationFails()
        .assertThat().statusCode(404);

    }

    @Test
    public void validateGetBookingDetailsByInvalidIdUsingTestNGAssertion() {
        Response getResponse=RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("x-api-key", "PMAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
                .when()
                .get("/booking/4040")
                .then()
                .log().ifError()
                .extract().response();

        Assert.assertEquals(getResponse.statusCode(),404);
        Assert.assertEquals(getResponse.getBody().asString(),"Not Found");

    }
}
