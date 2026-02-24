package m1;

import android.os.Bundle;
import g1.a0;
import g1.d1;
import g1.w0;
import j1.a;
import j1.l0;

public final class p extends d1 {
    public static final String A = l0.C(1005);
    public static final String B = l0.C(1006);

    /* renamed from: w  reason: collision with root package name */
    public static final String f10420w = l0.C(1001);

    /* renamed from: x  reason: collision with root package name */
    public static final String f10421x = l0.C(1002);

    /* renamed from: y  reason: collision with root package name */
    public static final String f10422y = l0.C(1003);

    /* renamed from: z  reason: collision with root package name */
    public static final String f10423z = l0.C(1004);

    /* renamed from: p  reason: collision with root package name */
    public final int f10424p;

    /* renamed from: q  reason: collision with root package name */
    public final String f10425q;

    /* renamed from: r  reason: collision with root package name */
    public final int f10426r;

    /* renamed from: s  reason: collision with root package name */
    public final a0 f10427s;

    /* renamed from: t  reason: collision with root package name */
    public final int f10428t;

    /* renamed from: u  reason: collision with root package name */
    public final w0 f10429u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f10430v;

    public p(int i10, Throwable th, int i11) {
        this(i10, th, i11, (String) null, -1, (a0) null, 4, false);
    }

    public final Bundle h() {
        Bundle h10 = super.h();
        h10.putInt(f10420w, this.f10424p);
        h10.putString(f10421x, this.f10425q);
        h10.putInt(f10422y, this.f10426r);
        a0 a0Var = this.f10427s;
        if (a0Var != null) {
            h10.putBundle(f10423z, a0Var.l(false));
        }
        h10.putInt(A, this.f10428t);
        h10.putBoolean(B, this.f10430v);
        return h10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r4 = (m1.p) r4;
        r0 = r4.f10424p;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(g1.d1 r4) {
        /*
            r3 = this;
            boolean r0 = super.i(r4)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            m1.p r4 = (m1.p) r4
            int r0 = r4.f10424p
            int r2 = r3.f10424p
            if (r2 != r0) goto L_0x0041
            java.lang.String r0 = r3.f10425q
            java.lang.String r2 = r4.f10425q
            boolean r0 = j1.l0.a(r0, r2)
            if (r0 == 0) goto L_0x0041
            int r0 = r3.f10426r
            int r2 = r4.f10426r
            if (r0 != r2) goto L_0x0041
            g1.a0 r0 = r3.f10427s
            g1.a0 r2 = r4.f10427s
            boolean r0 = j1.l0.a(r0, r2)
            if (r0 == 0) goto L_0x0041
            int r0 = r3.f10428t
            int r2 = r4.f10428t
            if (r0 != r2) goto L_0x0041
            g1.w0 r0 = r3.f10429u
            g1.w0 r2 = r4.f10429u
            boolean r0 = j1.l0.a(r0, r2)
            if (r0 == 0) goto L_0x0041
            boolean r0 = r3.f10430v
            boolean r4 = r4.f10430v
            if (r0 != r4) goto L_0x0041
            r1 = 1
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.p.i(g1.d1):boolean");
    }

    public final p j(v1.a0 a0Var) {
        return new p(getMessage(), getCause(), this.f6349h, this.f10424p, this.f10425q, this.f10426r, this.f10427s, this.f10428t, a0Var, this.f6350i, this.f10430v);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p(int r14, java.lang.Throwable r15, int r16, java.lang.String r17, int r18, g1.a0 r19, int r20, boolean r21) {
        /*
            r13 = this;
            r4 = r14
            r8 = r20
            if (r4 == 0) goto L_0x0064
            r0 = 3
            r1 = 1
            if (r4 == r1) goto L_0x0017
            if (r4 == r0) goto L_0x000e
            java.lang.String r0 = "Unexpected runtime error"
            goto L_0x0010
        L_0x000e:
            java.lang.String r0 = "Remote error"
        L_0x0010:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x006c
        L_0x0017:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r5 = r17
            r2.append(r5)
            java.lang.String r3 = " error, index="
            r2.append(r3)
            r6 = r18
            r2.append(r6)
            java.lang.String r3 = ", format="
            r2.append(r3)
            r7 = r19
            r2.append(r7)
            java.lang.String r3 = ", format_supported="
            r2.append(r3)
            int r3 = j1.l0.f8453a
            if (r8 == 0) goto L_0x005a
            if (r8 == r1) goto L_0x0057
            r1 = 2
            if (r8 == r1) goto L_0x0054
            if (r8 == r0) goto L_0x0051
            r0 = 4
            if (r8 != r0) goto L_0x004b
            java.lang.String r0 = "YES"
            goto L_0x005c
        L_0x004b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0051:
            java.lang.String r0 = "NO_EXCEEDS_CAPABILITIES"
            goto L_0x005c
        L_0x0054:
            java.lang.String r0 = "NO_UNSUPPORTED_DRM"
            goto L_0x005c
        L_0x0057:
            java.lang.String r0 = "NO_UNSUPPORTED_TYPE"
            goto L_0x005c
        L_0x005a:
            java.lang.String r0 = "NO"
        L_0x005c:
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x006c
        L_0x0064:
            r5 = r17
            r6 = r18
            r7 = r19
            java.lang.String r0 = "Source error"
        L_0x006c:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = ": null"
            java.lang.String r0 = q0.f.g(r0, r1)
        L_0x0079:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r16
            r4 = r14
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r12 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.p.<init>(int, java.lang.Throwable, int, java.lang.String, int, g1.a0, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(String str, Throwable th, int i10, int i11, String str2, int i12, a0 a0Var, int i13, v1.a0 a0Var2, long j10, boolean z10) {
        super(str, th, i10, j10);
        int i14 = i11;
        boolean z11 = z10;
        boolean z12 = false;
        a.b(!z11 || i14 == 1);
        a.b((th != null || i14 == 3) ? true : z12);
        this.f10424p = i14;
        this.f10425q = str2;
        this.f10426r = i12;
        this.f10427s = a0Var;
        this.f10428t = i13;
        this.f10429u = a0Var2;
        this.f10430v = z11;
    }
}
