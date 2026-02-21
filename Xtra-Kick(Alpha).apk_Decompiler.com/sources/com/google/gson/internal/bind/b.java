package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import l9.g;
import l9.q;

public final class b extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f4005b = new DateTypeAdapter$1();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4006a;

    public b() {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        this.f4006a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (g.f9768a >= 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            arrayList.add(q.a(2, 2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3 = m9.a.b(r3, new java.text.ParsePosition(0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.google.gson.stream.JsonReader r3) {
        /*
            r2 = this;
            com.google.gson.stream.JsonToken r0 = r3.peek()
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
            if (r0 != r1) goto L_0x000d
            r3.nextNull()
            r3 = 0
            goto L_0x0034
        L_0x000d:
            java.lang.String r3 = r3.nextString()
            monitor-enter(r2)
            java.util.ArrayList r0 = r2.f4006a     // Catch:{ all -> 0x003c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003c }
        L_0x0018:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003c }
            java.text.DateFormat r1 = (java.text.DateFormat) r1     // Catch:{ all -> 0x003c }
            java.util.Date r3 = r1.parse(r3)     // Catch:{ ParseException -> 0x0018 }
            goto L_0x0033
        L_0x0029:
            java.text.ParsePosition r0 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x0035 }
            r1 = 0
            r0.<init>(r1)     // Catch:{ ParseException -> 0x0035 }
            java.util.Date r3 = m9.a.b(r3, r0)     // Catch:{ ParseException -> 0x0035 }
        L_0x0033:
            monitor-exit(r2)
        L_0x0034:
            return r3
        L_0x0035:
            r0 = move-exception
            j9.t r1 = new j9.t     // Catch:{ all -> 0x003c }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x003c }
            throw r1     // Catch:{ all -> 0x003c }
        L_0x003c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.b.b(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        Date date = (Date) obj;
        synchronized (this) {
            if (date == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(((DateFormat) this.f4006a.get(0)).format(date));
            }
        }
    }
}
