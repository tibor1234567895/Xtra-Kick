package j1;

public final class c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f8417c = new c0(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f8418a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8419b;

    static {
        new c0(0, 0);
    }

    public c0(int i10, int i11) {
        a.b((i10 == -1 || i10 >= 0) && (i11 == -1 || i11 >= 0));
        this.f8418a = i10;
        this.f8419b = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f8418a == c0Var.f8418a && this.f8419b == c0Var.f8419b;
    }

    public final int hashCode() {
        int i10 = this.f8418a;
        return ((i10 >>> 16) | (i10 << 16)) ^ this.f8419b;
    }

    public final String toString() {
        return this.f8418a + "x" + this.f8419b;
    }
}
