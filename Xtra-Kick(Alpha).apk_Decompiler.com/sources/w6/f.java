package w6;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.c1;
import androidx.fragment.app.z1;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.media3.ui.AspectRatioFrameLayout;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.model.ui.BroadcastSettings;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.woxthebox.draglistview.R;
import e4.a;
import e6.x;
import fb.w;
import fb.y;
import h3.b0;
import h3.f4;
import h6.b;
import h6.m;
import h6.n;
import h6.o;
import h9.e0;
import h9.q;
import hb.f0;
import hb.h0;
import i6.e;
import la.i;
import s7.g;
import t6.a0;
import t6.o0;
import wa.p;
import xa.j;
import xa.v;

public final class f extends a {
    public static final d H0 = new d(0);
    public final x1 E0;
    public e F0;
    public Stream G0;

    public f() {
        la.e t10 = h.t(new z1(20, this), 12);
        this.E0 = h0.K(this, v.a(StreamPlayerViewModel.class), new m(t10, 12), new n(t10, 12), new o(this, t10, 12));
    }

    public final void L0() {
        p pVar;
        f0 f0Var;
        super.L0();
        if (v0().f3445o.d() == null) {
            StreamPlayerViewModel Q0 = v0();
            Stream stream = this.G0;
            if (stream != null) {
                Q0.f3445o.l(stream);
                Stream stream2 = this.G0;
                if (stream2 != null) {
                    R0(stream2);
                    StreamPlayerViewModel Q02 = v0();
                    Context f02 = f0();
                    Stream stream3 = this.G0;
                    if (stream3 != null) {
                        Account account = Account.Companion.get(f02);
                        if (h0.l1(f02).getBoolean("chat_disable", false) || account.getId() != 0) {
                            f0Var = h0.I0(Q02);
                            pVar = new i(Q02, f02, stream3, (pa.e) null);
                        } else if (stream3.getViewerCount() == null) {
                            f0Var = h0.I0(Q02);
                            pVar = new j(Q02, f02, stream3, (pa.e) null);
                        } else {
                            return;
                        }
                        h0.b1(f0Var, (pa.h) null, 0, pVar, 3);
                        return;
                    }
                    j.l("stream");
                    throw null;
                }
                j.l("stream");
                throw null;
            }
            j.l("stream");
            throw null;
        }
    }

    public final void N(Bundle bundle) {
        super.N(bundle);
        Parcelable parcelable = e0().getParcelable("stream");
        j.c(parcelable);
        this.G0 = (Stream) parcelable;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_player_stream, viewGroup, false);
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

    public final boolean O0() {
        k5.a aVar = P0().f8315o0;
        j.c(aVar);
        return ((ChatView) aVar.f9125j).o();
    }

    public final e P0() {
        e eVar = this.F0;
        if (eVar != null) {
            return eVar;
        }
        j.l("chatFragment");
        throw null;
    }

    public final void Q() {
        super.Q();
    }

    /* renamed from: Q0 */
    public final StreamPlayerViewModel v0() {
        return (StreamPlayerViewModel) this.E0.getValue();
    }

    public final void R0(Stream stream) {
        b0 s02 = s0();
        if (s02 != null) {
            s02.e();
        }
        try {
            String channelSlug = stream.getChannelSlug();
            if (channelSlug != null) {
                StreamPlayerViewModel Q0 = v0();
                h0.b1(h0.I0(Q0), (pa.h) null, 0, new h(Q0, channelSlug, (pa.e) null), 3);
            }
            v0().f3446p.f(C(), new v1(16, new u1(this, 12, stream)));
        } catch (Exception unused) {
            h0.X1(f0(), R.string.error_stream);
        }
    }

    public final void S0() {
        Stream stream = this.G0;
        if (stream != null) {
            String channelSlug = stream.getChannelSlug();
            if (channelSlug != null) {
                g gVar = g.f14374a;
                c1 u10 = u();
                j.e("childFragmentManager", u10);
                x xVar = v0().f14603d;
                gVar.getClass();
                j.f("repository", xVar);
                o0.J0.getClass();
                o0 o0Var = new o0(xVar);
                o0Var.j0(h0.r(new i("login", channelSlug)));
                o0Var.q0(u10, "closeOnPip");
                return;
            }
            return;
        }
        j.l("stream");
        throw null;
    }

    public final void T0() {
        if (v0().f14607h != a0.DISABLED) {
            Stream stream = this.G0;
            if (stream != null) {
                R0(stream);
            } else {
                j.l("stream");
                throw null;
            }
        }
    }

    public final void U0(boolean z10) {
        b0 s02 = s0();
        if (s02 != null) {
            String str = z10 ? "getMediaPlaylist" : "getMultivariantPlaylist";
            Bundle bundle = Bundle.EMPTY;
            e0 T0 = s02.T0(new f4(bundle, str), bundle);
            if (T0 != null) {
                T0.a(new c(T0, this, 0), q.f7765h);
            }
        }
    }

    public final void V0(BroadcastSettings broadcastSettings) {
        if (broadcastSettings != null) {
            TextView textView = (TextView) h0().findViewById(R.id.playerTitle);
            boolean z10 = false;
            if (textView != null) {
                String title = broadcastSettings.getTitle();
                if ((title == null || w.h(title)) || !t0().getBoolean("player_title", true)) {
                    textView.setText((CharSequence) null);
                    h0.J0(textView);
                } else {
                    textView.setText(y.R(broadcastSettings.getTitle()).toString());
                    h0.b2(textView);
                }
            }
            TextView textView2 = (TextView) h0().findViewById(R.id.playerCategory);
            if (textView2 != null) {
                String gameName = broadcastSettings.getGameName();
                if (gameName == null || w.h(gameName)) {
                    z10 = true;
                }
                if (z10 || !t0().getBoolean("player_category", true)) {
                    textView2.setText((CharSequence) null);
                    h0.J0(textView2);
                    return;
                }
                textView2.setText(broadcastSettings.getGameName());
                h0.b2(textView2);
                textView2.setOnClickListener(new b(this, 10, broadcastSettings));
            }
        }
    }

    public final void W0(Integer num) {
        TextView textView = (TextView) h0().findViewById(R.id.viewers);
        ImageView imageView = (ImageView) h0().findViewById(R.id.viewerIcon);
        if (num != null) {
            if (textView != null) {
                s7.h hVar = s7.h.f14375a;
                Context f02 = f0();
                int intValue = num.intValue();
                hVar.getClass();
                textView.setText(s7.h.a(f02, intValue));
            }
            if (t0().getBoolean("player_viewericon", true) && imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (imageView != null) {
            h0.J0(imageView);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0194, code lost:
        if (r5 == r6.getChannelId()) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ad, code lost:
        if (r4 != 1) goto L_0x01e4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r0 = "view"
            xa.j.f(r0, r13)
            super.Z(r13, r14)
            android.view.View r13 = r12.h0()
            r14 = 2131362343(0x7f0a0227, float:1.8344464E38)
            android.view.View r13 = r13.findViewById(r14)
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            android.view.View r14 = r12.h0()
            r0 = 2131362340(0x7f0a0224, float:1.8344458E38)
            android.view.View r14 = r14.findViewById(r0)
            android.widget.ImageButton r14 = (android.widget.ImageButton) r14
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r0 = r12.v0()
            androidx.lifecycle.o0 r0 = r0.f14608i
            androidx.fragment.app.y1 r1 = r12.C()
            j3.m2 r2 = new j3.m2
            r3 = 11
            r2.<init>(r13, r14, r12, r3)
            androidx.lifecycle.v1 r13 = new androidx.lifecycle.v1
            r14 = 16
            r13.<init>(r14, r2)
            r0.f(r1, r13)
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r13 = r12.v0()
            androidx.lifecycle.o0 r13 = r13.f3445o
            androidx.fragment.app.y1 r0 = r12.C()
            androidx.fragment.app.k r1 = new androidx.fragment.app.k
            r2 = 14
            r1.<init>(r2, r12)
            androidx.lifecycle.v1 r2 = new androidx.lifecycle.v1
            r2.<init>(r14, r1)
            r13.f(r0, r2)
            android.content.SharedPreferences r13 = r12.t0()
            java.lang.String r0 = "player_menu"
            r1 = 1
            boolean r13 = r13.getBoolean(r0, r1)
            r0 = 0
            if (r13 == 0) goto L_0x007e
            android.view.View r13 = r12.h0()
            r2 = 2131362338(0x7f0a0222, float:1.8344454E38)
            android.view.View r13 = r13.findViewById(r2)
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            if (r13 == 0) goto L_0x007e
            r13.setVisibility(r0)
            w6.b r2 = new w6.b
            r2.<init>(r12, r0)
            r13.setOnClickListener(r2)
        L_0x007e:
            android.content.SharedPreferences r13 = r12.t0()
            java.lang.String r2 = "player_restart"
            boolean r13 = r13.getBoolean(r2, r1)
            if (r13 == 0) goto L_0x00a4
            android.view.View r13 = r12.h0()
            r2 = 2131362341(0x7f0a0225, float:1.834446E38)
            android.view.View r13 = r13.findViewById(r2)
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            if (r13 == 0) goto L_0x00a4
            r13.setVisibility(r0)
            w6.b r2 = new w6.b
            r2.<init>(r12, r1)
            r13.setOnClickListener(r2)
        L_0x00a4:
            android.content.SharedPreferences r13 = r12.t0()
            java.lang.String r2 = "player_seeklive"
            boolean r13 = r13.getBoolean(r2, r0)
            if (r13 == 0) goto L_0x00cb
            android.view.View r13 = r12.h0()
            r2 = 2131362342(0x7f0a0226, float:1.8344462E38)
            android.view.View r13 = r13.findViewById(r2)
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            if (r13 == 0) goto L_0x00cb
            r13.setVisibility(r0)
            w6.b r2 = new w6.b
            r3 = 2
            r2.<init>(r12, r3)
            r13.setOnClickListener(r2)
        L_0x00cb:
            android.content.SharedPreferences r13 = r12.t0()
            java.lang.String r2 = "player_viewerlist"
            boolean r13 = r13.getBoolean(r2, r0)
            if (r13 == 0) goto L_0x00ef
            android.view.View r13 = r12.h0()
            r2 = 2131362607(0x7f0a032f, float:1.8345E38)
            android.view.View r13 = r13.findViewById(r2)
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00ef
            w6.b r2 = new w6.b
            r3 = 3
            r2.<init>(r12, r3)
            r13.setOnClickListener(r2)
        L_0x00ef:
            android.content.SharedPreferences r13 = r12.t0()
            java.lang.String r2 = "player_channel"
            boolean r13 = r13.getBoolean(r2, r1)
            r2 = 0
            java.lang.String r3 = "stream"
            if (r13 == 0) goto L_0x0129
            android.view.View r13 = r12.h0()
            r4 = 2131362330(0x7f0a021a, float:1.8344438E38)
            android.view.View r13 = r13.findViewById(r4)
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0129
            r13.setVisibility(r0)
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x0125
            java.lang.String r4 = r4.getChannelName()
            r13.setText(r4)
            w6.b r4 = new w6.b
            r5 = 4
            r4.<init>(r12, r5)
            r13.setOnClickListener(r4)
            goto L_0x0129
        L_0x0125:
            xa.j.l(r3)
            throw r2
        L_0x0129:
            com.github.andreyasadchy.xtra.model.ui.BroadcastSettings r13 = new com.github.andreyasadchy.xtra.model.ui.BroadcastSettings
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x0252
            java.lang.String r7 = r4.getTitle()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x024e
            java.lang.String r8 = r4.getGameName()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x024a
            int r9 = r4.getGameId()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x0246
            java.lang.String r10 = r4.getGameSlug()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x0242
            java.lang.String r11 = r4.getBoxArtUrl()
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            r12.V0(r13)
            androidx.fragment.app.f0 r13 = r12.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r13 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r13
            com.github.andreyasadchy.xtra.model.Account$Companion r4 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r13 = r4.get(r13)
            android.content.SharedPreferences r4 = r12.t0()
            java.lang.String r5 = "ui_follow_button"
            java.lang.String r6 = "0"
            java.lang.String r4 = r4.getString(r5, r6)
            if (r4 == 0) goto L_0x0179
            int r4 = java.lang.Integer.parseInt(r4)
            goto L_0x017a
        L_0x0179:
            r4 = 0
        L_0x017a:
            android.content.SharedPreferences r5 = r12.t0()
            java.lang.String r6 = "player_follow"
            boolean r5 = r5.getBoolean(r6, r1)
            if (r5 == 0) goto L_0x01e4
            if (r4 != 0) goto L_0x019b
            int r5 = r13.getId()
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = r12.G0
            if (r6 == 0) goto L_0x0197
            int r6 = r6.getChannelId()
            if (r5 != r6) goto L_0x01af
            goto L_0x019b
        L_0x0197:
            xa.j.l(r3)
            throw r2
        L_0x019b:
            java.lang.String r13 = r13.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Stream r5 = r12.G0
            if (r5 == 0) goto L_0x01e0
            java.lang.String r5 = r5.getChannelSlug()
            boolean r13 = xa.j.a(r13, r5)
            if (r13 == 0) goto L_0x01af
            if (r4 != r1) goto L_0x01e4
        L_0x01af:
            android.view.View r13 = r12.h0()
            r1 = 2131362335(0x7f0a021f, float:1.8344448E38)
            android.view.View r13 = r13.findViewById(r1)
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            if (r13 == 0) goto L_0x01c1
            r13.setVisibility(r0)
        L_0x01c1:
            xa.q r0 = new xa.q
            r0.<init>()
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r1 = r12.v0()
            androidx.lifecycle.o0 r1 = r1.f14609j
            androidx.fragment.app.y1 r4 = r12.C()
            j3.m2 r5 = new j3.m2
            r6 = 12
            r5.<init>(r0, r12, r13, r6)
            androidx.lifecycle.v1 r13 = new androidx.lifecycle.v1
            r13.<init>(r14, r5)
            r1.f(r4, r13)
            goto L_0x01e4
        L_0x01e0:
            xa.j.l(r3)
            throw r2
        L_0x01e4:
            androidx.fragment.app.c1 r13 = r12.u()
            r14 = 2131361958(0x7f0a00a6, float:1.8343683E38)
            androidx.fragment.app.c0 r13 = r13.D(r14)
            if (r13 == 0) goto L_0x01f4
            i6.e r13 = (i6.e) r13
            goto L_0x022f
        L_0x01f4:
            i6.a r13 = i6.e.f8314q0
            com.github.andreyasadchy.xtra.model.ui.Stream r0 = r12.G0
            if (r0 == 0) goto L_0x023e
            int r0 = r0.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Stream r1 = r12.G0
            if (r1 == 0) goto L_0x023a
            java.lang.String r1 = r1.getChannelSlug()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r12.G0
            if (r4 == 0) goto L_0x0236
            java.lang.String r4 = r4.getChannelName()
            com.github.andreyasadchy.xtra.model.ui.Stream r5 = r12.G0
            if (r5 == 0) goto L_0x0232
            int r3 = r5.getId()
            r13.getClass()
            i6.e r13 = i6.a.a(r0, r3, r1, r4)
            androidx.fragment.app.c1 r0 = r12.u()
            r0.getClass()
            androidx.fragment.app.a r1 = new androidx.fragment.app.a
            r1.<init>((androidx.fragment.app.c1) r0)
            r1.e(r14, r13, r2)
            r1.g()
        L_0x022f:
            r12.F0 = r13
            return
        L_0x0232:
            xa.j.l(r3)
            throw r2
        L_0x0236:
            xa.j.l(r3)
            throw r2
        L_0x023a:
            xa.j.l(r3)
            throw r2
        L_0x023e:
            xa.j.l(r3)
            throw r2
        L_0x0242:
            xa.j.l(r3)
            throw r2
        L_0x0246:
            xa.j.l(r3)
            throw r2
        L_0x024a:
            xa.j.l(r3)
            throw r2
        L_0x024e:
            xa.j.l(r3)
            throw r2
        L_0x0252:
            xa.j.l(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.f.Z(android.view.View, android.os.Bundle):void");
    }

    public final void l() {
        super.l();
        e P0 = P0();
        k5.a aVar = P0.f8315o0;
        j.c(aVar);
        ChatView chatView = (ChatView) aVar.f9125j;
        j.e("binding.chatView", chatView);
        h0.P0(chatView);
        k5.a aVar2 = P0.f8315o0;
        j.c(aVar2);
        ((ChatView) aVar2.f9125j).clearFocus();
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
            java.lang.String r3 = "stream"
            if (r1 != 0) goto L_0x0048
            int r5 = r0.getId()
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = r7.G0
            if (r6 == 0) goto L_0x0044
            int r6 = r6.getChannelId()
            if (r5 != r6) goto L_0x005c
            goto L_0x0048
        L_0x0044:
            xa.j.l(r3)
            throw r2
        L_0x0048:
            java.lang.String r0 = r0.getLogin()
            com.github.andreyasadchy.xtra.model.ui.Stream r5 = r7.G0
            if (r5 == 0) goto L_0x007f
            java.lang.String r5 = r5.getChannelSlug()
            boolean r0 = xa.j.a(r0, r5)
            if (r0 == 0) goto L_0x005c
            if (r1 != r4) goto L_0x0083
        L_0x005c:
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r0 = r7.v0()
            android.content.Context r1 = r7.f0()
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = r7.G0
            if (r4 == 0) goto L_0x007b
            int r4 = r4.getChannelId()
            com.github.andreyasadchy.xtra.model.ui.Stream r5 = r7.G0
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
        throw new UnsupportedOperationException("Method not decompiled: w6.f.m0():void");
    }

    public final void o0() {
        if (I()) {
            T0();
        }
    }

    public final boolean q0() {
        return false;
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
            w6.c r0 = new w6.c
            r1 = 1
            r0.<init>(r4, r3, r1)
            h9.q r1 = h9.q.f7765h
            r4.a(r0, r1)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.f.z0(g1.d1):void");
    }
}
