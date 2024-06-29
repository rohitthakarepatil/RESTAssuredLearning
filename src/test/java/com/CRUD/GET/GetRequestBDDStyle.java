package com.CRUD.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetRequestBDDStyle {

    //Two ways to creaT TEST CASES IN Rest Assured
    // BDD style - given, when, themn
    // Non bdd style - classes and ibjects

        //Get request - https://api.zippopotam.us/IN/5600061

        //base URL - https://api.zippopotam.us
        //base path - /IN/5600061
        //get method
        // no payload
        //header =?
        // Any authentication = no

        //verification
        //statis code
        //headers/
        //response body

        // BDD Style = given when then = gherkin syntax
        @Test
        public void getRequestBddStyle(){
            RestAssured

                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/560037")

                    .when().log().all().get()

                    .then().statusCode(200);

        }
}

