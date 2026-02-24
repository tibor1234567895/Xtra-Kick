package com.github.andreyasadchy.xtra.ui.follow.channels;

import android.content.Context;
import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import com.woxthebox.draglistview.R;
import e6.c2;
import e6.e0;
import e6.o1;
import e6.y0;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import n3.z1;
import o6.o;
import pa.e;
import pa.l;
import xa.j;

public final class FollowedChannelsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final c2 f3402d;

    /* renamed from: e  reason: collision with root package name */
    public final y0 f3403e;

    /* renamed from: f  reason: collision with root package name */
    public final o1 f3404f;

    /* renamed from: g  reason: collision with root package name */
    public final e0 f3405g;

    /* renamed from: h  reason: collision with root package name */
    public final o0 f3406h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f3407i;

    /* renamed from: j  reason: collision with root package name */
    public final m0 f3408j;

    @Inject
    public FollowedChannelsViewModel(Context context, c2 c2Var, y0 y0Var, o1 o1Var, e0 e0Var) {
        String str;
        int i10;
        String str2;
        int i11;
        String str3;
        String str4;
        j.f("context", context);
        j.f("sortChannelRepository", c2Var);
        j.f("localFollowsChannel", y0Var);
        j.f("offlineRepository", o1Var);
        j.f("bookmarksRepository", e0Var);
        this.f3402d = c2Var;
        this.f3403e = y0Var;
        this.f3404f = o1Var;
        this.f3405g = e0Var;
        o0 o0Var = new o0();
        this.f3406h = o0Var;
        SortChannel sortChannel = (SortChannel) h0.v1(l.f12754h, new o(this, (e) null));
        Object[] objArr = new Object[2];
        if (sortChannel != null) {
            str = sortChannel.getVideoSort();
        } else {
            str = null;
        }
        FollowSortEnum followSortEnum = FollowSortEnum.FOLLOWED_AT;
        if (j.a(str, followSortEnum.getValue())) {
            i10 = R.string.time_followed;
        } else if (j.a(str, FollowSortEnum.ALPHABETICALLY.getValue())) {
            i10 = R.string.alphabetically;
        } else {
            i10 = R.string.last_broadcast;
        }
        objArr[0] = context.getString(i10);
        if (sortChannel != null) {
            str2 = sortChannel.getVideoType();
        } else {
            str2 = null;
        }
        FollowOrderEnum followOrderEnum = FollowOrderEnum.ASC;
        if (j.a(str2, followOrderEnum.getValue())) {
            i11 = R.string.ascending;
        } else {
            i11 = R.string.descending;
        }
        objArr[1] = context.getString(i11);
        o0Var.l(context.getString(R.string.sort_and_order, objArr));
        if (sortChannel != null) {
            str3 = sortChannel.getVideoSort();
        } else {
            str3 = null;
        }
        if (!j.a(str3, followSortEnum.getValue())) {
            followSortEnum = FollowSortEnum.ALPHABETICALLY;
            if (!j.a(str3, followSortEnum.getValue())) {
                followSortEnum = FollowSortEnum.LAST_BROADCAST;
            }
        }
        if (sortChannel != null) {
            str4 = sortChannel.getVideoType();
        } else {
            str4 = null;
        }
        e1 a10 = f1.a(new o6.l(followSortEnum, !j.a(str4, followOrderEnum.getValue()) ? FollowOrderEnum.DESC : followOrderEnum));
        this.f3407i = a10;
        this.f3408j = h0.s(h0.Y1(a10, new z1((e) null, this, context, 1)), h0.I0(this));
    }
}
