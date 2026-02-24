package s7;

import androidx.lifecycle.p0;

public final /* synthetic */ class j implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f14376a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f14377b;

    public /* synthetic */ j(l lVar, p0 p0Var) {
        this.f14376a = lVar;
        this.f14377b = p0Var;
    }

    public final void b(Object obj) {
        l lVar = this.f14376a;
        xa.j.f("this$0", lVar);
        p0 p0Var = this.f14377b;
        xa.j.f("$observer", p0Var);
        if (lVar.f14378l.compareAndSet(true, false)) {
            p0Var.b(obj);
        }
    }
}
