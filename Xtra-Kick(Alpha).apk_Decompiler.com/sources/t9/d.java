package t9;

import android.support.v4.media.h;
import java.util.Iterator;
import la.v;
import xa.j;
import y9.p;

public final class d implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f14845h;

    public d(e eVar, boolean z10, boolean z11) {
        this.f14845h = eVar;
    }

    public final void run() {
        e eVar = this.f14845h;
        if (!((m) eVar.f14847i).c()) {
            Iterator it = ((m) eVar.f14847i).f14877d.iterator();
            if (it.hasNext()) {
                h.y(it.next());
                throw null;
            }
        }
        if (!((m) eVar.f14847i).c()) {
            m mVar = (m) eVar.f14847i;
            long j10 = mVar.f14880g.f12690o;
            p pVar = mVar.f14881h;
            e eVar2 = mVar.f14878e;
            pVar.getClass();
            j.g("runnable", eVar2);
            synchronized (pVar.f17276a) {
                if (!pVar.f17277b) {
                    pVar.f17279d.postDelayed(eVar2, j10);
                }
                v vVar = v.f9814a;
            }
        }
    }
}
