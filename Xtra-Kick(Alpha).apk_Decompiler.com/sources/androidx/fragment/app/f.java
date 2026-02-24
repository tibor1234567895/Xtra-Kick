package androidx.fragment.app;

import h3.g2;
import h3.r1;
import h3.y1;
import q.e;
import xa.j;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1411h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f1412i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1413j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f1414k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1415l;

    public /* synthetic */ f(h2 h2Var, h2 h2Var2, boolean z10, e eVar) {
        this.f1413j = h2Var;
        this.f1414k = h2Var2;
        this.f1412i = z10;
        this.f1415l = eVar;
    }

    public final void run() {
        int i10 = this.f1411h;
        Object obj = this.f1415l;
        Object obj2 = this.f1414k;
        Object obj3 = this.f1413j;
        switch (i10) {
            case 0:
                j.f("$lastInViews", (e) obj);
                c0 c0Var = ((h2) obj3).f1455c;
                c0 c0Var2 = ((h2) obj2).f1455c;
                v1 v1Var = q1.f1552a;
                j.f("inFragment", c0Var);
                j.f("outFragment", c0Var2);
                return;
            default:
                ((y1) obj3).d((g2) obj2, (r1) obj, this.f1412i);
                return;
        }
    }

    public /* synthetic */ f(y1 y1Var, g2 g2Var, r1 r1Var, boolean z10) {
        this.f1413j = y1Var;
        this.f1414k = g2Var;
        this.f1415l = r1Var;
        this.f1412i = z10;
    }
}
