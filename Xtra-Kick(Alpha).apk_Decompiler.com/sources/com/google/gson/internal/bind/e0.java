package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.Currency;

public final class e0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        return Currency.getInstance(jsonReader.nextString());
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value(((Currency) obj).getCurrencyCode());
    }
}
