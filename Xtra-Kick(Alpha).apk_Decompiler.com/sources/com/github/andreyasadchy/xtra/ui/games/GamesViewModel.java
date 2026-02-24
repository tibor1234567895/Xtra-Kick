package com.github.andreyasadchy.xtra.ui.games;

import androidx.lifecycle.p1;
import androidx.lifecycle.w1;
import e.a;
import e6.x;
import hb.h0;
import javax.inject.Inject;
import kb.i;
import kb.m0;
import n3.r3;
import xa.j;

public final class GamesViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3430d;

    /* renamed from: e  reason: collision with root package name */
    public final m0 f3431e = h0.s((i) new a(new r3(30, 10, 30), (wa.a) new p1(13, this)).f4852i, h0.I0(this));

    @Inject
    public GamesViewModel(x xVar) {
        j.f("apiRepository", xVar);
        this.f3430d = xVar;
    }
}
