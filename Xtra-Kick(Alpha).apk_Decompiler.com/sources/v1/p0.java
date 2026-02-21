package v1;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f15747a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15748b;

    public p0(int i10, boolean z10) {
        this.f15747a = i10;
        this.f15748b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p0.class != obj.getClass()) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.f15747a == p0Var.f15747a && this.f15748b == p0Var.f15748b;
    }

    public final int hashCode() {
        return (this.f15747a * 31) + (this.f15748b ? 1 : 0);
    }
}
