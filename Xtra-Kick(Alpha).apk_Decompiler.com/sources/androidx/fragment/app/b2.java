package androidx.fragment.app;

import android.view.View;
import xa.j;

public final /* synthetic */ class b2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1332h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f1333i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d2 f1334j;

    public /* synthetic */ b2(n nVar, d2 d2Var, int i10) {
        this.f1332h = i10;
        this.f1333i = nVar;
        this.f1334j = d2Var;
    }

    public final void run() {
        int i10 = this.f1332h;
        d2 d2Var = this.f1334j;
        n nVar = this.f1333i;
        switch (i10) {
            case 0:
                c2 c2Var = n.f1505f;
                j.f("this$0", nVar);
                j.f("$operation", d2Var);
                if (nVar.f1507b.contains(d2Var)) {
                    g2 g2Var = d2Var.f1453a;
                    View view = d2Var.f1455c.M;
                    j.e("operation.fragment.mView", view);
                    g2Var.a(view);
                    return;
                }
                return;
            default:
                c2 c2Var2 = n.f1505f;
                j.f("this$0", nVar);
                j.f("$operation", d2Var);
                nVar.f1507b.remove(d2Var);
                nVar.f1508c.remove(d2Var);
                return;
        }
    }
}
