package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.net.InetAddress;

public final class c0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return InetAddress.getByName(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        InetAddress inetAddress = (InetAddress) obj;
        if (inetAddress == null) {
            str = null;
        } else {
            str = inetAddress.getHostAddress();
        }
        jsonWriter.value(str);
    }
}
