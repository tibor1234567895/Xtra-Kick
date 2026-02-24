package u6;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.i5;
import androidx.fragment.app.z1;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.media3.ui.AspectRatioFrameLayout;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import g1.d1;
import h3.b0;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import hb.p0;
import i6.g;
import la.e;
import m6.r;
import mb.u;
import xa.j;
import xa.v;

public final class d extends h implements r, g {
    public static final b I0 = new b(0);
    public i5 E0;
    public final x1 F0;
    public Clip G0;
    public final int H0 = 2500;

    public d() {
        e t10 = h.t(new z1(18, this), 10);
        this.F0 = h0.K(this, v.a(ClipPlayerViewModel.class), new m(t10, 10), new n(t10, 10), new o(this, t10, 10));
    }

    public final void L0() {
        super.L0();
        Clip clip = this.G0;
        if (clip != null) {
            ClipPlayerViewModel O0 = v0();
            clip.getUuid();
            if (O0.f3442n.d() == null) {
                h0.b1(h0.I0(O0), (pa.h) null, 0, new f(O0, (pa.e) null), 3);
            }
            v0().f3442n.f(C(), new v1(15, new u1(this, 11, clip)));
            return;
        }
        j.l("clip");
        throw null;
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        Parcelable parcelable = e0().getParcelable("clip");
        j.c(parcelable);
        this.G0 = (Clip) parcelable;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_player_clip, viewGroup, false);
        int i10 = R.id.aspectRatioFrameLayout;
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) a.a(inflate, R.id.aspectRatioFrameLayout);
        if (aspectRatioFrameLayout != null) {
            i10 = R.id.chatFragmentContainer;
            FrameLayout frameLayout = (FrameLayout) a.a(inflate, R.id.chatFragmentContainer);
            if (frameLayout != null) {
                i10 = R.id.clipChatContainer;
                LinearLayout linearLayout = (LinearLayout) a.a(inflate, R.id.clipChatContainer);
                if (linearLayout != null) {
                    i10 = R.id.playerView;
                    CustomPlayerView customPlayerView = (CustomPlayerView) a.a(inflate, R.id.playerView);
                    if (customPlayerView != null) {
                        SlidingLayout slidingLayout = (SlidingLayout) inflate;
                        Button button = (Button) a.a(inflate, R.id.watchVideo);
                        if (button != null) {
                            i5 i5Var = new i5(slidingLayout, aspectRatioFrameLayout, frameLayout, linearLayout, customPlayerView, slidingLayout, button, 5);
                            SlidingLayout slidingLayout2 = (SlidingLayout) i5Var.f879g;
                            j.d("null cannot be cast to non-null type android.widget.LinearLayout", slidingLayout2);
                            slidingLayout2.setOrientation(this.f14628o0 ? 1 : 0);
                            this.E0 = i5Var;
                            j.e("binding.root", slidingLayout);
                            return slidingLayout;
                        }
                        i10 = R.id.watchVideo;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    /* renamed from: O0 */
    public final ClipPlayerViewModel v0() {
        return (ClipPlayerViewModel) this.F0.getValue();
    }

    public final void Q() {
        super.Q();
        this.E0 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01cd, code lost:
        if (r5 == r6.getChannelId()) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e6, code lost:
        if (r4 != 1) goto L_0x021d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "view"
            xa.j.f(r0, r9)
            super.Z(r9, r10)
            android.view.View r9 = r8.h0()
            r10 = 2131362343(0x7f0a0227, float:1.8344464E38)
            android.view.View r9 = r9.findViewById(r10)
            r1 = r9
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
            android.view.View r9 = r8.h0()
            r10 = 2131362334(0x7f0a021e, float:1.8344446E38)
            android.view.View r9 = r9.findViewById(r10)
            android.widget.ImageButton r9 = (android.widget.ImageButton) r9
            android.view.View r10 = r8.h0()
            r0 = 2131362340(0x7f0a0224, float:1.8344458E38)
            android.view.View r10 = r10.findViewById(r0)
            r3 = r10
            android.widget.ImageButton r3 = (android.widget.ImageButton) r3
            com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel r10 = r8.v0()
            androidx.lifecycle.o0 r10 = r10.f14608i
            androidx.fragment.app.y1 r6 = r8.C()
            j3.i0 r7 = new j3.i0
            r5 = 1
            r0 = r7
            r2 = r9
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.lifecycle.v1 r0 = new androidx.lifecycle.v1
            r1 = 15
            r0.<init>(r1, r7)
            r10.f(r6, r0)
            android.content.SharedPreferences r10 = r8.t0()
            java.lang.String r0 = "player_menu"
            r2 = 1
            boolean r10 = r10.getBoolean(r0, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0076
            android.view.View r10 = r8.h0()
            r3 = 2131362338(0x7f0a0222, float:1.8344454E38)
            android.view.View r10 = r10.findViewById(r3)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            if (r10 == 0) goto L_0x0076
            r10.setVisibility(r0)
            u6.a r3 = new u6.a
            r3.<init>(r8, r0)
            r10.setOnClickListener(r3)
        L_0x0076:
            android.content.SharedPreferences r10 = r8.t0()
            java.lang.String r3 = "player_download"
            boolean r10 = r10.getBoolean(r3, r0)
            if (r10 == 0) goto L_0x008f
            if (r9 == 0) goto L_0x008f
            r9.setVisibility(r0)
            u6.a r10 = new u6.a
            r10.<init>(r8, r2)
            r9.setOnClickListener(r10)
        L_0x008f:
            com.github.andreyasadchy.xtra.model.ui.Clip r9 = r8.G0
            r10 = 0
            java.lang.String r3 = "clip"
            if (r9 == 0) goto L_0x028c
            java.lang.String r9 = r9.getVideoUrl()
            if (r9 == 0) goto L_0x00a5
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r9 = 0
            goto L_0x00a6
        L_0x00a5:
            r9 = 1
        L_0x00a6:
            if (r9 != 0) goto L_0x00cb
            androidx.appcompat.widget.i5 r9 = r8.E0
            xa.j.c(r9)
            java.lang.Object r9 = r9.f880h
            android.widget.Button r9 = (android.widget.Button) r9
            java.lang.String r4 = "binding.watchVideo"
            xa.j.e(r4, r9)
            r9.setVisibility(r0)
            androidx.appcompat.widget.i5 r9 = r8.E0
            xa.j.c(r9)
            java.lang.Object r9 = r9.f880h
            android.widget.Button r9 = (android.widget.Button) r9
            u6.a r4 = new u6.a
            r5 = 2
            r4.<init>(r8, r5)
            r9.setOnClickListener(r4)
        L_0x00cb:
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_channel"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x0102
            android.view.View r9 = r8.h0()
            r4 = 2131362330(0x7f0a021a, float:1.8344438E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0102
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Clip r4 = r8.G0
            if (r4 == 0) goto L_0x00fe
            java.lang.String r4 = r4.getChannelName()
            r9.setText(r4)
            u6.a r4 = new u6.a
            r5 = 3
            r4.<init>(r8, r5)
            r9.setOnClickListener(r4)
            goto L_0x0102
        L_0x00fe:
            xa.j.l(r3)
            throw r10
        L_0x0102:
            com.github.andreyasadchy.xtra.model.ui.Clip r9 = r8.G0
            if (r9 == 0) goto L_0x0288
            java.lang.String r9 = r9.getTitle()
            if (r9 == 0) goto L_0x0115
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x0113
            goto L_0x0115
        L_0x0113:
            r9 = 0
            goto L_0x0116
        L_0x0115:
            r9 = 1
        L_0x0116:
            if (r9 != 0) goto L_0x0146
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_title"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x0146
            android.view.View r9 = r8.h0()
            r4 = 2131362347(0x7f0a022b, float:1.8344472E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0146
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Clip r4 = r8.G0
            if (r4 == 0) goto L_0x0142
            java.lang.String r4 = r4.getTitle()
            r9.setText(r4)
            goto L_0x0146
        L_0x0142:
            xa.j.l(r3)
            throw r10
        L_0x0146:
            com.github.andreyasadchy.xtra.model.ui.Clip r9 = r8.G0
            if (r9 == 0) goto L_0x0284
            java.lang.String r9 = r9.getGameName()
            if (r9 == 0) goto L_0x0159
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x0157
            goto L_0x0159
        L_0x0157:
            r9 = 0
            goto L_0x015a
        L_0x0159:
            r9 = 1
        L_0x015a:
            if (r9 != 0) goto L_0x0193
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_category"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x0193
            android.view.View r9 = r8.h0()
            r4 = 2131362329(0x7f0a0219, float:1.8344436E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0193
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Clip r4 = r8.G0
            if (r4 == 0) goto L_0x018f
            java.lang.String r4 = r4.getGameName()
            r9.setText(r4)
            u6.a r4 = new u6.a
            r5 = 4
            r4.<init>(r8, r5)
            r9.setOnClickListener(r4)
            goto L_0x0193
        L_0x018f:
            xa.j.l(r3)
            throw r10
        L_0x0193:
            androidx.fragment.app.f0 r9 = r8.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r9 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r9
            com.github.andreyasadchy.xtra.model.Account$Companion r4 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r9 = r4.get(r9)
            android.content.SharedPreferences r4 = r8.t0()
            java.lang.String r5 = "ui_follow_button"
            java.lang.String r6 = "0"
            java.lang.String r4 = r4.getString(r5, r6)
            if (r4 == 0) goto L_0x01b2
            int r4 = java.lang.Integer.parseInt(r4)
            goto L_0x01b3
        L_0x01b2:
            r4 = 0
        L_0x01b3:
            android.content.SharedPreferences r5 = r8.t0()
            java.lang.String r6 = "player_follow"
            boolean r5 = r5.getBoolean(r6, r2)
            if (r5 == 0) goto L_0x021d
            if (r4 != 0) goto L_0x01d4
            int r5 = r9.getId()
            com.github.andreyasadchy.xtra.model.ui.Clip r6 = r8.G0
            if (r6 == 0) goto L_0x01d0
            int r6 = r6.getChannelId()
            if (r5 != r6) goto L_0x01e8
            goto L_0x01d4
        L_0x01d0:
            xa.j.l(r3)
            throw r10
        L_0x01d4:
            java.lang.String r9 = r9.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = r8.G0
            if (r5 == 0) goto L_0x0219
            java.lang.String r5 = r5.getChannelSlug()
            boolean r9 = xa.j.a(r9, r5)
            if (r9 == 0) goto L_0x01e8
            if (r4 != r2) goto L_0x021d
        L_0x01e8:
            android.view.View r9 = r8.h0()
            r2 = 2131362335(0x7f0a021f, float:1.8344448E38)
            android.view.View r9 = r9.findViewById(r2)
            android.widget.ImageButton r9 = (android.widget.ImageButton) r9
            if (r9 == 0) goto L_0x01fa
            r9.setVisibility(r0)
        L_0x01fa:
            xa.q r0 = new xa.q
            r0.<init>()
            com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel r2 = r8.v0()
            androidx.lifecycle.o0 r2 = r2.f14609j
            androidx.fragment.app.y1 r4 = r8.C()
            j3.m2 r5 = new j3.m2
            r6 = 10
            r5.<init>(r0, r8, r9, r6)
            androidx.lifecycle.v1 r9 = new androidx.lifecycle.v1
            r9.<init>(r1, r5)
            r2.f(r4, r9)
            goto L_0x021d
        L_0x0219:
            xa.j.l(r3)
            throw r10
        L_0x021d:
            androidx.fragment.app.c1 r9 = r8.u()
            r0 = 2131361958(0x7f0a00a6, float:1.8343683E38)
            androidx.fragment.app.c0 r9 = r9.D(r0)
            if (r9 != 0) goto L_0x0283
            androidx.fragment.app.c1 r9 = r8.u()
            r9.getClass()
            androidx.fragment.app.a r1 = new androidx.fragment.app.a
            r1.<init>((androidx.fragment.app.c1) r9)
            i6.a r9 = i6.e.f8314q0
            com.github.andreyasadchy.xtra.model.ui.Clip r2 = r8.G0
            if (r2 == 0) goto L_0x027f
            int r2 = r2.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Clip r4 = r8.G0
            if (r4 == 0) goto L_0x027b
            java.lang.String r4 = r4.getChannelSlug()
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = r8.G0
            if (r5 == 0) goto L_0x0277
            java.lang.String r5 = r5.getVideoId()
            com.github.andreyasadchy.xtra.model.ui.Clip r6 = r8.G0
            if (r6 == 0) goto L_0x0273
            java.lang.Integer r3 = r6.getVodOffset()
            if (r3 == 0) goto L_0x0264
            int r3 = r3.intValue()
            double r6 = (double) r3
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            goto L_0x0265
        L_0x0264:
            r3 = r10
        L_0x0265:
            r9.getClass()
            i6.e r9 = i6.a.b(r2, r4, r5, r3)
            r1.e(r0, r9, r10)
            r1.g()
            goto L_0x0283
        L_0x0273:
            xa.j.l(r3)
            throw r10
        L_0x0277:
            xa.j.l(r3)
            throw r10
        L_0x027b:
            xa.j.l(r3)
            throw r10
        L_0x027f:
            xa.j.l(r3)
            throw r10
        L_0x0283:
            return
        L_0x0284:
            xa.j.l(r3)
            throw r10
        L_0x0288:
            xa.j.l(r3)
            throw r10
        L_0x028c:
            xa.j.l(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.d.Z(android.view.View, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r2 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r4 = this;
            com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel r0 = r4.v0()
            androidx.lifecycle.o0 r0 = r0.f14608i
            java.lang.Object r0 = r0.d()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0032
            h3.b0 r0 = r4.s0()
            if (r0 == 0) goto L_0x0032
            h3.f4 r1 = new h3.f4
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            java.lang.String r3 = "getUrls"
            r1.<init>(r2, r3)
            h9.e0 r0 = r0.T0(r1, r2)
            if (r0 == 0) goto L_0x0032
            r3.b0 r1 = new r3.b0
            r2 = 4
            r1.<init>(r0, r2, r4)
            h9.q r2 = h9.q.f7765h
            r0.a(r1, r2)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.d.b():void");
    }

    public final double j() {
        nb.e eVar = p0.f7833a;
        return ((Number) h0.v1(u.f10886a, new c(this, (pa.e) null))).doubleValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r5 == r6.getChannelId()) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m0() {
        /*
            r7 = this;
            super.m0()
            androidx.fragment.app.f0 r0 = r7.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r0 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r0
            com.github.andreyasadchy.xtra.model.Account$Companion r1 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r0 = r1.get(r0)
            android.content.SharedPreferences r1 = r7.t0()
            java.lang.String r2 = "ui_follow_button"
            java.lang.String r3 = "0"
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto L_0x0022
            int r1 = java.lang.Integer.parseInt(r1)
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            android.content.SharedPreferences r2 = r7.t0()
            java.lang.String r3 = "player_follow"
            r4 = 1
            boolean r2 = r2.getBoolean(r3, r4)
            if (r2 == 0) goto L_0x0083
            r2 = 0
            java.lang.String r3 = "clip"
            if (r1 != 0) goto L_0x0048
            int r5 = r0.getId()
            com.github.andreyasadchy.xtra.model.ui.Clip r6 = r7.G0
            if (r6 == 0) goto L_0x0044
            int r6 = r6.getChannelId()
            if (r5 != r6) goto L_0x005c
            goto L_0x0048
        L_0x0044:
            xa.j.l(r3)
            throw r2
        L_0x0048:
            java.lang.String r0 = r0.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = r7.G0
            if (r5 == 0) goto L_0x007f
            java.lang.String r5 = r5.getChannelSlug()
            boolean r0 = xa.j.a(r0, r5)
            if (r0 == 0) goto L_0x005c
            if (r1 != r4) goto L_0x0083
        L_0x005c:
            com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel r0 = r7.v0()
            android.content.Context r1 = r7.f0()
            com.github.andreyasadchy.xtra.model.ui.Clip r4 = r7.G0
            if (r4 == 0) goto L_0x007b
            int r4 = r4.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Clip r5 = r7.G0
            if (r5 == 0) goto L_0x0077
            r5.getChannelSlug()
            r0.e(r4, r1)
            goto L_0x0083
        L_0x0077:
            xa.j.l(r3)
            throw r2
        L_0x007b:
            xa.j.l(r3)
            throw r2
        L_0x007f:
            xa.j.l(r3)
            throw r2
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.d.m0():void");
    }

    public final void n0() {
        b0 s02;
        if (I() && (s02 = s0()) != null) {
            s02.stop();
        }
    }

    public final void o0() {
        b0 s02;
        if (I() && (s02 = s0()) != null) {
            s02.e();
        }
    }

    public final int r0() {
        return this.H0;
    }

    public final void z0(d1 d1Var) {
        j.f("error", d1Var);
        Log.e(this.F, "Player error", d1Var);
    }
}
