package v2;

import d2.b1;
import d2.q0;
import d9.r0;
import g1.a0;
import g1.y0;
import g1.z;
import g1.z0;
import j1.a;
import j1.b0;
import j1.l0;
import java.util.ArrayList;
import java.util.Arrays;

public final class i extends l {

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f15871o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p  reason: collision with root package name */
    public static final byte[] f15872p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n  reason: collision with root package name */
    public boolean f15873n;

    public static boolean e(b0 b0Var, byte[] bArr) {
        int i10 = b0Var.f8416c;
        int i11 = b0Var.f8415b;
        if (i10 - i11 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        b0Var.d(bArr2, 0, bArr.length);
        b0Var.G(i11);
        return Arrays.equals(bArr2, bArr);
    }

    public final long b(b0 b0Var) {
        byte[] bArr = b0Var.f8414a;
        byte b10 = 0;
        byte b11 = bArr[0];
        if (bArr.length > 1) {
            b10 = bArr[1];
        }
        return (((long) this.f15884i) * q0.b(b11, b10)) / 1000000;
    }

    public final boolean c(b0 b0Var, long j10, j jVar) {
        a0 a0Var;
        if (e(b0Var, f15871o)) {
            byte[] copyOf = Arrays.copyOf(b0Var.f8414a, b0Var.f8416c);
            byte b10 = copyOf[9] & 255;
            ArrayList a10 = q0.a(copyOf);
            if (jVar.f15874a != null) {
                return true;
            }
            z zVar = new z();
            zVar.f6754k = "audio/opus";
            zVar.f6767x = b10;
            zVar.f6768y = 48000;
            zVar.f6756m = a10;
            a0Var = new a0(zVar);
        } else if (e(b0Var, f15872p)) {
            a.f(jVar.f15874a);
            if (this.f15873n) {
                return true;
            }
            this.f15873n = true;
            b0Var.H(8);
            z0 a11 = b1.a(r0.k((String[]) b1.b(b0Var, false, false).f4092j));
            if (a11 == null) {
                return true;
            }
            a0 a0Var2 = jVar.f15874a;
            a0Var2.getClass();
            z zVar2 = new z(a0Var2);
            z0 z0Var = jVar.f15874a.f6274q;
            if (z0Var != null) {
                y0[] y0VarArr = z0Var.f6770h;
                if (y0VarArr.length != 0) {
                    int i10 = l0.f8453a;
                    y0[] y0VarArr2 = a11.f6770h;
                    Object[] copyOf2 = Arrays.copyOf(y0VarArr2, y0VarArr2.length + y0VarArr.length);
                    System.arraycopy(y0VarArr, 0, copyOf2, y0VarArr2.length, y0VarArr.length);
                    a11 = new z0(a11.f6771i, (y0[]) copyOf2);
                }
            }
            zVar2.f6752i = a11;
            a0Var = new a0(zVar2);
        } else {
            a.f(jVar.f15874a);
            return false;
        }
        jVar.f15874a = a0Var;
        return true;
    }

    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f15873n = false;
        }
    }
}
