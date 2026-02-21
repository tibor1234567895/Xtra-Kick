package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.UUID;

public final class d0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return UUID.fromString(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        UUID uuid = (UUID) obj;
        if (uuid == null) {
            str = null;
        } else {
            str = uuid.toString();
        }
        jsonWriter.value(str);
    }
}
