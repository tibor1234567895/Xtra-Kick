package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class r extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return Double.valueOf(jsonReader.nextDouble());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((Number) obj);
    }
}
