package t4;

import android.view.ViewTreeObserver;
import hb.k;
import hb.l;
import q0.f;

public final class i implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: h  reason: collision with root package name */
    public boolean f14550h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e f14551i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f14552j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k f14553k;

    public i(e eVar, ViewTreeObserver viewTreeObserver, l lVar) {
        this.f14551i = eVar;
        this.f14552j = viewTreeObserver;
        this.f14553k = lVar;
    }

    public final boolean onPreDraw() {
        e eVar = this.f14551i;
        g a10 = f.a(eVar);
        if (a10 != null) {
            ViewTreeObserver viewTreeObserver = this.f14552j;
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                eVar.f14545a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if (!this.f14550h) {
                this.f14550h = true;
                int i10 = la.l.f9802h;
                this.f14553k.resumeWith(a10);
            }
        }
        return true;
    }
}
