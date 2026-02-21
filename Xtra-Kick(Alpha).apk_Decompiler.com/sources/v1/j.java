package v1;

import android.os.Handler;
import g1.u1;
import j1.a;
import j1.l0;
import java.util.HashMap;
import k1.f0;
import l.h;
import p1.p;
import p1.q;

public abstract class j extends a {

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f15677h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public Handler f15678i;

    /* renamed from: j  reason: collision with root package name */
    public f0 f15679j;

    public final void d() {
        for (i iVar : this.f15677h.values()) {
            iVar.f15657a.c(iVar.f15658b);
        }
    }

    public final void f() {
        for (i iVar : this.f15677h.values()) {
            iVar.f15657a.e(iVar.f15658b);
        }
    }

    public void j() {
        for (i iVar : this.f15677h.values()) {
            iVar.f15657a.j();
        }
    }

    public void l(f0 f0Var) {
        this.f15679j = f0Var;
        this.f15678i = l0.k((Handler.Callback) null);
    }

    public void p() {
        HashMap hashMap = this.f15677h;
        for (i iVar : hashMap.values()) {
            iVar.f15657a.o(iVar.f15658b);
            a aVar = iVar.f15657a;
            h hVar = iVar.f15659c;
            aVar.r(hVar);
            aVar.q(hVar);
        }
        hashMap.clear();
    }

    public a0 s(Object obj, a0 a0Var) {
        return a0Var;
    }

    public long t(long j10, Object obj) {
        return j10;
    }

    public int u(int i10, Object obj) {
        return i10;
    }

    public abstract void v(Object obj, a aVar, u1 u1Var);

    public final void w(Object obj, a aVar) {
        HashMap hashMap = this.f15677h;
        a.b(!hashMap.containsKey(obj));
        h hVar = new h(this, obj);
        h hVar2 = new h(this, obj);
        hashMap.put(obj, new i(aVar, hVar, hVar2));
        Handler handler = this.f15678i;
        handler.getClass();
        f0 f0Var = aVar.f15558c;
        f0Var.getClass();
        f0Var.f15620c.add(new e0(handler, hVar2));
        Handler handler2 = this.f15678i;
        handler2.getClass();
        q qVar = aVar.f15559d;
        qVar.getClass();
        qVar.f12507c.add(new p(handler2, hVar2));
        f0 f0Var2 = this.f15679j;
        n1.f0 f0Var3 = this.f15562g;
        a.f(f0Var3);
        aVar.k(hVar, f0Var2, f0Var3);
        if (!(!this.f15557b.isEmpty())) {
            aVar.c(hVar);
        }
    }
}
