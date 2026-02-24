package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.fragment.app.r0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m.m;
import m.o;

public final class w4 implements r, m {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Toolbar f1120h;

    public /* synthetic */ w4(Toolbar toolbar) {
        this.f1120h = toolbar;
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        this.f1120h.getClass();
        return false;
    }

    public final void l(o oVar) {
        boolean z10;
        Toolbar toolbar = this.f1120h;
        n nVar = toolbar.f691h.A;
        if (nVar == null || !nVar.f()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.N.f429j).iterator();
            while (it.hasNext()) {
                ((r0) it.next()).f1555a.s();
            }
        }
    }
}
