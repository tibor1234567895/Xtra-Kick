package l3;

import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.i1;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import xa.j;
import xa.y;

public final /* synthetic */ class a implements i1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f9534h;

    public /* synthetic */ a(e eVar) {
        this.f9534h = eVar;
    }

    public final void b(c1 c1Var, c0 c0Var) {
        int i10 = e.f9537h;
        e eVar = this.f9534h;
        j.f("this$0", eVar);
        LinkedHashSet linkedHashSet = eVar.f9540e;
        String str = c0Var.F;
        y.a(linkedHashSet);
        if (linkedHashSet.remove(str)) {
            c0Var.V.a(eVar.f9541f);
        }
        LinkedHashMap linkedHashMap = eVar.f9542g;
        String str2 = c0Var.F;
        y.b(linkedHashMap);
        linkedHashMap.remove(str2);
    }
}
