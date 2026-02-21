package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.p;
import j9.s;
import j9.u;
import j9.v;
import j9.x;
import java.util.Iterator;
import java.util.Map;
import l9.i;
import l9.k;
import l9.l;
import l9.m;

public final class i0 extends b0 {
    public static s d(JsonReader jsonReader) {
        switch (k0.f4037a[jsonReader.peek().ordinal()]) {
            case 1:
                return new x((Number) new i(jsonReader.nextString()));
            case 2:
                return new x(Boolean.valueOf(jsonReader.nextBoolean()));
            case 3:
                return new x(jsonReader.nextString());
            case 4:
                jsonReader.nextNull();
                return u.f8877h;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                p pVar = new p();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Object d10 = d(jsonReader);
                    if (d10 == null) {
                        d10 = u.f8877h;
                    }
                    pVar.f8876h.add(d10);
                }
                jsonReader.endArray();
                return pVar;
            case 6:
                v vVar = new v();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    Object d11 = d(jsonReader);
                    if (d11 == null) {
                        d11 = u.f8877h;
                    }
                    vVar.f8878h.put(nextName, d11);
                }
                jsonReader.endObject();
                return vVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void e(s sVar, JsonWriter jsonWriter) {
        if (sVar == null || (sVar instanceof u)) {
            jsonWriter.nullValue();
        } else if (sVar instanceof x) {
            x d10 = sVar.d();
            Object obj = d10.f8880h;
            if (obj instanceof Number) {
                jsonWriter.value(d10.g());
            } else if (obj instanceof Boolean) {
                jsonWriter.value(d10.f());
            } else {
                jsonWriter.value(d10.e());
            }
        } else if (sVar instanceof p) {
            jsonWriter.beginArray();
            Iterator it = sVar.b().iterator();
            while (it.hasNext()) {
                e((s) it.next(), jsonWriter);
            }
            jsonWriter.endArray();
        } else if (sVar instanceof v) {
            jsonWriter.beginObject();
            Iterator it2 = ((l) sVar.c().f8878h.entrySet()).iterator();
            while (((m) it2).hasNext()) {
                Map.Entry entry = (Map.Entry) ((k) it2).next();
                jsonWriter.name((String) entry.getKey());
                e((s) entry.getValue(), jsonWriter);
            }
            jsonWriter.endObject();
        } else {
            throw new IllegalArgumentException("Couldn't write " + sVar.getClass());
        }
    }

    public final /* bridge */ /* synthetic */ Object b(JsonReader jsonReader) {
        return d(jsonReader);
    }

    public final /* bridge */ /* synthetic */ void c(JsonWriter jsonWriter, Object obj) {
        e((s) obj, jsonWriter);
    }
}
