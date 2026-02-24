package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.n;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import k9.b;
import l9.p;

public final class f0 extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4017a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4018b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4019c;

    public f0(n nVar, Type type, b0 b0Var, p pVar) {
        this.f4017a = 2;
        this.f4018b = new n(nVar, b0Var, type);
        this.f4019c = pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.Collection} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.google.gson.stream.JsonReader r6) {
        /*
            r5 = this;
            int r0 = r5.f4017a
            java.lang.Object r1 = r5.f4019c
            r2 = 0
            java.lang.Object r3 = r5.f4018b
            switch(r0) {
                case 0: goto L_0x0075;
                case 1: goto L_0x0039;
                case 2: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0089
        L_0x000c:
            com.google.gson.stream.JsonToken r0 = r6.peek()
            com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.NULL
            if (r0 != r4) goto L_0x0018
            r6.nextNull()
            goto L_0x0038
        L_0x0018:
            l9.p r1 = (l9.p) r1
            java.lang.Object r0 = r1.i()
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            r6.beginArray()
        L_0x0024:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0035
            r0 = r3
            j9.b0 r0 = (j9.b0) r0
            java.lang.Object r0 = r0.b(r6)
            r2.add(r0)
            goto L_0x0024
        L_0x0035:
            r6.endArray()
        L_0x0038:
            return r2
        L_0x0039:
            com.google.gson.internal.bind.TypeAdapters$35 r1 = (com.google.gson.internal.bind.TypeAdapters$35) r1
            j9.b0 r0 = r1.f4001i
            java.lang.Object r6 = r0.b(r6)
            if (r6 == 0) goto L_0x0074
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isInstance(r6)
            if (r0 == 0) goto L_0x004c
            goto L_0x0074
        L_0x004c:
            j9.t r0 = new j9.t
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected a "
            r1.<init>(r2)
            java.lang.String r2 = r3.getName()
            r1.append(r2)
            java.lang.String r2 = " but was "
            r1.append(r2)
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>((java.lang.String) r6)
            throw r0
        L_0x0074:
            return r6
        L_0x0075:
            j9.b0 r3 = (j9.b0) r3
            java.lang.Object r6 = r3.b(r6)
            java.util.Date r6 = (java.util.Date) r6
            if (r6 == 0) goto L_0x0088
            java.sql.Timestamp r2 = new java.sql.Timestamp
            long r0 = r6.getTime()
            r2.<init>(r0)
        L_0x0088:
            return r2
        L_0x0089:
            com.google.gson.stream.JsonToken r0 = r6.peek()
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
            if (r0 != r1) goto L_0x0095
            r6.nextNull()
            goto L_0x00a2
        L_0x0095:
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = r6.nextString()
            java.lang.Object r6 = r3.get(r6)
            r2 = r6
            java.lang.Enum r2 = (java.lang.Enum) r2
        L_0x00a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.f0.b(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        int i10 = this.f4017a;
        Object obj2 = this.f4019c;
        Object obj3 = this.f4018b;
        switch (i10) {
            case 0:
                ((b0) obj3).c(jsonWriter, (Timestamp) obj);
                return;
            case 1:
                ((TypeAdapters$35) obj2).f4001i.c(jsonWriter, obj);
                return;
            case 2:
                Collection<Object> collection = (Collection) obj;
                if (collection == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (Object c10 : collection) {
                    ((b0) obj3).c(jsonWriter, c10);
                }
                jsonWriter.endArray();
                return;
            default:
                Enum enumR = (Enum) obj;
                if (enumR == null) {
                    str = null;
                } else {
                    str = (String) ((Map) obj2).get(enumR);
                }
                jsonWriter.value(str);
                return;
        }
    }

    public /* synthetic */ f0(c0 c0Var, Object obj, int i10) {
        this.f4017a = i10;
        this.f4019c = c0Var;
        this.f4018b = obj;
    }

    public f0(Class cls) {
        this.f4017a = 3;
        this.f4018b = new HashMap();
        this.f4019c = new HashMap();
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                String name = enumR.name();
                b bVar = (b) cls.getField(name).getAnnotation(b.class);
                Object obj = this.f4018b;
                if (bVar != null) {
                    name = bVar.value();
                    for (String put : bVar.alternate()) {
                        ((Map) obj).put(put, enumR);
                    }
                }
                ((Map) obj).put(name, enumR);
                ((Map) this.f4019c).put(enumR, name);
            }
        } catch (NoSuchFieldException e10) {
            throw new AssertionError(e10);
        }
    }
}
