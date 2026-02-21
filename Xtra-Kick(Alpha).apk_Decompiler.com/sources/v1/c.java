package v1;

import g1.a0;
import g1.z;
import l1.h;
import m1.w0;

public final class c implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f15589a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f15591c;

    public c(d dVar, b1 b1Var) {
        this.f15591c = dVar;
        this.f15589a = b1Var;
    }

    public final int a(w0 w0Var, h hVar, int i10) {
        d dVar = this.f15591c;
        if (dVar.a()) {
            return -3;
        }
        if (this.f15590b) {
            hVar.f9501h = 4;
            return -4;
        }
        int a10 = this.f15589a.a(w0Var, hVar, i10);
        if (a10 == -5) {
            a0 a0Var = w0Var.f10523b;
            a0Var.getClass();
            int i11 = a0Var.I;
            int i12 = a0Var.J;
            if (!(i11 == 0 && i12 == 0)) {
                if (dVar.f15601l != 0) {
                    i11 = 0;
                }
                if (dVar.f15602m != Long.MIN_VALUE) {
                    i12 = 0;
                }
                z i13 = a0Var.i();
                i13.A = i11;
                i13.B = i12;
                w0Var.f10523b = i13.a();
            }
            return -5;
        }
        long j10 = dVar.f15602m;
        if (j10 == Long.MIN_VALUE || ((a10 != -4 || hVar.f9517l < j10) && (a10 != -3 || dVar.u() != Long.MIN_VALUE || hVar.f9516k))) {
            return a10;
        }
        hVar.h();
        hVar.f9501h = 4;
        this.f15590b = true;
        return -4;
    }

    public final boolean b() {
        return !this.f15591c.a() && this.f15589a.b();
    }

    public final void c() {
        this.f15589a.c();
    }

    public final int d(long j10) {
        if (this.f15591c.a()) {
            return -3;
        }
        return this.f15589a.d(j10);
    }
}
