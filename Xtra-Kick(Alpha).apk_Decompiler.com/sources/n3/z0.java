package n3;

public final class z0 extends a1 {

    /* renamed from: b  reason: collision with root package name */
    public static final y0 f11599b = new y0(0);

    /* renamed from: c  reason: collision with root package name */
    public static final z0 f11600c = new z0(true);

    /* renamed from: d  reason: collision with root package name */
    public static final z0 f11601d = new z0(false);

    public z0(boolean z10) {
        super(z10);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z0) || this.f11039a != ((z0) obj).f11039a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f11039a ? 1231 : 1237;
    }

    public final String toString() {
        return "NotLoading(endOfPaginationReached=" + this.f11039a + ')';
    }
}
