package j1;

import android.os.Bundle;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.l;
import g1.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class c {
    private c() {
    }

    public static r1 a(l lVar, List list) {
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        for (int i10 = 0; i10 < list.size(); i10++) {
            Bundle bundle = (Bundle) list.get(i10);
            bundle.getClass();
            o0Var.c(lVar.e(bundle));
        }
        return o0Var.e();
    }

    public static ArrayList b(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((m) it.next()).h());
        }
        return arrayList;
    }

    public static r1 c(List list) {
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        for (int i10 = 0; i10 < list.size(); i10++) {
            o0Var.c(((m) list.get(i10)).h());
        }
        return o0Var.e();
    }
}
