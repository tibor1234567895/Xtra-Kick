package h3;

import android.os.Bundle;
import android.os.SystemClock;
import g1.m;
import j1.l0;

public final class j4 implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final String f7139k = l0.C(0);

    /* renamed from: l  reason: collision with root package name */
    public static final String f7140l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final String f7141m = l0.C(2);

    /* renamed from: n  reason: collision with root package name */
    public static final j3 f7142n = new j3(14);

    /* renamed from: h  reason: collision with root package name */
    public final int f7143h;

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f7144i;

    /* renamed from: j  reason: collision with root package name */
    public final long f7145j;

    public j4(int i10) {
        this(i10, Bundle.EMPTY);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7139k, this.f7143h);
        bundle.putBundle(f7140l, this.f7144i);
        bundle.putLong(f7141m, this.f7145j);
        return bundle;
    }

    public j4(int i10, Bundle bundle) {
        this(i10, bundle, SystemClock.elapsedRealtime());
    }

    public j4(int i10, Bundle bundle, long j10) {
        this.f7143h = i10;
        this.f7144i = new Bundle(bundle);
        this.f7145j = j10;
    }
}
