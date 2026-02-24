package g1;

import android.os.Bundle;
import j1.l0;

public final class r1 implements m {

    /* renamed from: o  reason: collision with root package name */
    public static final String f6536o = l0.C(0);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6537p = l0.C(1);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6538q = l0.C(2);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6539r = l0.C(3);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6540s = l0.C(4);

    /* renamed from: t  reason: collision with root package name */
    public static final a f6541t = new a(21);

    /* renamed from: h  reason: collision with root package name */
    public Object f6542h;

    /* renamed from: i  reason: collision with root package name */
    public Object f6543i;

    /* renamed from: j  reason: collision with root package name */
    public int f6544j;

    /* renamed from: k  reason: collision with root package name */
    public long f6545k;

    /* renamed from: l  reason: collision with root package name */
    public long f6546l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6547m;

    /* renamed from: n  reason: collision with root package name */
    public c f6548n = c.f6321n;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !r1.class.equals(obj.getClass())) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return l0.a(this.f6542h, r1Var.f6542h) && l0.a(this.f6543i, r1Var.f6543i) && this.f6544j == r1Var.f6544j && this.f6545k == r1Var.f6545k && this.f6546l == r1Var.f6546l && this.f6547m == r1Var.f6547m && l0.a(this.f6548n, r1Var.f6548n);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        int i10 = this.f6544j;
        if (i10 != 0) {
            bundle.putInt(f6536o, i10);
        }
        long j10 = this.f6545k;
        if (j10 != -9223372036854775807L) {
            bundle.putLong(f6537p, j10);
        }
        long j11 = this.f6546l;
        if (j11 != 0) {
            bundle.putLong(f6538q, j11);
        }
        boolean z10 = this.f6547m;
        if (z10) {
            bundle.putBoolean(f6539r, z10);
        }
        if (!this.f6548n.equals(c.f6321n)) {
            bundle.putBundle(f6540s, this.f6548n.h());
        }
        return bundle;
    }

    public final int hashCode() {
        Object obj = this.f6542h;
        int i10 = 0;
        int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f6543i;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        long j10 = this.f6545k;
        long j11 = this.f6546l;
        return this.f6548n.hashCode() + ((((((((((hashCode + i10) * 31) + this.f6544j) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f6547m ? 1 : 0)) * 31);
    }

    public final long i(int i10, int i11) {
        b i12 = this.f6548n.i(i10);
        if (i12.f6300i != -1) {
            return i12.f6304m[i11];
        }
        return -9223372036854775807L;
    }

    public final int j(long j10) {
        int i10;
        boolean z10;
        c cVar = this.f6548n;
        long j11 = this.f6545k;
        cVar.getClass();
        if (j10 == Long.MIN_VALUE) {
            return -1;
        }
        if (j11 != -9223372036854775807L && j10 >= j11) {
            return -1;
        }
        int i11 = cVar.f6332l;
        while (true) {
            i10 = cVar.f6329i;
            if (i11 >= i10) {
                break;
            }
            if (cVar.i(i11).f6299h == Long.MIN_VALUE || cVar.i(i11).f6299h > j10) {
                b i12 = cVar.i(i11);
                int i13 = i12.f6300i;
                if (i13 == -1 || i12.i(-1) < i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    break;
                }
            }
            i11++;
        }
        if (i11 < i10) {
            return i11;
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[LOOP:0: B:1:0x0008->B:16:0x0033, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0036 A[EDGE_INSN: B:31:0x0036->B:17:0x0036 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int k(long r12) {
        /*
            r11 = this;
            g1.c r0 = r11.f6548n
            long r1 = r11.f6545k
            int r3 = r0.f6329i
            r4 = 1
            int r3 = r3 - r4
        L_0x0008:
            r5 = 0
            if (r3 < 0) goto L_0x0036
            r6 = -9223372036854775808
            int r8 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0012
            goto L_0x0030
        L_0x0012:
            g1.b r8 = r0.i(r3)
            long r8 = r8.f6299h
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x002a
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x002e
            int r6 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x0030
            goto L_0x002e
        L_0x002a:
            int r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0030
        L_0x002e:
            r6 = 1
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r6 == 0) goto L_0x0036
            int r3 = r3 + -1
            goto L_0x0008
        L_0x0036:
            r12 = -1
            if (r3 < 0) goto L_0x0055
            g1.b r13 = r0.i(r3)
            int r0 = r13.f6300i
            if (r0 != r12) goto L_0x0042
            goto L_0x0052
        L_0x0042:
            r1 = 0
        L_0x0043:
            if (r1 >= r0) goto L_0x0051
            int[] r2 = r13.f6303l
            r2 = r2[r1]
            if (r2 == 0) goto L_0x0052
            if (r2 != r4) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            int r1 = r1 + 1
            goto L_0x0043
        L_0x0051:
            r4 = 0
        L_0x0052:
            if (r4 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r3 = -1
        L_0x0056:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.r1.k(long):int");
    }

    public final long l(int i10) {
        return this.f6548n.i(i10).f6299h;
    }

    public final int m(int i10, int i11) {
        b i12 = this.f6548n.i(i10);
        if (i12.f6300i != -1) {
            return i12.f6303l[i11];
        }
        return 0;
    }

    public final int n(int i10) {
        return this.f6548n.i(i10).i(-1);
    }

    public final boolean o(int i10) {
        return this.f6548n.i(i10).f6306o;
    }

    public final void p(Object obj, Object obj2, int i10, long j10, long j11) {
        q(obj, obj2, i10, j10, j11, c.f6321n, false);
    }

    public final void q(Object obj, Object obj2, int i10, long j10, long j11, c cVar, boolean z10) {
        this.f6542h = obj;
        this.f6543i = obj2;
        this.f6544j = i10;
        this.f6545k = j10;
        this.f6546l = j11;
        this.f6548n = cVar;
        this.f6547m = z10;
    }
}
