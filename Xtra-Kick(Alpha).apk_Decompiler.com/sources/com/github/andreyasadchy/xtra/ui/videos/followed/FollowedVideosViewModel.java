package com.github.andreyasadchy.xtra.ui.videos.followed;

import android.content.Context;
import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.woxthebox.draglistview.R;
import e6.c2;
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
import o7.h;
import pa.l;
import xa.j;

public final class FollowedVideosViewModel extends e {

    /* renamed from: h  reason: collision with root package name */
    public final c2 f3520h;

    /* renamed from: i  reason: collision with root package name */
    public final o0 f3521i;

    /* renamed from: j  reason: collision with root package name */
    public final e1 f3522j;

    /* renamed from: k  reason: collision with root package name */
    public final m0 f3523k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public FollowedVideosViewModel(Context context, c2 c2Var, x xVar, z1 z1Var, e0 e0Var) {
        super(z1Var, e0Var, xVar);
        String str;
        int i10;
        String str2;
        String str3;
        j.f("context", context);
        j.f("sortChannelRepository", c2Var);
        j.f("repository", xVar);
        j.f("playerRepository", z1Var);
        j.f("bookmarksRepository", e0Var);
        this.f3520h = c2Var;
        o0 o0Var = new o0();
        this.f3521i = o0Var;
        SortChannel sortChannel = (SortChannel) h0.v1(l.f12754h, new h(this, (pa.e) null));
        Object[] objArr = new Object[2];
        if (sortChannel != null) {
            str = sortChannel.getVideoSort();
        } else {
            str = null;
        }
        VideoSortEnum videoSortEnum = VideoSortEnum.VIEWS;
        if (j.a(str, videoSortEnum.getValue())) {
            i10 = R.string.view_count;
        } else {
            i10 = R.string.upload_date;
        }
        objArr[0] = context.getString(i10);
        objArr[1] = context.getString(R.string.all_time);
        o0Var.l(context.getString(R.string.sort_and_period, objArr));
        if (sortChannel != null) {
            str2 = sortChannel.getVideoSort();
        } else {
            str2 = null;
        }
        videoSortEnum = !j.a(str2, videoSortEnum.getValue()) ? VideoSortEnum.TIME : videoSortEnum;
        if (sortChannel != null) {
            str3 = sortChannel.getVideoType();
        } else {
            str3 = null;
        }
        BroadcastTypeEnum broadcastTypeEnum = BroadcastTypeEnum.ARCHIVE;
        if (!j.a(str3, broadcastTypeEnum.getValue())) {
            broadcastTypeEnum = BroadcastTypeEnum.HIGHLIGHT;
            if (!j.a(str3, broadcastTypeEnum.getValue())) {
                broadcastTypeEnum = BroadcastTypeEnum.UPLOAD;
                if (!j.a(str3, broadcastTypeEnum.getValue())) {
                    broadcastTypeEnum = BroadcastTypeEnum.ALL;
                }
            }
        }
        e1 a10 = f1.a(new o7.e(videoSortEnum, broadcastTypeEnum, 2));
        this.f3522j = a10;
        this.f3523k = h0.s(h0.Y1(a10, new u(2, (pa.e) null)), h0.I0(this));
    }
}
