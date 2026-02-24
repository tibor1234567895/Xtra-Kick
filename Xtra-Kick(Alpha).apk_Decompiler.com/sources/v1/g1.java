package v1;

import g1.a1;
import l1.h;
import m1.w0;

public final class g1 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public int f15647a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i1 f15649c;

    public g1(i1 i1Var) {
        this.f15649c = i1Var;
    }

    public final int a(w0 w0Var, h hVar, int i10) {
        e();
        i1 i1Var = this.f15649c;
        boolean z10 = i1Var.f15674s;
        if (z10 && i1Var.f15675t == null) {
            this.f15647a = 2;
        }
        int i11 = this.f15647a;
        if (i11 == 2) {
            hVar.e(4);
            return -4;
        } else if ((i10 & 2) != 0 || i11 == 0) {
            w0Var.f10523b = i1Var.f15672q;
            this.f15647a = 1;
            return -5;
        } else if (!z10) {
            return -3;
        } else {
            i1Var.f15675t.getClass();
            hVar.e(1);
            hVar.f9517l = 0;
            if ((i10 & 4) == 0) {
                hVar.j(i1Var.f15676u);
                hVar.f9515j.put(i1Var.f15675t, 0, i1Var.f15676u);
            }
            if ((i10 & 1) == 0) {
                this.f15647a = 2;
            }
            return -4;
        }
    }

    public final boolean b() {
        return this.f15649c.f15674s;
    }

    public final void c() {
        i1 i1Var = this.f15649c;
        if (!i1Var.f15673r) {
            i1Var.f15671p.e();
        }
    }

    public final int d(long j10) {
        e();
        if (j10 <= 0 || this.f15647a == 2) {
            return 0;
        }
        this.f15647a = 2;
        return 1;
    }

    public final void e() {
        if (!this.f15648b) {
            i1 i1Var = this.f15649c;
            i1Var.f15667l.b(a1.h(i1Var.f15672q.f6276s), i1Var.f15672q, 0, (Object) null, 0);
            this.f15648b = true;
        }
    }
}
