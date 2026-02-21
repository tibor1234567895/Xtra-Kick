package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.n;
import java.util.ArrayList;
import l9.o;
import o9.a;

public final class g extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f4020b = new ObjectTypeAdapter$1();

    /* renamed from: a  reason: collision with root package name */
    public final n f4021a;

    public g(n nVar) {
        this.f4021a = nVar;
    }

    public final Object b(JsonReader jsonReader) {
        switch (f.f4016a[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(b(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                o oVar = new o();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    oVar.put(jsonReader.nextName(), b(jsonReader));
                }
                jsonReader.endObject();
                return oVar;
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Class<?> cls = obj.getClass();
        n nVar = this.f4021a;
        nVar.getClass();
        b0 b10 = nVar.b(new a(cls));
        if (b10 instanceof g) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        b10.c(jsonWriter, obj);
    }
}
