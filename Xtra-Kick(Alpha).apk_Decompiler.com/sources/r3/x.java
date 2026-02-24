package r3;

import java.lang.ref.WeakReference;
import java.util.Set;
import xa.j;

public final class x extends v {

    /* renamed from: b  reason: collision with root package name */
    public final y f13770b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference f13771c;

    public x(y yVar, a0 a0Var) {
        super(a0Var.f13765a);
        this.f13770b = yVar;
        this.f13771c = new WeakReference(a0Var);
    }

    public final void b(Set set) {
        j.f("tables", set);
        v vVar = (v) this.f13771c.get();
        if (vVar == null) {
            this.f13770b.d(this);
        } else {
            vVar.b(set);
        }
    }
}
