package g1;

import android.os.Bundle;
import d9.r0;
import g9.b;
import j1.l0;
import java.util.Collections;
import java.util.List;

public final class w1 implements m {

    /* renamed from: j  reason: collision with root package name */
    public static final String f6683j = l0.C(0);

    /* renamed from: k  reason: collision with root package name */
    public static final String f6684k = l0.C(1);

    /* renamed from: l  reason: collision with root package name */
    public static final a f6685l = new a(24);

    /* renamed from: h  reason: collision with root package name */
    public final v1 f6686h;

    /* renamed from: i  reason: collision with root package name */
    public final r0 f6687i;

    public w1(v1 v1Var, int i10) {
        this(v1Var, (List) r0.n(Integer.valueOf(i10)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w1.class != obj.getClass()) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return this.f6686h.equals(w1Var.f6686h) && this.f6687i.equals(w1Var.f6687i);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f6683j, this.f6686h.h());
        bundle.putIntArray(f6684k, b.d(this.f6687i));
        return bundle;
    }

    public final int hashCode() {
        return (this.f6687i.hashCode() * 31) + this.f6686h.hashCode();
    }

    public w1(v1 v1Var, List list) {
        if (list.isEmpty() || (((Integer) Collections.min(list)).intValue() >= 0 && ((Integer) Collections.max(list)).intValue() < v1Var.f6673h)) {
            this.f6686h = v1Var;
            this.f6687i = r0.j(list);
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
