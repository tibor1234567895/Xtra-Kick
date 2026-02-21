package v1;

import a2.m;
import a2.q;
import j1.a;
import java.io.IOException;
import l1.h;
import m1.w0;
import p1.n;

public final class o0 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f15744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0 f15745b;

    public o0(r0 r0Var, int i10) {
        this.f15745b = r0Var;
        this.f15744a = i10;
    }

    public final int a(w0 w0Var, h hVar, int i10) {
        r0 r0Var = this.f15745b;
        if (r0Var.E()) {
            return -3;
        }
        int i11 = this.f15744a;
        r0Var.w(i11);
        int w10 = r0Var.f15777z[i11].w(w0Var, hVar, i10, r0Var.R);
        if (w10 == -3) {
            r0Var.x(i11);
        }
        return w10;
    }

    public final boolean b() {
        r0 r0Var = this.f15745b;
        if (r0Var.E() || !r0Var.f15777z[this.f15744a].s(r0Var.R)) {
            return false;
        }
        return true;
    }

    public final void c() {
        r0 r0Var = this.f15745b;
        a1 a1Var = r0Var.f15777z[this.f15744a];
        n nVar = a1Var.f15570h;
        if (nVar == null || nVar.getState() != 1) {
            int b10 = r0Var.f15762k.b(r0Var.I);
            q qVar = r0Var.f15769r;
            IOException iOException = qVar.f76c;
            if (iOException == null) {
                m mVar = qVar.f75b;
                if (mVar != null) {
                    if (b10 == Integer.MIN_VALUE) {
                        b10 = mVar.f61h;
                    }
                    IOException iOException2 = mVar.f65l;
                    if (iOException2 != null && mVar.f66m > b10) {
                        throw iOException2;
                    }
                    return;
                }
                return;
            }
            throw iOException;
        }
        p1.m f10 = a1Var.f15570h.f();
        f10.getClass();
        throw f10;
    }

    public final int d(long j10) {
        r0 r0Var = this.f15745b;
        boolean z10 = false;
        if (r0Var.E()) {
            return 0;
        }
        int i10 = this.f15744a;
        r0Var.w(i10);
        a1 a1Var = r0Var.f15777z[i10];
        int q10 = a1Var.q(j10, r0Var.R);
        synchronized (a1Var) {
            if (q10 >= 0) {
                try {
                    if (a1Var.f15581s + q10 <= a1Var.f15578p) {
                        z10 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            a.b(z10);
            a1Var.f15581s += q10;
        }
        if (q10 == 0) {
            r0Var.x(i10);
        }
        return q10;
    }
}
