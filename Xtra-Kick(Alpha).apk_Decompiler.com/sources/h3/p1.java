package h3;

import android.os.Bundle;
import f3.a;
import g1.m;
import j1.l0;

public final class p1 implements m {

    /* renamed from: l  reason: collision with root package name */
    public static final String f7275l = l0.C(0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f7276m = l0.C(1);

    /* renamed from: n  reason: collision with root package name */
    public static final String f7277n = l0.C(2);

    /* renamed from: o  reason: collision with root package name */
    public static final String f7278o = l0.C(3);

    /* renamed from: p  reason: collision with root package name */
    public static final a f7279p = new a(18);

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f7280h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7281i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f7282j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f7283k;

    public p1(Bundle bundle, boolean z10, boolean z11, boolean z12) {
        this.f7280h = new Bundle(bundle);
        this.f7281i = z10;
        this.f7282j = z11;
        this.f7283k = z12;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f7275l, this.f7280h);
        bundle.putBoolean(f7276m, this.f7281i);
        bundle.putBoolean(f7277n, this.f7282j);
        bundle.putBoolean(f7278o, this.f7283k);
        return bundle;
    }
}
