package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class r0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        return new AtomicBoolean(jsonReader.nextBoolean());
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value(((AtomicBoolean) obj).get());
    }
}
