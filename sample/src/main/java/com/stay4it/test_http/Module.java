package com.stay4it.test_http;

import com.google.gson.stream.JsonReader;
import com.stay4it.http.error.AppException;
import com.stay4it.http.entities.JsonReaderable;

import java.io.IOException;

/**
 * Created by Stay on 14/7/15.
 * Powered by www.stay4it.com
 */
public class Module implements JsonReaderable {
    public String name;
    public long timestamp;

    @Override
    public void readFromJson(JsonReader reader) throws AppException {
        try {
            reader.beginObject();
            String node ;
            while (reader.hasNext()) {
                node = reader.nextName();
                if ("name".equalsIgnoreCase(node)) {
                    name = reader.nextString();
                } else if ("timestamp".equalsIgnoreCase(node)) {
                    timestamp = reader.nextLong();
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
