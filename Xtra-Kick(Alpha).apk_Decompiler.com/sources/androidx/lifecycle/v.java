package androidx.lifecycle;

import hb.l1;
import java.util.concurrent.CancellationException;
import xa.j;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final t f1772a;

    /* renamed from: b  reason: collision with root package name */
    public final s f1773b;

    /* renamed from: c  reason: collision with root package name */
    public final j f1774c;

    /* renamed from: d  reason: collision with root package name */
    public final u f1775d;

    public v(t tVar, s sVar, j jVar, l1 l1Var) {
        j.f("lifecycle", tVar);
        j.f("minState", sVar);
        j.f("dispatchQueue", jVar);
        this.f1772a = tVar;
        this.f1773b = sVar;
        this.f1774c = jVar;
        u uVar = new u(this, 0, l1Var);
        this.f1775d = uVar;
        if (tVar.b() == s.DESTROYED) {
            l1Var.e((CancellationException) null);
            a();
            return;
        }
        tVar.a(uVar);
    }

    public final void a() {
        this.f1772a.c(this.f1775d);
        j jVar = this.f1774c;
        jVar.f1704b = true;
        jVar.a();
    }
}
