package t9;

import android.support.v4.media.h;
import java.util.Iterator;
import java.util.List;
import la.v;
import p9.b;

public final class t implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ w f14906h;

    public t(w wVar, b bVar) {
        this.f14906h = wVar;
    }

    public final void run() {
        synchronized (this.f14906h.f14914a.f17664b) {
            Iterator it = ((List) this.f14906h.f14914a.f17670h).iterator();
            if (!it.hasNext()) {
                v vVar = v.f9814a;
            } else {
                h.y(it.next());
                throw null;
            }
        }
    }
}
