package androidx.activity;

import androidx.fragment.app.q0;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import i0.b;
import java.util.ArrayDeque;

class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements b0, d {

    /* renamed from: h  reason: collision with root package name */
    public final t f471h;

    /* renamed from: i  reason: collision with root package name */
    public final n f472i;

    /* renamed from: j  reason: collision with root package name */
    public q f473j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ r f474k;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(r rVar, t tVar, q0 q0Var) {
        this.f474k = rVar;
        this.f471h = tVar;
        this.f472i = q0Var;
        tVar.a(this);
    }

    public final void cancel() {
        this.f471h.c(this);
        this.f472i.f490b.remove(this);
        q qVar = this.f473j;
        if (qVar != null) {
            qVar.cancel();
            this.f473j = null;
        }
    }

    public final void d(d0 d0Var, r rVar) {
        if (rVar == r.ON_START) {
            r rVar2 = this.f474k;
            ArrayDeque arrayDeque = rVar2.f497b;
            n nVar = this.f472i;
            arrayDeque.add(nVar);
            q qVar = new q(rVar2, nVar);
            nVar.f490b.add(qVar);
            if (b.a()) {
                rVar2.c();
                nVar.f491c = rVar2.f498c;
            }
            this.f473j = qVar;
        } else if (rVar == r.ON_STOP) {
            q qVar2 = this.f473j;
            if (qVar2 != null) {
                qVar2.cancel();
            }
        } else if (rVar == r.ON_DESTROY) {
            cancel();
        }
    }
}
