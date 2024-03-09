package com.qa.restassuredexamples;

import static io.restassured.RestAssured.given;

public class GetResponseValue {

    @org.testng.annotations.Test
    public void extractSingleValueFromResponse() {
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
    }
}
