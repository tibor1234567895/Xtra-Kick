package com.github.andreyasadchy.xtra.ui.streams.followed;

import android.content.Context;
import androidx.lifecycle.p1;
import androidx.lifecycle.w1;
import e.a;
import e6.x;
import e6.y0;
import hb.h0;
import javax.inject.Inject;
import kb.i;
import kb.m0;
import n3.r3;
import xa.j;

public final class FollowedStreamsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final y0 f3510d;

    /* renamed from: e  reason: collision with root package name */
    public final x f3511e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f3512f;

    @Inject
    public FollowedStreamsViewModel(Context context, y0 y0Var, x xVar) {
        r3 r3Var;
        j.f("context", context);
        j.f("localFollowsChannel", y0Var);
        j.f("apiRepository", xVar);
        this.f3510d = y0Var;
        this.f3511e = xVar;
        if (!j.a(h0.l1(context).getString("compactStreamsV2", "disabled"), "disabled")) {
            r3Var = new r3(30, 10, 30);
        } else {
            r3Var = new r3(30, 3, 30);
        }
        this.f3512f = h0.s((i) new a(r3Var, (wa.a) new p1(19, this)).f4852i, h0.I0(this));
    }
}
