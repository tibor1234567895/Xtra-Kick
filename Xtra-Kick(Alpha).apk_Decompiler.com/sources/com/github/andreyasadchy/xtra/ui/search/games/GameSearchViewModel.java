package com.github.andreyasadchy.xtra.ui.search.games;

import androidx.lifecycle.w1;
import e6.x;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import n3.t;
import pa.e;
import xa.j;

public final class GameSearchViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3479d;

    /* renamed from: e  reason: collision with root package name */
    public final e1 f3480e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f3481f;

    @Inject
    public GameSearchViewModel(x xVar) {
        j.f("apiRepository", xVar);
        this.f3479d = xVar;
        e1 a10 = f1.a("");
        this.f3480e = a10;
        this.f3481f = h0.s(h0.Y1(a10, new t((e) null, (Object) this, 4)), h0.I0(this));
    }
}
