package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.t;
import java.math.BigInteger;

public final class w extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new BigInteger(jsonReader.nextString());
        } catch (NumberFormatException e10) {
            throw new t((Exception) e10);
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((Number) (BigInteger) obj);
    }
}
