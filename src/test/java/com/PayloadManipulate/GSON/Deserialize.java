package com.PayloadManipulate.GSON;

import com.PayloadManipulate.SerializeDesirialize.Booking;
import com.PayloadManipulate.SerializeDesirialize.BookingDates;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Deserialize {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("Get all the repositories of the user")
    @Test
    public void testNonBddStyle() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        String jsonString = "{\n" +
                "    \"firstname\": \"raghav\",\n" +
                "    \"lastname\": \"chaddha\",\n" +
                "    \"totalprice\": 123,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2024-02-01\",\n" +
                "        \"checkout\": \"2024-02-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Dinner\"\n" +
                "}";

        //Deserialization =  JSON to Object String using GSON Library
        Gson gson = new Gson();

        Booking booking = gson.fromJson(jsonString,Booking.class);

        System.out.println(booking);

        int totalPrice = booking.getTotalprice();
        System.out.println(totalPrice + " totalprice ");
        System.out.println("**********************");
     //   System.out.println(JSONStringPayload);
    }
}
