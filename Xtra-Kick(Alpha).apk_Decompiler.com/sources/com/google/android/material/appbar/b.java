package com.google.android.material.appbar;

import android.view.View;
import android.widget.ScrollView;
import com.google.android.material.appbar.AppBarLayout;
import m0.c;
import n0.i;

public final class b extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f3632d;

    public b(AppBarLayout.BaseBehavior baseBehavior) {
        this.f3632d = baseBehavior;
    }

    public final void d(View view, i iVar) {
        this.f10052a.onInitializeAccessibilityNodeInfo(view, iVar.f10916a);
        iVar.k(this.f3632d.f3603o);
        iVar.h(ScrollView.class.getName());
    }
}
