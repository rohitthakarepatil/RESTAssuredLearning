package com.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetHeroku {

    RequestSpecification rs = RestAssured.given();
    @Test
    public void getRequestNonBDDPositive(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/3063");

        rs.when().log().all().get();

        rs.then().log().all().statusCode(200);

        //need to validate repsonse data as well

    }
    @Test
    public void getRequestNonBDDNegative(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/-1");

        rs.when().log().all().get();

        rs.then().log().all().statusCode(404);

        //need to validate repsonse data as well

    }


}
