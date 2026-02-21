package com.github.andreyasadchy.xtra.ui.player.video;

import androidx.lifecycle.o0;
import e6.e0;
import e6.x;
import e6.y0;
import e6.z1;
import javax.inject.Inject;
import t6.i0;
import xa.j;

public final class VideoPlayerViewModel extends i0 {

    /* renamed from: n  reason: collision with root package name */
    public final z1 f3447n;

    /* renamed from: o  reason: collision with root package name */
    public final e0 f3448o;

    /* renamed from: p  reason: collision with root package name */
    public final o0 f3449p = new o0();

    /* renamed from: q  reason: collision with root package name */
    public final o0 f3450q = new o0();

    /* renamed from: r  reason: collision with root package name */
    public final o0 f3451r = new o0();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public VideoPlayerViewModel(z1 z1Var, x xVar, y0 y0Var, e0 e0Var) {
        super(xVar, y0Var);
        j.f("playerRepository", z1Var);
        j.f("repository", xVar);
        j.f("localFollowsChannel", y0Var);
        j.f("bookmarksRepository", e0Var);
        this.f3447n = z1Var;
        this.f3448o = e0Var;
    }
}
