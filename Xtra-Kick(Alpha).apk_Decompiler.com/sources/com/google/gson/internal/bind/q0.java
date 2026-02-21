package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.t;
import java.util.concurrent.atomic.AtomicInteger;

public final class q0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        try {
            return new AtomicInteger(jsonReader.nextInt());
        } catch (NumberFormatException e10) {
            throw new t((Exception) e10);
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((long) ((AtomicInteger) obj).get());
    }
}
