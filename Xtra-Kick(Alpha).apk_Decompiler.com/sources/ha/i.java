package ha;

import android.os.Looper;
import android.support.v4.media.h;
import ca.a;
import ca.c;
import fa.b;
import java.util.HashSet;
import java.util.Iterator;

public final class i implements a, c {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f7774a = new HashSet();

    public final void a() {
        boolean z10;
        if (b.f5984a == null) {
            b.f5984a = Looper.getMainLooper().getThread();
        }
        if (Thread.currentThread() == b.f5984a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Iterator it = this.f7774a.iterator();
            if (it.hasNext()) {
                h.y(it.next());
                throw null;
            }
            return;
        }
        throw new IllegalStateException("Must be called on the Main thread.");
    }
}
