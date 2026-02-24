package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class l0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return Boolean.valueOf(peek == JsonToken.STRING ? Boolean.parseBoolean(jsonReader.nextString()) : jsonReader.nextBoolean());
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((Boolean) obj);
    }
}
