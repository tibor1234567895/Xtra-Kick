package g1;

import android.os.Bundle;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.c;
import j1.l0;

public final class a2 implements m {

    /* renamed from: i  reason: collision with root package name */
    public static final a2 f6286i = new a2(r1.f4658l);

    /* renamed from: j  reason: collision with root package name */
    public static final String f6287j = l0.C(0);

    /* renamed from: k  reason: collision with root package name */
    public static final a f6288k = new a(26);

    /* renamed from: h  reason: collision with root package name */
    public final r0 f6289h;

    static {
        p0 p0Var = r0.f4657i;
    }

    public a2(r1 r1Var) {
        this.f6289h = r0.j(r1Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a2.class != obj.getClass()) {
            return false;
        }
        return this.f6289h.equals(((a2) obj).f6289h);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f6287j, c.b(this.f6289h));
        return bundle;
    }

    public final int hashCode() {
        return this.f6289h.hashCode();
    }

    public final boolean i(int i10) {
        boolean z10;
        int i11 = 0;
        while (true) {
            r0 r0Var = this.f6289h;
            if (i11 >= r0Var.size()) {
                return false;
            }
            z1 z1Var = (z1) r0Var.get(i11);
            boolean[] zArr = z1Var.f6781l;
            int length = zArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z10 = false;
                    break;
                } else if (zArr[i12]) {
                    z10 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (z10 && z1Var.f6778i.f6675j == i10) {
                return true;
            }
            i11++;
        }
    }
}
