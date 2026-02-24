package h3;

import android.os.Bundle;
import f3.a;
import g1.m;
import j1.l0;

public final class d implements m {

    /* renamed from: n  reason: collision with root package name */
    public static final String f6964n = l0.C(0);

    /* renamed from: o  reason: collision with root package name */
    public static final String f6965o = l0.C(1);

    /* renamed from: p  reason: collision with root package name */
    public static final String f6966p = l0.C(2);

    /* renamed from: q  reason: collision with root package name */
    public static final String f6967q = l0.C(3);

    /* renamed from: r  reason: collision with root package name */
    public static final String f6968r = l0.C(4);

    /* renamed from: s  reason: collision with root package name */
    public static final String f6969s = l0.C(5);

    /* renamed from: t  reason: collision with root package name */
    public static final a f6970t = new a(6);

    /* renamed from: h  reason: collision with root package name */
    public final f4 f6971h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6972i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6973j;

    /* renamed from: k  reason: collision with root package name */
    public final CharSequence f6974k;

    /* renamed from: l  reason: collision with root package name */
    public final Bundle f6975l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f6976m;

    public d(f4 f4Var, int i10, int i11, CharSequence charSequence, Bundle bundle, boolean z10) {
        this.f6971h = f4Var;
        this.f6972i = i10;
        this.f6973j = i11;
        this.f6974k = charSequence;
        this.f6975l = new Bundle(bundle);
        this.f6976m = z10;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        f4 f4Var = this.f6971h;
        if (f4Var != null) {
            bundle.putBundle(f6964n, f4Var.h());
        }
        bundle.putInt(f6965o, this.f6972i);
        bundle.putInt(f6966p, this.f6973j);
        bundle.putCharSequence(f6967q, this.f6974k);
        bundle.putBundle(f6968r, this.f6975l);
        bundle.putBoolean(f6969s, this.f6976m);
        return bundle;
    }
}
