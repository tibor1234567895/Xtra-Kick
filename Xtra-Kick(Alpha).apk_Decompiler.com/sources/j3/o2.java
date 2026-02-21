package j3;

import android.os.Bundle;
import eb.e;
import eb.f;
import eb.p;
import eb.q;
import eb.r;
import hb.h0;
import java.util.List;
import java.util.ListIterator;
import m0.h1;
import xa.j;

public abstract class o2 {

    /* renamed from: a  reason: collision with root package name */
    public r2 f8648a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8649b;

    public abstract c1 a();

    public final r2 b() {
        r2 r2Var = this.f8648a;
        if (r2Var != null) {
            return r2Var;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public c1 c(c1 c1Var, Bundle bundle, n1 n1Var) {
        return c1Var;
    }

    public void d(List list, n1 n1Var) {
        r c10 = q.c(new h1(1, list), new m2(this, n1Var, (Object) null, 0));
        p pVar = p.f5350h;
        j.f("predicate", pVar);
        e eVar = new e(new f(c10, pVar));
        while (eVar.hasNext()) {
            b().g((r) eVar.next());
        }
    }

    public void e(y yVar) {
        this.f8648a = yVar;
        this.f8649b = true;
    }

    public void f(r rVar) {
        c1 c1Var = rVar.f8661i;
        if (!(c1Var instanceof c1)) {
            c1Var = null;
        }
        if (c1Var != null) {
            c(c1Var, (Bundle) null, h0.f1(n2.f8642h));
            b().c(rVar);
        }
    }

    public void g(Bundle bundle) {
    }

    public Bundle h() {
        return null;
    }

    public void i(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        List list = (List) b().f8678e.getValue();
        if (list.contains(rVar)) {
            ListIterator listIterator = list.listIterator(list.size());
            r rVar2 = null;
            while (j()) {
                rVar2 = (r) listIterator.previous();
                if (j.a(rVar2, rVar)) {
                    break;
                }
            }
            if (rVar2 != null) {
                b().d(rVar2, z10);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + rVar + " which does not exist in back stack " + list).toString());
    }

    public boolean j() {
        return true;
    }
}
