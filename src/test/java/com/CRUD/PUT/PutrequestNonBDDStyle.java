package com.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PutrequestNonBDDStyle {

    RequestSpecification rs = RestAssured.given();
    Response res;
    ValidatableResponse vr;

    String bookingId = "4485";
    String token = "344575c20ecc9af";

    String payload = "{\n" +
            "    \"firstname\": \"sagar\",\n" +
            "    \"lastname\": \"Brown\",\n" +
            "    \"totalprice\": 111,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2018-01-01\",\n" +
            "        \"checkout\": \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    String BaseURI = "https://restful-booker.herokuapp.com";
    String BasePath = "/booking";
    String basepathUpdate = BasePath +"/" + bookingId;
    @Test
    public void updateRecord(){
        rs.baseUri(BaseURI);
        rs.basePath(basepathUpdate);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(payload);

        res = rs.when().log().all().put();

        vr = res.then().log().all();
        vr.body("firstname", Matchers.equalTo("sagar"));
        vr.body("lastname", Matchers.equalTo("Brown"));

        vr.statusCode(200);

    }
}
