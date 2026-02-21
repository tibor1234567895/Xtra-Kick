package m1;

import android.util.Pair;
import androidx.emoji2.text.r;
import d9.o0;
import d9.p0;
import d9.r0;
import g1.c;
import g1.r1;
import g1.t1;
import g1.u1;
import j1.f0;
import j1.n;
import n1.a;
import v1.a0;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public final r1 f10174a = new r1();

    /* renamed from: b  reason: collision with root package name */
    public final t1 f10175b = new t1();

    /* renamed from: c  reason: collision with root package name */
    public final a f10176c;

    /* renamed from: d  reason: collision with root package name */
    public final n f10177d;

    /* renamed from: e  reason: collision with root package name */
    public long f10178e;

    /* renamed from: f  reason: collision with root package name */
    public int f10179f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10180g;

    /* renamed from: h  reason: collision with root package name */
    public y0 f10181h;

    /* renamed from: i  reason: collision with root package name */
    public y0 f10182i;

    /* renamed from: j  reason: collision with root package name */
    public y0 f10183j;

    /* renamed from: k  reason: collision with root package name */
    public int f10184k;

    /* renamed from: l  reason: collision with root package name */
    public Object f10185l;

    /* renamed from: m  reason: collision with root package name */
    public long f10186m;

    public a1(a aVar, f0 f0Var) {
        this.f10176c = aVar;
        this.f10177d = f0Var;
    }

    public static a0 l(u1 u1Var, Object obj, long j10, long j11, t1 t1Var, r1 r1Var) {
        u1Var.p(obj, r1Var);
        u1Var.v(r1Var.f6544j, t1Var);
        int k10 = u1Var.k(obj);
        Object obj2 = obj;
        while (r1Var.f6545k == 0) {
            c cVar = r1Var.f6548n;
            if (cVar.f6329i <= 0 || !r1Var.o(cVar.f6332l) || r1Var.k(0) != -1) {
                break;
            }
            int i10 = k10 + 1;
            if (k10 >= t1Var.f6590w) {
                break;
            }
            u1Var.o(i10, r1Var, true);
            obj2 = r1Var.f6543i;
            obj2.getClass();
            k10 = i10;
        }
        u1Var.p(obj2, r1Var);
        int k11 = r1Var.k(j10);
        if (k11 == -1) {
            return new a0(r1Var.j(j10), j11, obj2);
        }
        return new a0(obj2, k11, r1Var.n(k11), j11);
    }

    public final y0 a() {
        y0 y0Var = this.f10181h;
        if (y0Var == null) {
            return null;
        }
        if (y0Var == this.f10182i) {
            this.f10182i = y0Var.f10540l;
        }
        y0Var.f();
        int i10 = this.f10184k - 1;
        this.f10184k = i10;
        if (i10 == 0) {
            this.f10183j = null;
            y0 y0Var2 = this.f10181h;
            this.f10185l = y0Var2.f10530b;
            this.f10186m = y0Var2.f10534f.f10547a.f6681d;
        }
        this.f10181h = this.f10181h.f10540l;
        j();
        return this.f10181h;
    }

    public final void b() {
        if (this.f10184k != 0) {
            y0 y0Var = this.f10181h;
            j1.a.f(y0Var);
            this.f10185l = y0Var.f10530b;
            this.f10186m = y0Var.f10534f.f10547a.f6681d;
            while (y0Var != null) {
                y0Var.f();
                y0Var = y0Var.f10540l;
            }
            this.f10181h = null;
            this.f10183j = null;
            this.f10182i = null;
            this.f10184k = 0;
            j();
        }
    }

    public final z0 c(u1 u1Var, y0 y0Var, long j10) {
        boolean z10;
        long j11;
        Object obj;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        u1 u1Var2 = u1Var;
        y0 y0Var2 = y0Var;
        z0 z0Var = y0Var2.f10534f;
        long j18 = (y0Var2.f10543o + z0Var.f10551e) - j10;
        boolean z11 = z0Var.f10553g;
        r1 r1Var = this.f10174a;
        long j19 = z0Var.f10549c;
        a0 a0Var = z0Var.f10547a;
        if (z11) {
            int k10 = u1Var2.k(a0Var.f6678a);
            r1 r1Var2 = this.f10174a;
            r1 r1Var3 = r1Var;
            r1 r1Var4 = r1Var2;
            boolean z12 = true;
            int m10 = u1Var.m(k10, r1Var4, this.f10175b, this.f10179f, this.f10180g);
            if (m10 == -1) {
                return null;
            }
            r1 r1Var5 = r1Var3;
            int i10 = u1Var2.o(m10, r1Var5, true).f6544j;
            Object obj2 = r1Var5.f6543i;
            obj2.getClass();
            if (u1Var2.v(i10, this.f10175b).f6589v == m10) {
                Pair s10 = u1Var.s(this.f10175b, this.f10174a, i10, -9223372036854775807L, Math.max(0, j18));
                if (s10 == null) {
                    return null;
                }
                obj2 = s10.first;
                long longValue = ((Long) s10.second).longValue();
                y0 y0Var3 = y0Var2.f10540l;
                if (y0Var3 == null || !y0Var3.f10530b.equals(obj2)) {
                    j15 = this.f10178e;
                    this.f10178e = 1 + j15;
                } else {
                    j15 = y0Var3.f10534f.f10547a.f6681d;
                }
                j14 = longValue;
                j13 = -9223372036854775807L;
            } else {
                j15 = a0Var.f6681d;
                j14 = 0;
                j13 = 0;
            }
            a0 l10 = l(u1Var, obj2, j14, j15, this.f10175b, this.f10174a);
            if (!(j13 == -9223372036854775807L || j19 == -9223372036854775807L)) {
                if (u1Var2.p(a0Var.f6678a, r1Var5).f6548n.f6329i <= 0 || !r1Var5.o(r1Var5.f6548n.f6332l)) {
                    z12 = false;
                }
                if (l10.a() && z12) {
                    j17 = j19;
                    j16 = j14;
                    return d(u1Var, l10, j17, j16);
                } else if (z12) {
                    j16 = j19;
                    j17 = j13;
                    return d(u1Var, l10, j17, j16);
                }
            }
            j16 = j14;
            j17 = j13;
            return d(u1Var, l10, j17, j16);
        }
        r1 r1Var6 = r1Var;
        u1Var2.p(a0Var.f6678a, r1Var6);
        boolean a10 = a0Var.a();
        Object obj3 = a0Var.f6678a;
        if (a10) {
            int i11 = a0Var.f6679b;
            int i12 = r1Var6.f6548n.i(i11).f6300i;
            if (i12 == -1) {
                return null;
            }
            int i13 = r1Var6.f6548n.i(i11).i(a0Var.f6680c);
            if (i13 < i12) {
                return e(u1Var, a0Var.f6678a, i11, i13, z0Var.f10549c, a0Var.f6681d);
            }
            if (j19 == -9223372036854775807L) {
                obj = obj3;
                Pair s11 = u1Var.s(this.f10175b, r1Var6, r1Var6.f6544j, -9223372036854775807L, Math.max(0, j18));
                if (s11 == null) {
                    return null;
                }
                j19 = ((Long) s11.second).longValue();
            } else {
                obj = obj3;
            }
            u1Var2.p(obj, r1Var6);
            int i14 = a0Var.f6679b;
            long l11 = r1Var6.l(i14);
            if (l11 == Long.MIN_VALUE) {
                j12 = r1Var6.f6545k;
            } else {
                j12 = l11 + r1Var6.f6548n.i(i14).f6305n;
            }
            return f(u1Var, a0Var.f6678a, Math.max(j12, j19), z0Var.f10549c, a0Var.f6681d);
        }
        Object obj4 = obj3;
        int i15 = a0Var.f6682e;
        int n10 = r1Var6.n(i15);
        if (!r1Var6.o(i15) || r1Var6.m(i15, n10) != 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (n10 == r1Var6.f6548n.i(i15).f6300i || z10) {
            u1Var2.p(obj4, r1Var6);
            long l12 = r1Var6.l(i15);
            if (l12 == Long.MIN_VALUE) {
                j11 = r1Var6.f6545k;
            } else {
                j11 = l12 + r1Var6.f6548n.i(i15).f6305n;
            }
            return f(u1Var, a0Var.f6678a, j11, z0Var.f10551e, a0Var.f6681d);
        }
        return e(u1Var, a0Var.f6678a, a0Var.f6682e, n10, z0Var.f10551e, a0Var.f6681d);
    }

    public final z0 d(u1 u1Var, a0 a0Var, long j10, long j11) {
        a0 a0Var2 = a0Var;
        u1 u1Var2 = u1Var;
        u1Var.p(a0Var2.f6678a, this.f10174a);
        boolean a10 = a0Var.a();
        Object obj = a0Var2.f6678a;
        if (a10) {
            return e(u1Var, obj, a0Var2.f6679b, a0Var2.f6680c, j10, a0Var2.f6681d);
        }
        return f(u1Var, obj, j11, j10, a0Var2.f6681d);
    }

    public final z0 e(u1 u1Var, Object obj, int i10, int i11, long j10, long j11) {
        long j12;
        long j13;
        int i12 = i10;
        int i13 = i11;
        a0 a0Var = new a0(obj, i10, i11, j11);
        r1 r1Var = this.f10174a;
        long i14 = u1Var.p(obj, r1Var).i(i12, i13);
        if (i13 == r1Var.n(i12)) {
            j12 = r1Var.f6548n.f6330j;
        } else {
            j12 = 0;
        }
        boolean o10 = r1Var.o(i12);
        if (i14 == -9223372036854775807L || j12 < i14) {
            j13 = j12;
        } else {
            j13 = Math.max(0, i14 - 1);
        }
        return new z0(a0Var, j13, j10, -9223372036854775807L, i14, o10, false, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r5.o(r10.f6332l) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b2 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m1.z0 f(g1.u1 r26, java.lang.Object r27, long r28, long r30, long r32) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            g1.r1 r5 = r0.f10174a
            r1.p(r2, r5)
            int r6 = r5.j(r3)
            r8 = 1
            r9 = -1
            if (r6 != r9) goto L_0x0024
            g1.c r10 = r5.f6548n
            int r11 = r10.f6329i
            if (r11 <= 0) goto L_0x0057
            int r10 = r10.f6332l
            boolean r10 = r5.o(r10)
            if (r10 == 0) goto L_0x0057
            goto L_0x0055
        L_0x0024:
            boolean r10 = r5.o(r6)
            if (r10 == 0) goto L_0x0057
            long r10 = r5.l(r6)
            long r12 = r5.f6545k
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0057
            g1.c r10 = r5.f6548n
            g1.b r10 = r10.i(r6)
            int r11 = r10.f6300i
            if (r11 != r9) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            r12 = 0
        L_0x0040:
            if (r12 >= r11) goto L_0x0050
            int[] r13 = r10.f6303l
            r13 = r13[r12]
            if (r13 == 0) goto L_0x004e
            if (r13 != r8) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            int r12 = r12 + 1
            goto L_0x0040
        L_0x004e:
            r10 = 1
            goto L_0x0051
        L_0x0050:
            r10 = 0
        L_0x0051:
            r10 = r10 ^ r8
            if (r10 == 0) goto L_0x0057
            r6 = -1
        L_0x0055:
            r10 = 1
            goto L_0x0058
        L_0x0057:
            r10 = 0
        L_0x0058:
            v1.a0 r12 = new v1.a0
            r13 = r32
            r12.<init>(r6, r13, r2)
            boolean r2 = r12.a()
            if (r2 != 0) goto L_0x0069
            if (r6 != r9) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0069:
            r2 = 0
        L_0x006a:
            boolean r23 = r0.i(r1, r12)
            boolean r24 = r0.h(r1, r12, r2)
            if (r6 == r9) goto L_0x007d
            boolean r1 = r5.o(r6)
            if (r1 == 0) goto L_0x007d
            r21 = 1
            goto L_0x007f
        L_0x007d:
            r21 = 0
        L_0x007f:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 == r9) goto L_0x008d
            long r15 = r5.l(r6)
            r17 = r15
            goto L_0x0096
        L_0x008d:
            if (r10 == 0) goto L_0x0094
            long r7 = r5.f6545k
            r17 = r7
            goto L_0x0096
        L_0x0094:
            r17 = r13
        L_0x0096:
            int r7 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x00a4
            r7 = -9223372036854775808
            int r9 = (r17 > r7 ? 1 : (r17 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r19 = r17
            goto L_0x00a8
        L_0x00a4:
            long r7 = r5.f6545k
            r19 = r7
        L_0x00a8:
            int r5 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r5 == 0) goto L_0x00c1
            int r5 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r5 < 0) goto L_0x00c1
            if (r24 != 0) goto L_0x00b7
            if (r10 != 0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r7 = 0
            goto L_0x00b8
        L_0x00b7:
            r7 = 1
        L_0x00b8:
            long r3 = (long) r7
            long r3 = r19 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        L_0x00c1:
            r13 = r3
            m1.z0 r1 = new m1.z0
            r11 = r1
            r15 = r30
            r22 = r2
            r11.<init>(r12, r13, r15, r17, r19, r21, r22, r23, r24)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a1.f(g1.u1, java.lang.Object, long, long, long):m1.z0");
    }

    public final z0 g(u1 u1Var, z0 z0Var) {
        boolean z10;
        long j10;
        long j11;
        boolean z11;
        u1 u1Var2 = u1Var;
        z0 z0Var2 = z0Var;
        a0 a0Var = z0Var2.f10547a;
        if (a0Var.a() || a0Var.f6682e != -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean i10 = i(u1Var2, a0Var);
        boolean h10 = h(u1Var2, a0Var, z10);
        Object obj = z0Var2.f10547a.f6678a;
        r1 r1Var = this.f10174a;
        u1Var2.p(obj, r1Var);
        boolean a10 = a0Var.a();
        int i11 = a0Var.f6682e;
        if (a10 || i11 == -1) {
            j10 = -9223372036854775807L;
        } else {
            j10 = r1Var.l(i11);
        }
        boolean a11 = a0Var.a();
        int i12 = a0Var.f6679b;
        if (a11) {
            j11 = r1Var.i(i12, a0Var.f6680c);
        } else if (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) {
            j11 = r1Var.f6545k;
        } else {
            j11 = j10;
        }
        if (a0Var.a()) {
            z11 = r1Var.o(i12);
        } else if (i11 == -1 || !r1Var.o(i11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        return new z0(a0Var, z0Var2.f10548b, z0Var2.f10549c, j10, j11, z11, z10, i10, h10);
    }

    public final boolean h(u1 u1Var, a0 a0Var, boolean z10) {
        boolean z11;
        int k10 = u1Var.k(a0Var.f6678a);
        if (u1Var.v(u1Var.o(k10, this.f10174a, false).f6544j, this.f10175b).f6583p) {
            return false;
        }
        if (u1Var.m(k10, this.f10174a, this.f10175b, this.f10179f, this.f10180g) == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !z10) {
            return false;
        }
        return true;
    }

    public final boolean i(u1 u1Var, a0 a0Var) {
        boolean z10;
        if (a0Var.a() || a0Var.f6682e != -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        Object obj = a0Var.f6678a;
        int i10 = u1Var.p(obj, this.f10174a).f6544j;
        if (u1Var.v(i10, this.f10175b).f6590w == u1Var.k(obj)) {
            return true;
        }
        return false;
    }

    public final void j() {
        a0 a0Var;
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        for (y0 y0Var = this.f10181h; y0Var != null; y0Var = y0Var.f10540l) {
            o0Var.c(y0Var.f10534f.f10547a);
        }
        y0 y0Var2 = this.f10182i;
        if (y0Var2 == null) {
            a0Var = null;
        } else {
            a0Var = y0Var2.f10534f.f10547a;
        }
        ((f0) this.f10177d).c(new r(this, o0Var, a0Var, 6));
    }

    public final boolean k(y0 y0Var) {
        boolean z10;
        boolean z11 = false;
        if (y0Var != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        j1.a.e(z10);
        if (y0Var.equals(this.f10183j)) {
            return false;
        }
        this.f10183j = y0Var;
        while (true) {
            y0Var = y0Var.f10540l;
            if (y0Var == null) {
                break;
            }
            if (y0Var == this.f10182i) {
                this.f10182i = this.f10181h;
                z11 = true;
            }
            y0Var.f();
            this.f10184k--;
        }
        y0 y0Var2 = this.f10183j;
        if (y0Var2.f10540l != null) {
            y0Var2.b();
            y0Var2.f10540l = null;
            y0Var2.c();
        }
        j();
        return z11;
    }

    public final a0 m(u1 u1Var, Object obj, long j10) {
        y0 y0Var;
        long j11;
        int k10;
        u1 u1Var2 = u1Var;
        Object obj2 = obj;
        r1 r1Var = this.f10174a;
        int i10 = u1Var2.p(obj2, r1Var).f6544j;
        Object obj3 = this.f10185l;
        if (obj3 == null || (k10 = u1Var2.k(obj3)) == -1 || u1Var2.o(k10, r1Var, false).f6544j != i10) {
            y0 y0Var2 = this.f10181h;
            while (true) {
                if (y0Var == null) {
                    y0Var = this.f10181h;
                    while (true) {
                        if (y0Var != null) {
                            int k11 = u1Var2.k(y0Var.f10530b);
                            if (k11 != -1 && u1Var2.o(k11, r1Var, false).f6544j == i10) {
                                break;
                            }
                            y0Var = y0Var.f10540l;
                        } else {
                            j11 = this.f10178e;
                            this.f10178e = 1 + j11;
                            if (this.f10181h == null) {
                                this.f10185l = obj2;
                                this.f10186m = j11;
                            }
                        }
                    }
                } else if (y0Var.f10530b.equals(obj2)) {
                    break;
                } else {
                    y0Var2 = y0Var.f10540l;
                }
            }
            j11 = y0Var.f10534f.f10547a.f6681d;
        } else {
            j11 = this.f10186m;
        }
        long j12 = j11;
        u1Var2.p(obj2, r1Var);
        int i11 = r1Var.f6544j;
        t1 t1Var = this.f10175b;
        u1Var2.v(i11, t1Var);
        boolean z10 = false;
        for (int k12 = u1Var.k(obj); k12 >= t1Var.f6589v; k12--) {
            boolean z11 = true;
            u1Var2.o(k12, r1Var, true);
            if (r1Var.f6548n.f6329i <= 0) {
                z11 = false;
            }
            z10 |= z11;
            if (r1Var.k(r1Var.f6545k) != -1) {
                obj2 = r1Var.f6543i;
                obj2.getClass();
            }
            if (z10 && (!z11 || r1Var.f6545k != 0)) {
                break;
            }
        }
        return l(u1Var, obj2, j10, j12, this.f10175b, this.f10174a);
    }

    public final boolean n(u1 u1Var) {
        y0 y0Var;
        y0 y0Var2 = this.f10181h;
        if (y0Var2 == null) {
            return true;
        }
        int k10 = u1Var.k(y0Var2.f10530b);
        while (true) {
            k10 = u1Var.m(k10, this.f10174a, this.f10175b, this.f10179f, this.f10180g);
            while (true) {
                y0Var = y0Var2.f10540l;
                if (y0Var != null && !y0Var2.f10534f.f10553g) {
                    y0Var2 = y0Var;
                }
            }
            if (k10 == -1 || y0Var == null || u1Var.k(y0Var.f10530b) != k10) {
                boolean k11 = k(y0Var2);
                y0Var2.f10534f = g(u1Var, y0Var2.f10534f);
            } else {
                y0Var2 = y0Var;
            }
        }
        boolean k112 = k(y0Var2);
        y0Var2.f10534f = g(u1Var, y0Var2.f10534f);
        return !k112;
    }

    public final boolean o(u1 u1Var, long j10, long j11) {
        z0 z0Var;
        boolean z10;
        long j12;
        boolean z11;
        boolean k10;
        boolean z12;
        u1 u1Var2 = u1Var;
        y0 y0Var = null;
        for (y0 y0Var2 = this.f10181h; y0Var2 != null; y0Var2 = y0Var2.f10540l) {
            z0 z0Var2 = y0Var2.f10534f;
            if (y0Var == null) {
                z0Var = g(u1Var2, z0Var2);
                long j13 = j10;
            } else {
                z0 c10 = c(u1Var2, y0Var, j10);
                if (c10 == null) {
                    k10 = k(y0Var);
                } else {
                    if (z0Var2.f10548b != c10.f10548b || !z0Var2.f10547a.equals(c10.f10547a)) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (!z12) {
                        k10 = k(y0Var);
                    } else {
                        z0Var = c10;
                    }
                }
                return !k10;
            }
            y0Var2.f10534f = z0Var.a(z0Var2.f10549c);
            long j14 = z0Var.f10551e;
            long j15 = z0Var2.f10551e;
            if (j15 == -9223372036854775807L || j15 == j14) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                y0Var2.h();
                if (j14 == -9223372036854775807L) {
                    j12 = Long.MAX_VALUE;
                } else {
                    j12 = y0Var2.f10543o + j14;
                }
                if (y0Var2 != this.f10182i || y0Var2.f10534f.f10552f || (j11 != Long.MIN_VALUE && j11 < j12)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (k(y0Var2) || z11) {
                    return false;
                }
                return true;
            }
            y0Var = y0Var2;
        }
        return true;
    }
}
