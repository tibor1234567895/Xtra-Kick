package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class m0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return Boolean.valueOf(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            str = "null";
        } else {
            str = bool.toString();
        }
        jsonWriter.value(str);
    }
}
