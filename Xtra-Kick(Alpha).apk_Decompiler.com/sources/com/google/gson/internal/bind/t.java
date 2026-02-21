package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class t extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        if (nextString.length() == 1) {
            return Character.valueOf(nextString.charAt(0));
        }
        throw new j9.t("Expecting character, got: ".concat(nextString));
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        Character ch = (Character) obj;
        if (ch == null) {
            str = null;
        } else {
            str = String.valueOf(ch);
        }
        jsonWriter.value(str);
    }
}
