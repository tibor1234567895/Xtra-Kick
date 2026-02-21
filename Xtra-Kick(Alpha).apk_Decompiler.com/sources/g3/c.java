package g3;

import d2.b;
import d2.w;
import d2.w0;
import d2.x0;
import d2.y;
import g1.a0;
import g1.b1;
import g1.z;
import j1.l0;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final y f6810a;

    /* renamed from: b  reason: collision with root package name */
    public final x0 f6811b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6812c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f6813d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6814e;

    /* renamed from: f  reason: collision with root package name */
    public long f6815f;

    /* renamed from: g  reason: collision with root package name */
    public int f6816g;

    /* renamed from: h  reason: collision with root package name */
    public long f6817h;

    public c(y yVar, x0 x0Var, b bVar, String str, int i10) {
        this.f6810a = yVar;
        this.f6811b = x0Var;
        this.f6812c = bVar;
        int i11 = bVar.f4147d;
        int i12 = bVar.f4144a;
        int i13 = (i11 * i12) / 8;
        int i14 = bVar.f4146c;
        if (i14 == i13) {
            int i15 = bVar.f4145b;
            int i16 = i15 * i13;
            int i17 = i16 * 8;
            int max = Math.max(i13, i16 / 10);
            this.f6814e = max;
            z zVar = new z();
            zVar.f6754k = str;
            zVar.f6749f = i17;
            zVar.f6750g = i17;
            zVar.f6755l = max;
            zVar.f6767x = i12;
            zVar.f6768y = i15;
            zVar.f6769z = i10;
            this.f6813d = new a0(zVar);
            return;
        }
        throw b1.a("Expected block size: " + i13 + "; got: " + i14, (Exception) null);
    }

    public final boolean a(w wVar, long j10) {
        int i10;
        int i11;
        int i12;
        long j11 = j10;
        while (true) {
            i10 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i10 <= 0 || (i11 = this.f6816g) >= (i12 = this.f6814e)) {
                b bVar = this.f6812c;
                int i13 = bVar.f4146c;
                int i14 = this.f6816g / i13;
            } else {
                int c10 = this.f6811b.c(wVar, (int) Math.min((long) (i12 - i11), j11), true);
                if (c10 == -1) {
                    j11 = 0;
                } else {
                    this.f6816g += c10;
                    j11 -= (long) c10;
                }
            }
        }
        b bVar2 = this.f6812c;
        int i132 = bVar2.f4146c;
        int i142 = this.f6816g / i132;
        if (i142 > 0) {
            int i15 = i142 * i132;
            int i16 = this.f6816g - i15;
            this.f6811b.e(this.f6815f + l0.M(this.f6817h, 1000000, (long) bVar2.f4145b), 1, i15, i16, (w0) null);
            this.f6817h += (long) i142;
            this.f6816g = i16;
        }
        return i10 <= 0;
    }

    public final void b(int i10, long j10) {
        this.f6810a.g(new f(this.f6812c, 1, (long) i10, j10));
        this.f6811b.a(this.f6813d);
    }

    public final void c(long j10) {
        this.f6815f = j10;
        this.f6816g = 0;
        this.f6817h = 0;
    }
}
