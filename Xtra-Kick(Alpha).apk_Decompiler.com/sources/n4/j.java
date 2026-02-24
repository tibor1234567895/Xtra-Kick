package n4;

import android.support.v4.media.session.u;
import i4.m;
import q4.g;

public final class j implements k {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f11688d = 0;

    /* renamed from: a  reason: collision with root package name */
    public final m f11689a;

    /* renamed from: b  reason: collision with root package name */
    public final u f11690b;

    /* renamed from: c  reason: collision with root package name */
    public final g f11691c;

    static {
        new a(0);
    }

    public j(m mVar, u uVar) {
        this.f11689a = mVar;
        this.f11690b = uVar;
        this.f11691c = new g(mVar, uVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: j4.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: j4.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: la.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: la.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: j4.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: la.i} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(n4.j r16, m4.v r17, i4.c r18, s4.i r19, java.lang.Object r20, s4.m r21, i4.i r22, pa.e r23) {
        /*
            r0 = r23
            r16.getClass()
            boolean r1 = r0 instanceof n4.c
            if (r1 == 0) goto L_0x001a
            r1 = r0
            n4.c r1 = (n4.c) r1
            int r2 = r1.f11633r
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001a
            int r2 = r2 - r3
            r1.f11633r = r2
            r2 = r16
            goto L_0x0021
        L_0x001a:
            n4.c r1 = new n4.c
            r2 = r16
            r1.<init>(r2, r0)
        L_0x0021:
            java.lang.Object r0 = r1.f11631p
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r1.f11633r
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0056
            if (r4 != r6) goto L_0x004e
            int r2 = r1.f11630o
            i4.i r4 = r1.f11629n
            s4.m r7 = r1.f11628m
            java.lang.Object r8 = r1.f11627l
            s4.i r9 = r1.f11626k
            i4.c r10 = r1.f11625j
            m4.v r11 = r1.f11624i
            n4.j r12 = r1.f11623h
            hb.h0.O1(r0)
            r6 = r4
            r4 = r8
            r8 = r1
            r1 = r10
            r10 = r5
            r5 = r7
            r7 = r2
            r2 = r12
            r12 = 1
            r15 = r9
            r9 = r3
            r3 = r15
            goto L_0x00c2
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0056:
            hb.h0.O1(r0)
            r0 = 0
            r0 = r17
            r4 = r20
            r6 = r22
            r8 = r1
            r9 = r3
            r10 = r5
            r7 = 0
            r11 = 1
            r1 = r18
            r3 = r19
            r5 = r21
        L_0x006b:
            i4.m r12 = r2.f11689a
            java.util.List r12 = r1.f8241e
            int r13 = r12.size()
        L_0x0073:
            if (r7 >= r13) goto L_0x008e
            java.lang.Object r14 = r12.get(r7)
            j4.j r14 = (j4.j) r14
            j4.k r14 = r14.a(r0, r5)
            if (r14 == 0) goto L_0x008b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            la.i r12 = new la.i
            r12.<init>(r14, r7)
            goto L_0x008f
        L_0x008b:
            int r7 = r7 + 1
            goto L_0x0073
        L_0x008e:
            r12 = r10
        L_0x008f:
            if (r12 == 0) goto L_0x00e6
            java.lang.Object r7 = r12.f9799h
            j4.k r7 = (j4.k) r7
            java.lang.Object r12 = r12.f9800i
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            int r12 = r12 + r11
            r6.getClass()
            r8.f11623h = r2
            r8.f11624i = r0
            r8.f11625j = r1
            r8.f11626k = r3
            r8.f11627l = r4
            r8.f11628m = r5
            r8.f11629n = r6
            r8.getClass()
            r8.f11630o = r12
            r8.f11633r = r11
            java.lang.Object r7 = r7.a(r8)
            if (r7 != r9) goto L_0x00bd
            goto L_0x00e2
        L_0x00bd:
            r15 = r11
            r11 = r0
            r0 = r7
            r7 = r12
            r12 = r15
        L_0x00c2:
            j4.h r0 = (j4.h) r0
            r6.getClass()
            if (r0 == 0) goto L_0x00e3
            n4.b r9 = new n4.b
            int r1 = r11.f10602c
            j4.e0 r2 = r11.f10600a
            boolean r3 = r2 instanceof j4.q
            if (r3 == 0) goto L_0x00d6
            j4.q r2 = (j4.q) r2
            goto L_0x00d7
        L_0x00d6:
            r2 = r10
        L_0x00d7:
            if (r2 == 0) goto L_0x00db
            java.lang.String r10 = r2.f8775j
        L_0x00db:
            android.graphics.drawable.Drawable r2 = r0.f8756a
            boolean r0 = r0.f8757b
            r9.<init>(r2, r0, r1, r10)
        L_0x00e2:
            return r9
        L_0x00e3:
            r0 = r11
            r11 = r12
            goto L_0x006b
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to create a decoder that supports: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.j.a(n4.j, m4.v, i4.c, s4.i, java.lang.Object, s4.m, i4.i, pa.e):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: n4.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: n4.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: n4.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: n4.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: n4.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r10v0, types: [qa.a] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r10v3, types: [n4.b] */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019f, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a0, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021a, code lost:
        if (r1 == r10) goto L_0x0236;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x004f, B:60:0x0180] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0160 A[Catch:{ all -> 0x019e, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a3 A[Catch:{ all -> 0x019e, all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(n4.j r27, s4.i r28, java.lang.Object r29, s4.m r30, i4.i r31, pa.e r32) {
        /*
            r0 = r27
            r8 = r28
            r1 = r32
            r27.getClass()
            boolean r2 = r1 instanceof n4.d
            if (r2 == 0) goto L_0x001c
            r2 = r1
            n4.d r2 = (n4.d) r2
            int r3 = r2.f11644r
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001c
            int r3 = r3 - r4
            r2.f11644r = r3
            goto L_0x0021
        L_0x001c:
            n4.d r2 = new n4.d
            r2.<init>(r0, r1)
        L_0x0021:
            r9 = r2
            java.lang.Object r1 = r9.f11642p
            qa.a r10 = qa.a.COROUTINE_SUSPENDED
            int r2 = r9.f11644r
            r11 = 3
            r12 = 2
            r3 = 1
            if (r2 == 0) goto L_0x0077
            if (r2 == r3) goto L_0x0054
            if (r2 == r12) goto L_0x0041
            if (r2 != r11) goto L_0x0039
            hb.h0.O1(r1)
            r3 = 0
            goto L_0x021d
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            xa.u r2 = r9.f11638l
            java.lang.Object r0 = r9.f11637k
            xa.u r0 = (xa.u) r0
            java.lang.Object r3 = r9.f11636j
            i4.i r3 = (i4.i) r3
            s4.i r4 = r9.f11635i
            n4.j r5 = r9.f11634h
            hb.h0.O1(r1)     // Catch:{ all -> 0x0073 }
            goto L_0x0195
        L_0x0054:
            xa.u r0 = r9.f11641o
            xa.u r2 = r9.f11640n
            xa.u r3 = r9.f11639m
            xa.u r4 = r9.f11638l
            java.lang.Object r5 = r9.f11637k
            i4.i r5 = (i4.i) r5
            java.lang.Object r6 = r9.f11636j
            s4.i r7 = r9.f11635i
            n4.j r8 = r9.f11634h
            hb.h0.O1(r1)     // Catch:{ all -> 0x0073 }
            r13 = r0
            r21 = r3
            r14 = r4
            r12 = r5
            r23 = r6
            r0 = r8
            goto L_0x0155
        L_0x0073:
            r0 = move-exception
            r3 = 0
            goto L_0x0242
        L_0x0077:
            hb.h0.O1(r1)
            xa.u r14 = new xa.u
            r14.<init>()
            r1 = r30
            r14.f16818h = r1
            xa.u r15 = new xa.u
            r15.<init>()
            i4.m r1 = r0.f11689a
            i4.t r1 = (i4.t) r1
            i4.c r1 = r1.f8277f
            r15.f16818h = r1
            xa.u r7 = new xa.u
            r7.<init>()
            android.support.v4.media.session.u r1 = r0.f11690b     // Catch:{ all -> 0x0247 }
            java.lang.Object r2 = r14.f16818h     // Catch:{ all -> 0x0247 }
            s4.m r2 = (s4.m) r2     // Catch:{ all -> 0x0247 }
            r1.getClass()     // Catch:{ all -> 0x0247 }
            android.graphics.Bitmap$Config r2 = r2.f14277b     // Catch:{ all -> 0x0247 }
            boolean r2 = hb.h0.V0(r2)     // Catch:{ all -> 0x0247 }
            r4 = 0
            if (r2 == 0) goto L_0x00b4
            java.lang.Object r1 = r1.f430k     // Catch:{ all -> 0x0247 }
            w4.i r1 = (w4.i) r1     // Catch:{ all -> 0x0247 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0247 }
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r1 = 0
            goto L_0x00b5
        L_0x00b4:
            r1 = 1
        L_0x00b5:
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r14.f16818h     // Catch:{ all -> 0x00c4 }
            s4.m r1 = (s4.m) r1     // Catch:{ all -> 0x00c4 }
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x00c4 }
            s4.m r1 = s4.m.a(r1, r2)     // Catch:{ all -> 0x00c4 }
            r14.f16818h = r1     // Catch:{ all -> 0x00c4 }
            goto L_0x00c7
        L_0x00c4:
            r0 = move-exception
            goto L_0x01a0
        L_0x00c7:
            la.i r1 = r8.f14257i     // Catch:{ all -> 0x0247 }
            j4.j r2 = r8.f14258j
            if (r1 != 0) goto L_0x00cf
            if (r2 == 0) goto L_0x011d
        L_0x00cf:
            java.lang.Object r1 = r15.f16818h     // Catch:{ all -> 0x0247 }
            i4.c r1 = (i4.c) r1     // Catch:{ all -> 0x0247 }
            r1.getClass()     // Catch:{ all -> 0x0247 }
            java.util.List r5 = r1.f8237a     // Catch:{ all -> 0x0247 }
            java.util.ArrayList r5 = ma.z.K(r5)     // Catch:{ all -> 0x0247 }
            java.util.List r6 = r1.f8238b     // Catch:{ all -> 0x0247 }
            java.util.ArrayList r6 = ma.z.K(r6)     // Catch:{ all -> 0x0247 }
            java.util.List r11 = r1.f8239c     // Catch:{ all -> 0x0247 }
            java.util.ArrayList r11 = ma.z.K(r11)     // Catch:{ all -> 0x0247 }
            java.util.List r12 = r1.f8240d     // Catch:{ all -> 0x0247 }
            java.util.ArrayList r12 = ma.z.K(r12)     // Catch:{ all -> 0x0247 }
            java.util.List r1 = r1.f8241e     // Catch:{ all -> 0x0247 }
            java.util.ArrayList r1 = ma.z.K(r1)     // Catch:{ all -> 0x0247 }
            la.i r13 = r8.f14257i     // Catch:{ all -> 0x0247 }
            if (r13 == 0) goto L_0x00fb
            r12.add(r4, r13)     // Catch:{ all -> 0x00c4 }
        L_0x00fb:
            if (r2 == 0) goto L_0x0100
            r1.add(r4, r2)     // Catch:{ all -> 0x00c4 }
        L_0x0100:
            i4.c r2 = new i4.c     // Catch:{ all -> 0x0247 }
            java.util.List r19 = hb.h0.U1(r5)     // Catch:{ all -> 0x0247 }
            java.util.List r20 = hb.h0.U1(r6)     // Catch:{ all -> 0x0247 }
            java.util.List r21 = hb.h0.U1(r11)     // Catch:{ all -> 0x0247 }
            java.util.List r22 = hb.h0.U1(r12)     // Catch:{ all -> 0x0247 }
            java.util.List r23 = hb.h0.U1(r1)     // Catch:{ all -> 0x0247 }
            r18 = r2
            r18.<init>(r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0247 }
            r15.f16818h = r2     // Catch:{ all -> 0x0247 }
        L_0x011d:
            java.lang.Object r1 = r15.f16818h     // Catch:{ all -> 0x0247 }
            r2 = r1
            i4.c r2 = (i4.c) r2     // Catch:{ all -> 0x0247 }
            java.lang.Object r1 = r14.f16818h     // Catch:{ all -> 0x0247 }
            r5 = r1
            s4.m r5 = (s4.m) r5     // Catch:{ all -> 0x0247 }
            r9.f11634h = r0     // Catch:{ all -> 0x0247 }
            r9.f11635i = r8     // Catch:{ all -> 0x0247 }
            r11 = r29
            r9.f11636j = r11     // Catch:{ all -> 0x0247 }
            r12 = r31
            r9.f11637k = r12     // Catch:{ all -> 0x0247 }
            r9.f11638l = r14     // Catch:{ all -> 0x0247 }
            r9.f11639m = r15     // Catch:{ all -> 0x0247 }
            r9.f11640n = r7     // Catch:{ all -> 0x0247 }
            r9.f11641o = r7     // Catch:{ all -> 0x0247 }
            r9.f11644r = r3     // Catch:{ all -> 0x0247 }
            r1 = r27
            r3 = r28
            r4 = r29
            r6 = r31
            r13 = r7
            r7 = r9
            java.lang.Object r1 = r1.c(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0244 }
            if (r1 != r10) goto L_0x014f
            goto L_0x0236
        L_0x014f:
            r7 = r8
            r23 = r11
            r2 = r13
            r21 = r15
        L_0x0155:
            r13.f16818h = r1     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = r2.f16818h     // Catch:{ all -> 0x0073 }
            r3 = r1
            m4.i r3 = (m4.i) r3     // Catch:{ all -> 0x0073 }
            boolean r4 = r3 instanceof m4.v     // Catch:{ all -> 0x0073 }
            if (r4 == 0) goto L_0x01a3
            hb.d0 r1 = r7.f14269u     // Catch:{ all -> 0x0073 }
            n4.e r3 = new n4.e     // Catch:{ all -> 0x0073 }
            r26 = 0
            r18 = r3
            r19 = r0
            r20 = r2
            r22 = r7
            r24 = r14
            r25 = r12
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0073 }
            r9.f11634h = r0     // Catch:{ all -> 0x0073 }
            r9.f11635i = r7     // Catch:{ all -> 0x0073 }
            r9.f11636j = r12     // Catch:{ all -> 0x0073 }
            r9.f11637k = r14     // Catch:{ all -> 0x0073 }
            r9.f11638l = r2     // Catch:{ all -> 0x0073 }
            r4 = 0
            r9.f11639m = r4     // Catch:{ all -> 0x019e }
            r9.f11640n = r4     // Catch:{ all -> 0x019e }
            r9.f11641o = r4     // Catch:{ all -> 0x019e }
            r4 = 2
            r9.f11644r = r4     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = hb.h0.c2(r1, r3, r9)     // Catch:{ all -> 0x0073 }
            if (r1 != r10) goto L_0x0191
            goto L_0x0236
        L_0x0191:
            r5 = r0
            r4 = r7
            r3 = r12
            r0 = r14
        L_0x0195:
            n4.b r1 = (n4.b) r1     // Catch:{ all -> 0x0073 }
            r14 = r0
            r20 = r3
            r7 = r4
            r16 = r5
            goto L_0x01c0
        L_0x019e:
            r0 = move-exception
            r7 = r2
        L_0x01a0:
            r3 = 0
            goto L_0x024b
        L_0x01a3:
            boolean r3 = r3 instanceof m4.h     // Catch:{ all -> 0x0073 }
            if (r3 == 0) goto L_0x023a
            n4.b r3 = new n4.b     // Catch:{ all -> 0x0073 }
            r4 = r1
            m4.h r4 = (m4.h) r4     // Catch:{ all -> 0x0073 }
            android.graphics.drawable.Drawable r4 = r4.f10575a     // Catch:{ all -> 0x0073 }
            r5 = r1
            m4.h r5 = (m4.h) r5     // Catch:{ all -> 0x0073 }
            boolean r5 = r5.f10576b     // Catch:{ all -> 0x0073 }
            m4.h r1 = (m4.h) r1     // Catch:{ all -> 0x0073 }
            int r1 = r1.f10577c     // Catch:{ all -> 0x0073 }
            r6 = 0
            r3.<init>(r4, r5, r1, r6)     // Catch:{ all -> 0x0237 }
            r16 = r0
            r1 = r3
            r20 = r12
        L_0x01c0:
            java.lang.Object r0 = r2.f16818h
            boolean r2 = r0 instanceof m4.v
            if (r2 == 0) goto L_0x01ca
            r4 = r0
            m4.v r4 = (m4.v) r4
            goto L_0x01cb
        L_0x01ca:
            r4 = 0
        L_0x01cb:
            if (r4 == 0) goto L_0x01d4
            j4.e0 r0 = r4.f10600a
            if (r0 == 0) goto L_0x01d4
            w4.e.a(r0)
        L_0x01d4:
            java.lang.Object r0 = r14.f16818h
            r18 = r0
            s4.m r18 = (s4.m) r18
            r3 = 0
            r9.f11634h = r3
            r9.f11635i = r3
            r9.f11636j = r3
            r9.f11637k = r3
            r9.f11638l = r3
            r9.f11639m = r3
            r9.f11640n = r3
            r9.f11641o = r3
            r0 = 3
            r9.f11644r = r0
            r16.getClass()
            java.util.List r0 = r7.f14259k
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x01fa
            goto L_0x021a
        L_0x01fa:
            android.graphics.drawable.Drawable r2 = r1.f11619a
            boolean r2 = r2 instanceof android.graphics.drawable.BitmapDrawable
            if (r2 != 0) goto L_0x0205
            boolean r2 = r7.f14263o
            if (r2 != 0) goto L_0x0205
            goto L_0x021a
        L_0x0205:
            n4.i r2 = new n4.i
            r22 = 0
            r15 = r2
            r17 = r1
            r19 = r0
            r21 = r7
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            hb.d0 r0 = r7.f14270v
            java.lang.Object r0 = hb.h0.c2(r0, r2, r9)
            r1 = r0
        L_0x021a:
            if (r1 != r10) goto L_0x021d
            goto L_0x0236
        L_0x021d:
            r10 = r1
            n4.b r10 = (n4.b) r10
            android.graphics.drawable.Drawable r0 = r10.f11619a
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L_0x022a
            r13 = r0
            android.graphics.drawable.BitmapDrawable r13 = (android.graphics.drawable.BitmapDrawable) r13
            goto L_0x022b
        L_0x022a:
            r13 = r3
        L_0x022b:
            if (r13 == 0) goto L_0x0236
            android.graphics.Bitmap r0 = r13.getBitmap()
            if (r0 == 0) goto L_0x0236
            r0.prepareToDraw()
        L_0x0236:
            return r10
        L_0x0237:
            r0 = move-exception
            r3 = r6
            goto L_0x0242
        L_0x023a:
            r3 = 0
            la.g r0 = new la.g     // Catch:{ all -> 0x0241 }
            r0.<init>()     // Catch:{ all -> 0x0241 }
            throw r0     // Catch:{ all -> 0x0241 }
        L_0x0241:
            r0 = move-exception
        L_0x0242:
            r7 = r2
            goto L_0x024b
        L_0x0244:
            r0 = move-exception
        L_0x0245:
            r3 = 0
            goto L_0x024a
        L_0x0247:
            r0 = move-exception
            r13 = r7
            goto L_0x0245
        L_0x024a:
            r7 = r13
        L_0x024b:
            java.lang.Object r1 = r7.f16818h
            boolean r2 = r1 instanceof m4.v
            if (r2 == 0) goto L_0x0255
            r13 = r1
            m4.v r13 = (m4.v) r13
            goto L_0x0256
        L_0x0255:
            r13 = r3
        L_0x0256:
            if (r13 == 0) goto L_0x025f
            j4.e0 r1 = r13.f10600a
            if (r1 == 0) goto L_0x025f
            w4.e.a(r1)
        L_0x025f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.j.b(n4.j, s4.i, java.lang.Object, s4.m, i4.i, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(i4.c r18, s4.i r19, java.lang.Object r20, s4.m r21, i4.i r22, pa.e r23) {
        /*
            r17 = this;
            r0 = r23
            boolean r1 = r0 instanceof n4.f
            if (r1 == 0) goto L_0x0017
            r1 = r0
            n4.f r1 = (n4.f) r1
            int r2 = r1.f11662q
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f11662q = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            n4.f r1 = new n4.f
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f11660o
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r1.f11662q
            r5 = 1
            if (r4 == 0) goto L_0x004f
            if (r4 != r5) goto L_0x0047
            int r4 = r1.f11659n
            i4.i r6 = r1.f11658m
            s4.m r7 = r1.f11657l
            java.lang.Object r8 = r1.f11656k
            s4.i r9 = r1.f11655j
            i4.c r10 = r1.f11654i
            n4.j r11 = r1.f11653h
            hb.h0.O1(r0)
            r5 = r6
            r6 = r4
            r4 = r7
            r7 = r1
            r1 = r9
            r9 = 1
            r16 = r8
            r8 = r3
            r3 = r16
            goto L_0x00cf
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004f:
            hb.h0.O1(r0)
            r0 = 0
            r0 = r18
            r4 = r21
            r5 = r22
            r7 = r1
            r11 = r2
            r8 = r3
            r6 = 0
            r9 = 1
            r1 = r19
            r3 = r20
        L_0x0062:
            i4.m r10 = r11.f11689a
            java.util.List r10 = r0.f8240d
            int r12 = r10.size()
        L_0x006a:
            if (r6 >= r12) goto L_0x009c
            java.lang.Object r13 = r10.get(r6)
            la.i r13 = (la.i) r13
            java.lang.Object r14 = r13.f9799h
            m4.j r14 = (m4.j) r14
            java.lang.Object r13 = r13.f9800i
            java.lang.Class r13 = (java.lang.Class) r13
            java.lang.Class r15 = r3.getClass()
            boolean r13 = r13.isAssignableFrom(r15)
            if (r13 == 0) goto L_0x0099
            java.lang.String r13 = "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>"
            xa.j.d(r13, r14)
            m4.k r13 = r14.a(r3, r4)
            if (r13 == 0) goto L_0x0099
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            la.i r10 = new la.i
            r10.<init>(r13, r6)
            goto L_0x009d
        L_0x0099:
            int r6 = r6 + 1
            goto L_0x006a
        L_0x009c:
            r10 = 0
        L_0x009d:
            if (r10 == 0) goto L_0x00ee
            java.lang.Object r6 = r10.f9799h
            m4.k r6 = (m4.k) r6
            java.lang.Object r10 = r10.f9800i
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            int r10 = r10 + r9
            r5.getClass()
            r7.f11653h = r11
            r7.f11654i = r0
            r7.f11655j = r1
            r7.f11656k = r3
            r7.f11657l = r4
            r7.f11658m = r5
            r7.getClass()
            r7.f11659n = r10
            r7.f11662q = r9
            java.lang.Object r6 = r6.a(r7)
            if (r6 != r8) goto L_0x00c9
            return r8
        L_0x00c9:
            r16 = r10
            r10 = r0
            r0 = r6
            r6 = r16
        L_0x00cf:
            r12 = r0
            m4.i r12 = (m4.i) r12
            r5.getClass()     // Catch:{ all -> 0x00da }
            if (r12 == 0) goto L_0x00d8
            return r12
        L_0x00d8:
            r0 = r10
            goto L_0x0062
        L_0x00da:
            r0 = move-exception
            r1 = r0
            boolean r0 = r12 instanceof m4.v
            if (r0 == 0) goto L_0x00e3
            m4.v r12 = (m4.v) r12
            goto L_0x00e4
        L_0x00e3:
            r12 = 0
        L_0x00e4:
            if (r12 == 0) goto L_0x00ed
            j4.e0 r0 = r12.f10600a
            if (r0 == 0) goto L_0x00ed
            w4.e.a(r0)
        L_0x00ed:
            throw r1
        L_0x00ee:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to create a fetcher that supports: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.j.c(i4.c, s4.i, java.lang.Object, s4.m, i4.i, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(n4.m r18, pa.e r19) {
        /*
            r17 = this;
            r10 = r17
            r11 = r18
            r0 = r19
            q4.g r1 = r10.f11691c
            boolean r2 = r0 instanceof n4.g
            if (r2 == 0) goto L_0x001b
            r2 = r0
            n4.g r2 = (n4.g) r2
            int r3 = r2.f11667l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001b
            int r3 = r3 - r4
            r2.f11667l = r3
            goto L_0x0020
        L_0x001b:
            n4.g r2 = new n4.g
            r2.<init>(r10, r0)
        L_0x0020:
            r0 = r2
            java.lang.Object r2 = r0.f11665j
            qa.a r12 = qa.a.COROUTINE_SUSPENDED
            int r3 = r0.f11667l
            r13 = 1
            if (r3 == 0) goto L_0x0040
            if (r3 != r13) goto L_0x0038
            n4.m r1 = r0.f11664i
            n4.j r3 = r0.f11663h
            hb.h0.O1(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x00c5
        L_0x0035:
            r0 = move-exception
            goto L_0x00c9
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            hb.h0.O1(r2)
            s4.i r3 = r11.f11700d     // Catch:{ all -> 0x00c6 }
            java.lang.Object r2 = r3.f14250b     // Catch:{ all -> 0x00c6 }
            t4.g r4 = r11.f11701e     // Catch:{ all -> 0x00c6 }
            android.graphics.Bitmap$Config[] r5 = w4.e.f16080a     // Catch:{ all -> 0x00c6 }
            i4.i r6 = r11.f11702f     // Catch:{ all -> 0x00c6 }
            android.support.v4.media.session.u r5 = r10.f11690b     // Catch:{ all -> 0x00c6 }
            s4.m r5 = r5.H(r3, r4)     // Catch:{ all -> 0x00c6 }
            int r7 = r5.f14280e     // Catch:{ all -> 0x00c6 }
            r6.getClass()     // Catch:{ all -> 0x00c6 }
            i4.m r8 = r10.f11689a     // Catch:{ all -> 0x00c6 }
            i4.t r8 = (i4.t) r8     // Catch:{ all -> 0x00c6 }
            i4.c r8 = r8.f8277f     // Catch:{ all -> 0x00c6 }
            java.util.List r8 = r8.f8238b     // Catch:{ all -> 0x00c6 }
            int r9 = r8.size()     // Catch:{ all -> 0x00c6 }
            r14 = 0
            r14 = r2
            r2 = 0
        L_0x0067:
            if (r2 >= r9) goto L_0x0095
            java.lang.Object r15 = r8.get(r2)     // Catch:{ all -> 0x00c6 }
            la.i r15 = (la.i) r15     // Catch:{ all -> 0x00c6 }
            java.lang.Object r13 = r15.f9799h     // Catch:{ all -> 0x00c6 }
            p4.d r13 = (p4.d) r13     // Catch:{ all -> 0x00c6 }
            java.lang.Object r15 = r15.f9800i     // Catch:{ all -> 0x00c6 }
            java.lang.Class r15 = (java.lang.Class) r15     // Catch:{ all -> 0x00c6 }
            r16 = r8
            java.lang.Class r8 = r14.getClass()     // Catch:{ all -> 0x00c6 }
            boolean r8 = r15.isAssignableFrom(r8)     // Catch:{ all -> 0x00c6 }
            if (r8 == 0) goto L_0x008f
            java.lang.String r8 = "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>"
            xa.j.d(r8, r13)     // Catch:{ all -> 0x00c6 }
            java.lang.Object r8 = r13.a(r14, r5)     // Catch:{ all -> 0x00c6 }
            if (r8 == 0) goto L_0x008f
            r14 = r8
        L_0x008f:
            int r2 = r2 + 1
            r8 = r16
            r13 = 1
            goto L_0x0067
        L_0x0095:
            q4.d r8 = r1.b(r3, r14, r5, r6)     // Catch:{ all -> 0x00c6 }
            if (r8 == 0) goto L_0x00a0
            q4.e r1 = r1.a(r3, r8, r4, r7)     // Catch:{ all -> 0x00c6 }
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            if (r1 == 0) goto L_0x00a8
            s4.r r0 = q4.g.c(r11, r3, r8, r1)     // Catch:{ all -> 0x00c6 }
            return r0
        L_0x00a8:
            hb.d0 r13 = r3.f14268t     // Catch:{ all -> 0x00c6 }
            n4.h r15 = new n4.h     // Catch:{ all -> 0x00c6 }
            r9 = 0
            r1 = r15
            r2 = r17
            r4 = r14
            r7 = r8
            r8 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c6 }
            r0.f11663h = r10     // Catch:{ all -> 0x00c6 }
            r0.f11664i = r11     // Catch:{ all -> 0x00c6 }
            r1 = 1
            r0.f11667l = r1     // Catch:{ all -> 0x00c6 }
            java.lang.Object r2 = hb.h0.c2(r13, r15, r0)     // Catch:{ all -> 0x00c6 }
            if (r2 != r12) goto L_0x00c5
            return r12
        L_0x00c5:
            return r2
        L_0x00c6:
            r0 = move-exception
            r3 = r10
            r1 = r11
        L_0x00c9:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException
            if (r2 != 0) goto L_0x00f0
            android.support.v4.media.session.u r2 = r3.f11690b
            s4.i r1 = r1.f11700d
            r2.getClass()
            s4.d r2 = new s4.d
            boolean r3 = r0 instanceof s4.l
            if (r3 == 0) goto L_0x00e8
            s4.a r3 = r1.H
            android.graphics.drawable.Drawable r3 = r3.f14199l
            android.graphics.drawable.Drawable r4 = r1.F
            java.lang.Integer r5 = r1.E
            android.graphics.drawable.Drawable r3 = w4.c.b(r1, r4, r5, r3)
            if (r3 != 0) goto L_0x00ec
        L_0x00e8:
            android.graphics.drawable.Drawable r3 = r1.a()
        L_0x00ec:
            r2.<init>(r3, r1, r0)
            return r2
        L_0x00f0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.j.d(n4.m, pa.e):java.lang.Object");
    }
}
