package com.github.andreyasadchy.xtra.ui.games;

import android.content.Context;
import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import e6.e1;
import hb.d1;
import hb.h0;
import javax.inject.Inject;
import pa.e;
import pa.h;
import q6.m;
import q6.n;
import xa.j;

public final class GamePagerViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final e1 f3422d;

    /* renamed from: e  reason: collision with root package name */
    public final o0 f3423e = new o0();

    /* renamed from: f  reason: collision with root package name */
    public boolean f3424f;

    @Inject
    public GamePagerViewModel(e1 e1Var) {
        j.f("repository", e1Var);
        this.f3422d = e1Var;
    }

    public final void d(Context context, int i10, String str, String str2, String str3) {
        h0.b1(d1.f7786h, (h) null, 0, new m(i10, str3, context, this, str2, str, (e) null), 3);
    }

    public final void e(Context context, int i10, String str, String str2) {
        if (!this.f3424f) {
            this.f3424f = true;
            h0.b1(d1.f7786h, (h) null, 0, new n(i10, context, this, str, str2, (e) null), 3);
        }
    }
}
