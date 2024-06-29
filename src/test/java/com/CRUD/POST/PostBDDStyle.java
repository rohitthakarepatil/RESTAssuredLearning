package com.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostBDDStyle {
    String BaseURI = "https://restful-booker.herokuapp.com";
    String BasePath = "/booking";
    String payload = "{\n" +
            "    \"firstname\": \"Jim\",\n" +
            "    \"lastname\": \"Brown\",\n" +
            "    \"totalprice\": 111,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2018-01-01\",\n" +
            "        \"checkout\": \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    @Test
    public void PostRequestBDDStyle(){
        RestAssured
                .given().baseUri(BaseURI).basePath(BasePath).contentType(ContentType.JSON).log().all().body(payload)
                .when().post()
                .then().log().all().statusCode(200);
    }

}
