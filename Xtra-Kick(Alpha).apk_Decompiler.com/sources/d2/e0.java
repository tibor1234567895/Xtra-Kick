package d2;

import android.support.v4.media.n;
import f2.c;
import f2.f;
import j1.a;
import j1.l0;

public class e0 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4163a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4164b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4165c;

    public /* synthetic */ e0(int i10, long j10, Object obj) {
        this.f4163a = i10;
        this.f4165c = obj;
        this.f4164b = j10;
    }

    public final boolean f() {
        switch (this.f4163a) {
            case 1:
                return false;
            default:
                return true;
        }
    }

    public final t0 i(long j10) {
        long j11;
        long j12 = j10;
        int i10 = this.f4163a;
        int i11 = 1;
        Object obj = this.f4165c;
        switch (i10) {
            case 0:
                f0 f0Var = (f0) obj;
                a.f(f0Var.f4183k);
                n nVar = f0Var.f4183k;
                long[] jArr = (long[]) nVar.f337i;
                long[] jArr2 = (long[]) nVar.f338j;
                int f10 = l0.f(jArr, l0.i((((long) f0Var.f4177e) * j12) / 1000000, 0, f0Var.f4182j - 1), false);
                long j13 = 0;
                if (f10 == -1) {
                    j11 = 0;
                } else {
                    j11 = jArr[f10];
                }
                if (f10 != -1) {
                    j13 = jArr2[f10];
                }
                long j14 = (j11 * 1000000) / ((long) ((f0) obj).f4177e);
                long j15 = this.f4164b;
                v0 v0Var = new v0(j14, j13 + j15);
                if (j14 == j12 || f10 == jArr.length - 1) {
                    return new t0(v0Var, v0Var);
                }
                int i12 = f10 + 1;
                return new t0(v0Var, new v0((jArr[i12] * 1000000) / ((long) ((f0) obj).f4177e), j15 + jArr2[i12]));
            case 1:
                return (t0) obj;
            default:
                c cVar = (c) obj;
                t0 b10 = cVar.f5443g[0].b(j12);
                while (true) {
                    f[] fVarArr = cVar.f5443g;
                    if (i11 >= fVarArr.length) {
                        return b10;
                    }
                    t0 b11 = fVarArr[i11].b(j12);
                    if (b11.f4297a.f4302b < b10.f4297a.f4302b) {
                        b10 = b11;
                    }
                    i11++;
                }
        }
    }

    public final long j() {
        switch (this.f4163a) {
            case 0:
                return ((f0) this.f4165c).b();
            default:
                return this.f4164b;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e0(long j10) {
        this(j10, 0);
        this.f4163a = 1;
    }

    public e0(long j10, long j11) {
        this.f4163a = 1;
        this.f4164b = j10;
        v0 v0Var = j11 == 0 ? v0.f4300c : new v0(0, j11);
        this.f4165c = new t0(v0Var, v0Var);
    }
}
