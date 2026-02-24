package h3;

import android.os.Bundle;
import f3.a;
import g1.m;
import j1.l0;

public final class h implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final String f7053m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f7054n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f7055o = l0.C(2);

    /* renamed from: p  reason: collision with root package name */
    public static final String f7056p = l0.C(3);

    /* renamed from: q  reason: collision with root package name */
    public static final String f7057q = l0.C(4);

    /* renamed from: r  reason: collision with root package name */
    public static final a f7058r = new a(7);

    /* renamed from: h  reason: collision with root package name */
    public final int f7059h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7060i;

    /* renamed from: j  reason: collision with root package name */
    public final String f7061j;

    /* renamed from: k  reason: collision with root package name */
    public final int f7062k;

    /* renamed from: l  reason: collision with root package name */
    public final Bundle f7063l;

    public h(int i10, int i11, String str, int i12, Bundle bundle) {
        this.f7059h = i10;
        this.f7060i = i11;
        this.f7061j = str;
        this.f7062k = i12;
        this.f7063l = bundle;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7053m, this.f7059h);
        bundle.putString(f7054n, this.f7061j);
        bundle.putInt(f7055o, this.f7062k);
        bundle.putBundle(f7056p, this.f7063l);
        bundle.putInt(f7057q, this.f7060i);
        return bundle;
    }

    public h(String str, int i10, Bundle bundle) {
        this(1000002300, 2, str, i10, new Bundle(bundle));
    }
}
