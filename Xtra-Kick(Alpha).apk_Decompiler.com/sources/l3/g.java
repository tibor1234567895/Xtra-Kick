package l3;

import androidx.lifecycle.w1;
import java.lang.ref.WeakReference;
import wa.a;
import xa.j;

public final class g extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public WeakReference f9545d;

    public final void b() {
        WeakReference weakReference = this.f9545d;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        j.l("completeTransition");
        throw null;
    }
}
