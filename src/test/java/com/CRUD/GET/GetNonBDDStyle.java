package com.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetNonBDDStyle {

    //these we can reuse in next scenarios as well
    // thats why we prefer this over gherkin bdd style
    

    RequestSpecification rs = RestAssured.given();
    @Test
    public void getRequestNonBDD(){
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");

        rs.when().log().all().get();

        rs.then().log().all().statusCode(200);
    }


    @Test
    public void getRequestNonBDD2(){
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");

        rs.when().log().all().get();

        rs.then().log().all().statusCode(200);
    }
}
