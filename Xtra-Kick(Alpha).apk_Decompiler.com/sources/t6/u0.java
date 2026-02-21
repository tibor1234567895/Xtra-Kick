package t6;

import android.content.DialogInterface;
import la.b;
import s7.g;
import wa.a;
import wa.p;
import xa.j;
import xa.k;

public final /* synthetic */ class u0 implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14664h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f14665i;

    public /* synthetic */ u0(k kVar, int i10) {
        this.f14664h = i10;
        this.f14665i = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f14664h;
        b bVar = this.f14665i;
        switch (i11) {
            case 0:
                p pVar = (p) bVar;
                x0 x0Var = z0.f14677v0;
                j.f("$tmp0", pVar);
                pVar.g(dialogInterface, Integer.valueOf(i10));
                return;
            case 1:
                p pVar2 = (p) bVar;
                x0 x0Var2 = z0.f14677v0;
                j.f("$tmp0", pVar2);
                pVar2.g(dialogInterface, Integer.valueOf(i10));
                return;
            default:
                a aVar = (a) bVar;
                g gVar = g.f14374a;
                j.f("$positiveCallback", aVar);
                aVar.b();
                return;
        }
    }
}
