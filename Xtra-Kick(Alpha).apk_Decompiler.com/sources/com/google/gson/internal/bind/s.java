package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.t;
import l9.i;

public final class s extends b0 {
    public final Object b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        int i10 = k0.f4037a[peek.ordinal()];
        if (i10 == 1 || i10 == 3) {
            return new i(jsonReader.nextString());
        }
        if (i10 == 4) {
            jsonReader.nextNull();
            return null;
        }
        throw new t("Expecting number, got: " + peek);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((Number) obj);
    }
}
