package com.qa.restassured;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class StaticImports {

    public void simpleTestCase() {
        given().
                baseUri("https://restful-booker.herokuapp.com").header("x-api-key", "PMAK-659d4181012352002a6c4278-ec8e0bbf0d1f186092ed3ddf6dac9ecae0").
                when().
                get("/booking/1609").
                then().
                statusCode(200).
                body("firstname", is(equalTo("Bimal")),
                        "lastname", is(equalTo("Patra")));
    }
}
