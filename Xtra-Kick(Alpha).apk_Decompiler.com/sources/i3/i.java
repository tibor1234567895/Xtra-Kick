package i3;

import android.view.View;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8102h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f8103i;

    public /* synthetic */ i(int i10, Object obj) {
        this.f8102h = i10;
        this.f8103i = obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.text.method.TransformationMethod] */
    /* JADX WARNING: type inference failed for: r5v4, types: [l6.c0] */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.f8102h
            r2 = 3
            r3 = 29
            r4 = 1
            r5 = 0
            r6 = 0
            java.lang.String r7 = "this$0"
            java.lang.Object r8 = r0.f8103i
            switch(r1) {
                case 0: goto L_0x045d;
                case 1: goto L_0x0438;
                case 2: goto L_0x0409;
                case 3: goto L_0x03f1;
                case 4: goto L_0x036c;
                case 5: goto L_0x034c;
                case 6: goto L_0x0341;
                case 7: goto L_0x0336;
                case 8: goto L_0x031e;
                case 9: goto L_0x0306;
                case 10: goto L_0x0294;
                case 11: goto L_0x027c;
                case 12: goto L_0x0264;
                case 13: goto L_0x024c;
                case 14: goto L_0x0234;
                case 15: goto L_0x0216;
                case 16: goto L_0x0209;
                case 17: goto L_0x01d1;
                case 18: goto L_0x01b9;
                case 19: goto L_0x0153;
                case 20: goto L_0x0100;
                case 21: goto L_0x0089;
                case 22: goto L_0x002d;
                case 23: goto L_0x0019;
                case 24: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x04a0
        L_0x0013:
            y8.k r8 = (y8.k) r8
            r8.u()
            return
        L_0x0019:
            y8.d r8 = (y8.d) r8
            android.widget.EditText r1 = r8.f17130i
            if (r1 != 0) goto L_0x0020
            goto L_0x002c
        L_0x0020:
            android.text.Editable r1 = r1.getText()
            if (r1 == 0) goto L_0x0029
            r1.clear()
        L_0x0029:
            r8.q()
        L_0x002c:
            return
        L_0x002d:
            z5.m r8 = (z5.m) r8
            int r1 = com.github.andreyasadchy.xtra.ui.view.chat.ChatView.I
            java.lang.String r1 = "$this_with"
            xa.j.f(r1, r8)
            android.widget.MultiAutoCompleteTextView r1 = r8.f17716c
            android.text.Editable r2 = r1.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "<this>"
            xa.j.f(r3, r2)
            int r3 = r2.length()
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0064
        L_0x004d:
            int r5 = r3 + -1
            char r7 = r2.charAt(r3)
            boolean r7 = fb.a.b(r7)
            if (r7 != 0) goto L_0x005f
            int r3 = r3 + r4
            java.lang.CharSequence r2 = r2.subSequence(r6, r3)
            goto L_0x0066
        L_0x005f:
            if (r5 >= 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r3 = r5
            goto L_0x004d
        L_0x0064:
            java.lang.String r2 = ""
        L_0x0066:
            java.lang.String r2 = r2.toString()
            r3 = 32
            r4 = 6
            int r3 = fb.y.w(r2, r3, r6, r4)
            int r3 = java.lang.Math.max(r3, r6)
            java.lang.String r2 = r2.substring(r6, r3)
            java.lang.String r3 = "this as java.lang.String…ing(startIndex, endIndex)"
            xa.j.e(r3, r2)
            r1.setText(r2)
            int r2 = r1.length()
            r1.setSelection(r2)
            return
        L_0x0089:
            p7.c r8 = (p7.c) r8
            int r1 = p7.c.f12598t0
            xa.j.f(r7, r8)
            m7.j r9 = m7.m.f10712y0
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3527k
            java.lang.Object r1 = r1.getValue()
            p7.e r1 = (p7.e) r1
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r10 = r1.f12603b
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3527k
            java.lang.Object r1 = r1.getValue()
            p7.e r1 = (p7.e) r1
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r11 = r1.f12604c
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3527k
            java.lang.Object r1 = r1.getValue()
            p7.e r1 = (p7.e) r1
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r12 = r1.f12605d
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3527k
            java.lang.Object r1 = r1.getValue()
            p7.e r1 = (p7.e) r1
            int r1 = r1.f12606e
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3527k
            java.lang.Object r1 = r1.getValue()
            p7.e r1 = (p7.e) r1
            java.lang.Boolean r1 = r1.f12602a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r14 = xa.j.a(r1, r2)
            android.content.Context r1 = r8.f0()
            android.content.SharedPreferences r1 = hb.h0.l1(r1)
            java.lang.String r2 = "sort_default_game_videos"
            boolean r15 = r1.getBoolean(r2, r6)
            r17 = 64
            r16 = 0
            m7.m r1 = m7.j.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.fragment.app.c1 r2 = r8.u()
            r1.q0(r2, r5)
            return
        L_0x0100:
            o7.c r8 = (o7.c) r8
            int r1 = o7.c.f12289t0
            xa.j.f(r7, r8)
            m7.j r9 = m7.m.f10712y0
            com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3522j
            java.lang.Object r1 = r1.getValue()
            o7.e r1 = (o7.e) r1
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r10 = r1.f12293a
            com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3522j
            java.lang.Object r1 = r1.getValue()
            o7.e r1 = (o7.e) r1
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r11 = r1.f12294b
            com.github.andreyasadchy.xtra.ui.videos.followed.FollowedVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3522j
            java.lang.Object r1 = r1.getValue()
            o7.e r1 = (o7.e) r1
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r12 = r1.f12295c
            r13 = 0
            r14 = 0
            android.content.Context r1 = r8.f0()
            android.content.SharedPreferences r1 = hb.h0.l1(r1)
            java.lang.String r2 = "sort_default_followed_videos"
            boolean r15 = r1.getBoolean(r2, r6)
            r17 = 88
            r16 = 0
            m7.m r1 = m7.j.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.fragment.app.c1 r2 = r8.u()
            r1.q0(r2, r5)
            return
        L_0x0153:
            n7.g r8 = (n7.g) r8
            int r1 = n7.g.f11729t0
            xa.j.f(r7, r8)
            m7.j r9 = m7.m.f10712y0
            com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3518k
            java.lang.Object r1 = r1.getValue()
            n7.i r1 = (n7.i) r1
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r10 = r1.f11734b
            com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3518k
            java.lang.Object r1 = r1.getValue()
            n7.i r1 = (n7.i) r1
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r11 = r1.f11735c
            com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3518k
            java.lang.Object r1 = r1.getValue()
            n7.i r1 = (n7.i) r1
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r12 = r1.f11736d
            r13 = 0
            com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel r1 = r8.t0()
            kb.e1 r1 = r1.f3518k
            java.lang.Object r1 = r1.getValue()
            n7.i r1 = (n7.i) r1
            java.lang.Boolean r1 = r1.f11733a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r14 = xa.j.a(r1, r2)
            android.content.Context r1 = r8.f0()
            android.content.SharedPreferences r1 = hb.h0.l1(r1)
            java.lang.String r2 = "sort_default_channel_videos"
            boolean r15 = r1.getBoolean(r2, r6)
            r17 = 72
            r16 = 0
            m7.m r1 = m7.j.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.fragment.app.c1 r2 = r8.u()
            r1.q0(r2, r5)
            return
        L_0x01b9:
            com.github.andreyasadchy.xtra.ui.top.TopFragment r8 = (com.github.andreyasadchy.xtra.ui.top.TopFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.top.TopFragment.f3513h0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x01d1:
            j7.h r8 = (j7.h) r8
            j7.f r1 = j7.h.f8838x0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            f7.l r2 = f7.m.f5938a
            androidx.fragment.app.c0 r3 = r8.C
            if (r3 == 0) goto L_0x01ed
            android.os.Bundle r3 = r3.f1357m
            if (r3 == 0) goto L_0x01ed
            java.lang.String r4 = "gameId"
            int r3 = r3.getInt(r4)
            goto L_0x01ee
        L_0x01ed:
            r3 = 0
        L_0x01ee:
            androidx.fragment.app.c0 r4 = r8.C
            if (r4 == 0) goto L_0x01fc
            android.os.Bundle r4 = r4.f1357m
            if (r4 == 0) goto L_0x01fc
            java.lang.String r5 = "gameSlug"
            java.lang.String r5 = r4.getString(r5)
        L_0x01fc:
            r4 = 28
            y5.r r2 = f7.l.a(r2, r3, r5, r6, r4)
            r1.m(r2)
            r8.l0()
            return
        L_0x0209:
            com.github.andreyasadchy.xtra.ui.settings.SettingsActivity r8 = (com.github.andreyasadchy.xtra.ui.settings.SettingsActivity) r8
            int r1 = com.github.andreyasadchy.xtra.ui.settings.SettingsActivity.J
            xa.j.f(r7, r8)
            androidx.activity.r r1 = r8.f454o
            r1.b()
            return
        L_0x0216:
            com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment.f3468s0
            xa.j.f(r7, r8)
            b7.k r1 = b7.m.f2659v0
            androidx.fragment.app.c1 r2 = r8.u()
            java.lang.String r3 = "childFragmentManager"
            xa.j.e(r3, r2)
            r1.getClass()
            b7.m r1 = new b7.m
            r1.<init>()
            r1.q0(r2, r5)
            return
        L_0x0234:
            com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment.f3454k0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x024c:
            com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment.f3452h0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x0264:
            com.github.andreyasadchy.xtra.ui.games.GamePagerFragment r8 = (com.github.andreyasadchy.xtra.ui.games.GamePagerFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.games.GamePagerFragment.f3417s0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x027c:
            com.github.andreyasadchy.xtra.ui.games.GameMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.games.GameMediaFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.games.GameMediaFragment.f3411t0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x0294:
            o6.e r8 = (o6.e) r8
            int r1 = o6.e.f12249s0
            xa.j.f(r7, r8)
            o6.h r1 = o6.k.f12260x0
            com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel r3 = r8.s0()
            kb.e1 r3 = r3.f3407i
            java.lang.Object r3 = r3.getValue()
            o6.l r3 = (o6.l) r3
            com.github.andreyasadchy.xtra.model.ui.FollowSortEnum r3 = r3.f12263a
            com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel r7 = r8.s0()
            kb.e1 r7 = r7.f3407i
            java.lang.Object r7 = r7.getValue()
            o6.l r7 = (o6.l) r7
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r7 = r7.f12264b
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r10 = "sort_default_followed_channels"
            boolean r9 = r9.getBoolean(r10, r6)
            r1.getClass()
            java.lang.String r1 = "sort"
            xa.j.f(r1, r3)
            java.lang.String r10 = "order"
            xa.j.f(r10, r7)
            o6.k r11 = new o6.k
            r11.<init>()
            la.i[] r2 = new la.i[r2]
            la.i r12 = new la.i
            r12.<init>(r1, r3)
            r2[r6] = r12
            la.i r1 = new la.i
            r1.<init>(r10, r7)
            r2[r4] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            la.i r3 = new la.i
            java.lang.String r4 = "save_default"
            r3.<init>(r4, r1)
            r1 = 2
            r2[r1] = r3
            android.os.Bundle r1 = hb.h0.r(r2)
            r11.j0(r1)
            androidx.fragment.app.c1 r1 = r8.u()
            r11.q0(r1, r5)
            return
        L_0x0306:
            com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment.f3399k0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x031e:
            com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment.f3397h0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x0336:
            m6.z r8 = (m6.z) r8
            m6.w r1 = m6.z.D0
            xa.j.f(r7, r8)
            r8.m0(r6, r6)
            return
        L_0x0341:
            m6.d r8 = (m6.d) r8
            m6.c r1 = m6.d.D0
            xa.j.f(r7, r8)
            r8.m0(r6, r6)
            return
        L_0x034c:
            l6.x r8 = (l6.x) r8
            int r1 = l6.x.f9680j0
            xa.j.f(r7, r8)
            androidx.fragment.app.c0 r1 = r8.C
            boolean r2 = r1 instanceof l6.c0
            if (r2 == 0) goto L_0x035c
            r5 = r1
            l6.c0 r5 = (l6.c0) r5
        L_0x035c:
            if (r5 == 0) goto L_0x0361
            r5.n()
        L_0x0361:
            java.lang.String r1 = "it"
            r2 = r19
            xa.j.e(r1, r2)
            hb.h0.J0(r19)
            return
        L_0x036c:
            k6.e r8 = (k6.e) r8
            int r1 = k6.e.f9214u0
            xa.j.f(r7, r8)
            m7.j r9 = m7.m.f10712y0
            com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel r1 = r8.s0()
            kb.e1 r1 = r1.f3375i
            java.lang.Object r1 = r1.getValue()
            k6.g r1 = (k6.g) r1
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r11 = r1.f9220b
            com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel r1 = r8.s0()
            kb.e1 r1 = r1.f3375i
            java.lang.Object r1 = r1.getValue()
            k6.g r1 = (k6.g) r1
            int r1 = r1.f9221c
            j3.j r2 = r8.f9216r0
            java.lang.Object r2 = r2.getValue()
            q6.f r2 = (q6.f) r2
            int r2 = r2.f13359g
            if (r2 == 0) goto L_0x03a0
            r16 = 1
            goto L_0x03a2
        L_0x03a0:
            r16 = 0
        L_0x03a2:
            com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel r2 = r8.s0()
            kb.e1 r2 = r2.f3375i
            java.lang.Object r2 = r2.getValue()
            k6.g r2 = (k6.g) r2
            java.lang.Boolean r2 = r2.f9219a
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r14 = xa.j.a(r2, r3)
            n3.x3 r2 = r8.f9218t0
            if (r2 == 0) goto L_0x03eb
            boolean r2 = r2 instanceof j6.f
            if (r2 == 0) goto L_0x03c9
            android.content.Context r2 = r8.f0()
            android.content.SharedPreferences r2 = hb.h0.l1(r2)
            java.lang.String r3 = "sort_default_game_clips"
            goto L_0x03d3
        L_0x03c9:
            android.content.Context r2 = r8.f0()
            android.content.SharedPreferences r2 = hb.h0.l1(r2)
            java.lang.String r3 = "sort_default_channel_clips"
        L_0x03d3:
            boolean r15 = r2.getBoolean(r3, r6)
            r10 = 0
            r12 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r17 = 5
            m7.m r1 = m7.j.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.fragment.app.c1 r2 = r8.u()
            r1.q0(r2, r5)
            return
        L_0x03eb:
            java.lang.String r1 = "pagingAdapter"
            xa.j.l(r1)
            throw r5
        L_0x03f1:
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment) r8
            int r1 = com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment.f3334r0
            xa.j.f(r7, r8)
            j3.k0 r1 = hb.h0.V(r8)
            b7.d r2 = b7.e.f2652a
            r2.getClass()
            j3.a r2 = b7.d.a()
            r1.m(r2)
            return
        L_0x0409:
            i3.j r8 = (i3.j) r8
            i3.w r1 = r8.f8111d
            g1.k1 r4 = r1.f8201o0
            if (r4 == 0) goto L_0x0437
            boolean r3 = r4.L0(r3)
            if (r3 == 0) goto L_0x0437
            g1.k1 r3 = r1.f8201o0
            g1.y1 r3 = r3.p0()
            g1.k1 r4 = r1.f8201o0
            g1.x1 r3 = r3.i()
            g1.x1 r2 = r3.d(r2)
            g1.x1 r2 = r2.g()
            g1.y1 r2 = r2.b()
            r4.r(r2)
            android.widget.PopupWindow r1 = r1.f8206r
            r1.dismiss()
        L_0x0437:
            return
        L_0x0438:
            i3.p r8 = (i3.p) r8
            int r1 = i3.p.f8148l
            int r1 = r8.getAdapterPosition()
            i3.w r2 = r8.f8152k
            android.view.View r3 = r2.G
            if (r1 != 0) goto L_0x044c
            r3.getClass()
            i3.n r1 = r2.f8198n
            goto L_0x0453
        L_0x044c:
            if (r1 != r4) goto L_0x0457
            r3.getClass()
            i3.j r1 = r2.f8202p
        L_0x0453:
            r2.f(r1, r3)
            goto L_0x045c
        L_0x0457:
            android.widget.PopupWindow r1 = r2.f8206r
            r1.dismiss()
        L_0x045c:
            return
        L_0x045d:
            i3.j r8 = (i3.j) r8
            i3.w r1 = r8.f8111d
            g1.k1 r2 = r1.f8201o0
            if (r2 == 0) goto L_0x049f
            boolean r2 = r2.L0(r3)
            if (r2 != 0) goto L_0x046c
            goto L_0x049f
        L_0x046c:
            g1.k1 r2 = r1.f8201o0
            g1.y1 r2 = r2.p0()
            g1.k1 r3 = r1.f8201o0
            int r5 = j1.l0.f8453a
            g1.x1 r2 = r2.i()
            g1.x1 r2 = r2.d(r4)
            g1.x1 r2 = r2.i(r4, r6)
            g1.y1 r2 = r2.b()
            r3.r(r2)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131951818(0x7f1300ca, float:1.9540061E38)
            java.lang.String r2 = r2.getString(r3)
            i3.q r3 = r1.f8196m
            java.lang.String[] r3 = r3.f8154b
            r3[r4] = r2
            android.widget.PopupWindow r1 = r1.f8206r
            r1.dismiss()
        L_0x049f:
            return
        L_0x04a0:
            y8.u r8 = (y8.u) r8
            android.widget.EditText r1 = r8.f17220f
            if (r1 != 0) goto L_0x04a7
            goto L_0x04cf
        L_0x04a7:
            int r1 = r1.getSelectionEnd()
            android.widget.EditText r2 = r8.f17220f
            if (r2 == 0) goto L_0x04b8
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            if (r2 == 0) goto L_0x04b8
            goto L_0x04b9
        L_0x04b8:
            r4 = 0
        L_0x04b9:
            android.widget.EditText r2 = r8.f17220f
            if (r4 == 0) goto L_0x04be
            goto L_0x04c2
        L_0x04be:
            android.text.method.PasswordTransformationMethod r5 = android.text.method.PasswordTransformationMethod.getInstance()
        L_0x04c2:
            r2.setTransformationMethod(r5)
            if (r1 < 0) goto L_0x04cc
            android.widget.EditText r2 = r8.f17220f
            r2.setSelection(r1)
        L_0x04cc:
            r8.q()
        L_0x04cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.i.onClick(android.view.View):void");
    }
}
