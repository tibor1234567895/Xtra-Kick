package n3;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ma.b0;
import xa.j;

public final class k4 extends l4 {

    /* renamed from: a  reason: collision with root package name */
    public final List f11287a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f11288b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f11289c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11290d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11291e;

    static {
        new j4(0);
        new k4(b0.f10801h, (Integer) null, (Integer) null, 0, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public k4(List list, Integer num, Integer num2) {
        this(list, num, num2, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
        j.f("data", list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k4)) {
            return false;
        }
        k4 k4Var = (k4) obj;
        return j.a(this.f11287a, k4Var.f11287a) && j.a(this.f11288b, k4Var.f11288b) && j.a(this.f11289c, k4Var.f11289c) && this.f11290d == k4Var.f11290d && this.f11291e == k4Var.f11291e;
    }

    public final int hashCode() {
        int hashCode = this.f11287a.hashCode() * 31;
        int i10 = 0;
        Object obj = this.f11288b;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f11289c;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return ((((hashCode2 + i10) * 31) + this.f11290d) * 31) + this.f11291e;
    }

    public final String toString() {
        return "Page(data=" + this.f11287a + ", prevKey=" + this.f11288b + ", nextKey=" + this.f11289c + ", itemsBefore=" + this.f11290d + ", itemsAfter=" + this.f11291e + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k4(List list, Integer num, Integer num2, int i10, int i11) {
        super(0);
        j.f("data", list);
        boolean z10 = false;
        this.f11287a = list;
        this.f11288b = num;
        this.f11289c = num2;
        this.f11290d = i10;
        this.f11291e = i11;
        if (i10 == Integer.MIN_VALUE || i10 >= 0) {
            if (!((i11 == Integer.MIN_VALUE || i11 >= 0) ? true : z10)) {
                throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
            }
            return;
        }
        throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
    }
}
