package r3;

import a6.a;
import u2.c;
import u3.h;
import v3.d;
import xa.j;

public final class q0 extends h {

    /* renamed from: f  reason: collision with root package name */
    public static final p0 f13734f = new p0(0);

    /* renamed from: b  reason: collision with root package name */
    public j f13735b;

    /* renamed from: c  reason: collision with root package name */
    public final c f13736c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13737d;

    /* renamed from: e  reason: collision with root package name */
    public final String f13738e;

    public q0(j jVar, a aVar, String str, String str2) {
        super(aVar.f15201b);
        this.f13735b = jVar;
        this.f13736c = aVar;
        this.f13737d = str;
        this.f13738e = str2;
    }

    public final void b(d dVar) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        hb.h0.A(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(v3.d r4) {
        /*
            r3 = this;
            r3.p0 r0 = f13734f
            r0.getClass()
            java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            android.database.Cursor r0 = r4.C0(r0)
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x004c }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            int r1 = r0.getInt(r2)     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0019
            r2 = 1
        L_0x0019:
            r1 = 0
            hb.h0.A(r0, r1)
            u2.c r0 = r3.f13736c
            r0.a(r4)
            if (r2 != 0) goto L_0x0045
            h3.s2 r1 = r0.h(r4)
            boolean r2 = r1.f7314h
            if (r2 == 0) goto L_0x002d
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.Object r1 = r1.f7315i
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L_0x0045:
            r3.g(r4)
            r0.d(r4)
            return
        L_0x004c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            hb.h0.A(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.q0.c(v3.d):void");
    }

    public final void d(d dVar, int i10, int i11) {
        f(dVar, i10, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        hb.h0.A(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        hb.h0.A(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a3, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(v3.d r6) {
        /*
            r5 = this;
            r3.p0 r0 = f13734f
            r0.getClass()
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r6.C0(r0)
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x009d }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            int r1 = r0.getInt(r2)     // Catch:{ all -> 0x009d }
            if (r1 == 0) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            r3 = 0
            hb.h0.A(r0, r3)
            u2.c r0 = r5.f13736c
            if (r1 == 0) goto L_0x0071
            u3.b r1 = new u3.b
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r4)
            android.database.Cursor r1 = r6.T(r1)
            boolean r4 = r1.moveToFirst()     // Catch:{ all -> 0x006a }
            if (r4 == 0) goto L_0x0039
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x006a }
            goto L_0x003a
        L_0x0039:
            r2 = r3
        L_0x003a:
            hb.h0.A(r1, r3)
            java.lang.String r1 = r5.f13737d
            boolean r4 = xa.j.a(r1, r2)
            if (r4 != 0) goto L_0x007f
            java.lang.String r4 = r5.f13738e
            boolean r4 = xa.j.a(r4, r2)
            if (r4 == 0) goto L_0x004e
            goto L_0x007f
        L_0x004e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = ", found: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x006a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x006c }
        L_0x006c:
            r0 = move-exception
            hb.h0.A(r1, r6)
            throw r0
        L_0x0071:
            h3.s2 r1 = r0.h(r6)
            boolean r2 = r1.f7314h
            if (r2 == 0) goto L_0x0085
            r0.f()
            r5.g(r6)
        L_0x007f:
            r0.e(r6)
            r5.f13735b = r3
            return
        L_0x0085:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.Object r1 = r1.f7315i
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x009d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x009f }
        L_0x009f:
            r1 = move-exception
            hb.h0.A(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.q0.e(v3.d):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r10 <= r15) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r10 < r6) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(v3.d r13, int r14, int r15) {
        /*
            r12 = this;
            r3.j r0 = r12.f13735b
            u2.c r1 = r12.f13736c
            r2 = 0
            if (r0 == 0) goto L_0x00cd
            r3.l0 r0 = r0.f13700d
            r0.getClass()
            r3 = 1
            if (r14 != r15) goto L_0x0013
            ma.b0 r0 = ma.b0.f10801h
            goto L_0x008c
        L_0x0013:
            if (r15 <= r14) goto L_0x0017
            r4 = 1
            goto L_0x0018
        L_0x0017:
            r4 = 0
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r14
        L_0x001e:
            if (r4 == 0) goto L_0x0023
            if (r6 >= r15) goto L_0x0027
            goto L_0x0025
        L_0x0023:
            if (r6 <= r15) goto L_0x0027
        L_0x0025:
            r7 = 1
            goto L_0x0028
        L_0x0027:
            r7 = 0
        L_0x0028:
            if (r7 == 0) goto L_0x008b
            java.util.LinkedHashMap r7 = r0.f13713a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r7.get(r8)
            java.util.TreeMap r7 = (java.util.TreeMap) r7
            if (r7 != 0) goto L_0x0039
            goto L_0x0089
        L_0x0039:
            if (r4 == 0) goto L_0x0040
            java.util.NavigableSet r8 = r7.descendingKeySet()
            goto L_0x0044
        L_0x0040:
            java.util.Set r8 = r7.keySet()
        L_0x0044:
            java.util.Iterator r8 = r8.iterator()
        L_0x0048:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0086
            java.lang.Object r9 = r8.next()
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.String r10 = "targetVersion"
            if (r4 == 0) goto L_0x0066
            int r11 = r6 + 1
            xa.j.e(r10, r9)
            int r10 = r9.intValue()
            if (r11 > r10) goto L_0x0073
            if (r10 > r15) goto L_0x0073
            goto L_0x0071
        L_0x0066:
            xa.j.e(r10, r9)
            int r10 = r9.intValue()
            if (r15 > r10) goto L_0x0073
            if (r10 >= r6) goto L_0x0073
        L_0x0071:
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            if (r10 == 0) goto L_0x0048
            java.lang.Object r6 = r7.get(r9)
            xa.j.c(r6)
            r5.add(r6)
            int r6 = r9.intValue()
            r7 = 1
            goto L_0x0087
        L_0x0086:
            r7 = 0
        L_0x0087:
            if (r7 != 0) goto L_0x001e
        L_0x0089:
            r0 = 0
            goto L_0x008c
        L_0x008b:
            r0 = r5
        L_0x008c:
            if (r0 == 0) goto L_0x00cd
            r1.g(r13)
            java.util.Iterator r0 = r0.iterator()
        L_0x0095:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00a5
            java.lang.Object r2 = r0.next()
            r9.a r2 = (r9.a) r2
            r2.a(r13)
            goto L_0x0095
        L_0x00a5:
            h3.s2 r0 = r1.h(r13)
            boolean r2 = r0.f7314h
            if (r2 == 0) goto L_0x00b5
            r1.f()
            r12.g(r13)
            r2 = 1
            goto L_0x00cd
        L_0x00b5:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "Migration didn't properly handle: "
            r14.<init>(r15)
            java.lang.Object r15 = r0.f7315i
            java.lang.String r15 = (java.lang.String) r15
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x00cd:
            if (r2 != 0) goto L_0x0101
            r3.j r0 = r12.f13735b
            if (r0 == 0) goto L_0x00e0
            boolean r0 = r0.a(r14, r15)
            if (r0 != 0) goto L_0x00e0
            r1.b(r13)
            r1.a(r13)
            goto L_0x0101
        L_0x00e0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A migration from "
            r0.<init>(r1)
            r0.append(r14)
            java.lang.String r14 = " to "
            r0.append(r14)
            r0.append(r15)
            java.lang.String r14 = " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods."
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.q0.f(v3.d, int, int):void");
    }

    public final void g(d dVar) {
        dVar.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        int i10 = o0.f13731a;
        String str = this.f13737d;
        j.f("hash", str);
        dVar.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
    }
}
