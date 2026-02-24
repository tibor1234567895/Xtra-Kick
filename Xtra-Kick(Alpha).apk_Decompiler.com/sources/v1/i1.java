package v1;

import a2.i;
import a2.l;
import a2.n;
import a2.q;
import android.net.Uri;
import g1.a0;
import g1.v1;
import java.util.ArrayList;
import k1.f0;
import k1.g;
import k1.h;
import k1.m;
import m1.p1;
import z1.s;

public final class i1 implements y, l {

    /* renamed from: h  reason: collision with root package name */
    public final m f15663h;

    /* renamed from: i  reason: collision with root package name */
    public final g f15664i;

    /* renamed from: j  reason: collision with root package name */
    public final f0 f15665j;

    /* renamed from: k  reason: collision with root package name */
    public final i f15666k;

    /* renamed from: l  reason: collision with root package name */
    public final f0 f15667l;

    /* renamed from: m  reason: collision with root package name */
    public final l1 f15668m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f15669n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final long f15670o;

    /* renamed from: p  reason: collision with root package name */
    public final q f15671p = new q("SingleSampleMediaPeriod");

    /* renamed from: q  reason: collision with root package name */
    public final a0 f15672q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f15673r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15674s;

    /* renamed from: t  reason: collision with root package name */
    public byte[] f15675t;

    /* renamed from: u  reason: collision with root package name */
    public int f15676u;

    public i1(m mVar, g gVar, f0 f0Var, a0 a0Var, long j10, i iVar, f0 f0Var2, boolean z10) {
        this.f15663h = mVar;
        this.f15664i = gVar;
        this.f15665j = f0Var;
        this.f15672q = a0Var;
        this.f15670o = j10;
        this.f15666k = iVar;
        this.f15667l = f0Var2;
        this.f15673r = z10;
        this.f15668m = new l1(new v1("", a0Var));
    }

    public final long B(long j10) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f15669n;
            if (i10 >= arrayList.size()) {
                return j10;
            }
            g1 g1Var = (g1) arrayList.get(i10);
            if (g1Var.f15647a == 2) {
                g1Var.f15647a = 1;
            }
            i10++;
        }
    }

    public final boolean C(long j10) {
        if (this.f15674s) {
            return false;
        }
        q qVar = this.f15671p;
        if (qVar.d() || qVar.c()) {
            return false;
        }
        h a10 = this.f15664i.a();
        f0 f0Var = this.f15665j;
        if (f0Var != null) {
            a10.i(f0Var);
        }
        m mVar = this.f15663h;
        qVar.g(new h1(a10, mVar), this, this.f15666k.b(1));
        this.f15667l.n(new r(mVar), 1, -1, this.f15672q, 0, (Object) null, 0, this.f15670o);
        return true;
    }

    public final void D(long j10) {
    }

    public final boolean c() {
        return this.f15671p.d();
    }

    public final long f(long j10, p1 p1Var) {
        return j10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a2.k h(a2.n r18, long r19, long r21, java.io.IOException r23, int r24) {
        /*
            r17 = this;
            r0 = r17
            r12 = r23
            r1 = r24
            r2 = r18
            v1.h1 r2 = (v1.h1) r2
            k1.e0 r2 = r2.f15655b
            v1.r r3 = new v1.r
            android.net.Uri r2 = r2.f8992c
            r3.<init>()
            long r4 = r0.f15670o
            j1.l0.Q(r4)
            a2.i r2 = r0.f15666k
            r2.getClass()
            boolean r4 = r12 instanceof g1.b1
            r5 = 0
            r6 = 1
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 != 0) goto L_0x005d
            boolean r4 = r12 instanceof java.io.FileNotFoundException
            if (r4 != 0) goto L_0x005d
            boolean r4 = r12 instanceof k1.w
            if (r4 != 0) goto L_0x005d
            boolean r4 = r12 instanceof a2.p
            if (r4 != 0) goto L_0x005d
            int r4 = k1.i.f9006i
            r4 = r12
        L_0x0037:
            if (r4 == 0) goto L_0x004d
            boolean r9 = r4 instanceof k1.i
            if (r9 == 0) goto L_0x0048
            r9 = r4
            k1.i r9 = (k1.i) r9
            int r9 = r9.f9007h
            r10 = 2008(0x7d8, float:2.814E-42)
            if (r9 != r10) goto L_0x0048
            r4 = 1
            goto L_0x004e
        L_0x0048:
            java.lang.Throwable r4 = r4.getCause()
            goto L_0x0037
        L_0x004d:
            r4 = 0
        L_0x004e:
            if (r4 == 0) goto L_0x0051
            goto L_0x005d
        L_0x0051:
            int r4 = r1 + -1
            int r4 = r4 * 1000
            r9 = 5000(0x1388, float:7.006E-42)
            int r4 = java.lang.Math.min(r4, r9)
            long r9 = (long) r4
            goto L_0x005e
        L_0x005d:
            r9 = r7
        L_0x005e:
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x006b
            int r2 = r2.b(r6)
            if (r1 < r2) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r1 = 0
            goto L_0x006c
        L_0x006b:
            r1 = 1
        L_0x006c:
            boolean r2 = r0.f15673r
            if (r2 == 0) goto L_0x007e
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "SingleSampleMediaPeriod"
            java.lang.String r2 = "Loading failed, treating as end-of-stream."
            j1.v.h(r1, r2, r12)
            r0.f15674s = r6
            a2.k r1 = a2.q.f72e
            goto L_0x0087
        L_0x007e:
            if (r4 == 0) goto L_0x0085
            a2.k r1 = a2.q.b(r9, r5)
            goto L_0x0087
        L_0x0085:
            a2.k r1 = a2.q.f73f
        L_0x0087:
            r14 = r1
            int r1 = r14.f59a
            if (r1 == 0) goto L_0x008e
            if (r1 != r6) goto L_0x008f
        L_0x008e:
            r5 = 1
        L_0x008f:
            r13 = r5 ^ 1
            v1.f0 r1 = r0.f15667l
            r4 = 1
            r5 = -1
            g1.a0 r6 = r0.f15672q
            r7 = 0
            r8 = 0
            long r10 = r0.f15670o
            r15 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r15
            r12 = r23
            r1.j(r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.i1.h(a2.n, long, long, java.io.IOException, int):a2.k");
    }

    public final long j() {
        return (this.f15674s || this.f15671p.d()) ? Long.MIN_VALUE : 0;
    }

    public final long k() {
        return -9223372036854775807L;
    }

    public final void l(n nVar, long j10, long j11, boolean z10) {
        Uri uri = ((h1) nVar).f15655b.f8992c;
        r rVar = new r();
        this.f15666k.getClass();
        this.f15667l.e(rVar, 1, -1, (a0) null, 0, (Object) null, 0, this.f15670o);
    }

    public final void m(x xVar, long j10) {
        xVar.h(this);
    }

    public final void n(n nVar, long j10, long j11) {
        h1 h1Var = (h1) nVar;
        this.f15676u = (int) h1Var.f15655b.f8991b;
        byte[] bArr = h1Var.f15656c;
        bArr.getClass();
        this.f15675t = bArr;
        this.f15674s = true;
        Uri uri = h1Var.f15655b.f8992c;
        r rVar = new r();
        this.f15666k.getClass();
        this.f15667l.h(rVar, 1, -1, this.f15672q, 0, (Object) null, 0, this.f15670o);
    }

    public final l1 o() {
        return this.f15668m;
    }

    public final long p(s[] sVarArr, boolean[] zArr, b1[] b1VarArr, boolean[] zArr2, long j10) {
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            b1 b1Var = b1VarArr[i10];
            ArrayList arrayList = this.f15669n;
            if (b1Var != null && (sVarArr[i10] == null || !zArr[i10])) {
                arrayList.remove(b1Var);
                b1VarArr[i10] = null;
            }
            if (b1VarArr[i10] == null && sVarArr[i10] != null) {
                g1 g1Var = new g1(this);
                arrayList.add(g1Var);
                b1VarArr[i10] = g1Var;
                zArr2[i10] = true;
            }
        }
        return j10;
    }

    public final long u() {
        return this.f15674s ? Long.MIN_VALUE : 0;
    }

    public final void v() {
    }

    public final void y(long j10, boolean z10) {
    }
}
