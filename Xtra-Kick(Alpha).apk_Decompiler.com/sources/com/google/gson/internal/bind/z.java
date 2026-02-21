package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;

public final class z extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return new StringBuffer(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        StringBuffer stringBuffer = (StringBuffer) obj;
        if (stringBuffer == null) {
            str = null;
        } else {
            str = stringBuffer.toString();
        }
        jsonWriter.value(str);
    }
}
