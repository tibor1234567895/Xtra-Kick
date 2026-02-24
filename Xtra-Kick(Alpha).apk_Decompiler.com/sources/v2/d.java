package v2;

import android.support.v4.media.n;
import d2.c0;
import d2.d0;
import d2.f0;
import g1.z0;
import j1.b0;
import java.util.Arrays;

public final class d extends l {

    /* renamed from: n  reason: collision with root package name */
    public f0 f15854n;

    /* renamed from: o  reason: collision with root package name */
    public c f15855o;

    public final long b(b0 b0Var) {
        boolean z10;
        byte[] bArr = b0Var.f8414a;
        if (bArr[0] == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return -1;
        }
        int i10 = (bArr[2] & 255) >> 4;
        if (i10 == 6 || i10 == 7) {
            b0Var.H(4);
            b0Var.B();
        }
        int b10 = c0.b(i10, b0Var);
        b0Var.G(0);
        return (long) b10;
    }

    public final boolean c(b0 b0Var, long j10, j jVar) {
        boolean z10;
        b0 b0Var2 = b0Var;
        j jVar2 = jVar;
        byte[] bArr = b0Var2.f8414a;
        f0 f0Var = this.f15854n;
        if (f0Var == null) {
            f0 f0Var2 = new f0(17, bArr);
            this.f15854n = f0Var2;
            jVar2.f15874a = f0Var2.c(Arrays.copyOfRange(bArr, 9, b0Var2.f8416c), (z0) null);
            return true;
        }
        byte b10 = bArr[0];
        if ((b10 & Byte.MAX_VALUE) == 3) {
            n a10 = d0.a(b0Var);
            f0 f0Var3 = new f0(f0Var.f4173a, f0Var.f4174b, f0Var.f4175c, f0Var.f4176d, f0Var.f4177e, f0Var.f4179g, f0Var.f4180h, f0Var.f4182j, a10, f0Var.f4184l);
            this.f15854n = f0Var3;
            this.f15855o = new c(f0Var3, a10);
            return true;
        }
        if (b10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return true;
        }
        c cVar = this.f15855o;
        if (cVar != null) {
            cVar.f15852c = j10;
            jVar2.f15875b = cVar;
        }
        jVar2.f15874a.getClass();
        return false;
    }

    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f15854n = null;
            this.f15855o = null;
        }
    }
}
