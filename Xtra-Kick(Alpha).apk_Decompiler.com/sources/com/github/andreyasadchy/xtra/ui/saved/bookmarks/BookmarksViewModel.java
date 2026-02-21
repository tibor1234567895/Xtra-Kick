package com.github.andreyasadchy.xtra.ui.saved.bookmarks;

import a6.e;
import androidx.lifecycle.m0;
import androidx.lifecycle.w1;
import e6.e0;
import e6.j2;
import e6.x;
import e6.z1;
import javax.inject.Inject;
import r3.s0;
import r3.u0;
import xa.j;

public final class BookmarksViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3457d;

    /* renamed from: e  reason: collision with root package name */
    public final e0 f3458e;

    /* renamed from: f  reason: collision with root package name */
    public final j2 f3459f;

    /* renamed from: g  reason: collision with root package name */
    public final u0 f3460g;

    /* renamed from: h  reason: collision with root package name */
    public final m0 f3461h;

    /* renamed from: i  reason: collision with root package name */
    public final u0 f3462i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3463j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3464k;

    @Inject
    public BookmarksViewModel(x xVar, e0 e0Var, z1 z1Var, j2 j2Var) {
        j.f("repository", xVar);
        j.f("bookmarksRepository", e0Var);
        j.f("playerRepository", z1Var);
        j.f("vodBookmarkIgnoredUsersRepository", j2Var);
        this.f3457d = xVar;
        this.f3458e = e0Var;
        this.f3459f = j2Var;
        this.f3460g = e0Var.c();
        this.f3461h = z1Var.c();
        a6.e0 e0Var2 = (a6.e0) j2Var.f5167a;
        e0Var2.getClass();
        this.f3462i = e0Var2.f231a.f13722e.b(new String[]{"vod_bookmark_ignored_users"}, new e(e0Var2, s0.k(0, "SELECT * FROM vod_bookmark_ignored_users"), 5));
    }
}
