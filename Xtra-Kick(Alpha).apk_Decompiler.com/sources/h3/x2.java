package h3;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.u;
import android.support.v4.media.session.w;
import android.support.v4.media.session.y;
import android.support.v4.media.session.z;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.fragment.app.g;
import e1.c0;
import e1.d0;
import g.g0;
import g1.f0;
import g1.l1;
import g1.o0;
import g1.p0;
import g1.s0;
import h9.v;
import j1.a;
import j1.l0;
import java.util.List;
import java.util.Objects;
import n1.h;
import z1.e;

public final class x2 extends y {

    /* renamed from: t  reason: collision with root package name */
    public static final int f7435t = (l0.f8453a >= 31 ? 33554432 : 0);

    /* renamed from: f  reason: collision with root package name */
    public final g f7436f;

    /* renamed from: g  reason: collision with root package name */
    public final n2 f7437g;

    /* renamed from: h  reason: collision with root package name */
    public final d0 f7438h;

    /* renamed from: i  reason: collision with root package name */
    public final v2 f7439i = new v2(this);

    /* renamed from: j  reason: collision with root package name */
    public final w f7440j;

    /* renamed from: k  reason: collision with root package name */
    public final w f7441k;

    /* renamed from: l  reason: collision with root package name */
    public final u f7442l;

    /* renamed from: m  reason: collision with root package name */
    public final String f7443m;

    /* renamed from: n  reason: collision with root package name */
    public final g0 f7444n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f7445o;

    /* renamed from: p  reason: collision with root package name */
    public y3 f7446p;

    /* renamed from: q  reason: collision with root package name */
    public volatile long f7447q;

    /* renamed from: r  reason: collision with root package name */
    public v f7448r;

    /* renamed from: s  reason: collision with root package name */
    public int f7449s;

    public x2(n2 n2Var, Uri uri, ComponentName componentName, Handler handler) {
        ComponentName componentName2;
        boolean z10;
        PendingIntent pendingIntent;
        ComponentName componentName3;
        this.f7437g = n2Var;
        Context context = n2Var.f7232e;
        this.f7443m = context.getPackageName();
        this.f7438h = d0.a(context);
        this.f7441k = new w(this, n2Var.f7239l.getLooper(), 6);
        g gVar = new g(n2Var);
        this.f7436f = gVar;
        this.f7447q = 300000;
        this.f7440j = new w(n2Var.f7239l.getLooper(), gVar);
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            componentName2 = new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.isEmpty()) {
            componentName2 = null;
        } else {
            throw new IllegalStateException("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found " + queryBroadcastReceivers.size());
        }
        if (componentName2 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f7445o = z10;
        componentName2 = componentName2 == null ? componentName : componentName2;
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", uri);
        if (componentName2 == null) {
            g0 g0Var = new g0(this);
            this.f7444n = g0Var;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(uri.getScheme());
            if (l0.f8453a < 33) {
                context.registerReceiver(g0Var, intentFilter);
            } else {
                Intent unused = context.registerReceiver(g0Var, intentFilter, 4);
            }
            intent2.setPackage(context.getPackageName());
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, f7435t);
            componentName3 = new ComponentName(context, context.getClass());
        } else {
            intent2.setComponent(componentName2);
            if (!Objects.equals(componentName, componentName2)) {
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, f7435t);
            } else if (l0.f8453a >= 26) {
                pendingIntent = PendingIntent.getForegroundService(context, 0, intent2, f7435t);
            } else {
                pendingIntent = PendingIntent.getService(context, 0, intent2, f7435t);
            }
            this.f7444n = null;
            componentName3 = componentName2;
        }
        u uVar = new u(context, TextUtils.join(".", new String[]{"androidx.media3.session.id", n2Var.f7235h}), componentName3, pendingIntent, n2Var.f7236i.f7191h.f());
        this.f7442l = uVar;
        PendingIntent pendingIntent2 = n2Var.f7238k;
        if (pendingIntent2 != null) {
            ((z) uVar.f428i).i(pendingIntent2);
        }
        uVar.K(this, handler);
    }

    public static void E(x2 x2Var, a4 a4Var) {
        int i10;
        x2Var.getClass();
        if (a4Var.L0(20)) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        if (x2Var.f7449s != i10) {
            x2Var.f7449s = i10;
            ((z) x2Var.f7442l.f428i).g(i10);
        }
    }

    public static s0 F(String str, Uri uri, String str2, Bundle bundle) {
        f0 f0Var = new f0();
        if (str == null) {
            str = "";
        }
        f0Var.f6358a = str;
        o0 o0Var = new o0();
        o0Var.f6495a = uri;
        o0Var.f6496b = str2;
        o0Var.f6497c = bundle;
        f0Var.f6369l = new p0(o0Var);
        return f0Var.a();
    }

    public final void A() {
        boolean L0 = this.f7437g.f7246s.L0(7);
        u uVar = this.f7442l;
        if (L0) {
            G(7, uVar.s(), new o2(this, 8));
            return;
        }
        G(6, uVar.s(), new o2(this, 9));
    }

    public final void B(long j10) {
        G(10, this.f7442l.s(), new q2(this, j10, 0));
    }

    public final void C() {
        G(3, this.f7442l.s(), new o2(this, 10));
    }

    public final void G(int i10, c0 c0Var, w2 w2Var) {
        n2 n2Var = this.f7437g;
        if (!n2Var.f()) {
            if (c0Var == null) {
                j1.v.b();
            } else {
                l0.L(n2Var.f7239l, new t1(this, i10, c0Var, w2Var, 1));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        j1.l0.L(r8.f7437g.f7239l, new h3.z0(r8, r12, r9, r10, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(int r9, e1.c0 r10, h3.w2 r11, h3.f4 r12) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x000f
            if (r12 != 0) goto L_0x0008
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)
        L_0x0008:
            java.util.Objects.toString(r12)
            j1.v.b()
            return
        L_0x000f:
            h3.n2 r0 = r8.f7437g
            android.os.Handler r0 = r0.f7239l
            h3.z0 r7 = new h3.z0
            r1 = r7
            r2 = r8
            r3 = r12
            r4 = r9
            r5 = r10
            r6 = r11
            r1.<init>((h3.x2) r2, (h3.f4) r3, (int) r4, (e1.c0) r5, (h3.w2) r6)
            j1.l0.L(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.x2.H(int, e1.c0, h3.w2, h3.f4):void");
    }

    public final void I(s0 s0Var, boolean z10) {
        G(31, this.f7442l.s(), new e(this, s0Var, z10, 3));
    }

    public final e2 J(c0 c0Var) {
        e2 e10 = this.f7436f.e(c0Var);
        if (e10 == null) {
            t2 t2Var = new t2(c0Var);
            boolean b10 = this.f7438h.b(c0Var);
            Bundle bundle = Bundle.EMPTY;
            e2 e2Var = new e2(c0Var, 0, b10, t2Var);
            n2 n2Var = this.f7437g;
            c2 c10 = n2Var.f7231d.c(n2Var.f7237j, e2Var);
            a.d(c10, "onConnect must return non-null future");
            this.f7436f.a(c0Var, e2Var, c10.f6955a, c10.f6956b);
            e10 = e2Var;
        }
        w wVar = this.f7440j;
        long j10 = this.f7447q;
        wVar.removeMessages(1001, e10);
        wVar.sendMessageDelayed(wVar.obtainMessage(1001, e10), j10);
        return e10;
    }

    public final void b(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat != null) {
            G(20, this.f7442l.s(), new h((Object) this, -1, (Object) mediaDescriptionCompat));
        }
    }

    public final void c(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        if (mediaDescriptionCompat != null) {
            G(20, this.f7442l.s(), new h((Object) this, i10, (Object) mediaDescriptionCompat));
        }
    }

    public final void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        a.f(str);
        if (!TextUtils.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN", str) || resultReceiver == null) {
            f4 f4Var = new f4(Bundle.EMPTY, str);
            H(0, this.f7442l.s(), new androidx.fragment.app.h(this, f4Var, bundle, resultReceiver, 1), f4Var);
            return;
        }
        resultReceiver.send(0, this.f7437g.f7236i.h());
    }

    public final void e(String str, Bundle bundle) {
        f4 f4Var = new f4(Bundle.EMPTY, str);
        H(0, this.f7442l.s(), new f0(this, f4Var, bundle, 3), f4Var);
    }

    public final void f() {
        G(12, this.f7442l.s(), new o2(this, 5));
    }

    public final boolean g(Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return false;
        }
        c0 s10 = this.f7442l.s();
        int keyCode = keyEvent.getKeyCode();
        w wVar = this.f7441k;
        if (keyCode == 79 || keyCode == 85) {
            if (this.f7443m.equals(s10.f4895a.f4909a) || keyEvent.getRepeatCount() != 0) {
                wVar.removeMessages(1002);
                G(1, s10, new o2(this, 0));
            } else if (wVar.hasMessages(1002)) {
                wVar.removeMessages(1002);
                z();
            } else {
                wVar.sendMessageDelayed(wVar.obtainMessage(1002, s10), (long) ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }
        if (wVar.hasMessages(1002)) {
            wVar.removeMessages(1002);
            G(1, s10, new o2(this, 0));
        }
        return false;
    }

    public final void h() {
        G(1, this.f7442l.s(), new o2(this, 4));
    }

    public final void i() {
        G(1, this.f7442l.s(), new o2(this, 6));
    }

    public final void j(String str, Bundle bundle) {
        I(F(str, (Uri) null, (String) null, bundle), true);
    }

    public final void k(String str, Bundle bundle) {
        I(F((String) null, (Uri) null, str, bundle), true);
    }

    public final void l(Uri uri, Bundle bundle) {
        I(F((String) null, uri, (String) null, bundle), true);
    }

    public final void m() {
        G(2, this.f7442l.s(), new o2(this, 1));
    }

    public final void n(String str, Bundle bundle) {
        I(F(str, (Uri) null, (String) null, bundle), false);
    }

    public final void o(String str, Bundle bundle) {
        I(F((String) null, (Uri) null, str, bundle), false);
    }

    public final void p(Uri uri, Bundle bundle) {
        I(F((String) null, uri, (String) null, bundle), false);
    }

    public final void q(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat != null) {
            G(20, this.f7442l.s(), new g(this, 27, mediaDescriptionCompat));
        }
    }

    public final void r() {
        G(11, this.f7442l.s(), new o2(this, 7));
    }

    public final void s(long j10) {
        G(5, this.f7442l.s(), new q2(this, j10, 1));
    }

    public final void t() {
    }

    public final void u(float f10) {
        G(13, this.f7442l.s(), new n1.v(this, f10));
    }

    public final void v(RatingCompat ratingCompat) {
        w(ratingCompat);
    }

    public final void w(RatingCompat ratingCompat) {
        l1 q10 = t3.q(ratingCompat);
        if (q10 == null) {
            j1.v.g("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + ratingCompat);
            return;
        }
        H(40010, this.f7442l.s(), new g(this, 28, q10), (f4) null);
    }

    public final void x(int i10) {
        G(15, this.f7442l.s(), new p2(this, i10, 1));
    }

    public final void y(int i10) {
        G(14, this.f7442l.s(), new p2(this, i10, 0));
    }

    public final void z() {
        boolean L0 = this.f7437g.f7246s.L0(9);
        u uVar = this.f7442l;
        if (L0) {
            G(9, uVar.s(), new o2(this, 2));
            return;
        }
        G(8, uVar.s(), new o2(this, 3));
    }
}
