package com.github.andreyasadchy.xtra.util;

import androidx.lifecycle.d0;
import androidx.lifecycle.h;
import java.util.ArrayList;
import java.util.Iterator;
import s7.i;
import xa.j;

public final class AppLifecycleObserver implements h {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f3557h = new ArrayList();

    public final void a(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void b(d0 d0Var) {
        android.support.v4.media.h.b(d0Var);
    }

    public final /* synthetic */ void f(d0 d0Var) {
    }

    public final /* synthetic */ void onDestroy(d0 d0Var) {
    }

    public final void onStart(d0 d0Var) {
        j.f("owner", d0Var);
        for (i g10 : this.f3557h) {
            g10.g();
        }
    }

    public final void onStop(d0 d0Var) {
        Iterator it = this.f3557h.iterator();
        while (it.hasNext()) {
            ((i) it.next()).d();
        }
    }
}
