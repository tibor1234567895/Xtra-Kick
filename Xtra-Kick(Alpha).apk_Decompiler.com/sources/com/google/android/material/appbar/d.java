package com.google.android.material.appbar;

import android.view.View;
import n0.x;

public final class d implements x {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3638h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3639i;

    public d(AppBarLayout appBarLayout, boolean z10) {
        this.f3638h = appBarLayout;
        this.f3639i = z10;
    }

    public final boolean b(View view) {
        this.f3638h.setExpanded(this.f3639i);
        return true;
    }
}
