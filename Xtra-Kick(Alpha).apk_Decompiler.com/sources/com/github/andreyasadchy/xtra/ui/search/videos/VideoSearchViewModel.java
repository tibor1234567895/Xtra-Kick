package com.github.andreyasadchy.xtra.ui.search.videos;

import e6.e0;
import e6.x;
import e6.z1;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import m7.e;
import n3.u;
import xa.j;

public final class VideoSearchViewModel extends e {

    /* renamed from: h  reason: collision with root package name */
    public final e1 f3492h;

    /* renamed from: i  reason: collision with root package name */
    public final m0 f3493i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public VideoSearchViewModel(z1 z1Var, e0 e0Var, x xVar) {
        super(z1Var, e0Var, xVar);
        j.f("playerRepository", z1Var);
        j.f("bookmarksRepository", e0Var);
        j.f("repository", xVar);
        e1 a10 = f1.a("");
        this.f3492h = a10;
        this.f3493i = h0.s(h0.Y1(a10, new u(1, (pa.e) null)), h0.I0(this));
    }
}
