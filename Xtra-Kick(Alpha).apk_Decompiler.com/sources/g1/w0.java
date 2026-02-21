package g1;

public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6678a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6679b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6680c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6681d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6682e;

    public w0(long j10, Object obj) {
        this(obj, -1, -1, j10, -1);
    }

    public final boolean a() {
        return this.f6679b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f6678a.equals(w0Var.f6678a) && this.f6679b == w0Var.f6679b && this.f6680c == w0Var.f6680c && this.f6681d == w0Var.f6681d && this.f6682e == w0Var.f6682e;
    }

    public final int hashCode() {
        return ((((((((this.f6678a.hashCode() + 527) * 31) + this.f6679b) * 31) + this.f6680c) * 31) + ((int) this.f6681d)) * 31) + this.f6682e;
    }

    public w0(w0 w0Var) {
        this.f6678a = w0Var.f6678a;
        this.f6679b = w0Var.f6679b;
        this.f6680c = w0Var.f6680c;
        this.f6681d = w0Var.f6681d;
        this.f6682e = w0Var.f6682e;
    }

    public w0(Object obj, int i10, int i11, long j10, int i12) {
        this.f6678a = obj;
        this.f6679b = i10;
        this.f6680c = i11;
        this.f6681d = j10;
        this.f6682e = i12;
    }
}
