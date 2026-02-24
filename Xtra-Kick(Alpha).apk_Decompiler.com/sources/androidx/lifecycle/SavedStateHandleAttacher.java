package androidx.lifecycle;

public final class SavedStateHandleAttacher implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final q1 f1641h;

    public SavedStateHandleAttacher(q1 q1Var) {
        this.f1641h = q1Var;
    }

    public final void d(d0 d0Var, r rVar) {
        boolean z10;
        if (rVar == r.ON_CREATE) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            d0Var.o().c(this);
            q1 q1Var = this.f1641h;
            if (!q1Var.f1742b) {
                q1Var.f1743c = q1Var.f1741a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
                q1Var.f1742b = true;
                r1 r1Var = (r1) q1Var.f1744d.getValue();
                return;
            }
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + rVar).toString());
    }
}
