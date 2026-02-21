package com.github.andreyasadchy.xtra.ui.search.streams;

import android.content.Context;
import androidx.lifecycle.w1;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import n3.t;
import pa.e;
import xa.j;

public final class StreamSearchViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final e1 f3482d;

    /* renamed from: e  reason: collision with root package name */
    public final m0 f3483e;

    @Inject
    public StreamSearchViewModel(Context context) {
        j.f("context", context);
        e1 a10 = f1.a("");
        this.f3482d = a10;
        this.f3483e = h0.s(h0.Y1(a10, new t((e) null, (Object) context, 5)), h0.I0(this));
    }
}
