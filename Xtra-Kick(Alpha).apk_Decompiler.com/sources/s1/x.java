package s1;

import android.support.v4.media.h;
import android.text.TextUtils;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final String f14084a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f14085b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f14086c;

    public x(String str, boolean z10, boolean z11) {
        this.f14084a = str;
        this.f14085b = z10;
        this.f14086c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != x.class) {
            return false;
        }
        x xVar = (x) obj;
        return TextUtils.equals(this.f14084a, xVar.f14084a) && this.f14085b == xVar.f14085b && this.f14086c == xVar.f14086c;
    }

    public final int hashCode() {
        int i10;
        int e10 = h.e(this.f14084a, 31, 31);
        int i11 = 1231;
        if (this.f14085b) {
            i10 = 1231;
        } else {
            i10 = 1237;
        }
        int i12 = (e10 + i10) * 31;
        if (!this.f14086c) {
            i11 = 1237;
        }
        return i12 + i11;
    }
}
