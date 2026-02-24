package kb;

import h3.u1;
import hb.h;
import hb.h0;
import hb.l;
import jb.a;
import la.v;
import lb.b;
import lb.c;
import lb.i;
import lb.q;
import pa.e;
import pa.k;
import qa.d;
import xa.j;

public class s0 extends b implements k0, i, q {

    /* renamed from: l  reason: collision with root package name */
    public final int f9385l;

    /* renamed from: m  reason: collision with root package name */
    public final int f9386m;

    /* renamed from: n  reason: collision with root package name */
    public final a f9387n;

    /* renamed from: o  reason: collision with root package name */
    public Object[] f9388o;

    /* renamed from: p  reason: collision with root package name */
    public long f9389p;

    /* renamed from: q  reason: collision with root package name */
    public long f9390q;

    /* renamed from: r  reason: collision with root package name */
    public int f9391r;

    /* renamed from: s  reason: collision with root package name */
    public int f9392s;

    public s0(int i10, int i11, a aVar) {
        this.f9385l = i10;
        this.f9386m = i11;
        this.f9387n = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[Catch:{ all -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A[Catch:{ all -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qa.a m(kb.s0 r8, kb.j r9, pa.e r10) {
        /*
            boolean r0 = r10 instanceof kb.r0
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kb.r0 r0 = (kb.r0) r0
            int r1 = r0.f9379n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9379n = r1
            goto L_0x0018
        L_0x0013:
            kb.r0 r0 = new kb.r0
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f9377l
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9379n
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            hb.l1 r8 = r0.f9376k
            kb.u0 r9 = r0.f9375j
            kb.j r2 = r0.f9374i
            kb.s0 r5 = r0.f9373h
            hb.h0.O1(r10)     // Catch:{ all -> 0x003e }
            goto L_0x0089
        L_0x003e:
            r8 = move-exception
        L_0x003f:
            r10 = r9
            r9 = r8
            r8 = r5
            goto L_0x00c8
        L_0x0044:
            kb.u0 r9 = r0.f9375j
            kb.j r8 = r0.f9374i
            kb.s0 r2 = r0.f9373h
            hb.h0.O1(r10)     // Catch:{ all -> 0x0050 }
            r10 = r8
            r8 = r2
            goto L_0x007a
        L_0x0050:
            r8 = move-exception
            r10 = r9
            r9 = r8
            r8 = r2
            goto L_0x00c8
        L_0x0056:
            hb.h0.O1(r10)
            lb.c r10 = r8.e()
            kb.u0 r10 = (kb.u0) r10
            boolean r2 = r9 instanceof kb.i1     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x0077
            r2 = r9
            kb.i1 r2 = (kb.i1) r2     // Catch:{ all -> 0x0075 }
            r0.f9373h = r8     // Catch:{ all -> 0x0075 }
            r0.f9374i = r9     // Catch:{ all -> 0x0075 }
            r0.f9375j = r10     // Catch:{ all -> 0x0075 }
            r0.f9379n = r5     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = r2.b(r0)     // Catch:{ all -> 0x0075 }
            if (r2 != r1) goto L_0x0077
            return r1
        L_0x0075:
            r9 = move-exception
            goto L_0x00c8
        L_0x0077:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x007a:
            pa.k r2 = r0.getContext()     // Catch:{ all -> 0x00c3 }
            hb.k1 r5 = hb.l1.f7823b     // Catch:{ all -> 0x00c3 }
            pa.h r2 = r2.N(r5)     // Catch:{ all -> 0x00c3 }
            hb.l1 r2 = (hb.l1) r2     // Catch:{ all -> 0x00c3 }
            r5 = r8
            r8 = r2
            r2 = r10
        L_0x0089:
            java.lang.Object r10 = r5.u(r9)     // Catch:{ all -> 0x003e }
            h3.u1 r6 = kb.t0.f9395a     // Catch:{ all -> 0x003e }
            if (r10 != r6) goto L_0x00a2
            r0.f9373h = r5     // Catch:{ all -> 0x003e }
            r0.f9374i = r2     // Catch:{ all -> 0x003e }
            r0.f9375j = r9     // Catch:{ all -> 0x003e }
            r0.f9376k = r8     // Catch:{ all -> 0x003e }
            r0.f9379n = r4     // Catch:{ all -> 0x003e }
            java.lang.Object r10 = r5.k(r9, r0)     // Catch:{ all -> 0x003e }
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x00a2:
            if (r8 == 0) goto L_0x00b2
            boolean r6 = r8.c()     // Catch:{ all -> 0x003e }
            if (r6 == 0) goto L_0x00ab
            goto L_0x00b2
        L_0x00ab:
            hb.u1 r8 = (hb.u1) r8     // Catch:{ all -> 0x003e }
            java.util.concurrent.CancellationException r8 = r8.C()     // Catch:{ all -> 0x003e }
            throw r8     // Catch:{ all -> 0x003e }
        L_0x00b2:
            r0.f9373h = r5     // Catch:{ all -> 0x003e }
            r0.f9374i = r2     // Catch:{ all -> 0x003e }
            r0.f9375j = r9     // Catch:{ all -> 0x003e }
            r0.f9376k = r8     // Catch:{ all -> 0x003e }
            r0.f9379n = r3     // Catch:{ all -> 0x003e }
            java.lang.Object r10 = r2.a(r10, r0)     // Catch:{ all -> 0x003e }
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x00c3:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x003f
        L_0x00c8:
            r8.i(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.s0.m(kb.s0, kb.j, pa.e):qa.a");
    }

    public final Object a(Object obj, e eVar) {
        e[] eVarArr;
        q0 q0Var;
        if (!h(obj)) {
            l lVar = new l(1, d.b(eVar));
            lVar.w();
            e[] eVarArr2 = h0.f7803b;
            synchronized (this) {
                if (s(obj)) {
                    int i10 = la.l.f9802h;
                    lVar.resumeWith(v.f9814a);
                    eVarArr = p(eVarArr2);
                    q0Var = null;
                } else {
                    q0 q0Var2 = new q0(this, ((long) (this.f9391r + this.f9392s)) + q(), obj, lVar);
                    o(q0Var2);
                    this.f9392s++;
                    if (this.f9386m == 0) {
                        eVarArr2 = p(eVarArr2);
                    }
                    eVarArr = eVarArr2;
                    q0Var = q0Var2;
                }
            }
            if (q0Var != null) {
                lVar.j(new h(1, q0Var));
            }
            for (e eVar2 : eVarArr) {
                if (eVar2 != null) {
                    int i11 = la.l.f9802h;
                    eVar2.resumeWith(v.f9814a);
                }
            }
            Object u10 = lVar.u();
            qa.a aVar = qa.a.COROUTINE_SUSPENDED;
            if (u10 == aVar) {
                h0.m1(eVar);
            }
            if (u10 != aVar) {
                u10 = v.f9814a;
            }
            if (u10 == aVar) {
                return u10;
            }
        }
        return v.f9814a;
    }

    public final Object b(j jVar, e eVar) {
        m(this, jVar, eVar);
        return qa.a.COROUTINE_SUSPENDED;
    }

    public final void c() {
        synchronized (this) {
            v(q() + ((long) this.f9391r), this.f9390q, q() + ((long) this.f9391r), q() + ((long) this.f9391r) + ((long) this.f9392s));
            v vVar = v.f9814a;
        }
    }

    public final i d(k kVar, int i10, a aVar) {
        return ((i10 == 0 || i10 == -3) && aVar == a.SUSPEND) ? this : new i(i10, kVar, aVar, this);
    }

    public final c f() {
        return new u0();
    }

    public final c[] g() {
        return new u0[2];
    }

    public final boolean h(Object obj) {
        int i10;
        boolean z10;
        e[] eVarArr = h0.f7803b;
        synchronized (this) {
            if (s(obj)) {
                eVarArr = p(eVarArr);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (e eVar : eVarArr) {
            if (eVar != null) {
                int i11 = la.l.f9802h;
                eVar.resumeWith(v.f9814a);
            }
        }
        return z10;
    }

    public final Object k(u0 u0Var, r0 r0Var) {
        l lVar = new l(1, d.b(r0Var));
        lVar.w();
        synchronized (this) {
            if (t(u0Var) < 0) {
                u0Var.f9403b = lVar;
            } else {
                int i10 = la.l.f9802h;
                lVar.resumeWith(v.f9814a);
            }
            v vVar = v.f9814a;
        }
        Object u10 = lVar.u();
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (u10 == aVar) {
            h0.m1(r0Var);
        }
        if (u10 == aVar) {
            return u10;
        }
        return v.f9814a;
    }

    public final void l() {
        if (this.f9386m != 0 || this.f9392s > 1) {
            Object[] objArr = this.f9388o;
            j.c(objArr);
            while (this.f9392s > 0) {
                long q10 = q();
                int i10 = this.f9391r;
                int i11 = this.f9392s;
                if (objArr[(objArr.length - 1) & ((int) ((q10 + ((long) (i10 + i11))) - 1))] == t0.f9395a) {
                    this.f9392s = i11 - 1;
                    objArr[(objArr.length - 1) & ((int) (q() + ((long) (this.f9391r + this.f9392s))))] = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void n() {
        c[] cVarArr;
        Object[] objArr = this.f9388o;
        j.c(objArr);
        objArr[(objArr.length - 1) & ((int) q())] = null;
        this.f9391r--;
        long q10 = q() + 1;
        if (this.f9389p < q10) {
            this.f9389p = q10;
        }
        if (this.f9390q < q10) {
            if (!(this.f9819i == 0 || (cVarArr = this.f9818h) == null)) {
                for (c cVar : cVarArr) {
                    if (cVar != null) {
                        u0 u0Var = (u0) cVar;
                        long j10 = u0Var.f9402a;
                        if (j10 >= 0 && j10 < q10) {
                            u0Var.f9402a = q10;
                        }
                    }
                }
            }
            this.f9390q = q10;
        }
    }

    public final void o(Object obj) {
        int i10 = this.f9391r + this.f9392s;
        Object[] objArr = this.f9388o;
        if (objArr == null) {
            objArr = r(0, 2, (Object[]) null);
        } else if (i10 >= objArr.length) {
            objArr = r(i10, objArr.length * 2, objArr);
        }
        objArr[((int) (q() + ((long) i10))) & (objArr.length - 1)] = obj;
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r4 = (kb.u0) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pa.e[] p(pa.e[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = r11.f9819i
            if (r1 == 0) goto L_0x0044
            lb.c[] r1 = r11.f9818h
            if (r1 == 0) goto L_0x0044
            int r2 = r1.length
            r3 = 0
        L_0x000b:
            if (r3 >= r2) goto L_0x0044
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0041
            kb.u0 r4 = (kb.u0) r4
            hb.l r5 = r4.f9403b
            if (r5 != 0) goto L_0x0018
            goto L_0x0041
        L_0x0018:
            long r6 = r11.t(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0041
            int r6 = r12.length
            if (r0 < r6) goto L_0x0036
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            xa.j.e(r6, r12)
        L_0x0036:
            r6 = r12
            pa.e[] r6 = (pa.e[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f9403b = r0
            r0 = r7
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0044:
            pa.e[] r12 = (pa.e[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.s0.p(pa.e[]):pa.e[]");
    }

    public final long q() {
        return Math.min(this.f9390q, this.f9389p);
    }

    public final Object[] r(int i10, int i11, Object[] objArr) {
        boolean z10;
        if (i11 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Object[] objArr2 = new Object[i11];
            this.f9388o = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long q10 = q();
            for (int i12 = 0; i12 < i10; i12++) {
                int i13 = (int) (((long) i12) + q10);
                objArr2[i13 & (i11 - 1)] = objArr[(objArr.length - 1) & i13];
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean s(Object obj) {
        int i10 = this.f9819i;
        int i11 = this.f9385l;
        if (i10 == 0) {
            if (i11 != 0) {
                o(obj);
                int i12 = this.f9391r + 1;
                this.f9391r = i12;
                if (i12 > i11) {
                    n();
                }
                this.f9390q = q() + ((long) this.f9391r);
            }
            return true;
        }
        int i13 = this.f9391r;
        int i14 = this.f9386m;
        if (i13 >= i14 && this.f9390q <= this.f9389p) {
            int ordinal = this.f9387n.ordinal();
            if (ordinal == 0) {
                return false;
            }
            if (ordinal == 2) {
                return true;
            }
        }
        o(obj);
        int i15 = this.f9391r + 1;
        this.f9391r = i15;
        if (i15 > i14) {
            n();
        }
        long q10 = q() + ((long) this.f9391r);
        long j10 = this.f9389p;
        if (((int) (q10 - j10)) > i11) {
            v(j10 + 1, this.f9390q, q() + ((long) this.f9391r), q() + ((long) this.f9391r) + ((long) this.f9392s));
        }
        return true;
    }

    public final long t(u0 u0Var) {
        long j10 = u0Var.f9402a;
        if (j10 < q() + ((long) this.f9391r)) {
            return j10;
        }
        if (this.f9386m <= 0 && j10 <= q() && this.f9392s != 0) {
            return j10;
        }
        return -1;
    }

    public final Object u(u0 u0Var) {
        Object obj;
        e[] eVarArr = h0.f7803b;
        synchronized (this) {
            long t10 = t(u0Var);
            if (t10 < 0) {
                obj = t0.f9395a;
            } else {
                long j10 = u0Var.f9402a;
                Object[] objArr = this.f9388o;
                j.c(objArr);
                Object obj2 = objArr[((int) t10) & (objArr.length - 1)];
                if (obj2 instanceof q0) {
                    obj2 = ((q0) obj2).f9368j;
                }
                u0Var.f9402a = t10 + 1;
                Object obj3 = obj2;
                eVarArr = w(j10);
                obj = obj3;
            }
        }
        for (e eVar : eVarArr) {
            if (eVar != null) {
                int i10 = la.l.f9802h;
                eVar.resumeWith(v.f9814a);
            }
        }
        return obj;
    }

    public final void v(long j10, long j11, long j12, long j13) {
        long min = Math.min(j11, j10);
        for (long q10 = q(); q10 < min; q10++) {
            Object[] objArr = this.f9388o;
            j.c(objArr);
            objArr[((int) q10) & (objArr.length - 1)] = null;
        }
        this.f9389p = j10;
        this.f9390q = j11;
        this.f9391r = (int) (j12 - min);
        this.f9392s = (int) (j13 - j12);
    }

    public final e[] w(long j10) {
        int i10;
        long j11;
        long j12;
        long j13;
        boolean z10;
        long j14;
        c[] cVarArr;
        long j15 = this.f9390q;
        e[] eVarArr = h0.f7803b;
        if (j10 > j15) {
            return eVarArr;
        }
        long q10 = q();
        long j16 = ((long) this.f9391r) + q10;
        int i11 = this.f9386m;
        if (i11 == 0 && this.f9392s > 0) {
            j16++;
        }
        if (!(this.f9819i == 0 || (cVarArr = this.f9818h) == null)) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    long j17 = ((u0) cVar).f9402a;
                    if (j17 >= 0 && j17 < j16) {
                        j16 = j17;
                    }
                }
            }
        }
        if (j16 <= this.f9390q) {
            return eVarArr;
        }
        long q11 = q() + ((long) this.f9391r);
        if (this.f9819i > 0) {
            i10 = Math.min(this.f9392s, i11 - ((int) (q11 - j16)));
        } else {
            i10 = this.f9392s;
        }
        long j18 = ((long) this.f9392s) + q11;
        if (i10 > 0) {
            eVarArr = new e[i10];
            Object[] objArr = this.f9388o;
            j.c(objArr);
            long j19 = q11;
            int i12 = 0;
            while (true) {
                if (q11 >= j18) {
                    j12 = j16;
                    j11 = j18;
                    break;
                }
                int i13 = (int) q11;
                j12 = j16;
                Object obj = objArr[(objArr.length - 1) & i13];
                u1 u1Var = t0.f9395a;
                if (obj != u1Var) {
                    j11 = j18;
                    j.d("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter", obj);
                    q0 q0Var = (q0) obj;
                    int i14 = i12 + 1;
                    eVarArr[i12] = q0Var.f9369k;
                    objArr[i13 & (objArr.length - 1)] = u1Var;
                    objArr[((int) j19) & (objArr.length - 1)] = q0Var.f9368j;
                    j14 = 1;
                    j19++;
                    if (i14 >= i10) {
                        break;
                    }
                    i12 = i14;
                } else {
                    j11 = j18;
                    j14 = 1;
                }
                q11 += j14;
                j16 = j12;
                j18 = j11;
            }
            q11 = j19;
        } else {
            j12 = j16;
            j11 = j18;
        }
        e[] eVarArr2 = eVarArr;
        int i15 = (int) (q11 - q10);
        if (this.f9819i == 0) {
            j13 = q11;
        } else {
            j13 = j12;
        }
        long max = Math.max(this.f9389p, q11 - ((long) Math.min(this.f9385l, i15)));
        if (i11 == 0 && max < j11) {
            Object[] objArr2 = this.f9388o;
            j.c(objArr2);
            if (j.a(objArr2[((int) max) & (objArr2.length - 1)], t0.f9395a)) {
                q11++;
                max++;
            }
        }
        v(max, j13, q11, j11);
        l();
        if (eVarArr2.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return p(eVarArr2);
        }
        return eVarArr2;
    }
}
