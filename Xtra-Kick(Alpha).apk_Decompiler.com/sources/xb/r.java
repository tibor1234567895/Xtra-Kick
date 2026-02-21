package xb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.s;
import pb.h1;
import xa.j;

public final class r {
    private r() {
    }

    public /* synthetic */ r(int i10) {
        this();
    }

    public static ArrayList a(List list) {
        boolean z10;
        j.f("protocols", list);
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((h1) next) != h1.HTTP_1_0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(s.i(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((h1) it.next()).f12875h);
        }
        return arrayList2;
    }

    public static byte[] b(List list) {
        j.f("protocols", list);
        dc.j jVar = new dc.j();
        Iterator it = a(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            jVar.Q0(str.length());
            jVar.X0(str);
        }
        return jVar.M();
    }

    public static boolean c() {
        return j.a("Dalvik", System.getProperty("java.vm.name"));
    }
}
