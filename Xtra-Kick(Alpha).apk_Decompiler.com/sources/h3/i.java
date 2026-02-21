package h3;

import android.app.PendingIntent;
import android.os.Bundle;
import b0.j;
import f3.a;
import g1.g1;
import g1.m;
import j1.l0;

public final class i implements m {

    /* renamed from: q  reason: collision with root package name */
    public static final String f7079q = l0.C(0);

    /* renamed from: r  reason: collision with root package name */
    public static final String f7080r = l0.C(1);

    /* renamed from: s  reason: collision with root package name */
    public static final String f7081s = l0.C(2);

    /* renamed from: t  reason: collision with root package name */
    public static final String f7082t = l0.C(3);

    /* renamed from: u  reason: collision with root package name */
    public static final String f7083u = l0.C(4);

    /* renamed from: v  reason: collision with root package name */
    public static final String f7084v = l0.C(5);

    /* renamed from: w  reason: collision with root package name */
    public static final String f7085w = l0.C(6);

    /* renamed from: x  reason: collision with root package name */
    public static final String f7086x = l0.C(7);

    /* renamed from: y  reason: collision with root package name */
    public static final String f7087y = l0.C(8);

    /* renamed from: z  reason: collision with root package name */
    public static final a f7088z = new a(8);

    /* renamed from: h  reason: collision with root package name */
    public final int f7089h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7090i;

    /* renamed from: j  reason: collision with root package name */
    public final r f7091j;

    /* renamed from: k  reason: collision with root package name */
    public final PendingIntent f7092k;

    /* renamed from: l  reason: collision with root package name */
    public final h4 f7093l;

    /* renamed from: m  reason: collision with root package name */
    public final g1 f7094m;

    /* renamed from: n  reason: collision with root package name */
    public final g1 f7095n;

    /* renamed from: o  reason: collision with root package name */
    public final Bundle f7096o;

    /* renamed from: p  reason: collision with root package name */
    public final w3 f7097p;

    public i(int i10, int i11, r rVar, PendingIntent pendingIntent, h4 h4Var, g1 g1Var, g1 g1Var2, Bundle bundle, w3 w3Var) {
        this.f7089h = i10;
        this.f7090i = i11;
        this.f7091j = rVar;
        this.f7093l = h4Var;
        this.f7094m = g1Var;
        this.f7095n = g1Var2;
        this.f7092k = pendingIntent;
        this.f7096o = bundle;
        this.f7097p = w3Var;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7079q, this.f7089h);
        j.b(bundle, f7080r, this.f7091j.asBinder());
        bundle.putParcelable(f7081s, this.f7092k);
        bundle.putBundle(f7082t, this.f7093l.h());
        g1 g1Var = this.f7094m;
        bundle.putBundle(f7083u, g1Var.h());
        g1 g1Var2 = this.f7095n;
        bundle.putBundle(f7084v, g1Var2.h());
        bundle.putBundle(f7085w, this.f7096o);
        bundle.putBundle(f7086x, this.f7097p.p(t3.y(g1Var, g1Var2), false, false));
        bundle.putInt(f7087y, this.f7090i);
        return bundle;
    }
}
