package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class x extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return new StringBuilder(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        StringBuilder sb2 = (StringBuilder) obj;
        if (sb2 == null) {
            str = null;
        } else {
            str = sb2.toString();
        }
        jsonWriter.value(str);
    }
}
