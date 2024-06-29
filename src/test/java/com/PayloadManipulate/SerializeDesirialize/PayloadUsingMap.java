package com.PayloadManipulate.SerializeDesirialize;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadUsingMap {

    @Test

    public void testPayloadUsingMap() {

        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("name", "Amit");
        payload.put("age", 25);
            payload.put("city", "Delhi");
            payload.put("married", false);
            payload.put("salary", 25000.0);
            payload.put("null", null);
            payload.put("empty", "");
            payload.put("boolean", true);
            payload.put("int", 1);
            payload.put("float", 1.1);

        System.out.println(payload);
        Gson gson = new Gson();
       String jsonPayload = gson.toJson(payload);
        System.out.println("%^^%^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(jsonPayload);
    }

}
