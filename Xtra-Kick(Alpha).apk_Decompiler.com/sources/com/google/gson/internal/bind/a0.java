package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.net.URL;

public final class a0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        if ("null".equals(nextString)) {
            return null;
        }
        return new URL(nextString);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        URL url = (URL) obj;
        if (url == null) {
            str = null;
        } else {
            str = url.toExternalForm();
        }
        jsonWriter.value(str);
    }
}
