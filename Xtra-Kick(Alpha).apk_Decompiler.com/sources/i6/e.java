package i6;

import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.fragment.app.z1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.woxthebox.draglistview.R;
import fb.w;
import h6.m;
import h6.n;
import h6.o;
import h6.r;
import h6.s;
import hb.h0;
import k5.a;
import n3.w1;
import r7.x;
import s7.i;
import t6.l;
import xa.j;
import xa.v;

public final class e extends d0 implements i, x {

    /* renamed from: q0  reason: collision with root package name */
    public static final a f8314q0 = new a(0);

    /* renamed from: o0  reason: collision with root package name */
    public a f8315o0;

    /* renamed from: p0  reason: collision with root package name */
    public final x1 f8316p0;

    public e() {
        la.e t10 = h.t(new z1(3, this), 1);
        this.f8316p0 = h0.K(this, v.a(ChatViewModel.class), new m(t10, 1), new n(t10, 1), new o(this, t10, 1));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.fragment_chat, viewGroup, false);
        if (inflate != null) {
            ChatView chatView = (ChatView) inflate;
            this.f8315o0 = new a((Object) chatView, 5, (Object) chatView);
            return chatView;
        }
        throw new NullPointerException("rootView");
    }

    public final void Q() {
        super.Q();
        this.f8315o0 = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r12, android.os.Bundle r13) {
        /*
            r11 = this;
            java.lang.String r13 = "view"
            xa.j.f(r13, r12)
            k5.a r12 = r11.f8315o0
            xa.j.c(r12)
            android.os.Bundle r13 = r11.e0()
            java.lang.String r0 = "channel_id"
            int r0 = r13.getInt(r0)
            java.lang.String r1 = "isLive"
            boolean r1 = r13.getBoolean(r1)
            com.github.andreyasadchy.xtra.model.Account$Companion r2 = com.github.andreyasadchy.xtra.model.Account.Companion
            android.content.Context r3 = r11.f0()
            com.github.andreyasadchy.xtra.model.Account r2 = r2.get(r3)
            java.lang.String r3 = r2.getLogin()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0035
            boolean r3 = fb.w.h(r3)
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            r3 = r3 ^ r5
            android.content.Context r6 = r11.f0()
            android.content.SharedPreferences r6 = hb.h0.l1(r6)
            java.lang.String r7 = "chat_disable"
            boolean r6 = r6.getBoolean(r7, r4)
            r7 = 4
            java.lang.String r8 = "chatView"
            r9 = 3
            if (r6 == 0) goto L_0x004d
            goto L_0x0111
        L_0x004d:
            if (r1 == 0) goto L_0x00e6
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            r13.r(r0, r11)
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r0 = r11.q0()
            r13.setCallback(r0)
            if (r3 == 0) goto L_0x00fd
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            java.lang.String r0 = r2.getLogin()
            r13.setUsername(r0)
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r0 = r11.q0()
            i6.h r0 = r0.f3368y
            boolean r2 = r0 instanceof i6.m
            r6 = 0
            if (r2 == 0) goto L_0x0080
            i6.m r0 = (i6.m) r0
            goto L_0x0081
        L_0x0080:
            r0 = r6
        L_0x0081:
            if (r0 == 0) goto L_0x008b
            java.util.concurrent.ConcurrentHashMap r0 = r0.f8328h
            if (r0 == 0) goto L_0x008b
            java.util.Collection r6 = r0.values()
        L_0x008b:
            r13.m(r6)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            la.o r13 = r13.f3352i
            java.lang.Object r13 = r13.getValue()
            androidx.lifecycle.k0 r13 = (androidx.lifecycle.k0) r13
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r2 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            xa.j.e(r8, r2)
            i6.c r6 = new i6.c
            r10 = 5
            r6.<init>(r10, r2)
            r13.f(r0, r6)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3353j
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r2 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            xa.j.e(r8, r2)
            i6.c r6 = new i6.c
            r10 = 6
            r6.<init>(r10, r2)
            r13.f(r0, r6)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            la.o r13 = r13.f3369z
            java.lang.Object r13 = r13.getValue()
            s7.l r13 = (s7.l) r13
            androidx.fragment.app.y1 r0 = r11.C()
            i6.d r2 = new i6.d
            r2.<init>(r12, r7)
            androidx.lifecycle.v1 r6 = new androidx.lifecycle.v1
            r6.<init>(r9, r2)
            r13.f(r0, r6)
            goto L_0x00fd
        L_0x00e6:
            java.lang.String r2 = "videoId"
            java.lang.String r2 = r13.getString(r2)
            if (r2 == 0) goto L_0x00ff
            java.lang.String r2 = "startTime_empty"
            boolean r13 = r13.getBoolean(r2)
            if (r13 != 0) goto L_0x00ff
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            r13.r(r0, r11)
        L_0x00fd:
            r13 = 1
            goto L_0x0112
        L_0x00ff:
            android.view.View r13 = r11.h0()
            r0 = 2131361959(0x7f0a00a7, float:1.8343685E38)
            android.view.View r13 = r13.findViewById(r0)
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0111
            r13.setVisibility(r4)
        L_0x0111:
            r13 = 0
        L_0x0112:
            if (r13 == 0) goto L_0x0253
            java.lang.Object r13 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r13 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r13
            if (r1 == 0) goto L_0x011e
            if (r3 == 0) goto L_0x011e
            r0 = 1
            goto L_0x011f
        L_0x011e:
            r0 = 0
        L_0x011f:
            r13.p(r0)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.d()
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r1 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r1 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r1
            xa.j.e(r8, r1)
            i6.c r2 = new i6.c
            r2.<init>(r4, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            la.o r13 = r13.f3367x
            java.lang.Object r13 = r13.getValue()
            androidx.lifecycle.o0 r13 = (androidx.lifecycle.o0) r13
            androidx.fragment.app.y1 r0 = r11.C()
            i6.d r1 = new i6.d
            r1.<init>(r12, r4)
            androidx.lifecycle.v1 r2 = new androidx.lifecycle.v1
            r2.<init>(r9, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3355l
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r1 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r1 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r1
            xa.j.e(r8, r1)
            i6.c r2 = new i6.c
            r2.<init>(r5, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3356m
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r1 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r1 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r1
            xa.j.e(r8, r1)
            i6.c r2 = new i6.c
            r3 = 2
            r2.<init>(r3, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3357n
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r1 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r1 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r1
            xa.j.e(r8, r1)
            i6.c r2 = new i6.c
            r2.<init>(r9, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3358o
            androidx.fragment.app.y1 r0 = r11.C()
            java.lang.Object r1 = r12.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r1 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r1
            xa.j.e(r8, r1)
            i6.c r2 = new i6.c
            r2.<init>(r7, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            androidx.lifecycle.o0 r13 = r13.f3359p
            androidx.fragment.app.y1 r0 = r11.C()
            i6.d r1 = new i6.d
            r1.<init>(r12, r5)
            androidx.lifecycle.v1 r2 = new androidx.lifecycle.v1
            r2.<init>(r9, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            s7.l r13 = r13.f()
            androidx.fragment.app.y1 r0 = r11.C()
            i6.d r1 = new i6.d
            r1.<init>(r12, r3)
            androidx.lifecycle.v1 r2 = new androidx.lifecycle.v1
            r2.<init>(r9, r1)
            r13.f(r0, r2)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r13 = r11.q0()
            la.o r13 = r13.f3363t
            java.lang.Object r13 = r13.getValue()
            s7.l r13 = (s7.l) r13
            androidx.fragment.app.y1 r0 = r11.C()
            i6.d r1 = new i6.d
            r1.<init>(r12, r9)
            androidx.lifecycle.v1 r12 = new androidx.lifecycle.v1
            r12.<init>(r9, r1)
            r13.f(r0, r12)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r12 = r11.q0()
            s7.l r12 = r12.e()
            androidx.fragment.app.y1 r13 = r11.C()
            i6.b r0 = new i6.b
            r0.<init>(r11, r4)
            androidx.lifecycle.v1 r1 = new androidx.lifecycle.v1
            r1.<init>(r9, r0)
            r12.f(r13, r1)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r12 = r11.q0()
            androidx.lifecycle.o0 r12 = r12.f3360q
            androidx.fragment.app.y1 r13 = r11.C()
            i6.b r0 = new i6.b
            r0.<init>(r11, r5)
            androidx.lifecycle.v1 r1 = new androidx.lifecycle.v1
            r1.<init>(r9, r0)
            r12.f(r13, r1)
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r12 = r11.q0()
            androidx.lifecycle.o0 r12 = r12.f3361r
            androidx.fragment.app.y1 r13 = r11.C()
            i6.b r0 = new i6.b
            r0.<init>(r11, r3)
            androidx.lifecycle.v1 r1 = new androidx.lifecycle.v1
            r1.<init>(r9, r0)
            r12.f(r13, r1)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.e.Z(android.view.View, android.os.Bundle):void");
    }

    public final void d() {
        h hVar;
        if ((!e0().getBoolean("isLive") || !h0.l1(f0()).getBoolean("player_keep_chat_open", false) || h0.l1(f0()).getBoolean("chat_disable", false)) && (hVar = q0().f3368y) != null) {
            hVar.b();
        }
    }

    public final void g() {
        h hVar;
        if ((!e0().getBoolean("isLive") || !h0.l1(f0()).getBoolean("player_keep_chat_open", false) || h0.l1(f0()).getBoolean("chat_disable", false)) && (hVar = q0().f3368y) != null) {
            hVar.d();
        }
    }

    public final void m0() {
        boolean z10;
        String str;
        int i10;
        m mVar;
        Bundle e02 = e0();
        int i11 = e02.getInt("channel_id");
        String string = e02.getString("channel_login");
        String string2 = e02.getString("channel_name");
        e02.getInt("streamId");
        Account account = Account.Companion.get(f0());
        String login = account.getLogin();
        if (login == null || w.h(login)) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = !z10;
        int i12 = h0.l1(f0()).getInt("chat_limit", 600);
        String string3 = h0.l1(f0()).getString("chat_image_quality", "4");
        if (string3 == null) {
            str = "4";
        } else {
            str = string3;
        }
        h0.l1(f0()).getBoolean("animatedGifEmotes", true);
        boolean z12 = h0.l1(f0()).getBoolean("chat_show_clearmsg", true);
        boolean z13 = h0.l1(f0()).getBoolean("chat_show_clearchat", true);
        boolean z14 = h0.l1(f0()).getBoolean("chat_recent", true);
        int i13 = h0.l1(f0()).getInt("chat_recent_limit", 100);
        boolean z15 = h0.l1(f0()).getBoolean("chat_enable_stv", true);
        boolean z16 = h0.l1(f0()).getBoolean("chat_disable", false);
        boolean z17 = e02.getBoolean("isLive");
        if (!z16) {
            if (z17) {
                ChatViewModel q02 = q0();
                String valueOf = String.valueOf(i13);
                j.f("recentMsgLimit", valueOf);
                if (!(q02.f3368y != null || string == null || i11 == 0)) {
                    q02.f3365v = i12;
                    m mVar2 = r2;
                    boolean z18 = z11;
                    String str2 = valueOf;
                    m mVar3 = new m(q02, account, z11, i11, string, string2, z12, z13);
                    q02.f3368y = mVar2;
                    mVar2.d();
                    q02.g(i11, string, str, z15);
                    if (z14) {
                        i10 = 3;
                        h0.b1(h0.I0(q02), (pa.h) null, 0, new b0(q02, i11, str2, (pa.e) null), 3);
                    } else {
                        i10 = 3;
                    }
                    if (z18) {
                        h hVar = q02.f3368y;
                        if (hVar instanceof m) {
                            mVar = (m) hVar;
                        } else {
                            mVar = null;
                        }
                        if (mVar != null) {
                            ChatViewModel chatViewModel = mVar.f8329i;
                            h0.b1(h0.I0(chatViewModel), (pa.h) null, 0, new l(chatViewModel, mVar, (pa.e) null), i10);
                        }
                    }
                }
            } else {
                boolean z19 = z15;
                String string4 = e02.getString("videoId");
                if (string4 != null && !e02.getBoolean("startTime_empty")) {
                    c0 c0Var = this.C;
                    j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.chat.ChatReplayPlayerFragment", c0Var);
                    w1 w1Var = new w1(3, (g) c0Var);
                    ChatViewModel q03 = q0();
                    double d10 = e02.getDouble("startTime");
                    if (q03.f3368y == null) {
                        q03.f3365v = i12;
                        o oVar = new o(q03, string4, d10, w1Var);
                        q03.f3368y = oVar;
                        oVar.d();
                        q03.g(i11, string, str, z19);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void o0() {
        h hVar;
        if (I() && (hVar = q0().f3368y) != null) {
            hVar.d();
        }
    }

    public final ChatViewModel q0() {
        return (ChatViewModel) this.f8316p0.getValue();
    }

    public final void r0(int i10, String str, String str2, String str3) {
        l lVar;
        h0.V(this).m(r.a(s.f7686a, i10, str, str2, str3, false, 0, 48));
        c0 c0Var = this.C;
        if (c0Var instanceof l) {
            lVar = (l) c0Var;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            lVar.u0().g();
        }
    }

    public final void s0() {
        int i10 = e0().getInt("channel_id");
        String string = e0().getString("channel_login");
        String str = "4";
        String string2 = h0.l1(f0()).getString("chat_image_quality", str);
        if (string2 != null) {
            str = string2;
        }
        h0.l1(f0()).getBoolean("animatedGifEmotes", true);
        boolean z10 = h0.l1(f0()).getBoolean("chat_enable_stv", true);
        ChatViewModel q02 = q0();
        ChatViewModel.A = null;
        ChatViewModel.B = null;
        q02.g(i10, string, str, z10);
    }
}
