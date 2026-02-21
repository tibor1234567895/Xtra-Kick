package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import n0.x;

public final class c implements x {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f3633h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f3634i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f3635j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3636k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f3637l;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
        this.f3637l = baseBehavior;
        this.f3633h = coordinatorLayout;
        this.f3634i = appBarLayout;
        this.f3635j = view;
        this.f3636k = i10;
    }

    public final boolean b(View view) {
        this.f3637l.E(this.f3633h, this.f3634i, this.f3635j, this.f3636k, new int[]{0, 0});
        return true;
    }
}
