package com.github.andreyasadchy.xtra.ui.saved.downloads;

import a6.c0;
import a6.e;
import androidx.lifecycle.w1;
import e6.o1;
import javax.inject.Inject;
import r3.s0;
import r3.u0;
import s7.f;
import xa.j;

public final class DownloadsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final o1 f3465d;

    /* renamed from: e  reason: collision with root package name */
    public final f f3466e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f3467f;

    @Inject
    public DownloadsViewModel(o1 o1Var, f fVar) {
        j.f("repository", o1Var);
        j.f("fetchProvider", fVar);
        this.f3465d = o1Var;
        this.f3466e = fVar;
        c0 c0Var = (c0) o1Var.f5207a;
        c0Var.getClass();
        this.f3467f = c0Var.f221a.f13722e.b(new String[]{"videos"}, new e(c0Var, s0.k(0, "SELECT * FROM videos ORDER BY id DESC"), 4));
    }
}
