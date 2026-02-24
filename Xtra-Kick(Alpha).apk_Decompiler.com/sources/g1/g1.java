package g1;

import android.os.Bundle;
import j1.l0;
import java.util.ArrayList;

public final class g1 implements m {

    /* renamed from: i  reason: collision with root package name */
    public static final g1 f6382i = new f1().c();

    /* renamed from: j  reason: collision with root package name */
    public static final String f6383j = l0.C(0);

    /* renamed from: k  reason: collision with root package name */
    public static final a f6384k = new a(15);

    /* renamed from: h  reason: collision with root package name */
    public final y f6385h;

    public g1(y yVar) {
        this.f6385h = yVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        return this.f6385h.equals(((g1) obj).f6385h);
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            y yVar = this.f6385h;
            if (i10 < yVar.c()) {
                arrayList.add(Integer.valueOf(yVar.b(i10)));
                i10++;
            } else {
                bundle.putIntegerArrayList(f6383j, arrayList);
                return bundle;
            }
        }
    }

    public final int hashCode() {
        return this.f6385h.hashCode();
    }

    public final boolean i(int i10) {
        return this.f6385h.f6716a.get(i10);
    }
}
