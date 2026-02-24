package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.t;
import java.net.URI;
import java.net.URISyntaxException;

public final class b0 extends j9.b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
        } else {
            try {
                String nextString = jsonReader.nextString();
                if (!"null".equals(nextString)) {
                    return new URI(nextString);
                }
            } catch (URISyntaxException e10) {
                throw new t((Exception) e10);
            }
        }
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        URI uri = (URI) obj;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toASCIIString();
        }
        jsonWriter.value(str);
    }
}
