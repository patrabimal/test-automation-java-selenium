package com.qa.restassuredexamples;

import static io.restassured.RestAssured.given;

public class GetResponseBody {
    @org.testng.annotations.Test
    public void validateResponseBody() {
        given().
                baseUri("https://restful-booker.herokuapp.com").
                header("x-api-key", "PMAK-659d4181012352002a6c4278-ec8e0bbf0d1f186092ed3ddf6dac9ecae0").
                when().
                get("/booking/342").
                then().
                log().all().
                assertThat().statusCode(200);
        //.body("firstname",hashItems("Bimal"),"lastname",hasItems("Patra"));
    }
}
