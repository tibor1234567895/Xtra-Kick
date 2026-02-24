package m1;

import android.text.TextUtils;
import g1.a0;
import j1.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f10252a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f10253b;

    /* renamed from: c  reason: collision with root package name */
    public final a0 f10254c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10255d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10256e;

    public h(String str, a0 a0Var, a0 a0Var2, int i10, int i11) {
        boolean z10;
        if (i10 == 0 || i11 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        if (!TextUtils.isEmpty(str)) {
            this.f10252a = str;
            a0Var.getClass();
            this.f10253b = a0Var;
            a0Var2.getClass();
            this.f10254c = a0Var2;
            this.f10255d = i10;
            this.f10256e = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f10255d == hVar.f10255d && this.f10256e == hVar.f10256e && this.f10252a.equals(hVar.f10252a) && this.f10253b.equals(hVar.f10253b) && this.f10254c.equals(hVar.f10254c);
    }

    public final int hashCode() {
        int e10 = android.support.v4.media.h.e(this.f10252a, (((this.f10255d + 527) * 31) + this.f10256e) * 31, 31);
        return this.f10254c.hashCode() + ((this.f10253b.hashCode() + e10) * 31);
    }
}
