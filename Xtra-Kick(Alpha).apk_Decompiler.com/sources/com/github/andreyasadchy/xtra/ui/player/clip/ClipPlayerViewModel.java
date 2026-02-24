package com.github.andreyasadchy.xtra.ui.player.clip;

import androidx.lifecycle.o0;
import e6.x;
import e6.y0;
import javax.inject.Inject;
import t6.i0;
import xa.j;

public final class ClipPlayerViewModel extends i0 {

    /* renamed from: n  reason: collision with root package name */
    public final o0 f3442n = new o0();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ClipPlayerViewModel(x xVar, y0 y0Var) {
        super(xVar, y0Var);
        j.f("repository", xVar);
        j.f("localFollowsChannel", y0Var);
    }
}
