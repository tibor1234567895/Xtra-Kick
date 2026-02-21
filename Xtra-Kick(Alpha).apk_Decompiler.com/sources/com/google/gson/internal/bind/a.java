package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.n;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class a extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f4002c = new ArrayTypeAdapter$1();

    /* renamed from: a  reason: collision with root package name */
    public final Class f4003a;

    /* renamed from: b  reason: collision with root package name */
    public final n f4004b;

    public a(n nVar, b0 b0Var, Class cls) {
        this.f4004b = new n(nVar, b0Var, cls);
        this.f4003a = cls;
    }

    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f4004b.b(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f4003a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f4004b.c(jsonWriter, Array.get(obj, i10));
        }
        jsonWriter.endArray();
    }
}
