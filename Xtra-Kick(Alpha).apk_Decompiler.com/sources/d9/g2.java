package d9;

public final class g2 extends u0 {

    /* renamed from: k  reason: collision with root package name */
    public final transient Object f4620k;

    public g2(Object obj) {
        obj.getClass();
        this.f4620k = obj;
    }

    public final r0 a() {
        return r0.n(this.f4620k);
    }

    public final int b(int i10, Object[] objArr) {
        objArr[i10] = this.f4620k;
        return i10 + 1;
    }

    public final boolean contains(Object obj) {
        return this.f4620k.equals(obj);
    }

    public final boolean f() {
        return false;
    }

    /* renamed from: g */
    public final i2 iterator() {
        return new x0(this.f4620k);
    }

    public final int hashCode() {
        return this.f4620k.hashCode();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.f4620k.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }
}
