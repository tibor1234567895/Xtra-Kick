package d9;

import c9.q;
import java.util.AbstractMap;
import java.util.Objects;

public final class s1 extends r0 {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t1 f4665j;

    public s1(t1 t1Var) {
        this.f4665j = t1Var;
    }

    public final boolean f() {
        return true;
    }

    public final Object get(int i10) {
        t1 t1Var = this.f4665j;
        q.b(i10, t1Var.f4676n);
        int i11 = i10 * 2;
        int i12 = t1Var.f4675m;
        Object[] objArr = t1Var.f4674l;
        Object obj = objArr[i12 + i11];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i11 + (i12 ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.f4665j.f4676n;
    }
}
