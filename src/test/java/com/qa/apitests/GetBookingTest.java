package com.qa.apitests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.EnvironmentConfig;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetBookingTest {
    @Test
    public void validateResponseContainsAllBookingIds() {
        Response getAllBookingIds= RestAssured.given()
                .baseUri(EnvironmentConfig.getBaseURLApi())
                .when()
                .get(EnvironmentConfig.getBooking())
                .then()
                .log().ifError()
                .extract().response();

        Assert.assertEquals(getAllBookingIds.statusCode(),200);
        // Check Schema : https://jsonschema.net/app/schemas/0
        getAllBookingIds.then()
        .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get-booking-ids-schema.json"));
        // Validate response is an array and it is not empty

    }
}
