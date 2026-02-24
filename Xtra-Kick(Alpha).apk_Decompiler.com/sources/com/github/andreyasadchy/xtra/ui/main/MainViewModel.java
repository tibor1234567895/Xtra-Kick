package com.github.andreyasadchy.xtra.ui.main;

import android.app.Application;
import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import e6.j1;
import e6.o1;
import e6.x;
import hb.d1;
import hb.h0;
import javax.inject.Inject;
import pa.e;
import pa.h;
import xa.j;

public final class MainViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final o0 f3432d = new o0();

    /* renamed from: e  reason: collision with root package name */
    public boolean f3433e;

    @Inject
    public MainViewModel(Application application, x xVar, o1 o1Var) {
        j.f("application", application);
        j.f("repository", xVar);
        j.f("offlineRepository", o1Var);
        new o0();
        new o0();
        new o0();
        h0.b1(d1.f7786h, (h) null, 0, new j1(o1Var, application, (e) null), 3);
    }
}
