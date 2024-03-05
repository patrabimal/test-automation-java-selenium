package com.qa.restassured;

import io.restassured.config.LogConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class PracticeWithLogs {
 @Test
public void verifyResponseWithLogs() {
        given()
        .baseUri("https://restful-booker.herokuapp.com")
        .header("x-api-key", "PMAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
        .log().headers()
        .when()
        .get("/booking/2019")
        .then()
        .log().body()
        .assertThat()
        .statusCode(200);
}
        @Test
        public void verifyWithIfErrorLogs() {
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("x-api-key", "MAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
                .log().all()
                .when()
                .get("/booking/2019")
                .then()
                .log().ifError()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void verifyWithIfValidationFailsLogs() {
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("x-api-key", "MAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
                .log().ifValidationFails()
                .when()
                .get("/booking/2019")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(201);
    }

    @Test
    public void verifyWithIfValidationFailsLogsWithset() {
        Set<String> headers=new HashSet<String>();
        headers.add("x-api-key");
        headers.add("Accept");
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("x-api-key", "MAK-65a61915fb1cc57ce33451e6-f381c9710bd9ad1950681626aec7a728e7")
                //.config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key")))
                .config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
                .log().all()
                .when()
                .get("/booking/2019")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void verifyWithExtractResponseHeader() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("x-api-key", "value1");
        headers.put("Accept", "header");
        Headers extractedHeader = given()
                .baseUri("https://restful-booker.herokuapp.com")
                .headers(headers)
                .when()
                .get("/booking/2019")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .headers();

        for(Header header:extractedHeader){
            System.out.println("header name = " +header.getName() + ", ");
            System.out.println("header value = " +header.getValue());
        }
        System.out.println("header name = " +extractedHeader.get("responseHeader").getName());
        System.out.println("header value = " +extractedHeader.get("responseHeader").getValue());
        System.out.println("header name = " +extractedHeader.getValue("responseHeader"));
 }

@Test
public void verifyWithExtractMultiValueResponseHeader() {
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("x-api-key", "value1");
    headers.put("Accept", "header");
    Headers extractedHeader = given()
            .baseUri("https://restful-booker.herokuapp.com")
            .headers(headers)
            .when()
            .get("/booking/2019")
            .then()
            .assertThat()
            .statusCode(200)
            .extract()
            .headers();

    List<String> values= extractedHeader.getValues("multiValueHeader");
    for(String value:values){
        System.out.println(value);
    }
}
}
