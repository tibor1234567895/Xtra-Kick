package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.Locale;
import java.util.StringTokenizer;

public final class h0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        Locale locale;
        String str = null;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (stringTokenizer.hasMoreElements()) {
            str = stringTokenizer.nextToken();
        }
        if (nextToken2 == null && str == null) {
            return new Locale(nextToken);
        }
        if (str != null) {
            locale = new Locale(nextToken, nextToken2, str);
        }
        return locale;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        Locale locale = (Locale) obj;
        if (locale == null) {
            str = null;
        } else {
            str = locale.toString();
        }
        jsonWriter.value(str);
    }
}
