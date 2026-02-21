package x6;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.c1;
import androidx.fragment.app.z1;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.media3.ui.AspectRatioFrameLayout;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import fb.w;
import h3.b0;
import h3.f4;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import hb.p0;
import i6.g;
import java.util.ArrayList;
import java.util.List;
import la.e;
import la.i;
import m6.r;
import mb.u;
import t6.v;
import xa.j;

public final class h extends a implements r, g, v {
    public static final d H0 = new d(0);
    public final x1 E0;
    public Video F0;
    public final int G0 = 5000;

    public h() {
        e t10 = android.support.v4.media.h.t(new z1(21, this), 13);
        this.E0 = h0.K(this, xa.v.a(VideoPlayerViewModel.class), new m(t10, 13), new n(t10, 13), new o(this, t10, 13));
    }

    public final void L0() {
        boolean z10;
        super.L0();
        Long valueOf = Long.valueOf((long) e0().getDouble("offset"));
        Video video = this.F0;
        if (video != null) {
            String animatedPreviewURL = video.getAnimatedPreviewURL();
            if (animatedPreviewURL == null || w.h(animatedPreviewURL)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                b0 s02 = s0();
                if (s02 != null) {
                    i[] iVarArr = new i[3];
                    Video video2 = this.F0;
                    if (video2 != null) {
                        iVarArr[0] = new i("item", video2);
                        iVarArr[1] = new i("usingPlaylist", Boolean.FALSE);
                        iVarArr[2] = new i("playbackPosition", valueOf);
                        s02.T0(new f4(h0.r(iVarArr), "startVideo"), Bundle.EMPTY);
                        return;
                    }
                    j.l("video");
                    throw null;
                }
                return;
            }
            VideoPlayerViewModel O0 = v0();
            Video video3 = this.F0;
            if (video3 != null) {
                h0.b1(h0.I0(O0), (pa.h) null, 0, new k(O0, video3.getUuid(), t0().getString("token_playertype_video", "channel_home_live"), (pa.e) null), 3);
                v0().f3449p.f(C(), new v1(17, new u1(this, 13, valueOf)));
                return;
            }
            j.l("video");
            throw null;
        }
        j.l("video");
        throw null;
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        Parcelable parcelable = e0().getParcelable("video");
        j.c(parcelable);
        this.F0 = (Video) parcelable;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_player_video, viewGroup, false);
        int i10 = R.id.aspectRatioFrameLayout;
        if (((AspectRatioFrameLayout) a.a(inflate, R.id.aspectRatioFrameLayout)) != null) {
            i10 = R.id.chatFragmentContainer;
            if (((FrameLayout) a.a(inflate, R.id.chatFragmentContainer)) != null) {
                i10 = R.id.playerView;
                if (((CustomPlayerView) a.a(inflate, R.id.playerView)) != null) {
                    SlidingLayout slidingLayout = (SlidingLayout) inflate;
                    j.d("null cannot be cast to non-null type android.widget.LinearLayout", slidingLayout);
                    slidingLayout.setOrientation(this.f14628o0 ? 1 : 0);
                    j.e("binding.root", slidingLayout);
                    return slidingLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    /* renamed from: O0 */
    public final VideoPlayerViewModel v0() {
        return (VideoPlayerViewModel) this.E0.getValue();
    }

    public final void P0() {
        List list = (List) v0().f3451r.d();
        if (list != null) {
            s7.g gVar = s7.g.f14374a;
            c1 u10 = u();
            j.e("childFragmentManager", u10);
            gVar.getClass();
            t6.w.f14668w0.getClass();
            t6.w wVar = new t6.w();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("games_list", new ArrayList(list));
            wVar.j0(bundle);
            wVar.q0(u10, "closeOnPip");
        }
    }

    public final void Q() {
        super.Q();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0200, code lost:
        if (r5 == r6.getChannelId()) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0219, code lost:
        if (r4 != 1) goto L_0x0250;
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
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r10 = r8.v0()
            androidx.lifecycle.o0 r10 = r10.f14608i
            androidx.fragment.app.y1 r6 = r8.C()
            j3.i0 r7 = new j3.i0
            r5 = 2
            r0 = r7
            r2 = r9
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.lifecycle.v1 r0 = new androidx.lifecycle.v1
            r1 = 17
            r0.<init>(r1, r7)
            r10.f(r6, r0)
            android.content.Context r10 = r8.f0()
            android.content.SharedPreferences r10 = hb.h0.l1(r10)
            java.lang.String r0 = "player_menu_bookmark"
            r2 = 1
            boolean r10 = r10.getBoolean(r0, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0077
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r10 = r8.v0()
            androidx.lifecycle.o0 r10 = r10.f3450q
            androidx.fragment.app.y1 r3 = r8.C()
            x6.g r4 = new x6.g
            r4.<init>(r8, r0)
            androidx.lifecycle.v1 r5 = new androidx.lifecycle.v1
            r5.<init>(r1, r4)
            r10.f(r3, r5)
        L_0x0077:
            android.content.SharedPreferences r10 = r8.t0()
            java.lang.String r3 = "player_menu"
            boolean r10 = r10.getBoolean(r3, r2)
            if (r10 == 0) goto L_0x009d
            android.view.View r10 = r8.h0()
            r3 = 2131362338(0x7f0a0222, float:1.8344454E38)
            android.view.View r10 = r10.findViewById(r3)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            if (r10 == 0) goto L_0x009d
            r10.setVisibility(r0)
            x6.b r3 = new x6.b
            r3.<init>(r8, r0)
            r10.setOnClickListener(r3)
        L_0x009d:
            android.content.SharedPreferences r10 = r8.t0()
            java.lang.String r3 = "player_download"
            boolean r10 = r10.getBoolean(r3, r0)
            if (r10 == 0) goto L_0x00b6
            if (r9 == 0) goto L_0x00b6
            r9.setVisibility(r0)
            x6.b r10 = new x6.b
            r10.<init>(r8, r2)
            r9.setOnClickListener(r10)
        L_0x00b6:
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r10 = "player_gamesbutton"
            boolean r9 = r9.getBoolean(r10, r2)
            r10 = 0
            java.lang.String r3 = "video"
            if (r9 != 0) goto L_0x00d1
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_menu_games"
            boolean r9 = r9.getBoolean(r4, r0)
            if (r9 == 0) goto L_0x00fe
        L_0x00d1:
            com.github.andreyasadchy.xtra.model.ui.Video r9 = r8.F0
            if (r9 == 0) goto L_0x02ac
            java.lang.String r9 = r9.getUuid()
            if (r9 == 0) goto L_0x00e4
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x00e2
            goto L_0x00e4
        L_0x00e2:
            r9 = 0
            goto L_0x00e5
        L_0x00e4:
            r9 = 1
        L_0x00e5:
            if (r9 != 0) goto L_0x00fe
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r9 = r8.v0()
            androidx.lifecycle.o0 r9 = r9.f3451r
            androidx.fragment.app.y1 r4 = r8.C()
            x6.g r5 = new x6.g
            r5.<init>(r8, r2)
            androidx.lifecycle.v1 r6 = new androidx.lifecycle.v1
            r6.<init>(r1, r5)
            r9.f(r4, r6)
        L_0x00fe:
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_channel"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x0135
            android.view.View r9 = r8.h0()
            r4 = 2131362330(0x7f0a021a, float:1.8344438E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0135
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Video r4 = r8.F0
            if (r4 == 0) goto L_0x0131
            java.lang.String r4 = r4.getChannelName()
            r9.setText(r4)
            x6.b r4 = new x6.b
            r5 = 2
            r4.<init>(r8, r5)
            r9.setOnClickListener(r4)
            goto L_0x0135
        L_0x0131:
            xa.j.l(r3)
            throw r10
        L_0x0135:
            com.github.andreyasadchy.xtra.model.ui.Video r9 = r8.F0
            if (r9 == 0) goto L_0x02a8
            java.lang.String r9 = r9.getTitle()
            if (r9 == 0) goto L_0x0148
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r9 = 0
            goto L_0x0149
        L_0x0148:
            r9 = 1
        L_0x0149:
            if (r9 != 0) goto L_0x0179
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_title"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x0179
            android.view.View r9 = r8.h0()
            r4 = 2131362347(0x7f0a022b, float:1.8344472E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0179
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Video r4 = r8.F0
            if (r4 == 0) goto L_0x0175
            java.lang.String r4 = r4.getTitle()
            r9.setText(r4)
            goto L_0x0179
        L_0x0175:
            xa.j.l(r3)
            throw r10
        L_0x0179:
            com.github.andreyasadchy.xtra.model.ui.Video r9 = r8.F0
            if (r9 == 0) goto L_0x02a4
            java.lang.String r9 = r9.getGameName()
            if (r9 == 0) goto L_0x018c
            boolean r9 = fb.w.h(r9)
            if (r9 == 0) goto L_0x018a
            goto L_0x018c
        L_0x018a:
            r9 = 0
            goto L_0x018d
        L_0x018c:
            r9 = 1
        L_0x018d:
            if (r9 != 0) goto L_0x01c6
            android.content.SharedPreferences r9 = r8.t0()
            java.lang.String r4 = "player_category"
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 == 0) goto L_0x01c6
            android.view.View r9 = r8.h0()
            r4 = 2131362329(0x7f0a0219, float:1.8344436E38)
            android.view.View r9 = r9.findViewById(r4)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x01c6
            r9.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Video r4 = r8.F0
            if (r4 == 0) goto L_0x01c2
            java.lang.String r4 = r4.getGameName()
            r9.setText(r4)
            x6.b r4 = new x6.b
            r5 = 3
            r4.<init>(r8, r5)
            r9.setOnClickListener(r4)
            goto L_0x01c6
        L_0x01c2:
            xa.j.l(r3)
            throw r10
        L_0x01c6:
            androidx.fragment.app.f0 r9 = r8.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r9 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r9
            com.github.andreyasadchy.xtra.model.Account$Companion r4 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r9 = r4.get(r9)
            android.content.SharedPreferences r4 = r8.t0()
            java.lang.String r5 = "ui_follow_button"
            java.lang.String r6 = "0"
            java.lang.String r4 = r4.getString(r5, r6)
            if (r4 == 0) goto L_0x01e5
            int r4 = java.lang.Integer.parseInt(r4)
            goto L_0x01e6
        L_0x01e5:
            r4 = 0
        L_0x01e6:
            android.content.SharedPreferences r5 = r8.t0()
            java.lang.String r6 = "player_follow"
            boolean r5 = r5.getBoolean(r6, r2)
            if (r5 == 0) goto L_0x0250
            if (r4 != 0) goto L_0x0207
            int r5 = r9.getId()
            com.github.andreyasadchy.xtra.model.ui.Video r6 = r8.F0
            if (r6 == 0) goto L_0x0203
            int r6 = r6.getChannelId()
            if (r5 != r6) goto L_0x021b
            goto L_0x0207
        L_0x0203:
            xa.j.l(r3)
            throw r10
        L_0x0207:
            java.lang.String r9 = r9.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Video r5 = r8.F0
            if (r5 == 0) goto L_0x024c
            java.lang.String r5 = r5.getChannelSlug()
            boolean r9 = xa.j.a(r9, r5)
            if (r9 == 0) goto L_0x021b
            if (r4 != r2) goto L_0x0250
        L_0x021b:
            android.view.View r9 = r8.h0()
            r2 = 2131362335(0x7f0a021f, float:1.8344448E38)
            android.view.View r9 = r9.findViewById(r2)
            android.widget.ImageButton r9 = (android.widget.ImageButton) r9
            if (r9 == 0) goto L_0x022d
            r9.setVisibility(r0)
        L_0x022d:
            xa.q r0 = new xa.q
            r0.<init>()
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r2 = r8.v0()
            androidx.lifecycle.o0 r2 = r2.f14609j
            androidx.fragment.app.y1 r4 = r8.C()
            j3.m2 r5 = new j3.m2
            r6 = 13
            r5.<init>(r0, r8, r9, r6)
            androidx.lifecycle.v1 r9 = new androidx.lifecycle.v1
            r9.<init>(r1, r5)
            r2.f(r4, r9)
            goto L_0x0250
        L_0x024c:
            xa.j.l(r3)
            throw r10
        L_0x0250:
            androidx.fragment.app.c1 r9 = r8.u()
            r0 = 2131361958(0x7f0a00a6, float:1.8343683E38)
            androidx.fragment.app.c0 r9 = r9.D(r0)
            if (r9 != 0) goto L_0x02a3
            androidx.fragment.app.c1 r9 = r8.u()
            r9.getClass()
            androidx.fragment.app.a r1 = new androidx.fragment.app.a
            r1.<init>((androidx.fragment.app.c1) r9)
            i6.a r9 = i6.e.f8314q0
            com.github.andreyasadchy.xtra.model.ui.Video r2 = r8.F0
            if (r2 == 0) goto L_0x029f
            int r2 = r2.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Video r4 = r8.F0
            if (r4 == 0) goto L_0x029b
            java.lang.String r4 = r4.getChannelSlug()
            com.github.andreyasadchy.xtra.model.ui.Video r5 = r8.F0
            if (r5 == 0) goto L_0x0297
            java.lang.String r3 = r5.getUuid()
            r5 = 0
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r9.getClass()
            i6.e r9 = i6.a.b(r2, r4, r3, r5)
            r1.e(r0, r9, r10)
            r1.g()
            goto L_0x02a3
        L_0x0297:
            xa.j.l(r3)
            throw r10
        L_0x029b:
            xa.j.l(r3)
            throw r10
        L_0x029f:
            xa.j.l(r3)
            throw r10
        L_0x02a3:
            return
        L_0x02a4:
            xa.j.l(r3)
            throw r10
        L_0x02a8:
            xa.j.l(r3)
            throw r10
        L_0x02ac:
            xa.j.l(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.h.Z(android.view.View, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r2 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r4 = this;
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r0 = r4.v0()
            androidx.lifecycle.o0 r0 = r0.f14608i
            java.lang.Object r0 = r0.d()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0032
            h3.b0 r0 = r4.s0()
            if (r0 == 0) goto L_0x0032
            h3.f4 r1 = new h3.f4
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            java.lang.String r3 = "getVideoDownloadInfo"
            r1.<init>(r2, r3)
            h9.e0 r0 = r0.T0(r1, r2)
            if (r0 == 0) goto L_0x0032
            x6.c r1 = new x6.c
            r2 = 0
            r1.<init>(r0, r4, r2)
            h9.q r2 = h9.q.f7765h
            r0.a(r1, r2)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.h.b():void");
    }

    public final double j() {
        nb.e eVar = p0.f7833a;
        return ((Number) h0.v1(u.f10886a, new e(this, (pa.e) null))).doubleValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r3 == r7.getChannelId()) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r1 != 1) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m0() {
        /*
            r8 = this;
            super.m0()
            androidx.fragment.app.f0 r0 = r8.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r0 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r0
            com.github.andreyasadchy.xtra.model.Account$Companion r1 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r0 = r1.get(r0)
            android.content.SharedPreferences r1 = r8.t0()
            java.lang.String r2 = "ui_follow_button"
            java.lang.String r3 = "0"
            java.lang.String r1 = r1.getString(r2, r3)
            r2 = 0
            if (r1 == 0) goto L_0x0023
            int r1 = java.lang.Integer.parseInt(r1)
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            android.content.SharedPreferences r3 = r8.t0()
            java.lang.String r4 = "player_follow"
            r5 = 1
            boolean r3 = r3.getBoolean(r4, r5)
            r4 = 0
            java.lang.String r6 = "video"
            if (r3 == 0) goto L_0x0084
            if (r1 != 0) goto L_0x0049
            int r3 = r0.getId()
            com.github.andreyasadchy.xtra.model.ui.Video r7 = r8.F0
            if (r7 == 0) goto L_0x0045
            int r7 = r7.getChannelId()
            if (r3 != r7) goto L_0x005d
            goto L_0x0049
        L_0x0045:
            xa.j.l(r6)
            throw r4
        L_0x0049:
            java.lang.String r0 = r0.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Video r3 = r8.F0
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = r3.getChannelSlug()
            boolean r0 = xa.j.a(r0, r3)
            if (r0 == 0) goto L_0x005d
            if (r1 != r5) goto L_0x0084
        L_0x005d:
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r0 = r8.v0()
            android.content.Context r1 = r8.f0()
            com.github.andreyasadchy.xtra.model.ui.Video r3 = r8.F0
            if (r3 == 0) goto L_0x007c
            int r3 = r3.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Video r7 = r8.F0
            if (r7 == 0) goto L_0x0078
            r7.getChannelSlug()
            r0.e(r3, r1)
            goto L_0x0084
        L_0x0078:
            xa.j.l(r6)
            throw r4
        L_0x007c:
            xa.j.l(r6)
            throw r4
        L_0x0080:
            xa.j.l(r6)
            throw r4
        L_0x0084:
            android.content.SharedPreferences r0 = r8.t0()
            java.lang.String r1 = "player_gamesbutton"
            boolean r0 = r0.getBoolean(r1, r5)
            if (r0 != 0) goto L_0x009c
            android.content.SharedPreferences r0 = r8.t0()
            java.lang.String r1 = "player_menu_games"
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto L_0x00d6
        L_0x009c:
            com.github.andreyasadchy.xtra.model.ui.Video r0 = r8.F0
            if (r0 == 0) goto L_0x00d7
            java.lang.String r0 = r0.getUuid()
            if (r0 == 0) goto L_0x00ae
            boolean r0 = fb.w.h(r0)
            if (r0 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r5 = 0
        L_0x00ae:
            if (r5 != 0) goto L_0x00d6
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r0 = r8.v0()
            com.github.andreyasadchy.xtra.model.ui.Video r1 = r8.F0
            if (r1 == 0) goto L_0x00d2
            java.lang.String r1 = r1.getUuid()
            androidx.lifecycle.o0 r3 = r0.f3451r
            boolean r3 = r3.e()
            if (r3 != 0) goto L_0x00d6
            hb.f0 r3 = hb.h0.I0(r0)
            x6.l r5 = new x6.l
            r5.<init>(r0, r1, r4)
            r0 = 3
            hb.h0.b1(r3, r4, r2, r5, r0)
            goto L_0x00d6
        L_0x00d2:
            xa.j.l(r6)
            throw r4
        L_0x00d6:
            return
        L_0x00d7:
            xa.j.l(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.h.m0():void");
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

    public final void q() {
        Long e10;
        if (t0().getBoolean("player_use_videopositions", true)) {
            Video video = this.F0;
            if (video != null) {
                String uuid = video.getUuid();
                if (!(uuid == null || (e10 = fb.v.e(uuid)) == null)) {
                    long longValue = e10.longValue();
                    b0 s02 = s0();
                    if (s02 != null) {
                        long j10 = s02.j();
                        VideoPlayerViewModel O0 = v0();
                        O0.getClass();
                        O0.f3447n.d(new VideoPosition(longValue, j10));
                    }
                }
            } else {
                j.l("video");
                throw null;
            }
        }
        super.q();
    }

    public final int r0() {
        return this.G0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(g1.d1 r4) {
        /*
            r3 = this;
            java.lang.String r0 = "error"
            xa.j.f(r0, r4)
            java.lang.String r0 = r3.F
            java.lang.String r1 = "Player error"
            android.util.Log.e(r0, r1, r4)
            h3.b0 r4 = r3.s0()
            if (r4 == 0) goto L_0x002c
            h3.f4 r0 = new h3.f4
            android.os.Bundle r1 = android.os.Bundle.EMPTY
            java.lang.String r2 = "getErrorCode"
            r0.<init>(r1, r2)
            h9.e0 r4 = r4.T0(r0, r1)
            if (r4 == 0) goto L_0x002c
            x6.c r0 = new x6.c
            r1 = 1
            r0.<init>(r4, r3, r1)
            h9.q r1 = h9.q.f7765h
            r4.a(r0, r1)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.h.z0(g1.d1):void");
    }
}
