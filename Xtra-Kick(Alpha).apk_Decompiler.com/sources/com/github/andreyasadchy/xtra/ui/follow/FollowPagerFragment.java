package com.github.andreyasadchy.xtra.ui.follow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c1;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import l6.c0;
import n6.c;
import z5.j;

public final class FollowPagerFragment extends c implements c0 {

    /* renamed from: k0  reason: collision with root package name */
    public static final /* synthetic */ int f3399k0 = 0;

    /* renamed from: i0  reason: collision with root package name */
    public j f3400i0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f3401j0 = true;

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        this.f3401j0 = bundle == null;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        j b10 = j.b(layoutInflater, viewGroup);
        this.f3400i0 = b10;
        CoordinatorLayout a10 = b10.a();
        xa.j.e("binding.root", a10);
        return a10;
    }

    public final void Q() {
        this.K = true;
        this.f3400i0 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0073, code lost:
        if (r0.intValue() == 2) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r7 = "view"
            xa.j.f(r7, r6)
            z5.j r6 = r5.f3400i0
            xa.j.c(r6)
            androidx.fragment.app.f0 r7 = r5.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account$Companion r0 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r0 = r0.get(r7)
            java.lang.Object r1 = r6.f17680f
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            i3.i r2 = new i3.i
            r3 = 9
            r2.<init>(r3, r5)
            r1.setOnClickListener(r2)
            java.lang.Object r6 = r6.f17679e
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            h6.d r1 = new h6.d
            r2 = 5
            r1.<init>(r7, r0, r5, r2)
            r6.setOnClickListener(r1)
            z5.j r6 = r5.f3400i0
            xa.j.c(r6)
            java.lang.Object r6 = r6.f17683i
            android.support.v4.media.session.u r6 = (android.support.v4.media.session.u) r6
            n6.a r7 = new n6.a
            r7.<init>(r5)
            java.lang.Object r0 = r6.f430k
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            r0.setAdapter(r7)
            boolean r0 = r5.f3401j0
            if (r0 == 0) goto L_0x0088
            android.content.Context r0 = r5.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r1 = "ui_follow_default_page"
            java.lang.String r2 = "0"
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x0065
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            java.lang.Object r1 = r6.f430k
            androidx.viewpager2.widget.ViewPager2 r1 = (androidx.viewpager2.widget.ViewPager2) r1
            r2 = 0
            if (r0 != 0) goto L_0x006e
            goto L_0x0076
        L_0x006e:
            int r3 = r0.intValue()
            r4 = 2
            if (r3 != r4) goto L_0x0076
            goto L_0x0083
        L_0x0076:
            if (r0 != 0) goto L_0x0079
            goto L_0x0082
        L_0x0079:
            int r0 = r0.intValue()
            r3 = 3
            if (r0 != r3) goto L_0x0082
            r4 = 0
            goto L_0x0083
        L_0x0082:
            r4 = 1
        L_0x0083:
            r1.b(r4, r2)
            r5.f3401j0 = r2
        L_0x0088:
            java.lang.Object r0 = r6.f430k
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            int r7 = r7.getItemCount()
            r0.setOffscreenPageLimit(r7)
            java.lang.Object r7 = r6.f430k
            androidx.viewpager2.widget.ViewPager2 r7 = (androidx.viewpager2.widget.ViewPager2) r7
            java.lang.String r0 = "viewPager"
            xa.j.e(r0, r7)
            hb.h0.s1(r7)
            x8.n r7 = new x8.n
            java.lang.Object r0 = r6.f429j
            com.google.android.material.tabs.TabLayout r0 = (com.google.android.material.tabs.TabLayout) r0
            java.lang.Object r6 = r6.f430k
            androidx.viewpager2.widget.ViewPager2 r6 = (androidx.viewpager2.widget.ViewPager2) r6
            h3.h1 r1 = new h3.h1
            r1.<init>(r5)
            r7.<init>(r0, r6, r1)
            r7.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment.Z(android.view.View, android.os.Bundle):void");
    }

    public final void n() {
        c0 c0Var;
        j jVar = this.f3400i0;
        xa.j.c(jVar);
        ((AppBarLayout) jVar.f17677c).d(true, true, true);
        c1 u10 = u();
        j jVar2 = this.f3400i0;
        xa.j.c(jVar2);
        int currentItem = ((ViewPager2) ((u) jVar2.f17683i).f430k).getCurrentItem();
        androidx.fragment.app.c0 E = u10.E("f" + currentItem);
        if (E instanceof c0) {
            c0Var = (c0) E;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            c0Var.n();
        }
    }
}
