package g1;

import android.net.Uri;
import android.os.Bundle;
import j1.l0;

public final class p0 implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final p0 f6501k = new p0(new o0());

    /* renamed from: l  reason: collision with root package name */
    public static final String f6502l = l0.C(0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f6503m = l0.C(1);

    /* renamed from: n  reason: collision with root package name */
    public static final String f6504n = l0.C(2);

    /* renamed from: o  reason: collision with root package name */
    public static final a f6505o = new a(10);

    /* renamed from: h  reason: collision with root package name */
    public final Uri f6506h;

    /* renamed from: i  reason: collision with root package name */
    public final String f6507i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f6508j;

    public p0(o0 o0Var) {
        this.f6506h = o0Var.f6495a;
        this.f6507i = o0Var.f6496b;
        this.f6508j = o0Var.f6497c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return l0.a(this.f6506h, p0Var.f6506h) && l0.a(this.f6507i, p0Var.f6507i);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        Uri uri = this.f6506h;
        if (uri != null) {
            bundle.putParcelable(f6502l, uri);
        }
        String str = this.f6507i;
        if (str != null) {
            bundle.putString(f6503m, str);
        }
        Bundle bundle2 = this.f6508j;
        if (bundle2 != null) {
            bundle.putBundle(f6504n, bundle2);
        }
        return bundle;
    }

    public final int hashCode() {
        int i10 = 0;
        Uri uri = this.f6506h;
        int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.f6507i;
        if (str != null) {
            i10 = str.hashCode();
        }
        return hashCode + i10;
    }
}
