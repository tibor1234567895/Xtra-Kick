package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import e.a;
import m.a0;
import m.i0;
import m.o;
import m.x;

public final class h extends a0 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f841m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ n f842n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(n nVar, Context context, o oVar, k kVar) {
        super(context, oVar, kVar, true);
        this.f842n = nVar;
        this.f9896g = 8388613;
        a aVar = nVar.E;
        this.f9898i = aVar;
        x xVar = this.f9899j;
        if (xVar != null) {
            xVar.l(aVar);
        }
    }

    public final void c() {
        int i10 = this.f841m;
        n nVar = this.f842n;
        switch (i10) {
            case 0:
                nVar.B = null;
                nVar.F = 0;
                super.c();
                return;
            default:
                o oVar = nVar.f946j;
                if (oVar != null) {
                    oVar.c(true);
                }
                nVar.A = null;
                super.c();
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(n nVar, Context context, i0 i0Var, View view) {
        super(context, i0Var, view, false);
        this.f842n = nVar;
        if (!i0Var.A.f()) {
            View view2 = nVar.f953q;
            this.f9895f = view2 == null ? (View) nVar.f951o : view2;
        }
        a aVar = nVar.E;
        this.f9898i = aVar;
        x xVar = this.f9899j;
        if (xVar != null) {
            xVar.l(aVar);
        }
    }
}
