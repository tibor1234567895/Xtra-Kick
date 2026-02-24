package androidx.appcompat.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.support.v4.media.h;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public final class u extends DataSetObservable {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f1085i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap f1086j = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Object f1087a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1088b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1089c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Context f1090d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1091e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1092f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1093g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1094h;

    public u(Context context, String str) {
        new s();
        this.f1092f = 50;
        this.f1093g = true;
        this.f1094h = true;
        this.f1090d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f1091e = str;
        } else {
            this.f1091e = str.concat(".xml");
        }
    }

    public static u c(Context context, String str) {
        u uVar;
        synchronized (f1085i) {
            HashMap hashMap = f1086j;
            uVar = (u) hashMap.get(str);
            if (uVar == null) {
                uVar = new u(context, str);
                hashMap.put(str, uVar);
            }
        }
        return uVar;
    }

    public final void a() {
        synchronized (this.f1087a) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c3, code lost:
        if (r5 == null) goto L_0x00d2;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r13 = this;
            boolean r0 = r13.f1093g
            r1 = 0
            if (r0 == 0) goto L_0x00d1
            boolean r0 = r13.f1094h
            if (r0 == 0) goto L_0x00d1
            java.lang.String r0 = r13.f1091e
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x00d1
            r13.f1093g = r1
            java.lang.String r2 = "Error reading historical recrod file: "
            java.lang.String r3 = "u"
            r4 = 1
            android.content.Context r5 = r13.f1090d     // Catch:{ FileNotFoundException -> 0x00cf }
            java.io.FileInputStream r5 = r5.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x00cf }
            org.xmlpull.v1.XmlPullParser r6 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r7 = "UTF-8"
            r6.setInput(r5, r7)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            r7 = 0
        L_0x0028:
            if (r7 == r4) goto L_0x0032
            r8 = 2
            if (r7 == r8) goto L_0x0032
            int r7 = r6.next()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            goto L_0x0028
        L_0x0032:
            java.lang.String r7 = "historical-records"
            java.lang.String r8 = r6.getName()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            boolean r7 = r7.equals(r8)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            if (r7 == 0) goto L_0x0090
            java.util.ArrayList r7 = r13.f1089c     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            r7.clear()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
        L_0x0043:
            int r8 = r6.next()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            if (r8 != r4) goto L_0x004d
            if (r5 == 0) goto L_0x00d2
            goto L_0x00c5
        L_0x004d:
            r9 = 3
            if (r8 == r9) goto L_0x0043
            r9 = 4
            if (r8 != r9) goto L_0x0054
            goto L_0x0043
        L_0x0054:
            java.lang.String r8 = r6.getName()     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r9 = "historical-record"
            boolean r8 = r9.equals(r8)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            if (r8 == 0) goto L_0x0088
            java.lang.String r8 = "activity"
            r9 = 0
            java.lang.String r8 = r6.getAttributeValue(r9, r8)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r10 = "time"
            java.lang.String r10 = r6.getAttributeValue(r9, r10)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            long r10 = java.lang.Long.parseLong(r10)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r12 = "weight"
            java.lang.String r9 = r6.getAttributeValue(r9, r12)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            androidx.appcompat.widget.t r12 = new androidx.appcompat.widget.t     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            android.content.ComponentName r8 = android.content.ComponentName.unflattenFromString(r8)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            r12.<init>(r8, r10, r9)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            r7.add(r12)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            goto L_0x0043
        L_0x0088:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r7 = "Share records file not well-formed."
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            throw r6     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
        L_0x0090:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            java.lang.String r7 = "Share records file does not start with historical-records tag."
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
            throw r6     // Catch:{ XmlPullParserException -> 0x00b0, IOException -> 0x009a }
        L_0x0098:
            r0 = move-exception
            goto L_0x00c9
        L_0x009a:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r7.<init>()     // Catch:{ all -> 0x0098 }
            r7.append(r2)     // Catch:{ all -> 0x0098 }
            r7.append(r0)     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0098 }
            android.util.Log.e(r3, r0, r6)     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x00d2
            goto L_0x00c5
        L_0x00b0:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r7.<init>()     // Catch:{ all -> 0x0098 }
            r7.append(r2)     // Catch:{ all -> 0x0098 }
            r7.append(r0)     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0098 }
            android.util.Log.e(r3, r0, r6)     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x00d2
        L_0x00c5:
            r5.close()     // Catch:{  }
            goto L_0x00d2
        L_0x00c9:
            if (r5 == 0) goto L_0x00ce
            r5.close()     // Catch:{ IOException -> 0x00ce }
        L_0x00ce:
            throw r0
        L_0x00cf:
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            r0 = r1 | r4
            r13.g()
            if (r0 == 0) goto L_0x00dc
            r13.notifyChanged()
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u.b():void");
    }

    public final void d(int i10) {
        synchronized (this.f1087a) {
            b();
            h.y(this.f1088b.get(i10));
            throw null;
        }
    }

    public final int e() {
        int size;
        synchronized (this.f1087a) {
            b();
            size = this.f1088b.size();
        }
        return size;
    }

    public final void f() {
        synchronized (this.f1087a) {
            b();
            if (!this.f1088b.isEmpty()) {
                h.y(this.f1088b.get(0));
                throw null;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f1089c;
        int size = arrayList.size() - this.f1092f;
        if (size > 0) {
            this.f1094h = true;
            for (int i10 = 0; i10 < size; i10++) {
                t tVar = (t) arrayList.remove(0);
            }
        }
    }
}
