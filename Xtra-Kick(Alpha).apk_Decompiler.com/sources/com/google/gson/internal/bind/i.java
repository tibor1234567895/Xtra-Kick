package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.t;
import java.util.LinkedHashMap;
import java.util.Map;
import l9.p;

public final class i extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final p f4031a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f4032b;

    public i(p pVar, LinkedHashMap linkedHashMap) {
        this.f4031a = pVar;
        this.f4032b = linkedHashMap;
    }

    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Object i10 = this.f4031a.i();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                h hVar = (h) this.f4032b.get(jsonReader.nextName());
                if (hVar != null) {
                    if (hVar.f4024c) {
                        Object b10 = hVar.f4027f.b(jsonReader);
                        if (b10 != null || !hVar.f4030i) {
                            hVar.f4025d.set(i10, b10);
                        }
                    }
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            return i10;
        } catch (IllegalStateException e10) {
            throw new t((Exception) e10);
        } catch (IllegalAccessException e11) {
            throw new AssertionError(e11);
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        try {
            for (h hVar : this.f4032b.values()) {
                boolean z10 = false;
                if (hVar.f4023b) {
                    if (hVar.f4025d.get(obj) != obj) {
                        z10 = true;
                    }
                }
                if (z10) {
                    jsonWriter.name(hVar.f4022a);
                    Object obj2 = hVar.f4025d.get(obj);
                    boolean z11 = hVar.f4026e;
                    b0 b0Var = hVar.f4027f;
                    if (!z11) {
                        b0Var = new n(hVar.f4028g, b0Var, hVar.f4029h.f12362b);
                    }
                    b0Var.c(jsonWriter, obj2);
                }
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        }
    }
}
