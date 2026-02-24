package com.github.andreyasadchy.xtra.ui.search.channels;

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

public final class ChannelSearchViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3476d;

    /* renamed from: e  reason: collision with root package name */
    public final e1 f3477e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f3478f;

    @Inject
    public ChannelSearchViewModel(x xVar) {
        j.f("apiRepository", xVar);
        this.f3476d = xVar;
        e1 a10 = f1.a("");
        this.f3477e = a10;
        this.f3478f = h0.s(h0.Y1(a10, new t((e) null, (Object) this, 3)), h0.I0(this));
    }
}
