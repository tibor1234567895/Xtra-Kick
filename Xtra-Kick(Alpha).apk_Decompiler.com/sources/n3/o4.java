package n3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ma.r;
import ma.z;
import xa.j;

public final class o4 {

    /* renamed from: a  reason: collision with root package name */
    public final List f11382a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f11383b;

    /* renamed from: c  reason: collision with root package name */
    public final r3 f11384c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11385d;

    public o4(List list, Integer num, r3 r3Var, int i10) {
        j.f("pages", list);
        j.f("config", r3Var);
        this.f11382a = list;
        this.f11383b = num;
        this.f11384c = r3Var;
        this.f11385d = i10;
    }

    public final k4 a(int i10) {
        Object obj;
        List list = this.f11382a;
        int i11 = 0;
        boolean z10 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((k4) it.next()).f11287a.isEmpty()) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z10) {
            return null;
        }
        int i12 = i10 - this.f11385d;
        while (i11 < r.d(list) && i12 > r.d(((k4) list.get(i11)).f11287a)) {
            i12 -= ((k4) list.get(i11)).f11287a.size();
            i11++;
        }
        if (i12 < 0) {
            obj = z.s(list);
        } else {
            obj = list.get(i11);
        }
        return (k4) obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o4) {
            o4 o4Var = (o4) obj;
            return j.a(this.f11382a, o4Var.f11382a) && j.a(this.f11383b, o4Var.f11383b) && j.a(this.f11384c, o4Var.f11384c) && this.f11385d == o4Var.f11385d;
        }
    }

    public final int hashCode() {
        int hashCode = this.f11382a.hashCode();
        Integer num = this.f11383b;
        return this.f11384c.hashCode() + hashCode + (num != null ? num.hashCode() : 0) + this.f11385d;
    }

    public final String toString() {
        return "PagingState(pages=" + this.f11382a + ", anchorPosition=" + this.f11383b + ", config=" + this.f11384c + ", leadingPlaceholderCount=" + this.f11385d + ')';
    }
}
