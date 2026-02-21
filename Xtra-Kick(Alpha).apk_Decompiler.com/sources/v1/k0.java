package v1;

import e.a;
import g1.v1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import m1.p1;

public final class k0 implements y, x {

    /* renamed from: h  reason: collision with root package name */
    public final y[] f15691h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap f15692i;

    /* renamed from: j  reason: collision with root package name */
    public final k f15693j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f15694k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final HashMap f15695l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public x f15696m;

    /* renamed from: n  reason: collision with root package name */
    public l1 f15697n;

    /* renamed from: o  reason: collision with root package name */
    public y[] f15698o;

    /* renamed from: p  reason: collision with root package name */
    public a f15699p;

    public k0(k kVar, long[] jArr, y... yVarArr) {
        this.f15693j = kVar;
        this.f15691h = yVarArr;
        kVar.getClass();
        this.f15699p = new a(23, (Object) new d1[0]);
        this.f15692i = new IdentityHashMap();
        this.f15698o = new y[0];
        for (int i10 = 0; i10 < yVarArr.length; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                this.f15691h[i10] = new i0(yVarArr[i10], j10);
            }
        }
    }

    public final long B(long j10) {
        long B = this.f15698o[0].B(j10);
        int i10 = 1;
        while (true) {
            y[] yVarArr = this.f15698o;
            if (i10 >= yVarArr.length) {
                return B;
            }
            if (yVarArr[i10].B(B) == B) {
                i10++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final boolean C(long j10) {
        ArrayList arrayList = this.f15694k;
        if (arrayList.isEmpty()) {
            return this.f15699p.C(j10);
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((y) arrayList.get(i10)).C(j10);
        }
        return false;
    }

    public final void D(long j10) {
        this.f15699p.D(j10);
    }

    public final boolean c() {
        return this.f15699p.c();
    }

    public final long f(long j10, p1 p1Var) {
        y[] yVarArr = this.f15698o;
        return (yVarArr.length > 0 ? yVarArr[0] : this.f15691h[0]).f(j10, p1Var);
    }

    public final void h(y yVar) {
        ArrayList arrayList = this.f15694k;
        arrayList.remove(yVar);
        if (arrayList.isEmpty()) {
            y[] yVarArr = this.f15691h;
            int i10 = 0;
            for (y o10 : yVarArr) {
                i10 += o10.o().f15716h;
            }
            v1[] v1VarArr = new v1[i10];
            int i11 = 0;
            for (int i12 = 0; i12 < yVarArr.length; i12++) {
                l1 o11 = yVarArr[i12].o();
                int i13 = o11.f15716h;
                int i14 = 0;
                while (i14 < i13) {
                    v1 i15 = o11.i(i14);
                    v1 v1Var = new v1(i12 + Constants.EXT_TAG_END + i15.f6674i, i15.f6676k);
                    this.f15695l.put(v1Var, i15);
                    v1VarArr[i11] = v1Var;
                    i14++;
                    i11++;
                }
            }
            this.f15697n = new l1(v1VarArr);
            x xVar = this.f15696m;
            xVar.getClass();
            xVar.h(this);
        }
    }

    public final long j() {
        return this.f15699p.j();
    }

    public final long k() {
        long j10 = -9223372036854775807L;
        for (y yVar : this.f15698o) {
            long k10 = yVar.k();
            if (k10 != -9223372036854775807L) {
                if (j10 == -9223372036854775807L) {
                    y[] yVarArr = this.f15698o;
                    int length = yVarArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        y yVar2 = yVarArr[i10];
                        if (yVar2 == yVar) {
                            break;
                        } else if (yVar2.B(k10) == k10) {
                            i10++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j10 = k10;
                } else if (k10 != j10) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j10 == -9223372036854775807L || yVar.B(j10) == j10)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j10;
    }

    public final void m(x xVar, long j10) {
        this.f15696m = xVar;
        ArrayList arrayList = this.f15694k;
        y[] yVarArr = this.f15691h;
        Collections.addAll(arrayList, yVarArr);
        for (y m10 : yVarArr) {
            m10.m(this, j10);
        }
    }

    public final l1 o() {
        l1 l1Var = this.f15697n;
        l1Var.getClass();
        return l1Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long p(z1.s[] r23, boolean[] r24, v1.b1[] r25, boolean[] r26, long r27) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r25
            int r3 = r1.length
            int[] r3 = new int[r3]
            int r4 = r1.length
            int[] r4 = new int[r4]
            r5 = 0
            r6 = 0
        L_0x000e:
            int r7 = r1.length
            java.util.IdentityHashMap r8 = r0.f15692i
            if (r6 >= r7) goto L_0x004b
            r7 = r2[r6]
            if (r7 != 0) goto L_0x0019
            r9 = 0
            goto L_0x0020
        L_0x0019:
            java.lang.Object r7 = r8.get(r7)
            r9 = r7
            java.lang.Integer r9 = (java.lang.Integer) r9
        L_0x0020:
            r7 = -1
            if (r9 != 0) goto L_0x0025
            r8 = -1
            goto L_0x0029
        L_0x0025:
            int r8 = r9.intValue()
        L_0x0029:
            r3[r6] = r8
            r8 = r1[r6]
            if (r8 == 0) goto L_0x0046
            g1.v1 r7 = r8.l()
            java.lang.String r7 = r7.f6674i
            java.lang.String r8 = ":"
            int r8 = r7.indexOf(r8)
            java.lang.String r7 = r7.substring(r5, r8)
            int r7 = java.lang.Integer.parseInt(r7)
            r4[r6] = r7
            goto L_0x0048
        L_0x0046:
            r4[r6] = r7
        L_0x0048:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x004b:
            r8.clear()
            int r6 = r1.length
            v1.b1[] r7 = new v1.b1[r6]
            int r10 = r1.length
            v1.b1[] r10 = new v1.b1[r10]
            int r11 = r1.length
            z1.s[] r15 = new z1.s[r11]
            java.util.ArrayList r14 = new java.util.ArrayList
            v1.y[] r13 = r0.f15691h
            int r11 = r13.length
            r14.<init>(r11)
            r18 = r27
            r12 = 0
        L_0x0062:
            int r11 = r13.length
            if (r12 >= r11) goto L_0x0106
            r11 = 0
        L_0x0066:
            int r5 = r1.length
            if (r11 >= r5) goto L_0x00a0
            r5 = r3[r11]
            if (r5 != r12) goto L_0x0070
            r5 = r2[r11]
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            r10[r11] = r5
            r5 = r4[r11]
            if (r5 != r12) goto L_0x0096
            r5 = r1[r11]
            r5.getClass()
            g1.v1 r9 = r5.l()
            r16 = r14
            java.util.HashMap r14 = r0.f15695l
            java.lang.Object r9 = r14.get(r9)
            g1.v1 r9 = (g1.v1) r9
            r9.getClass()
            v1.h0 r14 = new v1.h0
            r14.<init>(r5, r9)
            r15[r11] = r14
            r5 = 0
            goto L_0x009b
        L_0x0096:
            r16 = r14
            r5 = 0
            r15[r11] = r5
        L_0x009b:
            int r11 = r11 + 1
            r14 = r16
            goto L_0x0066
        L_0x00a0:
            r16 = r14
            r5 = 0
            r11 = r13[r12]
            r9 = r12
            r12 = r15
            r20 = r13
            r13 = r24
            r5 = r16
            r14 = r10
            r21 = r15
            r15 = r26
            r16 = r18
            long r11 = r11.p(r12, r13, r14, r15, r16)
            if (r9 != 0) goto L_0x00bd
            r18 = r11
            goto L_0x00c1
        L_0x00bd:
            int r13 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r13 != 0) goto L_0x00fe
        L_0x00c1:
            r11 = 0
            r12 = 0
        L_0x00c3:
            int r13 = r1.length
            if (r11 >= r13) goto L_0x00ed
            r13 = r4[r11]
            r14 = 1
            if (r13 != r9) goto L_0x00dd
            r12 = r10[r11]
            r12.getClass()
            r13 = r10[r11]
            r7[r11] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)
            r8.put(r12, r13)
            r12 = 1
            goto L_0x00ea
        L_0x00dd:
            r13 = r3[r11]
            if (r13 != r9) goto L_0x00ea
            r13 = r10[r11]
            if (r13 != 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r14 = 0
        L_0x00e7:
            j1.a.e(r14)
        L_0x00ea:
            int r11 = r11 + 1
            goto L_0x00c3
        L_0x00ed:
            if (r12 == 0) goto L_0x00f4
            r11 = r20[r9]
            r5.add(r11)
        L_0x00f4:
            int r12 = r9 + 1
            r14 = r5
            r13 = r20
            r15 = r21
            r5 = 0
            goto L_0x0062
        L_0x00fe:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Children enabled at different positions."
            r1.<init>(r2)
            throw r1
        L_0x0106:
            r5 = r14
            r1 = 0
            java.lang.System.arraycopy(r7, r1, r2, r1, r6)
            v1.y[] r1 = new v1.y[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            v1.y[] r1 = (v1.y[]) r1
            r0.f15698o = r1
            v1.k r2 = r0.f15693j
            r2.getClass()
            e.a r2 = new e.a
            r3 = 23
            r2.<init>((int) r3, (java.lang.Object) r1)
            r0.f15699p = r2
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.k0.p(z1.s[], boolean[], v1.b1[], boolean[], long):long");
    }

    public final void r(d1 d1Var) {
        y yVar = (y) d1Var;
        x xVar = this.f15696m;
        xVar.getClass();
        xVar.r(this);
    }

    public final long u() {
        return this.f15699p.u();
    }

    public final void v() {
        for (y v10 : this.f15691h) {
            v10.v();
        }
    }

    public final void y(long j10, boolean z10) {
        for (y y10 : this.f15698o) {
            y10.y(j10, z10);
        }
    }
}
