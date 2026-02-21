package n3;

import androidx.recyclerview.widget.f1;
import la.v;
import wa.l;
import xa.j;

public final class w3 implements l {

    /* renamed from: h  reason: collision with root package name */
    public boolean f11539h = true;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ x3 f11540i;

    public w3(x3 x3Var) {
        this.f11540i = x3Var;
    }

    public final Object invoke(Object obj) {
        z zVar = (z) obj;
        j.f("loadStates", zVar);
        if (this.f11539h) {
            this.f11539h = false;
        } else if (zVar.f11597d.f11079a instanceof z0) {
            x3 x3Var = this.f11540i;
            if (x3Var.getStateRestorationPolicy() == f1.PREVENT && !x3Var.f11564a) {
                x3Var.setStateRestorationPolicy(f1.ALLOW);
            }
            i iVar = x3Var.f11565b;
            iVar.getClass();
            g gVar = iVar.f11240f;
            gVar.getClass();
            g1 g1Var = gVar.f11168e;
            g1Var.getClass();
            g1Var.f11181b.remove(this);
        }
        return v.f9814a;
    }
}
