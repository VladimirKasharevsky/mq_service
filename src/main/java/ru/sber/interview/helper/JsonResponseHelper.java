package ru.sber.interview.helper;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonResponseHelper {

    public JsonResponseHelper(){

    }

    public String jsonResponse (String status, String message ){

        JSONObject obj = new JSONObject();
        obj.put("success", status);
        obj.put("message", message);

        return  obj.toJSONString();
    }
}
