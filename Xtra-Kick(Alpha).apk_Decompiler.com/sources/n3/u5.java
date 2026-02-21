package n3;

import android.support.v4.media.h;
import java.util.Arrays;
import java.util.List;
import ma.b0;
import xa.j;

public final class u5 {

    /* renamed from: d  reason: collision with root package name */
    public static final t5 f11511d = new t5(0);

    /* renamed from: e  reason: collision with root package name */
    public static final u5 f11512e = new u5(b0.f10801h, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int[] f11513a;

    /* renamed from: b  reason: collision with root package name */
    public final List f11514b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11515c;

    public u5(List list, int i10) {
        j.f("data", list);
        this.f11513a = new int[]{i10};
        this.f11514b = list;
        this.f11515c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(u5.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            u5 u5Var = (u5) obj;
            return Arrays.equals(this.f11513a, u5Var.f11513a) && j.a(this.f11514b, u5Var.f11514b) && this.f11515c == u5Var.f11515c && j.a((Object) null, (Object) null);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
    }

    public final int hashCode() {
        return ((((this.f11514b.hashCode() + (Arrays.hashCode(this.f11513a) * 31)) * 31) + this.f11515c) * 31) + 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TransformablePage(originalPageOffsets=");
        sb2.append(Arrays.toString(this.f11513a));
        sb2.append(", data=");
        sb2.append(this.f11514b);
        sb2.append(", hintOriginalPageOffset=");
        return h.o(sb2, this.f11515c, ", hintOriginalIndices=null)");
    }
}
