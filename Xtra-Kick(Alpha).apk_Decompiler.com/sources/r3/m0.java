package r3;

import u3.f;
import wa.l;
import xa.j;
import xa.k;

public final class m0 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13715h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n0 f13716i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(n0 n0Var, int i10) {
        super(1);
        this.f13715h = i10;
        this.f13716i = n0Var;
    }

    public final Object a(f fVar) {
        int i10 = this.f13715h;
        n0 n0Var = this.f13716i;
        switch (i10) {
            case 0:
                j.f("it", fVar);
                n0Var.m();
                return null;
            default:
                j.f("it", fVar);
                n0Var.n();
                return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f13715h) {
            case 0:
                a((f) obj);
                return null;
            default:
                a((f) obj);
                return null;
        }
    }
}
