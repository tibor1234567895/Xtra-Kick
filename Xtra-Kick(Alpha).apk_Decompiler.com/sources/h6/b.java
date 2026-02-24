package h6;

import android.view.View;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7637h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f7638i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7639j;

    public /* synthetic */ b(Object obj, int i10, Object obj2) {
        this.f7637h = i10;
        this.f7638i = obj;
        this.f7639j = obj2;
    }

    /* JADX WARNING: type inference failed for: r1v26, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r33) {
        /*
            r32 = this;
            r0 = r32
            java.lang.String r1 = "tags"
            r2 = 2131361857(0x7f0a0041, float:1.8343478E38)
            r3 = 0
            int r4 = r0.f7637h
            java.lang.String r5 = "$activity"
            java.lang.String r6 = "$tag"
            java.lang.String r7 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.main.MainActivity"
            r8 = 0
            r9 = 1
            java.lang.String r10 = "this$0"
            java.lang.Object r11 = r0.f7639j
            java.lang.Object r12 = r0.f7638i
            switch(r4) {
                case 0: goto L_0x0363;
                case 1: goto L_0x034b;
                case 2: goto L_0x0333;
                case 3: goto L_0x0303;
                case 4: goto L_0x02d0;
                case 5: goto L_0x029d;
                case 6: goto L_0x0283;
                case 7: goto L_0x0254;
                case 8: goto L_0x020e;
                case 9: goto L_0x01e3;
                case 10: goto L_0x018a;
                case 11: goto L_0x0153;
                case 12: goto L_0x0144;
                case 13: goto L_0x0117;
                case 14: goto L_0x00ff;
                case 15: goto L_0x00e7;
                case 16: goto L_0x00b8;
                case 17: goto L_0x008b;
                case 18: goto L_0x005c;
                case 19: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x03b8
        L_0x001d:
            z5.m r12 = (z5.m) r12
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r11 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r11
            int r1 = com.github.andreyasadchy.xtra.ui.view.chat.ChatView.I
            java.lang.String r1 = "$this_with"
            xa.j.f(r1, r12)
            xa.j.f(r10, r11)
            java.lang.String r1 = "emoteMenu"
            android.widget.LinearLayout r2 = r12.f17717d
            xa.j.e(r1, r2)
            int r1 = r2.getVisibility()
            r2 = 8
            if (r1 != r2) goto L_0x003c
            r1 = 1
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            if (r1 == 0) goto L_0x0058
            java.lang.Boolean r1 = r11.B
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = xa.j.a(r1, r2)
            if (r1 != 0) goto L_0x0054
            androidx.viewpager2.widget.ViewPager2 r1 = r12.f17733t
            int r2 = r1.getCurrentItem()
            if (r2 != 0) goto L_0x0054
            r1.b(r9, r8)
        L_0x0054:
            r11.y(r9)
            goto L_0x005b
        L_0x0058:
            r11.y(r8)
        L_0x005b:
            return
        L_0x005c:
            n7.b r12 = (n7.b) r12
            com.github.andreyasadchy.xtra.model.ui.Tag r11 = (com.github.andreyasadchy.xtra.model.ui.Tag) r11
            int r1 = n7.b.f11710k
            xa.j.f(r10, r12)
            xa.j.f(r6, r11)
            androidx.fragment.app.c0 r1 = r12.f11712i
            j3.k0 r1 = hb.h0.V(r1)
            q6.g r12 = q6.h.f13361a
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String[] r2 = new java.lang.String[r9]
            java.lang.String r3 = r11.getName()
            r2[r8] = r3
            r19 = 239(0xef, float:3.35E-43)
            r18 = 0
            r17 = r2
            y5.q r2 = q6.g.a(r12, r13, r14, r15, r16, r17, r18, r19)
            r1.m(r2)
            return
        L_0x008b:
            m7.m r12 = (m7.m) r12
            java.util.List r11 = (java.util.List) r11
            m7.j r1 = m7.m.f10712y0
            xa.j.f(r10, r12)
            java.lang.String r1 = "$langArray"
            xa.j.f(r1, r11)
            s7.g r1 = s7.g.f14374a
            androidx.fragment.app.c1 r2 = r12.u()
            java.lang.String r4 = "childFragmentManager"
            xa.j.e(r4, r2)
            int r4 = r12.f10715x0
            r1.getClass()
            l6.z r1 = l6.b0.f9590w0
            r1.getClass()
            l6.b0 r1 = l6.z.a(r8, r11, r3, r4)
            java.lang.String r3 = "closeOnPip"
            r1.q0(r2, r3)
            return
        L_0x00b8:
            m7.g r12 = (m7.g) r12
            com.github.andreyasadchy.xtra.model.ui.Tag r11 = (com.github.andreyasadchy.xtra.model.ui.Tag) r11
            int r1 = m7.g.f10692l
            xa.j.f(r10, r12)
            xa.j.f(r6, r11)
            androidx.fragment.app.c0 r1 = r12.f10694i
            j3.k0 r1 = hb.h0.V(r1)
            q6.g r12 = q6.h.f13361a
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String[] r2 = new java.lang.String[r9]
            java.lang.String r3 = r11.getName()
            r2[r8] = r3
            r19 = 239(0xef, float:3.35E-43)
            r18 = 0
            r17 = r2
            y5.q r2 = q6.g.a(r12, r13, r14, r15, r16, r17, r18, r19)
            r1.m(r2)
            return
        L_0x00e7:
            i7.e r12 = (i7.e) r12
            com.github.andreyasadchy.xtra.model.ui.Stream r11 = (com.github.andreyasadchy.xtra.model.ui.Stream) r11
            int r1 = i7.e.f8367l
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f8369i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r7, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            r1.L(r11)
            return
        L_0x00ff:
            i7.b r12 = (i7.b) r12
            com.github.andreyasadchy.xtra.model.ui.Stream r11 = (com.github.andreyasadchy.xtra.model.ui.Stream) r11
            int r1 = i7.b.f8358l
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f8360i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r7, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            r1.L(r11)
            return
        L_0x0117:
            c7.b r12 = (c7.b) r12
            com.github.andreyasadchy.xtra.model.ui.User r11 = (com.github.andreyasadchy.xtra.model.ui.User) r11
            int r1 = c7.b.f2974j
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f2976i
            j3.k0 r1 = hb.h0.V(r1)
            h6.r r2 = h6.s.f7686a
            int r3 = r11.getChannelId()
            java.lang.String r4 = r11.getChannelSlug()
            java.lang.String r5 = r11.getChannelName()
            java.lang.String r6 = r11.getChannelLogo()
            r7 = 0
            r8 = 0
            r9 = 48
            y5.o r2 = h6.r.a(r2, r3, r4, r5, r6, r7, r8, r9)
            r1.m(r2)
            return
        L_0x0144:
            a7.d r12 = (a7.d) r12
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r11
            int r1 = a7.c.f271k
            xa.j.f(r10, r12)
            wa.l r1 = r12.f276c
            r1.invoke(r11)
            return
        L_0x0153:
            a7.c r12 = (a7.c) r12
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r11 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r11
            int r1 = a7.c.f271k
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f273i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r7, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            java.lang.String r2 = "video"
            xa.j.f(r2, r11)
            v6.c r3 = v6.d.H0
            r3.getClass()
            v6.d r3 = new v6.d
            r3.<init>()
            la.i[] r4 = new la.i[r9]
            la.i r5 = new la.i
            r5.<init>(r2, r11)
            r4[r8] = r5
            android.os.Bundle r2 = hb.h0.r(r4)
            r3.j0(r2)
            r1.K(r3)
            return
        L_0x018a:
            w6.f r12 = (w6.f) r12
            com.github.andreyasadchy.xtra.model.ui.BroadcastSettings r11 = (com.github.andreyasadchy.xtra.model.ui.BroadcastSettings) r11
            w6.d r1 = w6.f.H0
            xa.j.f(r10, r12)
            j3.k0 r1 = hb.h0.V(r12)
            android.content.SharedPreferences r2 = r12.t0()
            java.lang.String r3 = "ui_gamepager"
            boolean r2 = r2.getBoolean(r3, r9)
            if (r2 == 0) goto L_0x01be
            q6.g r3 = q6.h.f13361a
            int r4 = r11.getGameId()
            java.lang.String r5 = r11.getGameSlug()
            java.lang.String r6 = r11.getGameName()
            java.lang.String r7 = r11.getBoxArtUrl()
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            y5.q r2 = q6.g.a(r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01d8
        L_0x01be:
            q6.a r3 = q6.b.f13350a
            int r4 = r11.getGameId()
            java.lang.String r5 = r11.getGameSlug()
            java.lang.String r6 = r11.getGameName()
            java.lang.String r7 = r11.getBoxArtUrl()
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            y5.p r2 = q6.a.a(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x01d8:
            r1.m(r2)
            com.github.andreyasadchy.xtra.ui.view.SlidingLayout r1 = r12.u0()
            r1.g()
            return
        L_0x01e3:
            android.content.ComponentName r12 = (android.content.ComponentName) r12
            t6.z0 r11 = (t6.z0) r11
            t6.x0 r1 = t6.z0.f14677v0
            java.lang.String r1 = "$admin"
            xa.j.f(r1, r12)
            xa.j.f(r10, r11)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.app.action.ADD_DEVICE_ADMIN"
            r1.<init>(r2)
            java.lang.String r2 = "android.app.extra.DEVICE_ADMIN"
            android.content.Intent r1 = r1.putExtra(r2, r12)
            java.lang.String r2 = "Intent(\n                …                        )"
            xa.j.e(r2, r1)
            android.content.Context r2 = r11.f0()
            r2.startActivity(r1)
            r11.m0(r8, r8)
            return
        L_0x020e:
            com.github.andreyasadchy.xtra.model.ui.Game r12 = (com.github.andreyasadchy.xtra.model.ui.Game) r12
            t6.y r11 = (t6.y) r11
            int r1 = t6.y.f14673j
            xa.j.f(r10, r11)
            androidx.fragment.app.c0 r1 = r11.f14675i
            if (r12 == 0) goto L_0x0247
            java.lang.Integer r2 = r12.getVodPosition()
            if (r2 == 0) goto L_0x0247
            int r2 = r2.intValue()
            boolean r4 = r1 instanceof t6.w
            if (r4 == 0) goto L_0x022d
            r4 = r1
            t6.w r4 = (t6.w) r4
            goto L_0x022e
        L_0x022d:
            r4 = r3
        L_0x022e:
            if (r4 == 0) goto L_0x0247
            t6.v r4 = r4.f14669v0
            if (r4 == 0) goto L_0x0241
            long r5 = (long) r2
            x6.h r4 = (x6.h) r4
            h3.b0 r2 = r4.s0()
            if (r2 == 0) goto L_0x0247
            r2.q0(r5)
            goto L_0x0247
        L_0x0241:
            java.lang.String r1 = "listener"
            xa.j.l(r1)
            throw r3
        L_0x0247:
            boolean r2 = r1 instanceof t6.w
            if (r2 == 0) goto L_0x024e
            r3 = r1
            t6.w r3 = (t6.w) r3
        L_0x024e:
            if (r3 == 0) goto L_0x0253
            r3.l0()
        L_0x0253:
            return
        L_0x0254:
            t6.l r12 = (t6.l) r12
            android.widget.ImageButton r11 = (android.widget.ImageButton) r11
            t6.f r1 = t6.l.f14620w0
            xa.j.f(r10, r12)
            java.lang.String r1 = "$this_apply"
            xa.j.f(r1, r11)
            h3.b0 r1 = r12.s0()
            if (r1 == 0) goto L_0x0282
            h3.f4 r2 = new h3.f4
            android.os.Bundle r3 = android.os.Bundle.EMPTY
            java.lang.String r4 = "toggleDynamicsProcessing"
            r2.<init>(r3, r4)
            h9.e0 r1 = r1.T0(r2, r3)
            if (r1 == 0) goto L_0x0282
            r3.b0 r2 = new r3.b0
            r3 = 3
            r2.<init>(r1, r3, r11)
            h9.q r3 = h9.q.f7765h
            r1.a(r2, r3)
        L_0x0282:
            return
        L_0x0283:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r12 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r12
            t6.l r11 = (t6.l) r11
            t6.f r1 = t6.l.f14620w0
            xa.j.f(r5, r12)
            xa.j.f(r10, r11)
            boolean r1 = r11.f14628o0
            if (r1 == 0) goto L_0x0295
            r1 = 6
            goto L_0x0299
        L_0x0295:
            r12.setRequestedOrientation(r9)
            r1 = -1
        L_0x0299:
            r12.setRequestedOrientation(r1)
            return
        L_0x029d:
            q6.q r12 = (q6.q) r12
            com.github.andreyasadchy.xtra.model.ui.Tag r11 = (com.github.andreyasadchy.xtra.model.ui.Tag) r11
            int r4 = q6.q.f13385j
            xa.j.f(r10, r12)
            xa.j.f(r6, r11)
            androidx.fragment.app.c0 r4 = r12.f13387i
            j3.k0 r4 = hb.h0.V(r4)
            q6.u r5 = q6.v.f13392a
            java.lang.String[] r6 = new java.lang.String[r9]
            java.lang.String r7 = r11.getId()
            r6[r8] = r7
            r5.getClass()
            y5.t r5 = y5.u.f17067a
            r5.getClass()
            r4.getClass()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putStringArray(r1, r6)
            r4.k(r2, r5, r3)
            return
        L_0x02d0:
            p6.b r12 = (p6.b) r12
            com.github.andreyasadchy.xtra.model.ui.Tag r11 = (com.github.andreyasadchy.xtra.model.ui.Tag) r11
            int r4 = p6.b.f12575j
            xa.j.f(r10, r12)
            xa.j.f(r6, r11)
            androidx.fragment.app.c0 r4 = r12.f12577i
            j3.k0 r4 = hb.h0.V(r4)
            q6.u r5 = q6.v.f13392a
            java.lang.String[] r6 = new java.lang.String[r9]
            java.lang.String r7 = r11.getId()
            r6[r8] = r7
            r5.getClass()
            y5.t r5 = y5.u.f17067a
            r5.getClass()
            r4.getClass()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putStringArray(r1, r6)
            r4.k(r2, r5, r3)
            return
        L_0x0303:
            o6.b r12 = (o6.b) r12
            com.github.andreyasadchy.xtra.model.ui.User r11 = (com.github.andreyasadchy.xtra.model.ui.User) r11
            int r1 = o6.b.f12237j
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f12239i
            j3.k0 r1 = hb.h0.V(r1)
            h6.r r2 = h6.s.f7686a
            int r3 = r11.getChannelId()
            java.lang.String r4 = r11.getChannelSlug()
            java.lang.String r5 = r11.getChannelName()
            java.lang.String r6 = r11.getChannelLogo()
            boolean r7 = r11.getFollowLocal()
            r8 = 0
            r9 = 32
            y5.o r2 = h6.r.a(r2, r3, r4, r5, r6, r7, r8, r9)
            r1.m(r2)
            return
        L_0x0333:
            k6.b r12 = (k6.b) r12
            com.github.andreyasadchy.xtra.model.ui.Clip r11 = (com.github.andreyasadchy.xtra.model.ui.Clip) r11
            int r1 = k6.b.f9199k
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f9201i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r7, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            r1.J(r11)
            return
        L_0x034b:
            j6.e r12 = (j6.e) r12
            com.github.andreyasadchy.xtra.model.ui.Clip r11 = (com.github.andreyasadchy.xtra.model.ui.Clip) r11
            int r1 = j6.e.f8815l
            xa.j.f(r10, r12)
            androidx.fragment.app.c0 r1 = r12.f8817i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r7, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            r1.J(r11)
            return
        L_0x0363:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r12 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r12
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment r11 = (com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment) r11
            int r1 = com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment.f3334r0
            xa.j.f(r5, r12)
            xa.j.f(r10, r11)
            com.github.andreyasadchy.xtra.model.ui.Stream r1 = new com.github.andreyasadchy.xtra.model.ui.Stream
            r13 = r1
            h6.q r2 = r11.r0()
            int r14 = r2.f7685f
            h6.q r2 = r11.r0()
            int r15 = r2.f7680a
            h6.q r2 = r11.r0()
            java.lang.String r2 = r2.f7681b
            r16 = r2
            h6.q r2 = r11.r0()
            java.lang.String r2 = r2.f7682c
            r17 = r2
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            h6.q r2 = r11.r0()
            java.lang.String r2 = r2.f7683d
            r26 = r2
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 61424(0xeff0, float:8.6073E-41)
            r31 = 0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r12.L(r1)
            return
        L_0x03b8:
            r7.o r12 = (r7.o) r12
            com.github.andreyasadchy.xtra.model.chat.Emote r11 = (com.github.andreyasadchy.xtra.model.chat.Emote) r11
            xa.j.f(r10, r12)
            java.lang.String r1 = "emote"
            xa.j.e(r1, r11)
            wa.l r1 = r12.f13856c
            r1.invoke(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.b.onClick(android.view.View):void");
    }
}
