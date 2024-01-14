package com.qa.restassured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HamcrestAssertPractice {

    @org.testng.annotations.Test
    public void hamcrestAssertOnExtractedResponse() {
        String name = given().
                baseUri("https://restful-booker.herokuapp.com").
                header("x-api-key", "PMAK-659d4181012352002a6c4278-ec8e0bbf0d1f186092ed3ddf6dac9ecae0").
                when().
                get("/booking/4083").
                then().
                log().all().
                assertThat().statusCode(200).
                extract().response().path("firstname");
        System.out.println("First Name is = " + name);
        assertThat(name,equalTo("Bimal"));
    }
}
