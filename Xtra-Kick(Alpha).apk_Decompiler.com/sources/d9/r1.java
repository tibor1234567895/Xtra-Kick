package d9;

import c9.q;
import java.util.Objects;

public final class r1 extends r0 {

    /* renamed from: l  reason: collision with root package name */
    public static final r1 f4658l = new r1(0, new Object[0]);

    /* renamed from: j  reason: collision with root package name */
    public final transient Object[] f4659j;

    /* renamed from: k  reason: collision with root package name */
    public final transient int f4660k;

    public r1(int i10, Object[] objArr) {
        this.f4659j = objArr;
        this.f4660k = i10;
    }

    public final int b(int i10, Object[] objArr) {
        Object[] objArr2 = this.f4659j;
        int i11 = this.f4660k;
        System.arraycopy(objArr2, 0, objArr, i10, i11);
        return i10 + i11;
    }

    public final Object[] c() {
        return this.f4659j;
    }

    public final int d() {
        return this.f4660k;
    }

    public final int e() {
        return 0;
    }

    public final boolean f() {
        return false;
    }

    public final Object get(int i10) {
        q.b(i10, this.f4660k);
        Object obj = this.f4659j[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.f4660k;
    }
}
