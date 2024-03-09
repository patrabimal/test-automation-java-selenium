package com.qa.apitests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.EnvironmentConfig;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingByIdTest {
    @Test
    public void validateGetBookingDetailsByInvalidId() {
        Response getBookingDetails= RestAssured.given()
                .baseUri(EnvironmentConfig.getBaseURLApi())
                .when()
                .get(EnvironmentConfig.getBookingById()+"/4040")
                .then()
                .log().ifError()
                .extract().response();

        Assert.assertEquals(getBookingDetails.statusCode(),404);
        Assert.assertEquals(getBookingDetails.getBody().asString(),"Not Found");

    }

    @Test
    public void validateGetBookingDetailsByValidId() {

        Response getBookingDetails= RestAssured.given()
                .baseUri(EnvironmentConfig.getBaseURLApi())
                .when()
                .get(EnvironmentConfig.getBookingById()+"/329")
                .then()
                .log().ifError()
                .extract().response();

        Assert.assertEquals(getBookingDetails.statusCode(),200);

    }
}
