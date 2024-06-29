package com.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostNonBDDStyle {
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
    public void PostRequestNonBDDStyle(){
     RequestSpecification rs =  RestAssured.given();
         rs.baseUri(BaseURI);
         rs.basePath(BasePath);
         rs.contentType(ContentType.JSON);
         rs.log().all();
         rs.body(payload);
        Response res =  rs.when().log().all().post();
        System.out.println(res);
        System.out.println(res.asString());
        ValidatableResponse vres =  res.then().log().all();
        vres.statusCode(200);

    }
}
