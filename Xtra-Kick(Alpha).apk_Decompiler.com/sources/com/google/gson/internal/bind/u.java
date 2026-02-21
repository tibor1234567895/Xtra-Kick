package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class u extends b0 {
    public final Object b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        if (peek != JsonToken.NULL) {
            return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((String) obj);
    }
}
