package com.stay4it.test_http;

import com.google.gson.stream.JsonReader;
import com.stay4it.http.error.AppException;
import com.stay4it.http.entities.JsonReaderable;

import java.io.IOException;

/**
 * Created by Stay on 4/7/15.
 * Powered by www.stay4it.com
 */
public class User implements JsonReaderable {
    //    {"ret":200,"data":{"id":"2","account":"stay4it","email":"stay4it@163.com","username":"stay","password":"123456","avatar":"","token":"lI7oi96+8Q\/TIib9dSpy3mj7maC\/6ZEfI3HdwT\/ZwQI="},"msg":""}
    public String id;
    public String account;
    public String email;
    public String username;
    public String token;

    @Override
    public String toString() {


        return username + " : " + email;
    }

    @Override
    public void readFromJson(JsonReader reader) throws AppException {
        try {
            reader.beginObject();
            String node ;
            while (reader.hasNext()) {
                node = reader.nextName();
                if ("username".equalsIgnoreCase(node)) {
                    username = reader.nextString();
                } else if ("email".equalsIgnoreCase(node)) {
                    email = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            throw new AppException(AppException.ErrorType.JSON, e.getMessage());
        }
    }
}
