package com.github.andreyasadchy.xtra.ui.player.offline;

import e6.o1;
import e6.x;
import e6.y0;
import javax.inject.Inject;
import t6.i0;
import xa.j;

public final class OfflinePlayerViewModel extends i0 {

    /* renamed from: n  reason: collision with root package name */
    public final o1 f3443n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public OfflinePlayerViewModel(o1 o1Var, x xVar, y0 y0Var) {
        super(xVar, y0Var);
        j.f("offlineRepository", o1Var);
        j.f("repository", xVar);
        j.f("localFollowsChannel", y0Var);
        this.f3443n = o1Var;
    }
}
