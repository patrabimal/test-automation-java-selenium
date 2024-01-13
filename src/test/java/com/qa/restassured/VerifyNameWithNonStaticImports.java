package com.qa.restassured;

import io.restassured.RestAssured;

import org.hamcrest.Matchers;

public class VerifyNameWithNonStaticImports { //Program for Non-Static Imports

    public void shouldMatchFirstAndLastName() {
        RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").header("x-api-key", "PMAK-659d4181012352002a6c4278-ec8e0bbf0d1f186092ed3ddf6dac9ecae0").
                when().
                get("/booking/1609").
                then().
                statusCode(200).body("firstname", Matchers.is(Matchers.equalTo("Bimal")),
                        "lastname", Matchers.is(Matchers.equalTo("Patra")));
    }
}
