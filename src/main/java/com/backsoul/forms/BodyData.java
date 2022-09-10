package com.backsoul.forms;

import org.json.JSONObject;

public class BodyData {
    public JSONObject User;
    public JSONObject Payload;

    public BodyData(String bodyData) {
        JSONObject jsonObject = new JSONObject(bodyData);
        System.out.println("--------------------------------");
        System.out.println(bodyData);
        System.out.println(!jsonObject.getString("payload").isEmpty());
        System.out.println("--------------------------------");
        this.User = jsonObject.getJSONObject("user");
        if (!jsonObject.getString("payload").isEmpty()) {
            this.Payload = jsonObject.getJSONObject("payload");
        }
    }

    public String getUserValue(String attribute) {
        return (String) this.User.get(attribute);
    }

    public String getPayloadValue(String attribute) {
        return (String) this.Payload.get(attribute);
    }

}
