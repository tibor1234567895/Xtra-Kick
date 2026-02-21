package m4;

import android.webkit.MimeTypeMap;
import dc.f0;
import fb.w;
import fb.y;
import j4.q;
import java.util.Map;
import k4.c;
import k4.n;
import la.e;
import pb.g;
import pb.i1;
import pb.j1;
import pb.p0;
import pb.x0;
import q0.f;
import s4.m;
import xa.j;

public final class r implements k {

    /* renamed from: f  reason: collision with root package name */
    public static final g f10591f;

    /* renamed from: g  reason: collision with root package name */
    public static final g f10592g;

    /* renamed from: a  reason: collision with root package name */
    public final String f10593a;

    /* renamed from: b  reason: collision with root package name */
    public final m f10594b;

    /* renamed from: c  reason: collision with root package name */
    public final e f10595c;

    /* renamed from: d  reason: collision with root package name */
    public final e f10596d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f10597e;

    static {
        new n(0);
        pb.e eVar = new pb.e();
        eVar.f12814a = true;
        eVar.f12815b = true;
        f10591f = eVar.a();
        pb.e eVar2 = new pb.e();
        eVar2.f12814a = true;
        eVar2.f12819f = true;
        f10592g = eVar2.a();
    }

    public r(String str, m mVar, e eVar, e eVar2, boolean z10) {
        this.f10593a = str;
        this.f10594b = mVar;
        this.f10595c = eVar;
        this.f10596d = eVar2;
        this.f10597e = z10;
    }

    public static String d(String str, x0 x0Var) {
        String str2;
        String b10;
        if (x0Var != null) {
            str2 = x0Var.f13024a;
        } else {
            str2 = null;
        }
        if ((str2 == null || w.m(str2, "text/plain", false)) && (b10 = w4.e.b(MimeTypeMap.getSingleton(), str)) != null) {
            return b10;
        }
        if (str2 != null) {
            return y.N(str2, ';');
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: pb.x0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: pb.x0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0202 A[SYNTHETIC, Splitter:B:109:0x0202] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0 A[SYNTHETIC, Splitter:B:32:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0119 A[Catch:{ Exception -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0139 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0147 A[SYNTHETIC, Splitter:B:63:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c0 A[Catch:{ Exception -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ed A[Catch:{ Exception -> 0x01eb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            boolean r2 = r0 instanceof m4.q
            if (r2 == 0) goto L_0x0017
            r2 = r0
            m4.q r2 = (m4.q) r2
            int r3 = r2.f10590m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f10590m = r3
            goto L_0x001c
        L_0x0017:
            m4.q r2 = new m4.q
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f10588k
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f10590m
            java.lang.String r5 = "response body == null"
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 2
            r11 = 1
            r12 = 4
            r13 = 3
            if (r4 == 0) goto L_0x005a
            if (r4 == r11) goto L_0x004a
            if (r4 != r10) goto L_0x0042
            java.lang.Object r3 = r2.f10587j
            pb.r1 r3 = (pb.r1) r3
            k4.m r4 = r2.f10586i
            m4.r r2 = r2.f10585h
            hb.h0.O1(r0)     // Catch:{ Exception -> 0x003f }
            goto L_0x01b7
        L_0x003f:
            r0 = move-exception
            goto L_0x01f7
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            java.lang.Object r4 = r2.f10587j
            r4.e r4 = (r4.e) r4
            k4.m r11 = r2.f10586i
            m4.r r14 = r2.f10585h
            hb.h0.O1(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x013e
        L_0x0057:
            r0 = move-exception
            goto L_0x020e
        L_0x005a:
            hb.h0.O1(r0)
            s4.m r0 = r1.f10594b
            int r4 = r0.f14289n
            boolean r4 = q0.f.d(r4)
            java.lang.String r14 = r1.f10593a
            if (r4 == 0) goto L_0x009d
            la.e r4 = r1.f10596d
            java.lang.Object r4 = r4.getValue()
            k4.c r4 = (k4.c) r4
            if (r4 == 0) goto L_0x009d
            java.lang.String r0 = r0.f14284i
            if (r0 != 0) goto L_0x0078
            r0 = r14
        L_0x0078:
            k4.n r4 = (k4.n) r4
            int r15 = k4.n.f9120c
            dc.m r15 = dc.n.f4802k
            r15.getClass()
            dc.n r0 = dc.m.b(r0)
            java.lang.String r15 = "SHA-256"
            dc.n r0 = r0.c(r15)
            java.lang.String r0 = r0.e()
            k4.i r4 = r4.f9122b
            k4.f r0 = r4.v(r0)
            if (r0 == 0) goto L_0x009d
            k4.m r4 = new k4.m
            r4.<init>(r0)
            goto L_0x009e
        L_0x009d:
            r4 = r7
        L_0x009e:
            if (r4 == 0) goto L_0x0119
            dc.r r0 = r18.c()     // Catch:{ Exception -> 0x020c }
            k4.f r15 = r4.f9119h     // Catch:{ Exception -> 0x020c }
            dc.f0 r15 = r15.c(r6)     // Catch:{ Exception -> 0x020c }
            dc.p r0 = r0.h(r15)     // Catch:{ Exception -> 0x020c }
            java.lang.Long r0 = r0.f4814d     // Catch:{ Exception -> 0x020c }
            if (r0 != 0) goto L_0x00b3
            goto L_0x00c9
        L_0x00b3:
            long r15 = r0.longValue()     // Catch:{ Exception -> 0x020c }
            int r0 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x00c9
            m4.v r0 = new m4.v     // Catch:{ Exception -> 0x020c }
            j4.q r2 = r1.g(r4)     // Catch:{ Exception -> 0x020c }
            java.lang.String r3 = d(r14, r7)     // Catch:{ Exception -> 0x020c }
            r0.<init>(r2, r3, r13)     // Catch:{ Exception -> 0x020c }
            return r0
        L_0x00c9:
            boolean r0 = r1.f10597e     // Catch:{ Exception -> 0x020c }
            if (r0 == 0) goto L_0x00fc
            r4.d r0 = new r4.d     // Catch:{ Exception -> 0x020c }
            pb.j1 r15 = r18.e()     // Catch:{ Exception -> 0x020c }
            r4.b r10 = r1.f(r4)     // Catch:{ Exception -> 0x020c }
            r0.<init>(r15, r10)     // Catch:{ Exception -> 0x020c }
            r4.e r0 = r0.a()     // Catch:{ Exception -> 0x020c }
            pb.j1 r10 = r0.f13813a     // Catch:{ Exception -> 0x020c }
            if (r10 != 0) goto L_0x0126
            r4.b r10 = r0.f13814b
            if (r10 == 0) goto L_0x0126
            m4.v r0 = new m4.v     // Catch:{ Exception -> 0x020c }
            j4.q r2 = r1.g(r4)     // Catch:{ Exception -> 0x020c }
            la.e r3 = r10.f13796b     // Catch:{ Exception -> 0x020c }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x020c }
            pb.x0 r3 = (pb.x0) r3     // Catch:{ Exception -> 0x020c }
            java.lang.String r3 = d(r14, r3)     // Catch:{ Exception -> 0x020c }
            r0.<init>(r2, r3, r13)     // Catch:{ Exception -> 0x020c }
            return r0
        L_0x00fc:
            m4.v r0 = new m4.v     // Catch:{ Exception -> 0x020c }
            j4.q r2 = r1.g(r4)     // Catch:{ Exception -> 0x020c }
            r4.b r3 = r1.f(r4)     // Catch:{ Exception -> 0x020c }
            if (r3 == 0) goto L_0x0111
            la.e r3 = r3.f13796b     // Catch:{ Exception -> 0x020c }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x020c }
            r7 = r3
            pb.x0 r7 = (pb.x0) r7     // Catch:{ Exception -> 0x020c }
        L_0x0111:
            java.lang.String r3 = d(r14, r7)     // Catch:{ Exception -> 0x020c }
            r0.<init>(r2, r3, r13)     // Catch:{ Exception -> 0x020c }
            return r0
        L_0x0119:
            r4.d r0 = new r4.d     // Catch:{ Exception -> 0x020c }
            pb.j1 r10 = r18.e()     // Catch:{ Exception -> 0x020c }
            r0.<init>(r10, r7)     // Catch:{ Exception -> 0x020c }
            r4.e r0 = r0.a()     // Catch:{ Exception -> 0x020c }
        L_0x0126:
            pb.j1 r10 = r0.f13813a     // Catch:{ Exception -> 0x020c }
            xa.j.c(r10)     // Catch:{ Exception -> 0x020c }
            r2.f10585h = r1     // Catch:{ Exception -> 0x020c }
            r2.f10586i = r4     // Catch:{ Exception -> 0x020c }
            r2.f10587j = r0     // Catch:{ Exception -> 0x020c }
            r2.f10590m = r11     // Catch:{ Exception -> 0x020c }
            java.lang.Object r10 = r1.b(r10, r2)     // Catch:{ Exception -> 0x020c }
            if (r10 != r3) goto L_0x013a
            return r3
        L_0x013a:
            r14 = r1
            r11 = r4
            r4 = r0
            r0 = r10
        L_0x013e:
            r10 = r0
            pb.r1 r10 = (pb.r1) r10     // Catch:{ Exception -> 0x0057 }
            android.graphics.Bitmap$Config[] r0 = w4.e.f16080a     // Catch:{ Exception -> 0x0057 }
            pb.u1 r0 = r10.f12967n     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x0202
            pb.j1 r15 = r4.f13813a     // Catch:{ Exception -> 0x01fc }
            r4.b r4 = r4.f13814b     // Catch:{ Exception -> 0x01fc }
            k4.m r4 = r14.h(r11, r15, r10, r4)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r11 = r14.f10593a
            if (r4 == 0) goto L_0x0170
            m4.v r0 = new m4.v     // Catch:{ Exception -> 0x01f9 }
            j4.q r2 = r14.g(r4)     // Catch:{ Exception -> 0x01f9 }
            r4.b r3 = r14.f(r4)     // Catch:{ Exception -> 0x01f9 }
            if (r3 == 0) goto L_0x0168
            la.e r3 = r3.f13796b     // Catch:{ Exception -> 0x01f9 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x01f9 }
            r7 = r3
            pb.x0 r7 = (pb.x0) r7     // Catch:{ Exception -> 0x01f9 }
        L_0x0168:
            java.lang.String r3 = d(r11, r7)     // Catch:{ Exception -> 0x01f9 }
            r0.<init>(r2, r3, r12)     // Catch:{ Exception -> 0x01f9 }
            return r0
        L_0x0170:
            long r15 = r0.contentLength()     // Catch:{ Exception -> 0x01f9 }
            int r17 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r17 <= 0) goto L_0x019e
            m4.v r2 = new m4.v     // Catch:{ Exception -> 0x01f9 }
            dc.l r3 = r0.source()     // Catch:{ Exception -> 0x01f9 }
            s4.m r5 = r14.f10594b     // Catch:{ Exception -> 0x01f9 }
            android.content.Context r5 = r5.f14276a     // Catch:{ Exception -> 0x01f9 }
            j4.h0 r8 = new j4.h0     // Catch:{ Exception -> 0x01f9 }
            j4.f0 r9 = new j4.f0     // Catch:{ Exception -> 0x01f9 }
            r9.<init>(r5, r6)     // Catch:{ Exception -> 0x01f9 }
            r8.<init>(r3, r9, r7)     // Catch:{ Exception -> 0x01f9 }
            pb.x0 r0 = r0.contentType()     // Catch:{ Exception -> 0x01f9 }
            java.lang.String r0 = d(r11, r0)     // Catch:{ Exception -> 0x01f9 }
            pb.r1 r3 = r10.f12968o     // Catch:{ Exception -> 0x01f9 }
            if (r3 == 0) goto L_0x0199
            goto L_0x019a
        L_0x0199:
            r12 = 3
        L_0x019a:
            r2.<init>(r8, r0, r12)     // Catch:{ Exception -> 0x01f9 }
            return r2
        L_0x019e:
            w4.e.a(r10)     // Catch:{ Exception -> 0x01f9 }
            pb.j1 r0 = r14.e()     // Catch:{ Exception -> 0x01f9 }
            r2.f10585h = r14     // Catch:{ Exception -> 0x01f9 }
            r2.f10586i = r4     // Catch:{ Exception -> 0x01f9 }
            r2.f10587j = r10     // Catch:{ Exception -> 0x01f9 }
            r8 = 2
            r2.f10590m = r8     // Catch:{ Exception -> 0x01f9 }
            java.lang.Object r0 = r14.b(r0, r2)     // Catch:{ Exception -> 0x01f9 }
            if (r0 != r3) goto L_0x01b5
            return r3
        L_0x01b5:
            r3 = r10
            r2 = r14
        L_0x01b7:
            r10 = r0
            pb.r1 r10 = (pb.r1) r10     // Catch:{ Exception -> 0x003f }
            android.graphics.Bitmap$Config[] r0 = w4.e.f16080a     // Catch:{ Exception -> 0x01eb }
            pb.u1 r0 = r10.f12967n     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01ed
            m4.v r3 = new m4.v     // Catch:{ Exception -> 0x01eb }
            r2.getClass()     // Catch:{ Exception -> 0x01eb }
            dc.l r5 = r0.source()     // Catch:{ Exception -> 0x01eb }
            s4.m r8 = r2.f10594b     // Catch:{ Exception -> 0x01eb }
            android.content.Context r8 = r8.f14276a     // Catch:{ Exception -> 0x01eb }
            j4.h0 r9 = new j4.h0     // Catch:{ Exception -> 0x01eb }
            j4.f0 r11 = new j4.f0     // Catch:{ Exception -> 0x01eb }
            r11.<init>(r8, r6)     // Catch:{ Exception -> 0x01eb }
            r9.<init>(r5, r11, r7)     // Catch:{ Exception -> 0x01eb }
            java.lang.String r2 = r2.f10593a     // Catch:{ Exception -> 0x01eb }
            pb.x0 r0 = r0.contentType()     // Catch:{ Exception -> 0x01eb }
            java.lang.String r0 = d(r2, r0)     // Catch:{ Exception -> 0x01eb }
            pb.r1 r2 = r10.f12968o     // Catch:{ Exception -> 0x01eb }
            if (r2 == 0) goto L_0x01e6
            goto L_0x01e7
        L_0x01e6:
            r12 = 3
        L_0x01e7:
            r3.<init>(r9, r0, r12)     // Catch:{ Exception -> 0x01eb }
            return r3
        L_0x01eb:
            r0 = move-exception
            goto L_0x01fe
        L_0x01ed:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x01eb }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x01eb }
            r0.<init>(r2)     // Catch:{ Exception -> 0x01eb }
            throw r0     // Catch:{ Exception -> 0x01eb }
        L_0x01f7:
            r10 = r3
            goto L_0x01fe
        L_0x01f9:
            r0 = move-exception
            r11 = r4
            goto L_0x01fd
        L_0x01fc:
            r0 = move-exception
        L_0x01fd:
            r4 = r11
        L_0x01fe:
            w4.e.a(r10)     // Catch:{ Exception -> 0x020c }
            throw r0     // Catch:{ Exception -> 0x020c }
        L_0x0202:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0057 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0057 }
            throw r0     // Catch:{ Exception -> 0x0057 }
        L_0x020c:
            r0 = move-exception
            r11 = r4
        L_0x020e:
            if (r11 == 0) goto L_0x0213
            w4.e.a(r11)
        L_0x0213:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.r.a(pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(pb.j1 r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof m4.p
            if (r0 == 0) goto L_0x0013
            r0 = r6
            m4.p r0 = (m4.p) r0
            int r1 = r0.f10584j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f10584j = r1
            goto L_0x0018
        L_0x0013:
            m4.p r0 = new m4.p
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f10582h
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f10584j
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            hb.h0.O1(r6)
            goto L_0x0096
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            hb.h0.O1(r6)
            android.graphics.Bitmap$Config[] r6 = w4.e.f16080a
            android.os.Looper r6 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            boolean r6 = xa.j.a(r6, r2)
            la.e r2 = r4.f10595c
            if (r6 == 0) goto L_0x0065
            s4.m r6 = r4.f10594b
            int r6 = r6.f14290o
            boolean r6 = q0.f.d(r6)
            if (r6 != 0) goto L_0x005f
            java.lang.Object r6 = r2.getValue()
            pb.h r6 = (pb.h) r6
            pb.f1 r6 = (pb.f1) r6
            tb.o r5 = r6.a(r5)
            pb.r1 r5 = r5.e()
            goto L_0x0099
        L_0x005f:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L_0x0065:
            java.lang.Object r6 = r2.getValue()
            pb.h r6 = (pb.h) r6
            pb.f1 r6 = (pb.f1) r6
            tb.o r5 = r6.a(r5)
            r0.f10584j = r3
            hb.l r6 = new hb.l
            pa.e r2 = qa.d.b(r0)
            r6.<init>(r3, r2)
            r6.w()
            w4.f r2 = new w4.f
            r2.<init>(r5, r6)
            r5.d(r2)
            r6.j(r2)
            java.lang.Object r6 = r6.u()
            if (r6 != r1) goto L_0x0093
            hb.h0.m1(r0)
        L_0x0093:
            if (r6 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r5 = r6
            pb.r1 r5 = (pb.r1) r5
        L_0x0099:
            boolean r6 = r5.f12976w
            if (r6 != 0) goto L_0x00b0
            r6 = 304(0x130, float:4.26E-43)
            int r0 = r5.f12964k
            if (r0 == r6) goto L_0x00b0
            pb.u1 r6 = r5.f12967n
            if (r6 == 0) goto L_0x00aa
            w4.e.a(r6)
        L_0x00aa:
            m1.v0 r6 = new m1.v0
            r6.<init>((pb.r1) r5)
            throw r6
        L_0x00b0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.r.b(pb.j1, pa.e):java.lang.Object");
    }

    public final dc.r c() {
        Object value = this.f10596d.getValue();
        j.c(value);
        return ((n) ((c) value)).f9121a;
    }

    public final j1 e() {
        g gVar;
        i1 i1Var = new i1();
        i1Var.g(this.f10593a);
        m mVar = this.f10594b;
        p0 p0Var = mVar.f14285j;
        j.f("headers", p0Var);
        i1Var.f12878c = p0Var.d();
        for (Map.Entry entry : mVar.f14286k.f14303a.entrySet()) {
            Object key = entry.getKey();
            j.d("null cannot be cast to non-null type java.lang.Class<kotlin.Any>", key);
            i1Var.f((Class) key, entry.getValue());
        }
        int i10 = mVar.f14289n;
        boolean d10 = f.d(i10);
        boolean d11 = f.d(mVar.f14290o);
        if (!d11 && d10) {
            gVar = g.f12848p;
        } else if (!d11 || d10) {
            if (!d11 && !d10) {
                gVar = f10592g;
            }
            return new j1(i1Var);
        } else if (f.e(i10)) {
            gVar = g.f12847o;
        } else {
            gVar = f10591f;
        }
        i1Var.b(gVar);
        return new j1(i1Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d A[Catch:{ IOException -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[Catch:{ IOException -> 0x0032 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final r4.b f(k4.m r4) {
        /*
            r3 = this;
            r0 = 0
            dc.r r1 = r3.c()     // Catch:{ IOException -> 0x0032 }
            k4.f r4 = r4.f9119h     // Catch:{ IOException -> 0x0032 }
            r2 = 0
            dc.f0 r4 = r4.c(r2)     // Catch:{ IOException -> 0x0032 }
            dc.p0 r4 = r1.l(r4)     // Catch:{ IOException -> 0x0032 }
            dc.i0 r4 = hb.h0.o(r4)     // Catch:{ IOException -> 0x0032 }
            r4.b r1 = new r4.b     // Catch:{ all -> 0x0020 }
            r1.<init>((dc.i0) r4)     // Catch:{ all -> 0x0020 }
            r4.close()     // Catch:{ all -> 0x001e }
            r4 = r0
            goto L_0x002b
        L_0x001e:
            r4 = move-exception
            goto L_0x002b
        L_0x0020:
            r1 = move-exception
            r4.close()     // Catch:{ all -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r4 = move-exception
            la.a.a(r1, r4)     // Catch:{ IOException -> 0x0032 }
        L_0x0029:
            r4 = r1
            r1 = r0
        L_0x002b:
            if (r4 != 0) goto L_0x0031
            xa.j.c(r1)     // Catch:{ IOException -> 0x0032 }
            return r1
        L_0x0031:
            throw r4     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.r.f(k4.m):r4.b");
    }

    public final q g(k4.m mVar) {
        f0 c10 = mVar.f9119h.c(1);
        dc.r c11 = c();
        String str = this.f10594b.f14284i;
        if (str == null) {
            str = this.f10593a;
        }
        return new q(c10, c11, str, mVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:64|65|102|103|104|105|106|107) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r7 != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x017a */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0172 A[Catch:{ Exception -> 0x00f9, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[SYNTHETIC, Splitter:B:42:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f0 A[Catch:{ Exception -> 0x00f9, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f5 A[Catch:{ Exception -> 0x00f9, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012c A[Catch:{ Exception -> 0x00f9, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0166 A[Catch:{ Exception -> 0x00f9, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0171 A[SYNTHETIC, Splitter:B:99:0x0171] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final k4.m h(k4.b r6, pb.j1 r7, pb.r1 r8, r4.b r9) {
        /*
            r5 = this;
            s4.m r0 = r5.f10594b
            int r0 = r0.f14289n
            boolean r0 = q0.f.e(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x003c
            boolean r0 = r5.f10597e
            if (r0 == 0) goto L_0x003a
            r4.c r0 = r4.e.f13812c
            r0.getClass()
            pb.g r7 = r7.a()
            boolean r7 = r7.f12850b
            if (r7 != 0) goto L_0x0037
            pb.g r7 = r8.c()
            boolean r7 = r7.f12850b
            if (r7 != 0) goto L_0x0037
            java.lang.String r7 = "Vary"
            pb.p0 r0 = r8.f12966m
            java.lang.String r7 = r0.a(r7)
            java.lang.String r0 = "*"
            boolean r7 = xa.j.a(r7, r0)
            if (r7 != 0) goto L_0x0037
            r7 = 1
            goto L_0x0038
        L_0x0037:
            r7 = 0
        L_0x0038:
            if (r7 == 0) goto L_0x003c
        L_0x003a:
            r7 = 1
            goto L_0x003d
        L_0x003c:
            r7 = 0
        L_0x003d:
            r0 = 0
            if (r7 != 0) goto L_0x0046
            if (r6 == 0) goto L_0x0045
            w4.e.a(r6)
        L_0x0045:
            return r0
        L_0x0046:
            if (r6 == 0) goto L_0x0066
            k4.m r6 = (k4.m) r6
            k4.f r6 = r6.f9119h
            k4.i r7 = r6.f9096j
            monitor-enter(r7)
            r6.close()     // Catch:{ all -> 0x0063 }
            k4.e r6 = r6.f9094h     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = r6.f9085a     // Catch:{ all -> 0x0063 }
            p1.i0 r6 = r7.k(r6)     // Catch:{ all -> 0x0063 }
            monitor-exit(r7)
            if (r6 == 0) goto L_0x009b
            k4.l r7 = new k4.l
            r7.<init>(r6)
            goto L_0x009c
        L_0x0063:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        L_0x0066:
            la.e r6 = r5.f10596d
            java.lang.Object r6 = r6.getValue()
            k4.c r6 = (k4.c) r6
            if (r6 == 0) goto L_0x009b
            s4.m r7 = r5.f10594b
            java.lang.String r7 = r7.f14284i
            if (r7 != 0) goto L_0x0078
            java.lang.String r7 = r5.f10593a
        L_0x0078:
            k4.n r6 = (k4.n) r6
            k4.i r6 = r6.f9122b
            dc.m r3 = dc.n.f4802k
            r3.getClass()
            dc.n r7 = dc.m.b(r7)
            java.lang.String r3 = "SHA-256"
            dc.n r7 = r7.c(r3)
            java.lang.String r7 = r7.e()
            p1.i0 r6 = r6.k(r7)
            if (r6 == 0) goto L_0x009b
            k4.l r7 = new k4.l
            r7.<init>(r6)
            goto L_0x009c
        L_0x009b:
            r7 = r0
        L_0x009c:
            if (r7 != 0) goto L_0x009f
            return r0
        L_0x009f:
            int r6 = r8.f12964k     // Catch:{ Exception -> 0x00f9 }
            r3 = 304(0x130, float:4.26E-43)
            if (r6 != r3) goto L_0x00fc
            if (r9 == 0) goto L_0x00fc
            pb.q1 r6 = new pb.q1     // Catch:{ Exception -> 0x00f9 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x00f9 }
            r4.c r2 = r4.e.f13812c     // Catch:{ Exception -> 0x00f9 }
            pb.p0 r9 = r9.f13800f     // Catch:{ Exception -> 0x00f9 }
            pb.p0 r3 = r8.f12966m     // Catch:{ Exception -> 0x00f9 }
            r2.getClass()     // Catch:{ Exception -> 0x00f9 }
            pb.p0 r9 = r4.c.a(r9, r3)     // Catch:{ Exception -> 0x00f9 }
            r6.b(r9)     // Catch:{ Exception -> 0x00f9 }
            pb.r1 r6 = r6.a()     // Catch:{ Exception -> 0x00f9 }
            dc.r r9 = r5.c()     // Catch:{ Exception -> 0x00f9 }
            p1.i0 r2 = r7.f9118a     // Catch:{ Exception -> 0x00f9 }
            dc.f0 r1 = r2.j(r1)     // Catch:{ Exception -> 0x00f9 }
            dc.n0 r9 = r9.k(r1)     // Catch:{ Exception -> 0x00f9 }
            dc.h0 r9 = hb.h0.n(r9)     // Catch:{ Exception -> 0x00f9 }
            r4.b r1 = new r4.b     // Catch:{ all -> 0x00e2 }
            r1.<init>((pb.r1) r6)     // Catch:{ all -> 0x00e2 }
            r1.a(r9)     // Catch:{ all -> 0x00e2 }
            la.v r6 = la.v.f9814a     // Catch:{ all -> 0x00e2 }
            r9.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00ee
        L_0x00e0:
            r0 = move-exception
            goto L_0x00ee
        L_0x00e2:
            r6 = move-exception
            r9.close()     // Catch:{ all -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r9 = move-exception
            la.a.a(r6, r9)     // Catch:{ Exception -> 0x00f9 }
        L_0x00eb:
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x00ee:
            if (r0 != 0) goto L_0x00f5
            xa.j.c(r6)     // Catch:{ Exception -> 0x00f9 }
            goto L_0x0169
        L_0x00f5:
            throw r0     // Catch:{ Exception -> 0x00f9 }
        L_0x00f6:
            r6 = move-exception
            goto L_0x017b
        L_0x00f9:
            r6 = move-exception
            goto L_0x0173
        L_0x00fc:
            dc.r r6 = r5.c()     // Catch:{ Exception -> 0x00f9 }
            p1.i0 r9 = r7.f9118a     // Catch:{ Exception -> 0x00f9 }
            dc.f0 r9 = r9.j(r1)     // Catch:{ Exception -> 0x00f9 }
            dc.n0 r6 = r6.k(r9)     // Catch:{ Exception -> 0x00f9 }
            dc.h0 r6 = hb.h0.n(r6)     // Catch:{ Exception -> 0x00f9 }
            r4.b r9 = new r4.b     // Catch:{ all -> 0x011f }
            r9.<init>((pb.r1) r8)     // Catch:{ all -> 0x011f }
            r9.a(r6)     // Catch:{ all -> 0x011f }
            la.v r9 = la.v.f9814a     // Catch:{ all -> 0x011f }
            r6.close()     // Catch:{ all -> 0x011d }
            r6 = r0
            goto L_0x012a
        L_0x011d:
            r6 = move-exception
            goto L_0x012a
        L_0x011f:
            r9 = move-exception
            r6.close()     // Catch:{ all -> 0x0124 }
            goto L_0x0128
        L_0x0124:
            r6 = move-exception
            la.a.a(r9, r6)     // Catch:{ Exception -> 0x00f9 }
        L_0x0128:
            r6 = r9
            r9 = r0
        L_0x012a:
            if (r6 != 0) goto L_0x0172
            xa.j.c(r9)     // Catch:{ Exception -> 0x00f9 }
            dc.r r6 = r5.c()     // Catch:{ Exception -> 0x00f9 }
            p1.i0 r9 = r7.f9118a     // Catch:{ Exception -> 0x00f9 }
            dc.f0 r9 = r9.j(r2)     // Catch:{ Exception -> 0x00f9 }
            dc.n0 r6 = r6.k(r9)     // Catch:{ Exception -> 0x00f9 }
            dc.h0 r6 = hb.h0.n(r6)     // Catch:{ Exception -> 0x00f9 }
            pb.u1 r9 = r8.f12967n     // Catch:{ all -> 0x0158 }
            xa.j.c(r9)     // Catch:{ all -> 0x0158 }
            dc.l r9 = r9.source()     // Catch:{ all -> 0x0158 }
            long r1 = r9.Q(r6)     // Catch:{ all -> 0x0158 }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0158 }
            r6.close()     // Catch:{ all -> 0x0156 }
            goto L_0x0164
        L_0x0156:
            r0 = move-exception
            goto L_0x0164
        L_0x0158:
            r9 = move-exception
            r6.close()     // Catch:{ all -> 0x015d }
            goto L_0x0161
        L_0x015d:
            r6 = move-exception
            la.a.a(r9, r6)     // Catch:{ Exception -> 0x00f9 }
        L_0x0161:
            r4 = r0
            r0 = r9
            r9 = r4
        L_0x0164:
            if (r0 != 0) goto L_0x0171
            xa.j.c(r9)     // Catch:{ Exception -> 0x00f9 }
        L_0x0169:
            k4.m r6 = r7.a()     // Catch:{ Exception -> 0x00f9 }
            w4.e.a(r8)
            return r6
        L_0x0171:
            throw r0     // Catch:{ Exception -> 0x00f9 }
        L_0x0172:
            throw r6     // Catch:{ Exception -> 0x00f9 }
        L_0x0173:
            android.graphics.Bitmap$Config[] r9 = w4.e.f16080a     // Catch:{ all -> 0x00f6 }
            p1.i0 r7 = r7.f9118a     // Catch:{ Exception -> 0x017a }
            r7.c()     // Catch:{ Exception -> 0x017a }
        L_0x017a:
            throw r6     // Catch:{ all -> 0x00f6 }
        L_0x017b:
            w4.e.a(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.r.h(k4.b, pb.j1, pb.r1, r4.b):k4.m");
    }
}
