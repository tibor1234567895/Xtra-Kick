package androidx.appcompat.widget;

import android.view.View;
import m.g0;

public final class j extends r2 {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f881q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f882r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ View f883s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(View view, View view2, Object obj, int i10) {
        super(view2);
        this.f881q = i10;
        this.f883s = view;
        this.f882r = obj;
    }

    public final g0 b() {
        switch (this.f881q) {
            case 0:
                h hVar = ((k) this.f883s).f902k.A;
                if (hVar == null) {
                    return null;
                }
                return hVar.a();
            default:
                return (d1) this.f882r;
        }
    }

    public final boolean c() {
        int i10 = this.f881q;
        View view = this.f883s;
        switch (i10) {
            case 0:
                ((k) view).f902k.n();
                return true;
            default:
                h1 h1Var = (h1) view;
                if (!h1Var.getInternalPopup().b()) {
                    h1Var.f852m.m(y0.b(h1Var), y0.a(h1Var));
                }
                return true;
        }
    }

    public final boolean d() {
        switch (this.f881q) {
            case 0:
                n nVar = ((k) this.f883s).f902k;
                if (nVar.C != null) {
                    return false;
                }
                nVar.d();
                return true;
            default:
                g0 b10 = b();
                if (b10 != null && b10.b()) {
                    b10.dismiss();
                }
                return true;
        }
    }
}
