package com.qa.apitests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.config.EnvironmentConfig;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateTokenTest {
        // @Test
        public void validateIfTokenIsGeneratedWithValidCredentials() {
                String requestBody = "{\"username\":\"admin\",\"password\":\"password123\"}";
                System.out.println(requestBody);
                Response getResponse = RestAssured.given()
                                .header("Content-Type", "application/json")
                                .baseUri(EnvironmentConfig.getBaseURLApi())
                                .when()
                                .body(requestBody)
                                .post(EnvironmentConfig.generateToken())
                                .then()
                                .log().ifError()
                                .extract().response();

                Assert.assertEquals(getResponse.statusCode(), 200);
                Assert.assertNotNull(getResponse.jsonPath().getString("token"));
        }

        @Test
        public void validateIfTokenIsGeneratedWithInvalidCredentials() {
                String requestBody = "{\"username\":\"admin\",\"password\":\"password124\"}";
                Response getResponse = RestAssured.given()
                        //.header("Content-Type", "application/json")
                        .baseUri(EnvironmentConfig.getBaseURLApi())
                        .when()
                        .body(requestBody)
                        .post(EnvironmentConfig.postCredential())
                        .then()
                        .log().ifError()
                        .extract().response();

                Assert.assertEquals(getResponse.statusCode(), 200);
                System.out.println(getResponse.getBody().asString());
                Assert.assertEquals(getResponse.getBody().asString(), "{\"reason\":\"Bad credentials\"}");
        }
}
