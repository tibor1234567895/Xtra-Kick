package l3;

import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.i1;
import androidx.lifecycle.v1;
import j3.m2;
import j3.r;
import j3.r2;
import j3.y;
import java.util.List;
import java.util.ListIterator;
import xa.j;

public final /* synthetic */ class f implements i1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ r2 f9543h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f9544i;

    public /* synthetic */ f(y yVar, m mVar) {
        this.f9543h = yVar;
        this.f9544i = mVar;
    }

    public final void b(c1 c1Var, c0 c0Var) {
        Object obj;
        int i10 = m.f9553i;
        r2 r2Var = this.f9543h;
        j.f("$state", r2Var);
        m mVar = this.f9544i;
        j.f("this$0", mVar);
        List list = (List) r2Var.f8678e.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (j.a(((r) obj).f8665m, c0Var.F)) {
                break;
            }
        }
        r rVar = (r) obj;
        if (rVar != null) {
            c0Var.X.f(c0Var, new v1(1, new m2(mVar, c0Var, rVar, 1)));
            c0Var.V.a(mVar.f9558g);
            m.k(c0Var, rVar, r2Var);
        }
    }
}
