package m1;

import g1.a0;
import g1.z;
import j1.a;
import l1.h;
import n1.f0;
import s1.y;
import v1.b1;

public abstract class f implements l1 {

    /* renamed from: h  reason: collision with root package name */
    public final int f10216h;

    /* renamed from: i  reason: collision with root package name */
    public final w0 f10217i = new w0();

    /* renamed from: j  reason: collision with root package name */
    public o1 f10218j;

    /* renamed from: k  reason: collision with root package name */
    public int f10219k;

    /* renamed from: l  reason: collision with root package name */
    public f0 f10220l;

    /* renamed from: m  reason: collision with root package name */
    public int f10221m;

    /* renamed from: n  reason: collision with root package name */
    public b1 f10222n;

    /* renamed from: o  reason: collision with root package name */
    public a0[] f10223o;

    /* renamed from: p  reason: collision with root package name */
    public long f10224p;

    /* renamed from: q  reason: collision with root package name */
    public long f10225q = Long.MIN_VALUE;

    /* renamed from: r  reason: collision with root package name */
    public boolean f10226r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f10227s;

    public f(int i10) {
        this.f10216h = i10;
    }

    public void b(int i10, Object obj) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m1.p c(int r13, g1.a0 r14, java.lang.Exception r15, boolean r16) {
        /*
            r12 = this;
            r1 = r12
            r0 = r14
            r2 = 4
            if (r0 == 0) goto L_0x001d
            boolean r3 = r1.f10227s
            if (r3 != 0) goto L_0x001d
            r3 = 1
            r1.f10227s = r3
            r3 = 0
            int r4 = r12.x(r14)     // Catch:{ p -> 0x001b, all -> 0x0016 }
            r4 = r4 & 7
            r1.f10227s = r3
            goto L_0x001e
        L_0x0016:
            r0 = move-exception
            r2 = r0
            r1.f10227s = r3
            throw r2
        L_0x001b:
            r1.f10227s = r3
        L_0x001d:
            r4 = 4
        L_0x001e:
            java.lang.String r6 = r12.g()
            int r7 = r1.f10219k
            m1.p r11 = new m1.p
            r3 = 1
            if (r0 != 0) goto L_0x002b
            r9 = 4
            goto L_0x002c
        L_0x002b:
            r9 = r4
        L_0x002c:
            r2 = r11
            r4 = r15
            r5 = r13
            r8 = r14
            r10 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.f.c(int, g1.a0, java.lang.Exception, boolean):m1.p");
    }

    public final p e(y yVar, a0 a0Var) {
        return c(4002, a0Var, yVar, false);
    }

    public x0 f() {
        return null;
    }

    public abstract String g();

    public final boolean h() {
        return this.f10225q == Long.MIN_VALUE;
    }

    public abstract boolean j();

    public abstract boolean k();

    public abstract void l();

    public void m(boolean z10, boolean z11) {
    }

    public abstract void n(long j10, boolean z10);

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public abstract void r(a0[] a0VarArr, long j10, long j11);

    public final int s(w0 w0Var, h hVar, int i10) {
        b1 b1Var = this.f10222n;
        b1Var.getClass();
        int a10 = b1Var.a(w0Var, hVar, i10);
        if (a10 == -4) {
            if (hVar.f(4)) {
                this.f10225q = Long.MIN_VALUE;
                if (this.f10226r) {
                    return -4;
                }
                return -3;
            }
            long j10 = hVar.f9517l + this.f10224p;
            hVar.f9517l = j10;
            this.f10225q = Math.max(this.f10225q, j10);
        } else if (a10 == -5) {
            a0 a0Var = w0Var.f10523b;
            a0Var.getClass();
            if (a0Var.f6280w != Long.MAX_VALUE) {
                z i11 = a0Var.i();
                i11.f6758o = a0Var.f6280w + this.f10224p;
                w0Var.f10523b = i11.a();
            }
        }
        return a10;
    }

    public abstract void t(long j10, long j11);

    public final void u(a0[] a0VarArr, b1 b1Var, long j10, long j11) {
        a.e(!this.f10226r);
        this.f10222n = b1Var;
        if (this.f10225q == Long.MIN_VALUE) {
            this.f10225q = j10;
        }
        this.f10223o = a0VarArr;
        this.f10224p = j11;
        r(a0VarArr, j10, j11);
    }

    public final void v() {
        a.e(this.f10221m == 0);
        this.f10217i.a();
        o();
    }

    public void w(float f10, float f11) {
    }

    public abstract int x(a0 a0Var);

    public int y() {
        return 0;
    }
}
