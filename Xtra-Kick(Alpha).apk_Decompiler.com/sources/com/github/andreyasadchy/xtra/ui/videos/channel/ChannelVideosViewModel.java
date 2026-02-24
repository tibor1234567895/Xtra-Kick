package com.github.andreyasadchy.xtra.ui.videos.channel;

import android.content.Context;
import androidx.lifecycle.j1;
import androidx.lifecycle.o0;
import c6.b;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.woxthebox.draglistview.R;
import e6.c2;
import e6.e0;
import e6.s0;
import e6.x;
import e6.z1;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import m7.e;
import n7.i;
import n7.k;
import n7.m;
import pa.l;
import q6.f;
import xa.j;

public final class ChannelVideosViewModel extends e {

    /* renamed from: h  reason: collision with root package name */
    public final c2 f3515h;

    /* renamed from: i  reason: collision with root package name */
    public final o0 f3516i;

    /* renamed from: j  reason: collision with root package name */
    public final f f3517j;

    /* renamed from: k  reason: collision with root package name */
    public final e1 f3518k;

    /* renamed from: l  reason: collision with root package name */
    public final m0 f3519l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelVideosViewModel(Context context, c2 c2Var, x xVar, z1 z1Var, e0 e0Var, j1 j1Var, s0 s0Var, b bVar) {
        super(z1Var, e0Var, xVar);
        boolean z10;
        String str;
        int i10;
        Boolean bool;
        String str2;
        String str3;
        j.f("context", context);
        j.f("sortChannelRepository", c2Var);
        j.f("repository", xVar);
        j.f("playerRepository", z1Var);
        j.f("bookmarksRepository", e0Var);
        j.f("savedStateHandle", j1Var);
        j.f("kickApiRepository", s0Var);
        j.f("kickMapper", bVar);
        this.f3515h = c2Var;
        o0 o0Var = new o0();
        this.f3516i = o0Var;
        f.f13352i.getClass();
        f a10 = q6.e.a(j1Var);
        this.f3517j = a10;
        SortChannel sortChannel = (SortChannel) h0.v1(l.f12754h, new n7.l(this, a10.f13359g, (pa.e) null));
        if (sortChannel != null) {
            z10 = j.a(sortChannel.getSaveSort(), Boolean.TRUE);
        } else {
            z10 = false;
        }
        sortChannel = !z10 ? (SortChannel) h0.v1(l.f12754h, new k(this, (pa.e) null)) : sortChannel;
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
            bool = sortChannel.getSaveSort();
        } else {
            bool = null;
        }
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
        e1 a11 = f1.a(new i(bool, videoSortEnum, VideoPeriodEnum.ALL, broadcastTypeEnum));
        this.f3518k = a11;
        this.f3519l = h0.s(h0.Y1(a11, new m((pa.e) null, this, s0Var, bVar)), h0.I0(this));
    }
}
