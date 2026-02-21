package com.github.andreyasadchy.xtra.ui.streams.common;

import android.content.Context;
import androidx.lifecycle.j1;
import androidx.lifecycle.w1;
import e6.x;
import hb.h0;
import j7.i;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import n3.z1;
import q6.e;
import q6.f;
import xa.j;

public final class StreamsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3506d;

    /* renamed from: e  reason: collision with root package name */
    public final f f3507e;

    /* renamed from: f  reason: collision with root package name */
    public final e1 f3508f;

    /* renamed from: g  reason: collision with root package name */
    public final m0 f3509g;

    @Inject
    public StreamsViewModel(Context context, x xVar, j1 j1Var) {
        j.f("context", context);
        j.f("apiRepository", xVar);
        j.f("savedStateHandle", j1Var);
        this.f3506d = xVar;
        f.f13352i.getClass();
        this.f3507e = e.a(j1Var);
        e1 a10 = f1.a(new i(0));
        this.f3508f = a10;
        this.f3509g = h0.s(h0.Y1(a10, new z1((pa.e) null, context, this, 2)), h0.I0(this));
    }
}
