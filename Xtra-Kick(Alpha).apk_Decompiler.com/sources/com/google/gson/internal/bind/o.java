package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.t;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class o extends b0 {
    public final Object b(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(jsonReader.nextInt()));
            } catch (NumberFormatException e10) {
                throw new t((Exception) e10);
            }
        }
        jsonReader.endArray();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i10 = 0; i10 < size; i10++) {
            atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
        }
        return atomicIntegerArray;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
        jsonWriter.beginArray();
        int length = atomicIntegerArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            jsonWriter.value((long) atomicIntegerArray.get(i10));
        }
        jsonWriter.endArray();
    }
}
