package t6;

import android.annotation.SuppressLint;
import android.app.PictureInPictureParams;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.j3;
import androidx.fragment.app.c1;
import androidx.fragment.app.f0;
import androidx.fragment.app.q0;
import androidx.lifecycle.p1;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.github.andreyasadchy.xtra.ui.player.PlaybackService;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.woxthebox.draglistview.R;
import d9.r0;
import e.a;
import g1.d1;
import g1.e1;
import g1.k1;
import g1.w1;
import g1.x1;
import g1.z1;
import h3.b0;
import h3.c0;
import h3.f4;
import h3.l4;
import h6.b;
import h9.e0;
import h9.q;
import h9.w;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import l6.a0;
import l6.f;
import l6.z;
import m0.s1;
import m0.v2;
import ma.r;
import ma.s;
import pa.e;
import pa.h;
import q7.c;
import s7.g;
import s7.i;
import u6.d;
import xa.j;

@SuppressLint({"UnsafeOptInUsageError"})
public abstract class l extends f implements i, c, y0, a0, s0 {

    /* renamed from: w0  reason: collision with root package name */
    public static final f f14620w0 = new f(0);

    /* renamed from: x0  reason: collision with root package name */
    public static final List f14621x0 = r.e(Float.valueOf(0.25f), Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f));

    /* renamed from: y0  reason: collision with root package name */
    public static final List f14622y0 = r.e(Integer.valueOf(R.string.f0speed025), Integer.valueOf(R.string.f1speed05), Integer.valueOf(R.string.f2speed075), Integer.valueOf(R.string.speed1), Integer.valueOf(R.string.f3speed125), Integer.valueOf(R.string.f4speed15), Integer.valueOf(R.string.f5speed175), Integer.valueOf(R.string.speed2));

    /* renamed from: j0  reason: collision with root package name */
    public c0 f14623j0;

    /* renamed from: k0  reason: collision with root package name */
    public SlidingLayout f14624k0;

    /* renamed from: l0  reason: collision with root package name */
    public CustomPlayerView f14625l0;

    /* renamed from: m0  reason: collision with root package name */
    public AspectRatioFrameLayout f14626m0;

    /* renamed from: n0  reason: collision with root package name */
    public ViewGroup f14627n0;

    /* renamed from: o0  reason: collision with root package name */
    public boolean f14628o0;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f14629p0;

    /* renamed from: q0  reason: collision with root package name */
    public final boolean f14630q0 = true;

    /* renamed from: r0  reason: collision with root package name */
    public final int f14631r0 = 3000;

    /* renamed from: s0  reason: collision with root package name */
    public int f14632s0;

    /* renamed from: t0  reason: collision with root package name */
    public SharedPreferences f14633t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f14634u0;

    /* renamed from: v0  reason: collision with root package name */
    public final q0 f14635v0 = new q0(2, this);

    /* JADX WARNING: type inference failed for: r6v2, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void E0(t6.l r6, boolean r7, boolean r8, int r9) {
        /*
            r0 = r9 & 1
            r1 = 0
            r2 = 1
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L_0x003f
            h3.b0 r7 = r6.s0()
            if (r7 == 0) goto L_0x0039
            g1.a2 r7 = r7.D()
            if (r7 == 0) goto L_0x0039
            d9.r0 r7 = r7.f6289h
            if (r7 == 0) goto L_0x0039
            java.util.Iterator r7 = r7.iterator()
        L_0x001c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r7.next()
            r5 = r0
            g1.z1 r5 = (g1.z1) r5
            g1.v1 r5 = r5.f6778i
            int r5 = r5.f6675j
            if (r5 != r3) goto L_0x0031
            r5 = 1
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            if (r5 == 0) goto L_0x001c
            goto L_0x0036
        L_0x0035:
            r0 = r4
        L_0x0036:
            g1.z1 r0 = (g1.z1) r0
            goto L_0x003a
        L_0x0039:
            r0 = r4
        L_0x003a:
            if (r0 == 0) goto L_0x003e
            r7 = 1
            goto L_0x003f
        L_0x003e:
            r7 = 0
        L_0x003f:
            r9 = r9 & 2
            if (r9 == 0) goto L_0x008a
            h3.b0 r8 = r6.s0()
            if (r8 == 0) goto L_0x0089
            g1.a2 r8 = r8.D()
            if (r8 == 0) goto L_0x0089
            d9.r0 r8 = r8.f6289h
            if (r8 == 0) goto L_0x0089
            java.util.Iterator r8 = r8.iterator()
        L_0x0057:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0070
            java.lang.Object r9 = r8.next()
            r0 = r9
            g1.z1 r0 = (g1.z1) r0
            g1.v1 r0 = r0.f6778i
            int r0 = r0.f6675j
            if (r0 != r3) goto L_0x006c
            r0 = 1
            goto L_0x006d
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 == 0) goto L_0x0057
            goto L_0x0071
        L_0x0070:
            r9 = r4
        L_0x0071:
            g1.z1 r9 = (g1.z1) r9
            if (r9 == 0) goto L_0x0089
            boolean[] r8 = r9.f6781l
            int r9 = r8.length
            r0 = 0
        L_0x0079:
            if (r0 >= r9) goto L_0x0084
            boolean r3 = r8[r0]
            if (r3 != r2) goto L_0x0081
            r8 = 1
            goto L_0x0085
        L_0x0081:
            int r0 = r0 + 1
            goto L_0x0079
        L_0x0084:
            r8 = 0
        L_0x0085:
            if (r8 != r2) goto L_0x0089
            r8 = 1
            goto L_0x008a
        L_0x0089:
            r8 = 0
        L_0x008a:
            android.view.View r9 = r6.h0()
            r0 = 2131362346(0x7f0a022a, float:1.834447E38)
            android.view.View r9 = r9.findViewById(r0)
            android.widget.ImageButton r9 = (android.widget.ImageButton) r9
            if (r9 == 0) goto L_0x00ce
            if (r7 == 0) goto L_0x00cb
            android.content.SharedPreferences r0 = r6.t0()
            java.lang.String r2 = "player_subtitles"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 == 0) goto L_0x00cb
            r9.setVisibility(r1)
            if (r8 == 0) goto L_0x00ba
            r0 = 2131230911(0x7f0800bf, float:1.8077888E38)
            r9.setImageResource(r0)
            t6.d r0 = new t6.d
            r2 = 9
            r0.<init>(r6, r2)
            goto L_0x00c7
        L_0x00ba:
            r0 = 2131230910(0x7f0800be, float:1.8077886E38)
            r9.setImageResource(r0)
            t6.d r0 = new t6.d
            r2 = 10
            r0.<init>(r6, r2)
        L_0x00c7:
            r9.setOnClickListener(r0)
            goto L_0x00ce
        L_0x00cb:
            hb.h0.J0(r9)
        L_0x00ce:
            androidx.fragment.app.c1 r6 = r6.u()
            java.lang.String r9 = "closeOnPip"
            androidx.fragment.app.c0 r6 = r6.E(r9)
            boolean r9 = r6 instanceof t6.d0
            if (r9 == 0) goto L_0x00df
            r4 = r6
            t6.d0 r4 = (t6.d0) r4
        L_0x00df:
            if (r4 == 0) goto L_0x0135
            z5.l r6 = r4.f14581v0
            xa.j.c(r6)
            java.lang.String r9 = "menuSubtitles"
            android.widget.TextView r6 = r6.f17707l
            if (r7 == 0) goto L_0x012f
            android.content.Context r7 = r4.f0()
            android.content.SharedPreferences r7 = hb.h0.l1(r7)
            java.lang.String r0 = "player_menu_subtitles"
            boolean r7 = r7.getBoolean(r0, r1)
            if (r7 == 0) goto L_0x012f
            xa.j.e(r9, r6)
            r6.setVisibility(r1)
            android.content.Context r7 = r4.f0()
            if (r8 == 0) goto L_0x011a
            r8 = 2131951874(0x7f130102, float:1.9540175E38)
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
            t6.b0 r7 = new t6.b0
            r8 = 18
            r7.<init>(r4, r8)
            goto L_0x012b
        L_0x011a:
            r8 = 2131952324(0x7f1302c4, float:1.9541088E38)
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
            t6.b0 r7 = new t6.b0
            r8 = 19
            r7.<init>(r4, r8)
        L_0x012b:
            r6.setOnClickListener(r7)
            goto L_0x0135
        L_0x012f:
            xa.j.e(r9, r6)
            hb.h0.J0(r6)
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.E0(t6.l, boolean, boolean, int):void");
    }

    public final void A0(long j10, int i10, int i11, boolean z10) {
        String str;
        long j11 = j10;
        int i12 = i10;
        int i13 = i11;
        boolean z11 = z10;
        Context f02 = f0();
        int i14 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i14 > 0) {
            if (i12 == 0) {
                str = A(R.string.playback_will_stop, y().getQuantityString(R.plurals.minutes, i13, new Object[]{Integer.valueOf(i11)}));
            } else if (i13 == 0) {
                str = A(R.string.playback_will_stop, y().getQuantityString(R.plurals.hours, i12, new Object[]{Integer.valueOf(i10)}));
            } else {
                str = A(R.string.playback_will_stop_hours_minutes, y().getQuantityString(R.plurals.hours, i12, new Object[]{Integer.valueOf(i10)}), y().getQuantityString(R.plurals.minutes, i13, new Object[]{Integer.valueOf(i11)}));
            }
            j.e("when {\n                h…, minutes))\n            }", str);
            Toast.makeText(f02, str, 1).show();
        } else if (v0().f14612m - System.currentTimeMillis() > 0) {
            h0.X1(f02, R.string.timer_canceled);
        }
        if (z11 != t0().getBoolean("sleep_timer_lock", true)) {
            SharedPreferences.Editor edit = t0().edit();
            j.e("editor", edit);
            edit.putBoolean("sleep_timer_lock", z11);
            edit.apply();
        }
        i0 v02 = v0();
        Timer timer = v02.f14610k;
        if (timer != null) {
            timer.cancel();
            v02.f14612m = 0;
            v02.f14610k = null;
        }
        if (i14 > 0) {
            Timer timer2 = new Timer();
            v02.f14612m = System.currentTimeMillis() + j11;
            timer2.schedule(new h0(v02), j11);
            v02.f14610k = timer2;
        }
    }

    public final void B0() {
        CustomPlayerView customPlayerView = (CustomPlayerView) h0().findViewById(R.id.playerView);
        if (customPlayerView != null) {
            customPlayerView.setPlayer((k1) null);
        }
        c0 c0Var = this.f14623j0;
        if (c0Var == null) {
            j.l("controllerFuture");
            throw null;
        } else if (!c0Var.cancel(true)) {
            try {
                ((b0) w.b(c0Var)).a();
            } catch (CancellationException | ExecutionException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C0() {
        /*
            r4 = this;
            h3.b0 r0 = r4.s0()
            if (r0 == 0) goto L_0x0020
            h3.f4 r1 = new h3.f4
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            java.lang.String r3 = "getQualityText"
            r1.<init>(r2, r3)
            h9.e0 r0 = r0.T0(r1, r2)
            if (r0 == 0) goto L_0x0020
            t6.c r1 = new t6.c
            r2 = 1
            r1.<init>(r0, r4, r2)
            h9.q r2 = h9.q.f7765h
            r0.a(r1, r2)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.C0():void");
    }

    public final void D0() {
        int i10 = this.f14632s0 + 1;
        if (i10 >= 5) {
            i10 = 0;
        }
        this.f14632s0 = i10;
        CustomPlayerView customPlayerView = this.f14625l0;
        if (customPlayerView != null) {
            customPlayerView.setResizeMode(i10);
            SharedPreferences.Editor edit = t0().edit();
            j.e("editor", edit);
            edit.putInt("aspectRatioLandscape", this.f14632s0);
            edit.apply();
            return;
        }
        j.l("playerView");
        throw null;
    }

    public final void F0() {
        g1 adapter;
        ImageButton imageButton;
        if (t0().getBoolean("player_chattoggle", true) && (imageButton = (ImageButton) h0().findViewById(R.id.playerChatToggle)) != null) {
            h0.b2(imageButton);
            imageButton.setImageResource(R.drawable.baseline_speaker_notes_off_black_24);
            imageButton.setOnClickListener(new d(this, 11));
        }
        ViewGroup viewGroup = this.f14627n0;
        Integer num = null;
        if (viewGroup != null) {
            h0.b2(viewGroup);
            SharedPreferences.Editor edit = t0().edit();
            j.e("editor", edit);
            edit.putBoolean("key_chat_opened", true);
            edit.apply();
            boolean z10 = false;
            u0().setMaximizedSecondViewVisibility(0);
            RecyclerView recyclerView = (RecyclerView) h0().findViewById(R.id.recyclerView);
            Button button = (Button) h0().findViewById(R.id.btnDown);
            ViewGroup viewGroup2 = this.f14627n0;
            if (viewGroup2 != null) {
                if ((viewGroup2.getVisibility() == 0) && button != null) {
                    if (button.getVisibility() == 0) {
                        z10 = true;
                    }
                    if (!z10) {
                        if (((recyclerView == null || (adapter = recyclerView.getAdapter()) == null) ? null : Integer.valueOf(adapter.getItemCount())) != null) {
                            g1 adapter2 = recyclerView.getAdapter();
                            if (adapter2 != null) {
                                num = Integer.valueOf(adapter2.getItemCount());
                            }
                            j.c(num);
                            recyclerView.scrollToPosition(num.intValue() - 1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j.l("chatLayout");
            throw null;
        }
        j.l("chatLayout");
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G0() {
        /*
            r4 = this;
            h3.b0 r0 = r4.s0()
            if (r0 == 0) goto L_0x0020
            h3.f4 r1 = new h3.f4
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            java.lang.String r3 = "getQualities"
            r1.<init>(r2, r3)
            h9.e0 r0 = r0.T0(r1, r2)
            if (r0 == 0) goto L_0x0020
            t6.c r1 = new t6.c
            r2 = 4
            r1.<init>(r0, r4, r2)
            h9.q r2 = h9.q.f7765h
            r0.a(r1, r2)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.G0():void");
    }

    public final void H0() {
        x0 x0Var = z0.f14677v0;
        c1 u10 = u();
        j.e("childFragmentManager", u10);
        long currentTimeMillis = v0().f14612m - System.currentTimeMillis();
        x0Var.getClass();
        z0 z0Var = new z0();
        z0Var.j0(h0.r(new la.i("timeLeft", Long.valueOf(currentTimeMillis))));
        z0Var.q0(u10, (String) null);
    }

    public final void I0() {
        e1 i10;
        b0 s02 = s0();
        if (s02 != null && (i10 = s02.i()) != null) {
            g gVar = g.f14374a;
            Context f02 = f0();
            c1 u10 = u();
            j.e("childFragmentManager", u10);
            int indexOf = f14621x0.indexOf(Float.valueOf(i10.f6355h));
            gVar.getClass();
            List<Number> list = f14622y0;
            j.f("labels", list);
            z zVar = l6.b0.f9590w0;
            ArrayList arrayList = new ArrayList(s.i(list));
            for (Number intValue : list) {
                arrayList.add(f02.getString(intValue.intValue()));
            }
            int[] I = ma.z.I(list);
            zVar.getClass();
            z.a(1, arrayList, I, indexOf).q0(u10, "closeOnPip");
        }
    }

    public final void J0() {
        s1.a(d0().getWindow(), true);
        ((v2) new a(d0().getWindow(), d0().getWindow().getDecorView()).f4852i).f();
    }

    public final void K0() {
        Float f10;
        g gVar = g.f14374a;
        c1 u10 = u();
        j.e("childFragmentManager", u10);
        b0 s02 = s0();
        if (s02 != null) {
            f10 = Float.valueOf(s02.Q());
        } else {
            f10 = null;
        }
        gVar.getClass();
        t0.f14661x0.getClass();
        t0 t0Var = new t0();
        t0Var.j0(h0.r(new la.i("volume", f10)));
        t0Var.q0(u10, "closeOnPip");
    }

    public void L0() {
        v0().f14605f = true;
    }

    public final void M0(boolean z10) {
        x1 x1Var;
        Object obj;
        boolean z11;
        E0(this, false, z10, 1);
        b0 s02 = s0();
        if (s02 != null) {
            if (z10) {
                r0 r0Var = s02.D().f6289h;
                j.e("player.currentTracks.groups", r0Var);
                Iterator it = r0Var.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((z1) obj).f6778i.f6675j == 3) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        break;
                    }
                }
                z1 z1Var = (z1) obj;
                if (z1Var != null) {
                    x1Var = s02.p0().i().h(new w1(z1Var.f6778i, 0));
                } else {
                    return;
                }
            } else {
                x1Var = s02.p0().i().d(3);
            }
            s02.r(x1Var.b());
        }
    }

    public void N(Bundle bundle) {
        super.N(bundle);
        f0 d02 = d0();
        this.f14633t0 = h0.l1(d02);
        boolean z10 = true;
        if (d02.getResources().getConfiguration().orientation != 1) {
            z10 = false;
        }
        this.f14628o0 = z10;
        d02.f454o.a(this, this.f14635v0);
    }

    public final void U(boolean z10) {
        b8.i iVar;
        ComponentCallbacks componentCallbacks;
        c1 u10;
        b8.i iVar2 = null;
        if (z10) {
            if (!u0().f3546v) {
                u0().f();
            }
            CustomPlayerView customPlayerView = this.f14625l0;
            if (customPlayerView != null) {
                customPlayerView.setUseController(false);
                ViewGroup viewGroup = this.f14627n0;
                if (viewGroup != null) {
                    h0.J0(viewGroup);
                    androidx.fragment.app.c0 E = u().E("closeOnPip");
                    if (E instanceof b8.i) {
                        iVar = (b8.i) E;
                    } else {
                        iVar = null;
                    }
                    if (iVar != null) {
                        iVar.l0();
                    }
                    androidx.fragment.app.c0 D = u().D(R.id.chatFragmentContainer);
                    if (D == null || (u10 = D.u()) == null) {
                        componentCallbacks = null;
                    } else {
                        componentCallbacks = u10.E("closeOnPip");
                    }
                    if (componentCallbacks instanceof b8.i) {
                        iVar2 = (b8.i) componentCallbacks;
                    }
                    if (iVar2 != null) {
                        iVar2.l0();
                        return;
                    }
                    return;
                }
                j.l("chatLayout");
                throw null;
            }
            j.l("playerView");
            throw null;
        }
        CustomPlayerView customPlayerView2 = this.f14625l0;
        if (customPlayerView2 != null) {
            customPlayerView2.setUseController(true);
        } else {
            j.l("playerView");
            throw null;
        }
    }

    public final void X() {
        this.K = true;
        c0 c10 = new j3((ContextWrapper) d0(), new l4(d0(), new ComponentName(d0(), PlaybackService.class))).c();
        this.f14623j0 = c10;
        c10.a(new b(this, 1), q.f7765h);
    }

    public void Z(View view, Bundle bundle) {
        int i10;
        String str;
        View view2;
        ImageButton imageButton;
        ImageButton imageButton2;
        boolean z10;
        ImageButton imageButton3;
        ImageButton imageButton4;
        int i11;
        ImageButton imageButton5;
        ImageButton imageButton6;
        ImageButton imageButton7;
        ImageButton imageButton8;
        ImageButton imageButton9;
        ImageButton imageButton10;
        ImageButton imageButton11;
        ImageButton imageButton12;
        j.f("view", view);
        MainActivity mainActivity = (MainActivity) d0();
        SlidingLayout slidingLayout = (SlidingLayout) view;
        this.f14624k0 = slidingLayout;
        u0().f3550z.add(mainActivity);
        u0().f3550z.add(this);
        SlidingLayout u02 = u0();
        if (t0().getBoolean("key_chat_opened", true)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        u02.setMaximizedSecondViewVisibility(i10);
        View findViewById = view.findViewById(R.id.playerView);
        j.e("view.findViewById(R.id.playerView)", findViewById);
        this.f14625l0 = (CustomPlayerView) findViewById;
        if (mainActivity.getPackageManager().hasSystemFeature("android.software.picture_in_picture") && Build.VERSION.SDK_INT >= 26) {
            h0.b1(h0.v0(C()), (h) null, 0, new k(this, (e) null), 3);
        }
        boolean z11 = this instanceof d;
        if (z11) {
            view2 = view.findViewById(R.id.clipChatContainer);
            str = "view.findViewById(R.id.clipChatContainer)";
        } else {
            view2 = view.findViewById(R.id.chatFragmentContainer);
            str = "view.findViewById(R.id.chatFragmentContainer)";
        }
        j.e(str, view2);
        this.f14627n0 = (ViewGroup) view2;
        View findViewById2 = view.findViewById(R.id.aspectRatioFrameLayout);
        j.e("view.findViewById(R.id.aspectRatioFrameLayout)", findViewById2);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById2;
        this.f14626m0 = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setAspectRatio(1.7777778f);
        this.f14634u0 = t0().getInt("landscape_chat_width", 0);
        if (t0().getBoolean("player_fullscreen", true) && (imageButton12 = (ImageButton) view.findViewById(R.id.playerFullscreenToggle)) != null) {
            imageButton12.setVisibility(0);
            imageButton12.setOnClickListener(new b(mainActivity, 6, this));
        }
        if (t0().getBoolean("player_aspect", true) && (imageButton11 = (ImageButton) view.findViewById(R.id.playerAspectRatio)) != null) {
            imageButton11.setOnClickListener(new d(this, 1));
        }
        y0();
        CustomPlayerView customPlayerView = this.f14625l0;
        if (customPlayerView != null) {
            customPlayerView.setControllerAutoShow(q0());
            if (!(this instanceof v6.d)) {
                ImageButton imageButton13 = (ImageButton) view.findViewById(R.id.playerSettings);
                if (imageButton13 != null) {
                    h0.O(imageButton13);
                }
                if (!(this instanceof w6.f) && (imageButton10 = (ImageButton) view.findViewById(R.id.playerDownload)) != null) {
                    h0.O(imageButton10);
                }
                if (!z11 && (imageButton9 = (ImageButton) view.findViewById(R.id.playerMode)) != null) {
                    h0.O(imageButton9);
                }
                if (t0().getBoolean("player_doubletap", true) && !t0().getBoolean("chat_disable", false)) {
                    CustomPlayerView customPlayerView2 = this.f14625l0;
                    if (customPlayerView2 != null) {
                        customPlayerView2.setOnDoubleTapListener(new p1(14, this));
                    } else {
                        j.l("playerView");
                        throw null;
                    }
                }
            }
            if (t0().getBoolean("player_minimize", true) && (imageButton8 = (ImageButton) view.findViewById(R.id.playerMinimize)) != null) {
                imageButton8.setVisibility(0);
                imageButton8.setOnClickListener(new d(this, 2));
            }
            if (t0().getBoolean("player_volumebutton", true) && (imageButton7 = (ImageButton) view.findViewById(R.id.playerVolume)) != null) {
                imageButton7.setVisibility(0);
                imageButton7.setOnClickListener(new d(this, 3));
            }
            if (t0().getBoolean("player_settings", true) && (imageButton6 = (ImageButton) view.findViewById(R.id.playerSettings)) != null) {
                imageButton6.setVisibility(0);
                imageButton6.setOnClickListener(new d(this, 4));
            }
            if (t0().getBoolean("player_mode", false) && (imageButton5 = (ImageButton) view.findViewById(R.id.playerMode)) != null) {
                imageButton5.setVisibility(0);
                imageButton5.setOnClickListener(new d(this, 5));
            }
            if (Build.VERSION.SDK_INT >= 28 && t0().getBoolean("player_audio_compressor_button", false) && (imageButton4 = (ImageButton) view.findViewById(R.id.playerAudioCompressor)) != null) {
                imageButton4.setVisibility(0);
                if (t0().getBoolean("player_audio_compressor", false)) {
                    i11 = R.drawable.baseline_audio_compressor_on_24dp;
                } else {
                    i11 = R.drawable.baseline_audio_compressor_off_24dp;
                }
                imageButton4.setImageResource(i11);
                imageButton4.setOnClickListener(new b(this, 7, imageButton4));
            }
            if (this instanceof w6.f) {
                Account.Companion companion = Account.Companion;
                String login = companion.get(mainActivity).getLogin();
                if (login == null || fb.w.h(login)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && companion.get(mainActivity).getId() != 0) {
                    if (t0().getBoolean("player_chatbartoggle", false) && !t0().getBoolean("chat_disable", false) && (imageButton3 = (ImageButton) view.findViewById(R.id.playerChatBarToggle)) != null) {
                        imageButton3.setVisibility(0);
                        imageButton3.setOnClickListener(new d(this, 6));
                    }
                    u0().getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
                }
            } else if (t0().getBoolean("player_speedbutton", false) && (imageButton2 = (ImageButton) view.findViewById(R.id.playerSpeed)) != null) {
                imageButton2.setVisibility(0);
                imageButton2.setOnClickListener(new d(this, 7));
            }
            if (!z11) {
                v0().f14611l.f(C(), new v1(13, new u1(this, 9, mainActivity)));
                if (t0().getBoolean("player_sleep", false) && (imageButton = (ImageButton) view.findViewById(R.id.playerSleepTimer)) != null) {
                    imageButton.setVisibility(0);
                    imageButton.setOnClickListener(new d(this, 0));
                }
            }
            if (t0().getBoolean("player_keep_screen_on_when_paused", false)) {
                slidingLayout.setKeepScreenOn(true);
            }
            p0(v0().f14607h);
            return;
        }
        j.l("playerView");
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r2 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r4 = this;
            t6.i0 r0 = r4.v0()
            r1 = 1
            r0.f14606g = r1
            h3.b0 r0 = r4.s0()
            if (r0 == 0) goto L_0x0027
            h3.f4 r1 = new h3.f4
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            java.lang.String r3 = "moveBackground"
            r1.<init>(r2, r3)
            h9.e0 r0 = r0.T0(r1, r2)
            if (r0 == 0) goto L_0x0027
            t6.c r1 = new t6.c
            r2 = 0
            r1.<init>(r0, r4, r2)
            h9.q r2 = h9.q.f7765h
            r0.a(r1, r2)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.d():void");
    }

    public final void e() {
        f0 d02 = d0();
        d02.f454o.a(this, this.f14635v0);
        if (this instanceof w6.f) {
            w6.f fVar = (w6.f) this;
            if (fVar.O0()) {
                k5.a aVar = fVar.P0().f8315o0;
                j.c(aVar);
                ((ChatView) aVar.f9125j).x(true);
            }
        }
        CustomPlayerView customPlayerView = this.f14625l0;
        if (customPlayerView != null) {
            customPlayerView.setUseController(true);
            CustomPlayerView customPlayerView2 = this.f14625l0;
            if (customPlayerView2 != null) {
                if (!customPlayerView2.getControllerHideOnTouch()) {
                    CustomPlayerView customPlayerView3 = this.f14625l0;
                    if (customPlayerView3 != null) {
                        customPlayerView3.f(customPlayerView3.e());
                    } else {
                        j.l("playerView");
                        throw null;
                    }
                }
                if (!this.f14628o0) {
                    x0();
                    return;
                }
                return;
            }
            j.l("playerView");
            throw null;
        }
        j.l("playerView");
        throw null;
    }

    public final void f(int i10, int i11, CharSequence charSequence) {
        d0 d0Var;
        if (i10 == 0) {
            b0 s02 = s0();
            if (s02 != null) {
                e0 T0 = s02.T0(new f4(h0.r(new la.i("index", Integer.valueOf(i11))), "changeQuality"), Bundle.EMPTY);
                if (T0 != null) {
                    T0.a(new c(T0, this, 5), q.f7765h);
                }
            }
        } else if (i10 == 1) {
            Float f10 = (Float) ma.z.v(f14621x0, i11);
            if (f10 != null) {
                float floatValue = f10.floatValue();
                b0 s03 = s0();
                if (s03 != null) {
                    s03.E0(floatValue);
                }
                SharedPreferences.Editor edit = t0().edit();
                j.e("editor", edit);
                edit.putFloat("player_speed", floatValue);
                edit.apply();
            }
            Integer num = (Integer) ma.z.v(f14622y0, i11);
            if (num != null) {
                int intValue = num.intValue();
                androidx.fragment.app.c0 E = u().E("closeOnPip");
                if (E instanceof d0) {
                    d0Var = (d0) E;
                } else {
                    d0Var = null;
                }
                if (d0Var != null) {
                    d0Var.r0(f0().getString(intValue));
                }
            }
        }
    }

    public final void g() {
    }

    public void l() {
        if (this instanceof w6.f) {
            w6.f fVar = (w6.f) this;
            if (fVar.O0()) {
                k5.a aVar = fVar.P0().f8315o0;
                j.c(aVar);
                ((ChatView) aVar.f9125j).x(false);
            }
        }
        this.f14635v0.a();
        CustomPlayerView customPlayerView = this.f14625l0;
        if (customPlayerView != null) {
            customPlayerView.setUseController(false);
            if (!this.f14628o0) {
                J0();
                f0 d02 = d0();
                h0.b1(h0.v0(d02), (h) null, 0, new h(d02, (e) null), 3);
                return;
            }
            return;
        }
        j.l("playerView");
        throw null;
    }

    public void m0() {
        if (s0() != null && !v0().f14605f) {
            L0();
        }
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConfigurationChanged(android.content.res.Configuration r3) {
        /*
            r2 = this;
            java.lang.String r0 = "newConfig"
            xa.j.f(r0, r3)
            r0 = 1
            r2.K = r0
            int r3 = r3.orientation
            if (r3 != r0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r2.f14628o0 = r0
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            r1 = 0
            if (r3 < r0) goto L_0x0021
            androidx.fragment.app.f0 r3 = r2.d0()
            boolean r3 = r3.isInPictureInPictureMode()
            if (r3 != 0) goto L_0x0034
        L_0x0021:
            android.view.ViewGroup r3 = r2.f14627n0
            java.lang.String r0 = "chatLayout"
            if (r3 == 0) goto L_0x004f
            hb.h0.P0(r3)
            android.view.ViewGroup r3 = r2.f14627n0
            if (r3 == 0) goto L_0x004b
            r3.clearFocus()
            r2.y0()
        L_0x0034:
            androidx.fragment.app.c1 r3 = r2.u()
            java.lang.String r0 = "closeOnPip"
            androidx.fragment.app.c0 r3 = r3.E(r0)
            boolean r0 = r3 instanceof t6.d0
            if (r0 == 0) goto L_0x0045
            r1 = r3
            t6.d0 r1 = (t6.d0) r1
        L_0x0045:
            if (r1 == 0) goto L_0x004a
            r1.l0()
        L_0x004a:
            return
        L_0x004b:
            xa.j.l(r0)
            throw r1
        L_0x004f:
            xa.j.l(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.onConfigurationChanged(android.content.res.Configuration):void");
    }

    public final void p0(a0 a0Var) {
        f0 f0Var;
        PictureInPictureParams.Builder builder;
        i0 v02 = v0();
        v02.getClass();
        j.f("<set-?>", a0Var);
        v02.f14607h = a0Var;
        if (a0Var == a0.NORMAL) {
            CustomPlayerView customPlayerView = this.f14625l0;
            if (customPlayerView != null) {
                customPlayerView.setControllerHideOnTouch(true);
                CustomPlayerView customPlayerView2 = this.f14625l0;
                if (customPlayerView2 != null) {
                    customPlayerView2.setControllerShowTimeoutMs(r0());
                    if (d0().getPackageManager().hasSystemFeature("android.software.picture_in_picture") && Build.VERSION.SDK_INT >= 31 && j.a(t0().getString("player_background_playback", "0"), "0")) {
                        f0Var = d0();
                        androidx.activity.b.t();
                        builder = androidx.activity.b.i().setAutoEnterEnabled(true);
                    } else {
                        return;
                    }
                } else {
                    j.l("playerView");
                    throw null;
                }
            } else {
                j.l("playerView");
                throw null;
            }
        } else {
            CustomPlayerView customPlayerView3 = this.f14625l0;
            if (customPlayerView3 != null) {
                customPlayerView3.setControllerHideOnTouch(false);
                CustomPlayerView customPlayerView4 = this.f14625l0;
                if (customPlayerView4 != null) {
                    customPlayerView4.setControllerShowTimeoutMs(-1);
                    CustomPlayerView customPlayerView5 = this.f14625l0;
                    if (customPlayerView5 != null) {
                        customPlayerView5.f(customPlayerView5.e());
                        h0().setKeepScreenOn(true);
                        if (d0().getPackageManager().hasSystemFeature("android.software.picture_in_picture") && Build.VERSION.SDK_INT >= 31) {
                            f0Var = d0();
                            androidx.activity.b.t();
                            builder = androidx.activity.b.i().setAutoEnterEnabled(false);
                        } else {
                            return;
                        }
                    } else {
                        j.l("playerView");
                        throw null;
                    }
                } else {
                    j.l("playerView");
                    throw null;
                }
            } else {
                j.l("playerView");
                throw null;
            }
        }
        f0Var.setPictureInPictureParams(builder.build());
    }

    public void q() {
        b0 s02 = s0();
        if (s02 != null) {
            s02.g();
        }
        b0 s03 = s0();
        if (s03 != null) {
            s03.stop();
        }
        B0();
    }

    public boolean q0() {
        return this.f14630q0;
    }

    public int r0() {
        return this.f14631r0;
    }

    public final b0 s0() {
        c0 c0Var = this.f14623j0;
        if (c0Var == null) {
            j.l("controllerFuture");
            throw null;
        } else if (!c0Var.isDone()) {
            return null;
        } else {
            c0 c0Var2 = this.f14623j0;
            if (c0Var2 != null) {
                return (b0) c0Var2.get();
            }
            j.l("controllerFuture");
            throw null;
        }
    }

    public final SharedPreferences t0() {
        SharedPreferences sharedPreferences = this.f14633t0;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        j.l("prefs");
        throw null;
    }

    public final SlidingLayout u0() {
        SlidingLayout slidingLayout = this.f14624k0;
        if (slidingLayout != null) {
            return slidingLayout;
        }
        j.l("slidingLayout");
        throw null;
    }

    public abstract i0 v0();

    public final void w0() {
        ImageButton imageButton;
        if (t0().getBoolean("player_chattoggle", true) && (imageButton = (ImageButton) h0().findViewById(R.id.playerChatToggle)) != null) {
            h0.b2(imageButton);
            imageButton.setImageResource(R.drawable.baseline_speaker_notes_black_24);
            imageButton.setOnClickListener(new d(this, 8));
        }
        ViewGroup viewGroup = this.f14627n0;
        if (viewGroup != null) {
            h0.P0(viewGroup);
            ViewGroup viewGroup2 = this.f14627n0;
            if (viewGroup2 != null) {
                viewGroup2.clearFocus();
                ViewGroup viewGroup3 = this.f14627n0;
                if (viewGroup3 != null) {
                    h0.J0(viewGroup3);
                    SharedPreferences.Editor edit = t0().edit();
                    j.e("editor", edit);
                    edit.putBoolean("key_chat_opened", false);
                    edit.apply();
                    u0().setMaximizedSecondViewVisibility(8);
                    return;
                }
                j.l("chatLayout");
                throw null;
            }
            j.l("chatLayout");
            throw null;
        }
        j.l("chatLayout");
        throw null;
    }

    public final void x0() {
        s1.a(d0().getWindow(), false);
        a aVar = new a(d0().getWindow(), d0().getWindow().getDecorView());
        ((v2) aVar.f4852i).a();
        ((v2) aVar.f4852i).e();
    }

    public final void y0() {
        boolean z10;
        boolean z11;
        Integer num;
        Integer num2;
        g1 adapter;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = true;
        if (this.f14628o0) {
            d0().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener) null);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.f14626m0;
            if (aspectRatioFrameLayout != null) {
                ViewGroup.LayoutParams layoutParams = aspectRatioFrameLayout.getLayoutParams();
                if (layoutParams != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = -1;
                    layoutParams2.height = -2;
                    layoutParams2.weight = 0.0f;
                    aspectRatioFrameLayout.setLayoutParams(layoutParams2);
                    ViewGroup viewGroup = this.f14627n0;
                    if (viewGroup != null) {
                        ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                        if (layoutParams3 != null) {
                            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                            layoutParams4.width = -1;
                            layoutParams4.height = 0;
                            layoutParams4.weight = 1.0f;
                            viewGroup.setLayoutParams(layoutParams4);
                            ViewGroup viewGroup2 = this.f14627n0;
                            if (viewGroup2 != null) {
                                h0.b2(viewGroup2);
                                ImageButton imageButton = (ImageButton) h0().findViewById(R.id.playerFullscreenToggle);
                                if (imageButton != null) {
                                    if (imageButton.getVisibility() == 0) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    if (z14) {
                                        imageButton.setImageResource(R.drawable.baseline_fullscreen_black_24);
                                    }
                                }
                                ImageButton imageButton2 = (ImageButton) h0().findViewById(R.id.playerAspectRatio);
                                if (imageButton2 != null) {
                                    if (imageButton2.getVisibility() == 0) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    if (z13) {
                                        h0.J0(imageButton2);
                                    }
                                }
                                ImageButton imageButton3 = (ImageButton) h0().findViewById(R.id.playerChatToggle);
                                if (imageButton3 != null) {
                                    if (imageButton3.getVisibility() == 0) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (z12) {
                                        h0.J0(imageButton3);
                                    }
                                }
                                J0();
                                AspectRatioFrameLayout aspectRatioFrameLayout2 = this.f14626m0;
                                if (aspectRatioFrameLayout2 != null) {
                                    aspectRatioFrameLayout2.setResizeMode(1);
                                    this.f14632s0 = 0;
                                } else {
                                    j.l("aspectRatioFrameLayout");
                                    throw null;
                                }
                            } else {
                                j.l("chatLayout");
                                throw null;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        }
                    } else {
                        j.l("chatLayout");
                        throw null;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            } else {
                j.l("aspectRatioFrameLayout");
                throw null;
            }
        } else {
            d0().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a(this));
            AspectRatioFrameLayout aspectRatioFrameLayout3 = this.f14626m0;
            if (aspectRatioFrameLayout3 != null) {
                ViewGroup.LayoutParams layoutParams5 = aspectRatioFrameLayout3.getLayoutParams();
                if (layoutParams5 != null) {
                    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                    layoutParams6.width = 0;
                    layoutParams6.height = -1;
                    layoutParams6.weight = 1.0f;
                    aspectRatioFrameLayout3.setLayoutParams(layoutParams6);
                    if (!(this instanceof v6.d)) {
                        ViewGroup viewGroup3 = this.f14627n0;
                        if (viewGroup3 != null) {
                            ViewGroup.LayoutParams layoutParams7 = viewGroup3.getLayoutParams();
                            if (layoutParams7 != null) {
                                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) layoutParams7;
                                layoutParams8.width = this.f14634u0;
                                layoutParams8.height = -1;
                                layoutParams8.weight = 0.0f;
                                viewGroup3.setLayoutParams(layoutParams8);
                                if (t0().getBoolean("chat_disable", false)) {
                                    ViewGroup viewGroup4 = this.f14627n0;
                                    if (viewGroup4 != null) {
                                        h0.J0(viewGroup4);
                                        u0().setMaximizedSecondViewVisibility(8);
                                    } else {
                                        j.l("chatLayout");
                                        throw null;
                                    }
                                } else if (t0().getBoolean("key_chat_opened", true)) {
                                    F0();
                                } else {
                                    w0();
                                }
                                RecyclerView recyclerView = (RecyclerView) h0().findViewById(R.id.recyclerView);
                                Button button = (Button) h0().findViewById(R.id.btnDown);
                                ViewGroup viewGroup5 = this.f14627n0;
                                if (viewGroup5 != null) {
                                    if (viewGroup5.getVisibility() == 0) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    if (z10 && button != null) {
                                        if (button.getVisibility() == 0) {
                                            z11 = true;
                                        } else {
                                            z11 = false;
                                        }
                                        if (!z11) {
                                            if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
                                                num = null;
                                            } else {
                                                num = Integer.valueOf(adapter.getItemCount());
                                            }
                                            if (num != null) {
                                                g1 adapter2 = recyclerView.getAdapter();
                                                if (adapter2 != null) {
                                                    num2 = Integer.valueOf(adapter2.getItemCount());
                                                } else {
                                                    num2 = null;
                                                }
                                                j.c(num2);
                                                recyclerView.scrollToPosition(num2.intValue() - 1);
                                            }
                                        }
                                    }
                                } else {
                                    j.l("chatLayout");
                                    throw null;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        } else {
                            j.l("chatLayout");
                            throw null;
                        }
                    } else {
                        ViewGroup viewGroup6 = this.f14627n0;
                        if (viewGroup6 != null) {
                            h0.J0(viewGroup6);
                            u0().setMaximizedSecondViewVisibility(8);
                        } else {
                            j.l("chatLayout");
                            throw null;
                        }
                    }
                    ImageButton imageButton4 = (ImageButton) h0().findViewById(R.id.playerFullscreenToggle);
                    if (imageButton4 != null) {
                        if (imageButton4.getVisibility() != 0) {
                            z15 = false;
                        }
                        if (z15) {
                            imageButton4.setImageResource(R.drawable.baseline_fullscreen_exit_black_24);
                        }
                    }
                    ImageButton imageButton5 = (ImageButton) h0().findViewById(R.id.playerAspectRatio);
                    if (imageButton5 != null && imageButton5.hasOnClickListeners()) {
                        h0.b2(imageButton5);
                    }
                    u0().post(new b(this, 0));
                    AspectRatioFrameLayout aspectRatioFrameLayout4 = this.f14626m0;
                    if (aspectRatioFrameLayout4 != null) {
                        aspectRatioFrameLayout4.setResizeMode(3);
                        this.f14632s0 = t0().getInt("aspectRatioLandscape", 0);
                    } else {
                        j.l("aspectRatioFrameLayout");
                        throw null;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            } else {
                j.l("aspectRatioFrameLayout");
                throw null;
            }
        }
        CustomPlayerView customPlayerView = this.f14625l0;
        if (customPlayerView != null) {
            customPlayerView.setResizeMode(this.f14632s0);
        } else {
            j.l("playerView");
            throw null;
        }
    }

    public void z0(d1 d1Var) {
        j.f("error", d1Var);
        Log.e(this.F, "Player error", d1Var);
        h0.C1(f0(), R.string.player_error);
        h0.b1(h0.v0(C()), (h) null, 0, new g(this, (e) null), 3);
    }
}
