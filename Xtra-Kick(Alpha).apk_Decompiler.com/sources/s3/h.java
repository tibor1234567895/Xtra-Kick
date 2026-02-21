package s3;

import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import xa.j;

public final class h {

    /* renamed from: e  reason: collision with root package name */
    public static final c f14183e = new c(0);

    /* renamed from: a  reason: collision with root package name */
    public final String f14184a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f14185b;

    /* renamed from: c  reason: collision with root package name */
    public final Set f14186c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f14187d;

    public h(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        this.f14184a = str;
        this.f14185b = map;
        this.f14186c = abstractSet;
        this.f14187d = abstractSet2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0311 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0316 A[SYNTHETIC, Splitter:B:97:0x0316] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final s3.h a(v3.d r30, java.lang.String r31) {
        /*
            r0 = r30
            r1 = r31
            java.lang.String r2 = "seq"
            java.lang.String r3 = "id"
            s3.c r4 = f14183e
            r4.getClass()
            java.lang.String r4 = "type"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "PRAGMA table_info(`"
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r6 = "`)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.database.Cursor r5 = r0.C0(r5)
            int r7 = r5.getColumnCount()     // Catch:{ all -> 0x0357 }
            java.lang.String r8 = "name"
            if (r7 > 0) goto L_0x0033
            ma.c0 r4 = ma.j0.d()     // Catch:{ all -> 0x0357 }
            goto L_0x0095
        L_0x0033:
            int r7 = r5.getColumnIndex(r8)     // Catch:{ all -> 0x0357 }
            int r11 = r5.getColumnIndex(r4)     // Catch:{ all -> 0x0357 }
            java.lang.String r12 = "notnull"
            int r12 = r5.getColumnIndex(r12)     // Catch:{ all -> 0x0357 }
            java.lang.String r13 = "pk"
            int r13 = r5.getColumnIndex(r13)     // Catch:{ all -> 0x0357 }
            java.lang.String r14 = "dflt_value"
            int r14 = r5.getColumnIndex(r14)     // Catch:{ all -> 0x0357 }
            na.h r15 = new na.h     // Catch:{ all -> 0x0357 }
            r15.<init>()     // Catch:{ all -> 0x0357 }
        L_0x0052:
            boolean r16 = r5.moveToNext()     // Catch:{ all -> 0x0357 }
            if (r16 == 0) goto L_0x008e
            java.lang.String r9 = r5.getString(r7)     // Catch:{ all -> 0x0357 }
            java.lang.String r10 = r5.getString(r11)     // Catch:{ all -> 0x0357 }
            int r17 = r5.getInt(r12)     // Catch:{ all -> 0x0357 }
            if (r17 == 0) goto L_0x0069
            r23 = 1
            goto L_0x006b
        L_0x0069:
            r23 = 0
        L_0x006b:
            int r18 = r5.getInt(r13)     // Catch:{ all -> 0x0357 }
            java.lang.String r22 = r5.getString(r14)     // Catch:{ all -> 0x0357 }
            xa.j.e(r8, r9)     // Catch:{ all -> 0x0357 }
            r24 = r7
            s3.b r7 = new s3.b     // Catch:{ all -> 0x0357 }
            xa.j.e(r4, r10)     // Catch:{ all -> 0x0357 }
            r19 = 2
            r17 = r7
            r20 = r9
            r21 = r10
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0357 }
            r15.put(r9, r7)     // Catch:{ all -> 0x0357 }
            r7 = r24
            goto L_0x0052
        L_0x008e:
            r15.b()     // Catch:{ all -> 0x0357 }
            r4 = 1
            r15.f11791s = r4     // Catch:{ all -> 0x0357 }
            r4 = r15
        L_0x0095:
            r7 = 0
            hb.h0.A(r5, r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r9 = "PRAGMA foreign_key_list(`"
            r5.<init>(r9)
            r5.append(r1)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.database.Cursor r5 = r0.C0(r5)
            int r9 = r5.getColumnIndex(r3)     // Catch:{ all -> 0x034e }
            int r10 = r5.getColumnIndex(r2)     // Catch:{ all -> 0x034e }
            java.lang.String r11 = "table"
            int r11 = r5.getColumnIndex(r11)     // Catch:{ all -> 0x034e }
            java.lang.String r12 = "on_delete"
            int r12 = r5.getColumnIndex(r12)     // Catch:{ all -> 0x034e }
            java.lang.String r13 = "on_update"
            int r13 = r5.getColumnIndex(r13)     // Catch:{ all -> 0x034e }
            int r3 = r5.getColumnIndex(r3)     // Catch:{ all -> 0x034e }
            int r2 = r5.getColumnIndex(r2)     // Catch:{ all -> 0x034e }
            java.lang.String r14 = "from"
            int r14 = r5.getColumnIndex(r14)     // Catch:{ all -> 0x034e }
            java.lang.String r15 = "to"
            int r15 = r5.getColumnIndex(r15)     // Catch:{ all -> 0x034e }
            na.c r7 = new na.c     // Catch:{ all -> 0x034e }
            r7.<init>()     // Catch:{ all -> 0x034e }
        L_0x00e1:
            boolean r18 = r5.moveToNext()     // Catch:{ all -> 0x034e }
            if (r18 == 0) goto L_0x0122
            r18 = r4
            s3.e r4 = new s3.e     // Catch:{ all -> 0x034e }
            r19 = r8
            int r8 = r5.getInt(r3)     // Catch:{ all -> 0x034e }
            r20 = r3
            int r3 = r5.getInt(r2)     // Catch:{ all -> 0x034e }
            r21 = r2
            java.lang.String r2 = r5.getString(r14)     // Catch:{ all -> 0x034e }
            r22 = r14
            java.lang.String r14 = "cursor.getString(fromColumnIndex)"
            xa.j.e(r14, r2)     // Catch:{ all -> 0x034e }
            java.lang.String r14 = r5.getString(r15)     // Catch:{ all -> 0x034e }
            r23 = r15
            java.lang.String r15 = "cursor.getString(toColumnIndex)"
            xa.j.e(r15, r14)     // Catch:{ all -> 0x034e }
            r4.<init>(r8, r3, r2, r14)     // Catch:{ all -> 0x034e }
            r7.add(r4)     // Catch:{ all -> 0x034e }
            r4 = r18
            r8 = r19
            r3 = r20
            r2 = r21
            r14 = r22
            r15 = r23
            goto L_0x00e1
        L_0x0122:
            r18 = r4
            r19 = r8
            ma.q.a(r7)     // Catch:{ all -> 0x034e }
            int r2 = r7.a()     // Catch:{ all -> 0x034e }
            r3 = 1
            if (r2 > r3) goto L_0x0136
            java.util.List r2 = ma.z.J(r7)     // Catch:{ all -> 0x034e }
            r4 = 0
            goto L_0x014b
        L_0x0136:
            r4 = 0
            java.lang.Comparable[] r2 = new java.lang.Comparable[r4]     // Catch:{ all -> 0x034e }
            java.lang.Object[] r2 = r7.toArray(r2)     // Catch:{ all -> 0x034e }
            r3 = r2
            java.lang.Comparable[] r3 = (java.lang.Comparable[]) r3     // Catch:{ all -> 0x034e }
            int r7 = r3.length     // Catch:{ all -> 0x034e }
            r8 = 1
            if (r7 <= r8) goto L_0x0147
            java.util.Arrays.sort(r3)     // Catch:{ all -> 0x034e }
        L_0x0147:
            java.util.List r2 = ma.o.b(r2)     // Catch:{ all -> 0x034e }
        L_0x014b:
            r3 = -1
            r5.moveToPosition(r3)     // Catch:{ all -> 0x034e }
            na.l r7 = new na.l     // Catch:{ all -> 0x034e }
            r7.<init>()     // Catch:{ all -> 0x034e }
        L_0x0154:
            boolean r8 = r5.moveToNext()     // Catch:{ all -> 0x034e }
            if (r8 == 0) goto L_0x01ed
            int r8 = r5.getInt(r10)     // Catch:{ all -> 0x034e }
            if (r8 == 0) goto L_0x0161
            goto L_0x0154
        L_0x0161:
            int r8 = r5.getInt(r9)     // Catch:{ all -> 0x034e }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x034e }
            r14.<init>()     // Catch:{ all -> 0x034e }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x034e }
            r15.<init>()     // Catch:{ all -> 0x034e }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x034e }
            r4.<init>()     // Catch:{ all -> 0x034e }
            java.util.Iterator r20 = r2.iterator()     // Catch:{ all -> 0x034e }
        L_0x0178:
            boolean r21 = r20.hasNext()     // Catch:{ all -> 0x034e }
            if (r21 == 0) goto L_0x0197
            java.lang.Object r3 = r20.next()     // Catch:{ all -> 0x034e }
            r22 = r2
            r2 = r3
            s3.e r2 = (s3.e) r2     // Catch:{ all -> 0x034e }
            int r2 = r2.f14175h     // Catch:{ all -> 0x034e }
            if (r2 != r8) goto L_0x018d
            r2 = 1
            goto L_0x018e
        L_0x018d:
            r2 = 0
        L_0x018e:
            if (r2 == 0) goto L_0x0193
            r4.add(r3)     // Catch:{ all -> 0x034e }
        L_0x0193:
            r2 = r22
            r3 = -1
            goto L_0x0178
        L_0x0197:
            r22 = r2
            java.util.Iterator r2 = r4.iterator()     // Catch:{ all -> 0x034e }
        L_0x019d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x034e }
            if (r3 == 0) goto L_0x01b4
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x034e }
            s3.e r3 = (s3.e) r3     // Catch:{ all -> 0x034e }
            java.lang.String r4 = r3.f14177j     // Catch:{ all -> 0x034e }
            r14.add(r4)     // Catch:{ all -> 0x034e }
            java.lang.String r3 = r3.f14178k     // Catch:{ all -> 0x034e }
            r15.add(r3)     // Catch:{ all -> 0x034e }
            goto L_0x019d
        L_0x01b4:
            s3.d r2 = new s3.d     // Catch:{ all -> 0x034e }
            java.lang.String r3 = r5.getString(r11)     // Catch:{ all -> 0x034e }
            java.lang.String r4 = "cursor.getString(tableColumnIndex)"
            xa.j.e(r4, r3)     // Catch:{ all -> 0x034e }
            java.lang.String r4 = r5.getString(r12)     // Catch:{ all -> 0x034e }
            java.lang.String r8 = "cursor.getString(onDeleteColumnIndex)"
            xa.j.e(r8, r4)     // Catch:{ all -> 0x034e }
            java.lang.String r8 = r5.getString(r13)     // Catch:{ all -> 0x034e }
            r20 = r9
            java.lang.String r9 = "cursor.getString(onUpdateColumnIndex)"
            xa.j.e(r9, r8)     // Catch:{ all -> 0x034e }
            r24 = r2
            r25 = r3
            r26 = r4
            r27 = r8
            r28 = r14
            r29 = r15
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ all -> 0x034e }
            r7.add(r2)     // Catch:{ all -> 0x034e }
            r9 = r20
            r2 = r22
            r3 = -1
            r4 = 0
            goto L_0x0154
        L_0x01ed:
            ma.n0.a(r7)     // Catch:{ all -> 0x034e }
            r2 = 0
            hb.h0.A(r5, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "PRAGMA index_list(`"
            r2.<init>(r3)
            r2.append(r1)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.database.Cursor r2 = r0.C0(r2)
            r3 = r19
            int r4 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x0345 }
            java.lang.String r5 = "origin"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0345 }
            java.lang.String r8 = "unique"
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x0345 }
            r9 = -1
            if (r4 == r9) goto L_0x0339
            if (r5 == r9) goto L_0x0339
            if (r8 != r9) goto L_0x0224
            goto L_0x0339
        L_0x0224:
            na.l r9 = new na.l     // Catch:{ all -> 0x0345 }
            r9.<init>()     // Catch:{ all -> 0x0345 }
        L_0x0229:
            boolean r10 = r2.moveToNext()     // Catch:{ all -> 0x0345 }
            if (r10 == 0) goto L_0x0330
            java.lang.String r10 = r2.getString(r5)     // Catch:{ all -> 0x0345 }
            java.lang.String r11 = "c"
            boolean r10 = xa.j.a(r11, r10)     // Catch:{ all -> 0x0345 }
            if (r10 != 0) goto L_0x023c
            goto L_0x0229
        L_0x023c:
            java.lang.String r10 = r2.getString(r4)     // Catch:{ all -> 0x0345 }
            int r11 = r2.getInt(r8)     // Catch:{ all -> 0x0345 }
            r12 = 1
            if (r11 != r12) goto L_0x0249
            r11 = 1
            goto L_0x024a
        L_0x0249:
            r11 = 0
        L_0x024a:
            xa.j.e(r3, r10)     // Catch:{ all -> 0x0345 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            java.lang.String r14 = "PRAGMA index_xinfo(`"
            r13.<init>(r14)     // Catch:{ all -> 0x0345 }
            r13.append(r10)     // Catch:{ all -> 0x0345 }
            r13.append(r6)     // Catch:{ all -> 0x0345 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0345 }
            android.database.Cursor r13 = r0.C0(r13)     // Catch:{ all -> 0x0345 }
            java.lang.String r14 = "seqno"
            int r14 = r13.getColumnIndex(r14)     // Catch:{ all -> 0x0327 }
            java.lang.String r15 = "cid"
            int r15 = r13.getColumnIndex(r15)     // Catch:{ all -> 0x0327 }
            int r12 = r13.getColumnIndex(r3)     // Catch:{ all -> 0x0327 }
            java.lang.String r0 = "desc"
            int r0 = r13.getColumnIndex(r0)     // Catch:{ all -> 0x0327 }
            r19 = r3
            r3 = -1
            if (r14 == r3) goto L_0x0302
            if (r15 == r3) goto L_0x0302
            if (r12 == r3) goto L_0x0302
            if (r0 != r3) goto L_0x0285
            goto L_0x0302
        L_0x0285:
            java.util.TreeMap r3 = new java.util.TreeMap     // Catch:{ all -> 0x0327 }
            r3.<init>()     // Catch:{ all -> 0x0327 }
            r20 = r4
            java.util.TreeMap r4 = new java.util.TreeMap     // Catch:{ all -> 0x0327 }
            r4.<init>()     // Catch:{ all -> 0x0327 }
        L_0x0291:
            boolean r22 = r13.moveToNext()     // Catch:{ all -> 0x0327 }
            if (r22 == 0) goto L_0x02d7
            int r22 = r13.getInt(r15)     // Catch:{ all -> 0x0327 }
            if (r22 >= 0) goto L_0x029e
            goto L_0x0291
        L_0x029e:
            int r22 = r13.getInt(r14)     // Catch:{ all -> 0x0327 }
            r23 = r5
            java.lang.String r5 = r13.getString(r12)     // Catch:{ all -> 0x0327 }
            int r24 = r13.getInt(r0)     // Catch:{ all -> 0x0327 }
            if (r24 <= 0) goto L_0x02b1
            java.lang.String r24 = "DESC"
            goto L_0x02b3
        L_0x02b1:
            java.lang.String r24 = "ASC"
        L_0x02b3:
            r25 = r0
            r0 = r24
            r24 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r22)     // Catch:{ all -> 0x0327 }
            r26 = r8
            java.lang.String r8 = "columnName"
            xa.j.e(r8, r5)     // Catch:{ all -> 0x0327 }
            r3.put(r6, r5)     // Catch:{ all -> 0x0327 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r22)     // Catch:{ all -> 0x0327 }
            r4.put(r5, r0)     // Catch:{ all -> 0x0327 }
            r5 = r23
            r6 = r24
            r0 = r25
            r8 = r26
            goto L_0x0291
        L_0x02d7:
            r23 = r5
            r24 = r6
            r26 = r8
            java.util.Collection r0 = r3.values()     // Catch:{ all -> 0x0327 }
            java.lang.String r3 = "columnsMap.values"
            xa.j.e(r3, r0)     // Catch:{ all -> 0x0327 }
            java.util.List r0 = ma.z.J(r0)     // Catch:{ all -> 0x0327 }
            java.util.Collection r3 = r4.values()     // Catch:{ all -> 0x0327 }
            java.lang.String r4 = "ordersMap.values"
            xa.j.e(r4, r3)     // Catch:{ all -> 0x0327 }
            java.util.List r3 = ma.z.J(r3)     // Catch:{ all -> 0x0327 }
            s3.g r4 = new s3.g     // Catch:{ all -> 0x0327 }
            r4.<init>(r10, r11, r0, r3)     // Catch:{ all -> 0x0327 }
            r0 = 0
            hb.h0.A(r13, r0)     // Catch:{ all -> 0x0345 }
            r0 = 0
            goto L_0x030f
        L_0x0302:
            r20 = r4
            r23 = r5
            r24 = r6
            r26 = r8
            r0 = 0
            hb.h0.A(r13, r0)     // Catch:{ all -> 0x0345 }
            r4 = r0
        L_0x030f:
            if (r4 != 0) goto L_0x0316
            hb.h0.A(r2, r0)
            r0 = 0
            goto L_0x033d
        L_0x0316:
            r9.add(r4)     // Catch:{ all -> 0x0345 }
            r0 = r30
            r3 = r19
            r4 = r20
            r5 = r23
            r6 = r24
            r8 = r26
            goto L_0x0229
        L_0x0327:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x032a }
        L_0x032a:
            r0 = move-exception
            r3 = r0
            hb.h0.A(r13, r1)     // Catch:{ all -> 0x0345 }
            throw r3     // Catch:{ all -> 0x0345 }
        L_0x0330:
            ma.n0.a(r9)     // Catch:{ all -> 0x0345 }
            r0 = 0
            hb.h0.A(r2, r0)
            r0 = r9
            goto L_0x033d
        L_0x0339:
            r0 = 0
            hb.h0.A(r2, r0)
        L_0x033d:
            s3.h r2 = new s3.h
            r15 = r18
            r2.<init>(r1, r15, r7, r0)
            return r2
        L_0x0345:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0348 }
        L_0x0348:
            r0 = move-exception
            r3 = r0
            hb.h0.A(r2, r1)
            throw r3
        L_0x034e:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0351 }
        L_0x0351:
            r0 = move-exception
            r2 = r0
            hb.h0.A(r5, r1)
            throw r2
        L_0x0357:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x035a }
        L_0x035a:
            r0 = move-exception
            r2 = r0
            hb.h0.A(r5, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.h.a(v3.d, java.lang.String):s3.h");
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!j.a(this.f14184a, hVar.f14184a) || !j.a(this.f14185b, hVar.f14185b) || !j.a(this.f14186c, hVar.f14186c)) {
            return false;
        }
        Set set2 = this.f14187d;
        if (set2 == null || (set = hVar.f14187d) == null) {
            return true;
        }
        return j.a(set2, set);
    }

    public final int hashCode() {
        int hashCode = this.f14185b.hashCode();
        return this.f14186c.hashCode() + ((hashCode + (this.f14184a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f14184a + "', columns=" + this.f14185b + ", foreignKeys=" + this.f14186c + ", indices=" + this.f14187d + '}';
    }
}
