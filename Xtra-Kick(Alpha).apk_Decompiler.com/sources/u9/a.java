package u9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import la.q;
import p9.b;
import q9.e;
import q9.h;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h f15440a;

    public a(h hVar, int i10) {
        if (i10 != 1) {
            j.g("fetchDatabaseManagerWrapper", hVar);
            this.f15440a = hVar;
            return;
        }
        j.g("fetchDatabaseManagerWrapper", hVar);
        this.f15440a = hVar;
    }

    public final ArrayList a(int i10, b bVar) {
        boolean z10;
        j.g("download", bVar);
        List G = this.f15440a.G(i10);
        if (G != null) {
            ArrayList arrayList = (ArrayList) G;
            Iterator it = arrayList.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (((e) ((b) it.next())).f13433h == ((e) bVar).f13433h) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    break;
                }
                i11++;
            }
            if (i11 != -1) {
                arrayList.set(i11, bVar);
            }
            return arrayList;
        }
        throw new q("null cannot be cast to non-null type java.util.ArrayList<com.tonyodev.fetch2.Download>");
    }

    public final void b(e eVar) {
        j.g("downloadInfo", eVar);
        this.f15440a.I(eVar);
    }
}
