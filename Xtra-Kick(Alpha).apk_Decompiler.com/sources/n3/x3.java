package n3;

import androidx.fragment.app.p0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.f1;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.w;
import hb.x1;
import la.v;
import mb.u;
import nb.e;
import qa.a;
import xa.j;

public abstract class x3 extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f11564a;

    /* renamed from: b  reason: collision with root package name */
    public final i f11565b;

    /* renamed from: c  reason: collision with root package name */
    public final p0 f11566c;

    public x3(w wVar) {
        z zVar;
        e eVar = hb.p0.f7833a;
        x1 x1Var = u.f10886a;
        e eVar2 = hb.p0.f7833a;
        j.f("mainDispatcher", x1Var);
        j.f("workerDispatcher", eVar2);
        i iVar = new i(wVar, new c(this), x1Var, eVar2);
        this.f11565b = iVar;
        super.setStateRestorationPolicy(f1.PREVENT);
        registerAdapterDataObserver(new v3(0, this));
        w3 w3Var = new w3(this);
        g gVar = iVar.f11240f;
        gVar.getClass();
        g1 g1Var = gVar.f11168e;
        g1Var.getClass();
        g1Var.f11181b.add(w3Var);
        if (!g1Var.f11180a) {
            zVar = null;
        } else {
            zVar = new z(g1Var.f11182c, g1Var.f11183d, g1Var.f11184e, g1Var.f11185f, g1Var.f11186g);
        }
        if (zVar != null) {
            w3Var.invoke(zVar);
        }
        this.f11566c = iVar.f11242h;
    }

    /* JADX INFO: finally extract failed */
    public final Object a(int i10) {
        i iVar = this.f11565b;
        iVar.getClass();
        try {
            iVar.f11239e = true;
            Object b10 = iVar.f11240f.b(i10);
            iVar.f11239e = false;
            return b10;
        } catch (Throwable th) {
            iVar.f11239e = false;
            throw th;
        }
    }

    public final void b() {
        v5 v5Var = this.f11565b.f11240f.f11167d;
        if (v5Var != null) {
            v5Var.c();
        }
    }

    public final void c() {
        v5 v5Var = this.f11565b.f11240f.f11167d;
        if (v5Var != null) {
            v5Var.a();
        }
    }

    public final Object d(u3 u3Var, pa.e eVar) {
        i iVar = this.f11565b;
        iVar.f11241g.incrementAndGet();
        g gVar = iVar.f11240f;
        gVar.getClass();
        a4 a4Var = new a4(gVar, u3Var, (pa.e) null);
        int i10 = s5.f11476b;
        Object a10 = gVar.f11170g.a(0, a4Var, eVar);
        a aVar = a.COROUTINE_SUSPENDED;
        if (a10 != aVar) {
            a10 = v.f9814a;
        }
        if (a10 != aVar) {
            a10 = v.f9814a;
        }
        if (a10 == aVar) {
            return a10;
        }
        return v.f9814a;
    }

    public final int getItemCount() {
        return this.f11565b.f11240f.f11166c.f();
    }

    public final long getItemId(int i10) {
        return -1;
    }

    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public final void setStateRestorationPolicy(f1 f1Var) {
        j.f("strategy", f1Var);
        this.f11564a = true;
        super.setStateRestorationPolicy(f1Var);
    }
}
