package v1;

import a2.a;
import a2.e;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import d2.w0;
import d2.x0;
import g1.a0;
import g1.p;
import g1.z;
import i1.c;
import j1.b0;
import j1.l0;
import java.io.EOFException;
import l1.h;
import p1.n;
import p1.q;
import p1.u;

public class a1 implements x0 {
    public a0 A;
    public a0 B;
    public int C;
    public boolean D;
    public boolean E;
    public long F;
    public boolean G;

    /* renamed from: a  reason: collision with root package name */
    public final w0 f15563a;

    /* renamed from: b  reason: collision with root package name */
    public final x0 f15564b = new x0();

    /* renamed from: c  reason: collision with root package name */
    public final k1 f15565c = new k1(new c(12));

    /* renamed from: d  reason: collision with root package name */
    public final u f15566d;

    /* renamed from: e  reason: collision with root package name */
    public final q f15567e;

    /* renamed from: f  reason: collision with root package name */
    public z0 f15568f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f15569g;

    /* renamed from: h  reason: collision with root package name */
    public n f15570h;

    /* renamed from: i  reason: collision with root package name */
    public int f15571i = 1000;

    /* renamed from: j  reason: collision with root package name */
    public int[] f15572j = new int[1000];

    /* renamed from: k  reason: collision with root package name */
    public long[] f15573k = new long[1000];

    /* renamed from: l  reason: collision with root package name */
    public int[] f15574l = new int[1000];

    /* renamed from: m  reason: collision with root package name */
    public int[] f15575m = new int[1000];

    /* renamed from: n  reason: collision with root package name */
    public long[] f15576n = new long[1000];

    /* renamed from: o  reason: collision with root package name */
    public w0[] f15577o = new w0[1000];

    /* renamed from: p  reason: collision with root package name */
    public int f15578p;

    /* renamed from: q  reason: collision with root package name */
    public int f15579q;

    /* renamed from: r  reason: collision with root package name */
    public int f15580r;

    /* renamed from: s  reason: collision with root package name */
    public int f15581s;

    /* renamed from: t  reason: collision with root package name */
    public long f15582t = Long.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    public long f15583u = Long.MIN_VALUE;

    /* renamed from: v  reason: collision with root package name */
    public long f15584v = Long.MIN_VALUE;

    /* renamed from: w  reason: collision with root package name */
    public boolean f15585w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f15586x = true;

    /* renamed from: y  reason: collision with root package name */
    public boolean f15587y = true;

    /* renamed from: z  reason: collision with root package name */
    public boolean f15588z;

    public a1(e eVar, u uVar, q qVar) {
        this.f15566d = uVar;
        this.f15567e = qVar;
        this.f15563a = new w0(eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean A(long r10, boolean r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r9.y()     // Catch:{ all -> 0x0041 }
            int r0 = r9.f15581s     // Catch:{ all -> 0x0041 }
            int r4 = r9.p(r0)     // Catch:{ all -> 0x0041 }
            int r0 = r9.f15581s     // Catch:{ all -> 0x0041 }
            int r1 = r9.f15578p     // Catch:{ all -> 0x0041 }
            r7 = 1
            r8 = 0
            if (r0 == r1) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r2 == 0) goto L_0x003f
            long[] r2 = r9.f15576n     // Catch:{ all -> 0x0041 }
            r5 = r2[r4]     // Catch:{ all -> 0x0041 }
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x003f
            long r2 = r9.f15584v     // Catch:{ all -> 0x0041 }
            int r5 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0028
            if (r12 != 0) goto L_0x0028
            goto L_0x003f
        L_0x0028:
            int r5 = r1 - r0
            r6 = 1
            r1 = r9
            r2 = r10
            int r12 = r1.k(r2, r4, r5, r6)     // Catch:{ all -> 0x0041 }
            r0 = -1
            if (r12 != r0) goto L_0x0036
            monitor-exit(r9)
            return r8
        L_0x0036:
            r9.f15582t = r10     // Catch:{ all -> 0x0041 }
            int r10 = r9.f15581s     // Catch:{ all -> 0x0041 }
            int r10 = r10 + r12
            r9.f15581s = r10     // Catch:{ all -> 0x0041 }
            monitor-exit(r9)
            return r7
        L_0x003f:
            monitor-exit(r9)
            return r8
        L_0x0041:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a1.A(long, boolean):boolean");
    }

    public final void a(a0 a0Var) {
        boolean z10;
        a0 l10 = l(a0Var);
        boolean z11 = false;
        this.f15588z = false;
        this.A = a0Var;
        synchronized (this) {
            this.f15587y = false;
            if (!l0.a(l10, this.B)) {
                if (this.f15565c.f15701b.size() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    SparseArray sparseArray = this.f15565c.f15701b;
                    if (((y0) sparseArray.valueAt(sparseArray.size() - 1)).f15835a.equals(l10)) {
                        SparseArray sparseArray2 = this.f15565c.f15701b;
                        l10 = ((y0) sparseArray2.valueAt(sparseArray2.size() - 1)).f15835a;
                    }
                }
                this.B = l10;
                this.D = g1.a1.a(l10.f6276s, l10.f6273p);
                this.E = false;
                z11 = true;
            }
        }
        z0 z0Var = this.f15568f;
        if (z0Var != null && z11) {
            z0Var.e();
        }
    }

    public final void b(int i10, b0 b0Var) {
        while (true) {
            w0 w0Var = this.f15563a;
            if (i10 > 0) {
                int c10 = w0Var.c(i10);
                v0 v0Var = w0Var.f15830f;
                a aVar = v0Var.f15816c;
                b0Var.d(aVar.f16a, ((int) (w0Var.f15831g - v0Var.f15814a)) + aVar.f17b, c10);
                i10 -= c10;
                long j10 = w0Var.f15831g + ((long) c10);
                w0Var.f15831g = j10;
                v0 v0Var2 = w0Var.f15830f;
                if (j10 == v0Var2.f15815b) {
                    w0Var.f15830f = v0Var2.f15817d;
                }
            } else {
                w0Var.getClass();
                return;
            }
        }
    }

    public final int c(p pVar, int i10, boolean z10) {
        return z(pVar, i10, z10);
    }

    public final void d(int i10, b0 b0Var) {
        b(i10, b0Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00db, code lost:
        if (((v1.y0) r10.valueAt(r10.size() - 1)).f15835a.equals(r9.B) == false) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(long r10, int r12, int r13, int r14, d2.w0 r15) {
        /*
            r9 = this;
            boolean r0 = r9.f15588z
            if (r0 == 0) goto L_0x000c
            g1.a0 r0 = r9.A
            j1.a.f(r0)
            r9.a(r0)
        L_0x000c:
            r0 = r12 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            boolean r4 = r9.f15586x
            if (r4 == 0) goto L_0x001e
            if (r3 != 0) goto L_0x001c
            return
        L_0x001c:
            r9.f15586x = r1
        L_0x001e:
            long r4 = r9.F
            long r10 = r10 + r4
            boolean r4 = r9.D
            if (r4 == 0) goto L_0x004b
            long r4 = r9.f15582t
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x002c
            return
        L_0x002c:
            if (r0 != 0) goto L_0x004b
            boolean r0 = r9.E
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "SampleQueue"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Overriding unexpected non-sync sample for format: "
            r4.<init>(r5)
            g1.a0 r5 = r9.B
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            j1.v.g(r0, r4)
            r9.E = r2
        L_0x0049:
            r12 = r12 | 1
        L_0x004b:
            boolean r0 = r9.G
            if (r0 == 0) goto L_0x005c
            if (r3 == 0) goto L_0x005b
            boolean r0 = r9.f(r10)
            if (r0 != 0) goto L_0x0058
            goto L_0x005b
        L_0x0058:
            r9.G = r1
            goto L_0x005c
        L_0x005b:
            return
        L_0x005c:
            v1.w0 r0 = r9.f15563a
            long r3 = r0.f15831g
            long r5 = (long) r13
            long r3 = r3 - r5
            long r5 = (long) r14
            long r3 = r3 - r5
            monitor-enter(r9)
            int r14 = r9.f15578p     // Catch:{ all -> 0x01af }
            if (r14 <= 0) goto L_0x0082
            int r14 = r14 - r2
            int r14 = r9.p(r14)     // Catch:{ all -> 0x01af }
            long[] r0 = r9.f15573k     // Catch:{ all -> 0x01af }
            r5 = r0[r14]     // Catch:{ all -> 0x01af }
            int[] r0 = r9.f15574l     // Catch:{ all -> 0x01af }
            r14 = r0[r14]     // Catch:{ all -> 0x01af }
            long r7 = (long) r14     // Catch:{ all -> 0x01af }
            long r5 = r5 + r7
            int r14 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r14 > 0) goto L_0x007e
            r14 = 1
            goto L_0x007f
        L_0x007e:
            r14 = 0
        L_0x007f:
            j1.a.b(r14)     // Catch:{ all -> 0x01af }
        L_0x0082:
            r14 = 536870912(0x20000000, float:1.0842022E-19)
            r14 = r14 & r12
            if (r14 == 0) goto L_0x0089
            r14 = 1
            goto L_0x008a
        L_0x0089:
            r14 = 0
        L_0x008a:
            r9.f15585w = r14     // Catch:{ all -> 0x01af }
            long r5 = r9.f15584v     // Catch:{ all -> 0x01af }
            long r5 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x01af }
            r9.f15584v = r5     // Catch:{ all -> 0x01af }
            int r14 = r9.f15578p     // Catch:{ all -> 0x01af }
            int r14 = r9.p(r14)     // Catch:{ all -> 0x01af }
            long[] r0 = r9.f15576n     // Catch:{ all -> 0x01af }
            r0[r14] = r10     // Catch:{ all -> 0x01af }
            long[] r10 = r9.f15573k     // Catch:{ all -> 0x01af }
            r10[r14] = r3     // Catch:{ all -> 0x01af }
            int[] r10 = r9.f15574l     // Catch:{ all -> 0x01af }
            r10[r14] = r13     // Catch:{ all -> 0x01af }
            int[] r10 = r9.f15575m     // Catch:{ all -> 0x01af }
            r10[r14] = r12     // Catch:{ all -> 0x01af }
            d2.w0[] r10 = r9.f15577o     // Catch:{ all -> 0x01af }
            r10[r14] = r15     // Catch:{ all -> 0x01af }
            int[] r10 = r9.f15572j     // Catch:{ all -> 0x01af }
            int r11 = r9.C     // Catch:{ all -> 0x01af }
            r10[r14] = r11     // Catch:{ all -> 0x01af }
            v1.k1 r10 = r9.f15565c     // Catch:{ all -> 0x01af }
            android.util.SparseArray r10 = r10.f15701b     // Catch:{ all -> 0x01af }
            int r10 = r10.size()     // Catch:{ all -> 0x01af }
            if (r10 != 0) goto L_0x00c0
            r10 = 1
            goto L_0x00c1
        L_0x00c0:
            r10 = 0
        L_0x00c1:
            r11 = -1
            if (r10 != 0) goto L_0x00dd
            v1.k1 r10 = r9.f15565c     // Catch:{ all -> 0x01af }
            android.util.SparseArray r10 = r10.f15701b     // Catch:{ all -> 0x01af }
            int r12 = r10.size()     // Catch:{ all -> 0x01af }
            int r12 = r12 + r11
            java.lang.Object r10 = r10.valueAt(r12)     // Catch:{ all -> 0x01af }
            v1.y0 r10 = (v1.y0) r10     // Catch:{ all -> 0x01af }
            g1.a0 r10 = r10.f15835a     // Catch:{ all -> 0x01af }
            g1.a0 r12 = r9.B     // Catch:{ all -> 0x01af }
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x01af }
            if (r10 != 0) goto L_0x013b
        L_0x00dd:
            p1.u r10 = r9.f15566d     // Catch:{ all -> 0x01af }
            if (r10 == 0) goto L_0x00ea
            p1.q r12 = r9.f15567e     // Catch:{ all -> 0x01af }
            g1.a0 r13 = r9.B     // Catch:{ all -> 0x01af }
            p1.t r10 = r10.d(r12, r13)     // Catch:{ all -> 0x01af }
            goto L_0x00ec
        L_0x00ea:
            i1.c r10 = p1.t.f12508f     // Catch:{ all -> 0x01af }
        L_0x00ec:
            v1.k1 r12 = r9.f15565c     // Catch:{ all -> 0x01af }
            int r13 = r9.f15579q     // Catch:{ all -> 0x01af }
            int r14 = r9.f15578p     // Catch:{ all -> 0x01af }
            int r13 = r13 + r14
            v1.y0 r14 = new v1.y0     // Catch:{ all -> 0x01af }
            g1.a0 r15 = r9.B     // Catch:{ all -> 0x01af }
            r15.getClass()     // Catch:{ all -> 0x01af }
            r14.<init>(r15, r10)     // Catch:{ all -> 0x01af }
            int r10 = r12.f15700a     // Catch:{ all -> 0x01af }
            android.util.SparseArray r15 = r12.f15701b     // Catch:{ all -> 0x01af }
            if (r10 != r11) goto L_0x0111
            int r10 = r15.size()     // Catch:{ all -> 0x01af }
            if (r10 != 0) goto L_0x010b
            r10 = 1
            goto L_0x010c
        L_0x010b:
            r10 = 0
        L_0x010c:
            j1.a.e(r10)     // Catch:{ all -> 0x01af }
            r12.f15700a = r1     // Catch:{ all -> 0x01af }
        L_0x0111:
            int r10 = r15.size()     // Catch:{ all -> 0x01af }
            if (r10 <= 0) goto L_0x0138
            int r10 = r15.size()     // Catch:{ all -> 0x01af }
            int r10 = r10 - r2
            int r10 = r15.keyAt(r10)     // Catch:{ all -> 0x01af }
            if (r13 < r10) goto L_0x0124
            r11 = 1
            goto L_0x0125
        L_0x0124:
            r11 = 0
        L_0x0125:
            j1.a.b(r11)     // Catch:{ all -> 0x01af }
            if (r10 != r13) goto L_0x0138
            int r10 = r15.size()     // Catch:{ all -> 0x01af }
            int r10 = r10 - r2
            java.lang.Object r10 = r15.valueAt(r10)     // Catch:{ all -> 0x01af }
            j1.h r11 = r12.f15702c     // Catch:{ all -> 0x01af }
            r11.b(r10)     // Catch:{ all -> 0x01af }
        L_0x0138:
            r15.append(r13, r14)     // Catch:{ all -> 0x01af }
        L_0x013b:
            int r10 = r9.f15578p     // Catch:{ all -> 0x01af }
            int r10 = r10 + r2
            r9.f15578p = r10     // Catch:{ all -> 0x01af }
            int r11 = r9.f15571i     // Catch:{ all -> 0x01af }
            if (r10 != r11) goto L_0x01ad
            int r10 = r11 + 1000
            int[] r12 = new int[r10]     // Catch:{ all -> 0x01af }
            long[] r13 = new long[r10]     // Catch:{ all -> 0x01af }
            long[] r14 = new long[r10]     // Catch:{ all -> 0x01af }
            int[] r15 = new int[r10]     // Catch:{ all -> 0x01af }
            int[] r0 = new int[r10]     // Catch:{ all -> 0x01af }
            d2.w0[] r2 = new d2.w0[r10]     // Catch:{ all -> 0x01af }
            int r3 = r9.f15580r     // Catch:{ all -> 0x01af }
            int r11 = r11 - r3
            long[] r4 = r9.f15573k     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r3, r13, r1, r11)     // Catch:{ all -> 0x01af }
            long[] r3 = r9.f15576n     // Catch:{ all -> 0x01af }
            int r4 = r9.f15580r     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r3, r4, r14, r1, r11)     // Catch:{ all -> 0x01af }
            int[] r3 = r9.f15575m     // Catch:{ all -> 0x01af }
            int r4 = r9.f15580r     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r3, r4, r15, r1, r11)     // Catch:{ all -> 0x01af }
            int[] r3 = r9.f15574l     // Catch:{ all -> 0x01af }
            int r4 = r9.f15580r     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r3, r4, r0, r1, r11)     // Catch:{ all -> 0x01af }
            d2.w0[] r3 = r9.f15577o     // Catch:{ all -> 0x01af }
            int r4 = r9.f15580r     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r3, r4, r2, r1, r11)     // Catch:{ all -> 0x01af }
            int[] r3 = r9.f15572j     // Catch:{ all -> 0x01af }
            int r4 = r9.f15580r     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r3, r4, r12, r1, r11)     // Catch:{ all -> 0x01af }
            int r3 = r9.f15580r     // Catch:{ all -> 0x01af }
            long[] r4 = r9.f15573k     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r13, r11, r3)     // Catch:{ all -> 0x01af }
            long[] r4 = r9.f15576n     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r14, r11, r3)     // Catch:{ all -> 0x01af }
            int[] r4 = r9.f15575m     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r15, r11, r3)     // Catch:{ all -> 0x01af }
            int[] r4 = r9.f15574l     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r0, r11, r3)     // Catch:{ all -> 0x01af }
            d2.w0[] r4 = r9.f15577o     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r2, r11, r3)     // Catch:{ all -> 0x01af }
            int[] r4 = r9.f15572j     // Catch:{ all -> 0x01af }
            java.lang.System.arraycopy(r4, r1, r12, r11, r3)     // Catch:{ all -> 0x01af }
            r9.f15573k = r13     // Catch:{ all -> 0x01af }
            r9.f15576n = r14     // Catch:{ all -> 0x01af }
            r9.f15575m = r15     // Catch:{ all -> 0x01af }
            r9.f15574l = r0     // Catch:{ all -> 0x01af }
            r9.f15577o = r2     // Catch:{ all -> 0x01af }
            r9.f15572j = r12     // Catch:{ all -> 0x01af }
            r9.f15580r = r1     // Catch:{ all -> 0x01af }
            r9.f15571i = r10     // Catch:{ all -> 0x01af }
        L_0x01ad:
            monitor-exit(r9)
            return
        L_0x01af:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a1.e(long, int, int, int, d2.w0):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean f(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.f15578p     // Catch:{ all -> 0x0042 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r6.f15583u     // Catch:{ all -> 0x0042 }
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            monitor-exit(r6)
            return r1
        L_0x0011:
            long r3 = r6.n()     // Catch:{ all -> 0x0042 }
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r6)
            return r2
        L_0x001b:
            int r0 = r6.f15578p     // Catch:{ all -> 0x0042 }
            int r2 = r0 + -1
            int r2 = r6.p(r2)     // Catch:{ all -> 0x0042 }
        L_0x0023:
            int r3 = r6.f15581s     // Catch:{ all -> 0x0042 }
            if (r0 <= r3) goto L_0x003a
            long[] r3 = r6.f15576n     // Catch:{ all -> 0x0042 }
            r4 = r3[r2]     // Catch:{ all -> 0x0042 }
            int r3 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x003a
            int r0 = r0 + -1
            int r2 = r2 + -1
            r3 = -1
            if (r2 != r3) goto L_0x0023
            int r2 = r6.f15571i     // Catch:{ all -> 0x0042 }
            int r2 = r2 + r3
            goto L_0x0023
        L_0x003a:
            int r7 = r6.f15579q     // Catch:{ all -> 0x0042 }
            int r7 = r7 + r0
            r6.j(r7)     // Catch:{ all -> 0x0042 }
            monitor-exit(r6)
            return r1
        L_0x0042:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a1.f(long):boolean");
    }

    public final long g(int i10) {
        this.f15583u = Math.max(this.f15583u, o(i10));
        this.f15578p -= i10;
        int i11 = this.f15579q + i10;
        this.f15579q = i11;
        int i12 = this.f15580r + i10;
        this.f15580r = i12;
        int i13 = this.f15571i;
        if (i12 >= i13) {
            this.f15580r = i12 - i13;
        }
        int i14 = this.f15581s - i10;
        this.f15581s = i14;
        int i15 = 0;
        if (i14 < 0) {
            this.f15581s = 0;
        }
        while (true) {
            k1 k1Var = this.f15565c;
            SparseArray sparseArray = k1Var.f15701b;
            if (i15 >= sparseArray.size() - 1) {
                break;
            }
            int i16 = i15 + 1;
            if (i11 < sparseArray.keyAt(i16)) {
                break;
            }
            k1Var.f15702c.b(sparseArray.valueAt(i15));
            sparseArray.removeAt(i15);
            int i17 = k1Var.f15700a;
            if (i17 > 0) {
                k1Var.f15700a = i17 - 1;
            }
            i15 = i16;
        }
        if (this.f15578p != 0) {
            return this.f15573k[this.f15580r];
        }
        int i18 = this.f15580r;
        if (i18 == 0) {
            i18 = this.f15571i;
        }
        int i19 = i18 - 1;
        return this.f15573k[i19] + ((long) this.f15574l[i19]);
    }

    public final void h(long j10, boolean z10, boolean z11) {
        long j11;
        int i10;
        w0 w0Var = this.f15563a;
        synchronized (this) {
            int i11 = this.f15578p;
            if (i11 != 0) {
                long[] jArr = this.f15576n;
                int i12 = this.f15580r;
                if (j10 >= jArr[i12]) {
                    if (z11 && (i10 = this.f15581s) != i11) {
                        i11 = i10 + 1;
                    }
                    int k10 = k(j10, i12, i11, z10);
                    if (k10 != -1) {
                        j11 = g(k10);
                    }
                }
            }
            j11 = -1;
        }
        w0Var.b(j11);
    }

    public final void i() {
        long j10;
        w0 w0Var = this.f15563a;
        synchronized (this) {
            int i10 = this.f15578p;
            if (i10 == 0) {
                j10 = -1;
            } else {
                j10 = g(i10);
            }
        }
        w0Var.b(j10);
    }

    public final long j(int i10) {
        boolean z10;
        int i11 = this.f15579q;
        int i12 = this.f15578p;
        int i13 = (i11 + i12) - i10;
        boolean z11 = false;
        if (i13 < 0 || i13 > i12 - this.f15581s) {
            z10 = false;
        } else {
            z10 = true;
        }
        j1.a.b(z10);
        int i14 = this.f15578p - i13;
        this.f15578p = i14;
        this.f15584v = Math.max(this.f15583u, o(i14));
        if (i13 == 0 && this.f15585w) {
            z11 = true;
        }
        this.f15585w = z11;
        k1 k1Var = this.f15565c;
        SparseArray sparseArray = k1Var.f15701b;
        int i15 = -1;
        int size = sparseArray.size() - 1;
        while (size >= 0 && i10 < sparseArray.keyAt(size)) {
            k1Var.f15702c.b(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
            size--;
        }
        if (sparseArray.size() > 0) {
            i15 = Math.min(k1Var.f15700a, sparseArray.size() - 1);
        }
        k1Var.f15700a = i15;
        int i16 = this.f15578p;
        if (i16 == 0) {
            return 0;
        }
        int p10 = p(i16 - 1);
        return this.f15573k[p10] + ((long) this.f15574l[p10]);
    }

    public final int k(long j10, int i10, int i11, boolean z10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = this.f15576n[i10];
            if (j11 > j10) {
                return i12;
            }
            if (!z10 || (this.f15575m[i10] & 1) != 0) {
                if (j11 == j10) {
                    return i13;
                }
                i12 = i13;
            }
            i10++;
            if (i10 == this.f15571i) {
                i10 = 0;
            }
        }
        return i12;
    }

    public a0 l(a0 a0Var) {
        if (this.F == 0 || a0Var.f6280w == Long.MAX_VALUE) {
            return a0Var;
        }
        z i10 = a0Var.i();
        i10.f6758o = a0Var.f6280w + this.F;
        return i10.a();
    }

    public final synchronized long m() {
        return this.f15584v;
    }

    public final synchronized long n() {
        return Math.max(this.f15583u, o(this.f15581s));
    }

    public final long o(int i10) {
        long j10 = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int p10 = p(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = Math.max(j10, this.f15576n[p10]);
            if ((this.f15575m[p10] & 1) != 0) {
                break;
            }
            p10--;
            if (p10 == -1) {
                p10 = this.f15571i - 1;
            }
        }
        return j10;
    }

    public final int p(int i10) {
        int i11 = this.f15580r + i10;
        int i12 = this.f15571i;
        return i11 < i12 ? i11 : i11 - i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        if (r9 != -1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int q(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f15581s     // Catch:{ all -> 0x0038 }
            int r4 = r8.p(r0)     // Catch:{ all -> 0x0038 }
            int r0 = r8.f15581s     // Catch:{ all -> 0x0038 }
            int r1 = r8.f15578p     // Catch:{ all -> 0x0038 }
            r7 = 0
            if (r0 == r1) goto L_0x0010
            r2 = 1
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            if (r2 == 0) goto L_0x0036
            long[] r2 = r8.f15576n     // Catch:{ all -> 0x0038 }
            r5 = r2[r4]     // Catch:{ all -> 0x0038 }
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x001c
            goto L_0x0036
        L_0x001c:
            long r2 = r8.f15584v     // Catch:{ all -> 0x0038 }
            int r5 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0027
            if (r11 == 0) goto L_0x0027
            int r1 = r1 - r0
            monitor-exit(r8)
            return r1
        L_0x0027:
            int r5 = r1 - r0
            r6 = 1
            r1 = r8
            r2 = r9
            int r9 = r1.k(r2, r4, r5, r6)     // Catch:{ all -> 0x0038 }
            monitor-exit(r8)
            r10 = -1
            if (r9 != r10) goto L_0x0035
            return r7
        L_0x0035:
            return r9
        L_0x0036:
            monitor-exit(r8)
            return r7
        L_0x0038:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a1.q(long, boolean):int");
    }

    public final synchronized a0 r() {
        return this.f15587y ? null : this.B;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean s(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f15581s     // Catch:{ all -> 0x003f }
            int r1 = r4.f15578p     // Catch:{ all -> 0x003f }
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            if (r1 != 0) goto L_0x0020
            if (r5 != 0) goto L_0x001e
            boolean r5 = r4.f15585w     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x001e
            g1.a0 r5 = r4.B     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x001d
            g1.a0 r0 = r4.f15569g     // Catch:{ all -> 0x003f }
            if (r5 == r0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            monitor-exit(r4)
            return r2
        L_0x0020:
            v1.k1 r5 = r4.f15565c     // Catch:{ all -> 0x003f }
            int r1 = r4.f15579q     // Catch:{ all -> 0x003f }
            int r1 = r1 + r0
            java.lang.Object r5 = r5.a(r1)     // Catch:{ all -> 0x003f }
            v1.y0 r5 = (v1.y0) r5     // Catch:{ all -> 0x003f }
            g1.a0 r5 = r5.f15835a     // Catch:{ all -> 0x003f }
            g1.a0 r0 = r4.f15569g     // Catch:{ all -> 0x003f }
            if (r5 == r0) goto L_0x0033
            monitor-exit(r4)
            return r2
        L_0x0033:
            int r5 = r4.f15581s     // Catch:{ all -> 0x003f }
            int r5 = r4.p(r5)     // Catch:{ all -> 0x003f }
            boolean r5 = r4.t(r5)     // Catch:{ all -> 0x003f }
            monitor-exit(r4)
            return r5
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a1.s(boolean):boolean");
    }

    public final boolean t(int i10) {
        n nVar = this.f15570h;
        return nVar == null || nVar.getState() == 4 || ((this.f15575m[i10] & 1073741824) == 0 && this.f15570h.a());
    }

    public final void u(a0 a0Var, m1.w0 w0Var) {
        boolean z10;
        g1.u uVar;
        a0 a0Var2;
        a0 a0Var3 = this.f15569g;
        if (a0Var3 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            uVar = null;
        } else {
            uVar = a0Var3.f6279v;
        }
        this.f15569g = a0Var;
        g1.u uVar2 = a0Var.f6279v;
        u uVar3 = this.f15566d;
        if (uVar3 != null) {
            int b10 = uVar3.b(a0Var);
            z i10 = a0Var.i();
            i10.F = b10;
            a0Var2 = i10.a();
        } else {
            a0Var2 = a0Var;
        }
        w0Var.f10523b = a0Var2;
        w0Var.f10522a = this.f15570h;
        if (uVar3 != null) {
            if (z10 || !l0.a(uVar, uVar2)) {
                n nVar = this.f15570h;
                q qVar = this.f15567e;
                n c10 = uVar3.c(qVar, a0Var);
                this.f15570h = c10;
                w0Var.f10522a = c10;
                if (nVar != null) {
                    nVar.d(qVar);
                }
            }
        }
    }

    public final synchronized int v() {
        boolean z10;
        int i10;
        int p10 = p(this.f15581s);
        if (this.f15581s != this.f15578p) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = this.f15572j[p10];
        } else {
            i10 = this.C;
        }
        return i10;
    }

    public final int w(m1.w0 w0Var, h hVar, int i10, boolean z10) {
        boolean z11;
        boolean z12;
        int i11;
        boolean z13 = false;
        if ((i10 & 2) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        x0 x0Var = this.f15564b;
        synchronized (this) {
            hVar.f9516k = false;
            int i12 = this.f15581s;
            if (i12 != this.f15578p) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                if (!z10) {
                    if (!this.f15585w) {
                        a0 a0Var = this.B;
                        if (a0Var != null && (z11 || a0Var != this.f15569g)) {
                            u(a0Var, w0Var);
                            i11 = -5;
                        }
                    }
                }
                hVar.f9501h = 4;
                i11 = -4;
            } else {
                a0 a0Var2 = ((y0) this.f15565c.a(this.f15579q + i12)).f15835a;
                if (!z11) {
                    if (a0Var2 == this.f15569g) {
                        int p10 = p(this.f15581s);
                        if (!t(p10)) {
                            hVar.f9516k = true;
                        } else {
                            hVar.f9501h = this.f15575m[p10];
                            if (this.f15581s == this.f15578p - 1 && (z10 || this.f15585w)) {
                                hVar.e(536870912);
                            }
                            long j10 = this.f15576n[p10];
                            hVar.f9517l = j10;
                            if (j10 < this.f15582t) {
                                hVar.e(RecyclerView.UNDEFINED_DURATION);
                            }
                            x0Var.f15832a = this.f15574l[p10];
                            x0Var.f15833b = this.f15573k[p10];
                            x0Var.f15834c = this.f15577o[p10];
                            i11 = -4;
                        }
                    }
                }
                u(a0Var2, w0Var);
                i11 = -5;
            }
            i11 = -3;
        }
        if (i11 == -4 && !hVar.f(4)) {
            if ((i10 & 1) != 0) {
                z13 = true;
            }
            if ((i10 & 4) == 0) {
                w0 w0Var2 = this.f15563a;
                x0 x0Var2 = this.f15564b;
                if (z13) {
                    w0.f(w0Var2.f15829e, hVar, x0Var2, w0Var2.f15827c);
                } else {
                    w0Var2.f15829e = w0.f(w0Var2.f15829e, hVar, x0Var2, w0Var2.f15827c);
                }
            }
            if (!z13) {
                this.f15581s++;
            }
        }
        return i11;
    }

    public final void x(boolean z10) {
        boolean z11;
        k1 k1Var;
        SparseArray sparseArray;
        w0 w0Var = this.f15563a;
        w0Var.a(w0Var.f15828d);
        v0 v0Var = w0Var.f15828d;
        int i10 = 0;
        if (v0Var.f15816c == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        j1.a.e(z11);
        v0Var.f15814a = 0;
        v0Var.f15815b = ((long) w0Var.f15826b) + 0;
        v0 v0Var2 = w0Var.f15828d;
        w0Var.f15829e = v0Var2;
        w0Var.f15830f = v0Var2;
        w0Var.f15831g = 0;
        w0Var.f15825a.b();
        this.f15578p = 0;
        this.f15579q = 0;
        this.f15580r = 0;
        this.f15581s = 0;
        this.f15586x = true;
        this.f15582t = Long.MIN_VALUE;
        this.f15583u = Long.MIN_VALUE;
        this.f15584v = Long.MIN_VALUE;
        this.f15585w = false;
        while (true) {
            k1Var = this.f15565c;
            sparseArray = k1Var.f15701b;
            if (i10 >= sparseArray.size()) {
                break;
            }
            k1Var.f15702c.b(sparseArray.valueAt(i10));
            i10++;
        }
        k1Var.f15700a = -1;
        sparseArray.clear();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f15587y = true;
        }
    }

    public final synchronized void y() {
        this.f15581s = 0;
        w0 w0Var = this.f15563a;
        w0Var.f15829e = w0Var.f15828d;
    }

    public final int z(p pVar, int i10, boolean z10) {
        w0 w0Var = this.f15563a;
        int c10 = w0Var.c(i10);
        v0 v0Var = w0Var.f15830f;
        a aVar = v0Var.f15816c;
        int o10 = pVar.o(aVar.f16a, ((int) (w0Var.f15831g - v0Var.f15814a)) + aVar.f17b, c10);
        if (o10 != -1) {
            long j10 = w0Var.f15831g + ((long) o10);
            w0Var.f15831g = j10;
            v0 v0Var2 = w0Var.f15830f;
            if (j10 != v0Var2.f15815b) {
                return o10;
            }
            w0Var.f15830f = v0Var2.f15817d;
            return o10;
        } else if (z10) {
            return -1;
        } else {
            throw new EOFException();
        }
    }
}
