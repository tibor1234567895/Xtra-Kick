package com.github.andreyasadchy.xtra.ui.follow.games;

import android.content.Context;
import androidx.lifecycle.p1;
import androidx.lifecycle.w1;
import e.a;
import e6.e1;
import hb.h0;
import javax.inject.Inject;
import kb.i;
import kb.m0;
import n3.r3;
import xa.j;

public final class FollowedGamesViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final e1 f3409d;

    /* renamed from: e  reason: collision with root package name */
    public final m0 f3410e = h0.s((i) new a(new r3(30, 10, 30), (wa.a) new p1(10, this)).f4852i, h0.I0(this));

    @Inject
    public FollowedGamesViewModel(Context context, e1 e1Var) {
        j.f("context", context);
        j.f("localFollowsGame", e1Var);
        this.f3409d = e1Var;
    }
}
