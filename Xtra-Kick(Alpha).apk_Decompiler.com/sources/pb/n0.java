package pb;

import fb.w;
import hb.h0;
import java.util.ArrayList;
import xa.j;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f12909a = new ArrayList(20);

    public final void a(String str, String str2) {
        j.f("name", str);
        j.f("value", str2);
        h0.N0(str);
        h0.O0(str2, str);
        h0.C(this, str, str2);
    }

    public final p0 b() {
        Object[] array = this.f12909a.toArray(new String[0]);
        j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
        return new p0((String[]) array);
    }

    public final void c(String str) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f12909a;
            if (i10 < arrayList.size()) {
                if (w.g(str, (String) arrayList.get(i10))) {
                    arrayList.remove(i10);
                    arrayList.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            } else {
                return;
            }
        }
    }
}
