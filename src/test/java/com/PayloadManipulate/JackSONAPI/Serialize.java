package com.PayloadManipulate.JackSONAPI;

import com.PayloadManipulate.SerializeDesirialize.Booking;
import com.PayloadManipulate.SerializeDesirialize.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void testNonBddStyle() throws JsonProcessingException {

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


        System.out.println(booking);

        ObjectMapper objMapper = new ObjectMapper();
        String jsonString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);

        System.out.println("**********************");
        System.out.println(jsonString);


    }

}
