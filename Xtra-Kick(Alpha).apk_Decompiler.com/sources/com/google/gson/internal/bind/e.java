package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.n;
import j9.s;
import j9.t;
import j9.u;
import j9.v;
import j9.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import l9.h;
import l9.p;

public final class e extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final n f4012a;

    /* renamed from: b  reason: collision with root package name */
    public final n f4013b;

    /* renamed from: c  reason: collision with root package name */
    public final p f4014c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MapTypeAdapterFactory f4015d;

    public e(MapTypeAdapterFactory mapTypeAdapterFactory, n nVar, Type type, b0 b0Var, Type type2, b0 b0Var2, p pVar) {
        this.f4015d = mapTypeAdapterFactory;
        this.f4012a = new n(nVar, b0Var, type);
        this.f4013b = new n(nVar, b0Var2, type2);
        this.f4014c = pVar;
    }

    public final Object b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Map map = (Map) this.f4014c.i();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        n nVar = this.f4013b;
        n nVar2 = this.f4012a;
        if (peek == jsonToken) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                Object b10 = nVar2.b(jsonReader);
                if (map.put(b10, nVar.b(jsonReader)) == null) {
                    jsonReader.endArray();
                } else {
                    throw new t("duplicate key: " + b10);
                }
            }
            jsonReader.endArray();
        } else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                h.INSTANCE.promoteNameToValue(jsonReader);
                Object b11 = nVar2.b(jsonReader);
                if (map.put(b11, nVar.b(jsonReader)) != null) {
                    throw new t("duplicate key: " + b11);
                }
            }
            jsonReader.endObject();
        }
        return map;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        boolean z10;
        Map map = (Map) obj;
        if (map == null) {
            jsonWriter.nullValue();
            return;
        }
        boolean z11 = this.f4015d.f3980i;
        n nVar = this.f4013b;
        if (!z11) {
            jsonWriter.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                jsonWriter.name(String.valueOf(entry.getKey()));
                nVar.c(jsonWriter, entry.getValue());
            }
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z12 = false;
            for (Map.Entry entry2 : map.entrySet()) {
                Object key = entry2.getKey();
                n nVar2 = this.f4012a;
                nVar2.getClass();
                try {
                    d dVar = new d();
                    nVar2.c(dVar, key);
                    ArrayList arrayList3 = dVar.f4009h;
                    if (arrayList3.isEmpty()) {
                        s sVar = dVar.f4011j;
                        arrayList.add(sVar);
                        arrayList2.add(entry2.getValue());
                        sVar.getClass();
                        if ((sVar instanceof j9.p) || (sVar instanceof v)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z12 |= z10;
                    } else {
                        throw new IllegalStateException("Expected one JSON element but was " + arrayList3);
                    }
                } catch (IOException e10) {
                    throw new t((Exception) e10);
                }
            }
            if (z12) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (i10 < size) {
                    jsonWriter.beginArray();
                    s0.A.c(jsonWriter, (s) arrayList.get(i10));
                    nVar.c(jsonWriter, arrayList2.get(i10));
                    jsonWriter.endArray();
                    i10++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (i10 < size2) {
                s sVar2 = (s) arrayList.get(i10);
                sVar2.getClass();
                if (sVar2 instanceof x) {
                    x d10 = sVar2.d();
                    Object obj2 = d10.f8880h;
                    if (obj2 instanceof Number) {
                        str = String.valueOf(d10.g());
                    } else if (obj2 instanceof Boolean) {
                        str = Boolean.toString(d10.f());
                    } else if (obj2 instanceof String) {
                        str = d10.e();
                    } else {
                        throw new AssertionError();
                    }
                } else if (sVar2 instanceof u) {
                    str = "null";
                } else {
                    throw new AssertionError();
                }
                jsonWriter.name(str);
                nVar.c(jsonWriter, arrayList2.get(i10));
                i10++;
            }
        }
        jsonWriter.endObject();
    }
}
