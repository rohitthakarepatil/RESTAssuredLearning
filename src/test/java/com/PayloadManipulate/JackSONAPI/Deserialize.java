package com.PayloadManipulate.JackSONAPI;

import com.PayloadManipulate.SerializeDesirialize.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Deserialize {

    String payload = "{\n" +
            "    \"firstname\" : \" abhay\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"machli pakoda\"\n" +
            "}";

    @Test
    public void deserialized () throws JsonProcessingException {
        ObjectMapper objmap = new ObjectMapper();
        Booking booking = objmap.readValue(payload, Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
        System.out.println(booking.getTotalprice());
        System.out.println(booking.getDepositpaid());
        System.out.println(booking.getBookingdates().getCheckin());
            System.out.println(booking.getBookingdates().getCheckout());
            System.out.println(booking.getAdditionalneeds());
    }
}


