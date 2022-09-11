package com.backsoul.forms;

import org.json.JSONObject;

public class BodyData {
    public JSONObject User;
    public JSONObject Payload;
    public JSONObject jsonObject;

    public BodyData(String bodyData) {
        JSONObject jsonObject = new JSONObject(bodyData);
        this.jsonObject = jsonObject;

    }

    public String getUserValue(String attribute) {
        return this.jsonObject.getJSONObject("user").getString(attribute);
    }

    public String getPayloadValue(String attribute) {
        if (this.jsonObject.get("payload") != "") {
            String payload = this.jsonObject.getString("payload").toString();
            JSONObject jsonObject = new JSONObject(payload);
            return (String) jsonObject.get(attribute).toString();
        }
        return "";
    }

}
