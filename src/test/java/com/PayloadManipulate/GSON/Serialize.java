package com.PayloadManipulate.GSON;

import com.PayloadManipulate.SerializeDesirialize.Booking;
import com.PayloadManipulate.SerializeDesirialize.BookingDates;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Serialize {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("Get all the repositories of the user")
    @Test
    public void testNonBddStyle() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("raghav");
        booking.setLastname("chaddha");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Dinner");


        System.out.println(booking.toString());


        //Serialization = Object to JSON String using GSON Library
        Gson gson = new Gson();
        String JSONStringPayload = gson.toJson(booking);

        System.out.println("**********************");
        System.out.println(JSONStringPayload);

//        r.baseUri(BASE_URL);
//        r.basePath(BASE_PATH);
//        r.contentType(ContentType.JSON).log().all();
//        r.body(booking);
    }
}