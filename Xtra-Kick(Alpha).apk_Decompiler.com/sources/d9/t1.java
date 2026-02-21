package d9;

import java.util.Map;

public final class t1 extends u0 {

    /* renamed from: k  reason: collision with root package name */
    public final transient t0 f4673k;

    /* renamed from: l  reason: collision with root package name */
    public final transient Object[] f4674l;

    /* renamed from: m  reason: collision with root package name */
    public final transient int f4675m;

    /* renamed from: n  reason: collision with root package name */
    public final transient int f4676n;

    public t1(t0 t0Var, Object[] objArr, int i10, int i11) {
        this.f4673k = t0Var;
        this.f4674l = objArr;
        this.f4675m = i10;
        this.f4676n = i11;
    }

    public final int b(int i10, Object[] objArr) {
        return a().b(i10, objArr);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.f4673k.get(key));
    }

    public final boolean f() {
        return true;
    }

    /* renamed from: g */
    public final i2 iterator() {
        return a().listIterator(0);
    }

    public final r0 k() {
        return new s1(this);
    }

    public final int size() {
        return this.f4676n;
    }
}
