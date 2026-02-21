package e1;

import android.text.TextUtils;
import l0.b;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4909a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4910b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4911c;

    public h0(String str, int i10, int i11) {
        this.f4909a = str;
        this.f4910b = i10;
        this.f4911c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        int i10 = this.f4911c;
        String str = this.f4909a;
        int i11 = this.f4910b;
        return (i11 < 0 || h0Var.f4910b < 0) ? TextUtils.equals(str, h0Var.f4909a) && i10 == h0Var.f4911c : TextUtils.equals(str, h0Var.f4909a) && i11 == h0Var.f4910b && i10 == h0Var.f4911c;
    }

    public final int hashCode() {
        return b.b(this.f4909a, Integer.valueOf(this.f4911c));
    }
}
