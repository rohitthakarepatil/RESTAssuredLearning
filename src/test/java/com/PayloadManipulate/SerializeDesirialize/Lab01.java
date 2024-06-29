package com.PayloadManipulate.SerializeDesirialize;

import com.github.javafaker.Faker;
import com.github.javafaker.Food;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab01 {

RequestSpecification r = RestAssured.given();
Response response;
ValidatableResponse validatableResponse;

@Description("Get all the repositories of the user")
@Test
    public void testNonBddStyle() {

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    Food food = faker.food();


    String payload = "{\n" +
            "    \"firstname\" : \"" + firstName + "\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"" + food + "\"\n" +
            "}";

    r.baseUri(BASE_URL);
    r.basePath(BASE_PATH);
    r.contentType(ContentType.JSON).log().all();
    r.body(payload);

    response = r.when().log().all().post();
    String responseString = response.asString();
    System.out.println(responseString);


    validatableResponse = response.then();
    validatableResponse.statusCode(200);

}}