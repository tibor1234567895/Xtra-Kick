package f2;

import d2.t0;
import d2.v0;
import d2.x0;
import j1.a;
import j1.l0;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f5459a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5460b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5461c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5462d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5463e;

    /* renamed from: f  reason: collision with root package name */
    public int f5464f;

    /* renamed from: g  reason: collision with root package name */
    public int f5465g;

    /* renamed from: h  reason: collision with root package name */
    public int f5466h;

    /* renamed from: i  reason: collision with root package name */
    public int f5467i;

    /* renamed from: j  reason: collision with root package name */
    public int f5468j;

    /* renamed from: k  reason: collision with root package name */
    public long[] f5469k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f5470l;

    public f(int i10, int i11, long j10, int i12, x0 x0Var) {
        int i13;
        int i14;
        boolean z10 = true;
        if (!(i11 == 1 || i11 == 2)) {
            z10 = false;
        }
        a.b(z10);
        this.f5462d = j10;
        this.f5463e = i12;
        this.f5459a = x0Var;
        if (i11 == 2) {
            i13 = 1667497984;
        } else {
            i13 = 1651965952;
        }
        int i15 = (((i10 % 10) + 48) << 8) | ((i10 / 10) + 48);
        this.f5460b = i13 | i15;
        if (i11 == 2) {
            i14 = i15 | 1650720768;
        } else {
            i14 = -1;
        }
        this.f5461c = i14;
        this.f5469k = new long[512];
        this.f5470l = new int[512];
    }

    public final v0 a(int i10) {
        return new v0(((this.f5462d * ((long) 1)) / ((long) this.f5463e)) * ((long) this.f5470l[i10]), this.f5469k[i10]);
    }

    public final t0 b(long j10) {
        int i10 = (int) (j10 / ((this.f5462d * ((long) 1)) / ((long) this.f5463e)));
        int e10 = l0.e(this.f5470l, i10, true, true);
        if (this.f5470l[e10] == i10) {
            v0 a10 = a(e10);
            return new t0(a10, a10);
        }
        v0 a11 = a(e10);
        int i11 = e10 + 1;
        if (i11 < this.f5469k.length) {
            return new t0(a11, a(i11));
        }
        return new t0(a11, a11);
    }
}
