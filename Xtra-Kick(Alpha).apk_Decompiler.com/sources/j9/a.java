package j9;

import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import l9.g;
import l9.q;

public final class a extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final Class f8848a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f8849b;

    public a(int i10, int i11, Class cls) {
        ArrayList arrayList = new ArrayList();
        this.f8849b = arrayList;
        d(cls);
        this.f8848a = cls;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (g.f9768a >= 9) {
            arrayList.add(q.a(i10, i11));
        }
    }

    public static void d(Class cls) {
        Class cls2;
        Class cls3;
        Class<Date> cls4 = Date.class;
        if (cls != cls4 && cls != (cls2 = java.sql.Date.class) && cls != (cls3 = Timestamp.class)) {
            throw new IllegalArgumentException("Date type must be one of " + cls4 + ", " + cls3 + ", or " + cls2 + " but was " + cls);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = m9.a.b(r4, new java.text.ParsePosition(0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.google.gson.stream.JsonReader r4) {
        /*
            r3 = this;
            com.google.gson.stream.JsonToken r0 = r4.peek()
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
            if (r0 != r1) goto L_0x000d
            r4.nextNull()
            r4 = 0
            goto L_0x005a
        L_0x000d:
            java.lang.String r4 = r4.nextString()
            java.util.ArrayList r0 = r3.f8849b
            monitor-enter(r0)
            java.util.ArrayList r1 = r3.f8849b     // Catch:{ all -> 0x0068 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0068 }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0068 }
            java.text.DateFormat r2 = (java.text.DateFormat) r2     // Catch:{ all -> 0x0068 }
            java.util.Date r4 = r2.parse(r4)     // Catch:{ ParseException -> 0x001a }
            goto L_0x0035
        L_0x002b:
            java.text.ParsePosition r1 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x0061 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ ParseException -> 0x0061 }
            java.util.Date r4 = m9.a.b(r4, r1)     // Catch:{ ParseException -> 0x0061 }
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            java.lang.Class r0 = r3.f8848a
            java.lang.Class<java.util.Date> r1 = java.util.Date.class
            if (r0 != r1) goto L_0x003d
            goto L_0x005a
        L_0x003d:
            java.lang.Class<java.sql.Timestamp> r1 = java.sql.Timestamp.class
            if (r0 != r1) goto L_0x004c
            java.sql.Timestamp r0 = new java.sql.Timestamp
            long r1 = r4.getTime()
            r0.<init>(r1)
        L_0x004a:
            r4 = r0
            goto L_0x005a
        L_0x004c:
            java.lang.Class<java.sql.Date> r1 = java.sql.Date.class
            if (r0 != r1) goto L_0x005b
            java.sql.Date r0 = new java.sql.Date
            long r1 = r4.getTime()
            r0.<init>(r1)
            goto L_0x004a
        L_0x005a:
            return r4
        L_0x005b:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x0061:
            r1 = move-exception
            j9.t r2 = new j9.t     // Catch:{ all -> 0x0068 }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x0068 }
            throw r2     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.a.b(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.f8849b) {
            jsonWriter.value(((DateFormat) this.f8849b.get(0)).format(date));
        }
    }

    public final String toString() {
        StringBuilder sb2;
        String str;
        DateFormat dateFormat = (DateFormat) this.f8849b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb2 = new StringBuilder("DefaultDateTypeAdapter(");
            str = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb2 = new StringBuilder("DefaultDateTypeAdapter(");
            str = dateFormat.getClass().getSimpleName();
        }
        sb2.append(str);
        sb2.append(')');
        return sb2.toString();
    }

    public a(Class cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f8849b = arrayList;
        d(cls);
        this.f8848a = cls;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }
}
