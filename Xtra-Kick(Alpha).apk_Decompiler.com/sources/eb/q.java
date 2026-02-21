package eb;

import java.util.ArrayList;
import java.util.List;
import ma.r;
import wa.l;
import xa.j;

public class q extends n {
    public static final r c(h hVar, l lVar) {
        j.f("transform", lVar);
        return new r(hVar, lVar, 1);
    }

    public static final List d(h hVar) {
        j.f("<this>", hVar);
        return r.f(e(hVar));
    }

    public static final ArrayList e(h hVar) {
        j.f("<this>", hVar);
        ArrayList arrayList = new ArrayList();
        for (Object add : hVar) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
