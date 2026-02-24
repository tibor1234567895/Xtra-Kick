package d9;

import c9.q;
import java.util.Objects;

public final class v1 extends r0 {

    /* renamed from: j  reason: collision with root package name */
    public final transient Object[] f4683j;

    /* renamed from: k  reason: collision with root package name */
    public final transient int f4684k;

    /* renamed from: l  reason: collision with root package name */
    public final transient int f4685l;

    public v1(int i10, int i11, Object[] objArr) {
        this.f4683j = objArr;
        this.f4684k = i10;
        this.f4685l = i11;
    }

    public final boolean f() {
        return true;
    }

    public final Object get(int i10) {
        q.b(i10, this.f4685l);
        Object obj = this.f4683j[(i10 * 2) + this.f4684k];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.f4685l;
    }
}
