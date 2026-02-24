package h3;

import android.os.Bundle;
import d9.i2;
import d9.u0;
import g1.m;
import j1.a;
import j1.l0;
import java.util.ArrayList;
import java.util.HashSet;
import l0.b;

public final class h4 implements m {

    /* renamed from: i  reason: collision with root package name */
    public static final h4 f7075i = new h4(new g4().f7052a);

    /* renamed from: j  reason: collision with root package name */
    public static final String f7076j = l0.C(0);

    /* renamed from: k  reason: collision with root package name */
    public static final j3 f7077k = new j3(12);

    /* renamed from: h  reason: collision with root package name */
    public final u0 f7078h;

    public h4(HashSet hashSet) {
        this.f7078h = u0.j(hashSet);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h4)) {
            return false;
        }
        return this.f7078h.equals(((h4) obj).f7078h);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        i2 g10 = this.f7078h.iterator();
        while (g10.hasNext()) {
            arrayList.add(((f4) g10.next()).h());
        }
        bundle.putParcelableArrayList(f7076j, arrayList);
        return bundle;
    }

    public final int hashCode() {
        return b.b(this.f7078h);
    }

    public final boolean i(int i10) {
        boolean z10;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a("Use contains(Command) for custom command", z10);
        for (f4 f4Var : this.f7078h) {
            if (f4Var.f7034h == i10) {
                return true;
            }
        }
        return false;
    }
}
