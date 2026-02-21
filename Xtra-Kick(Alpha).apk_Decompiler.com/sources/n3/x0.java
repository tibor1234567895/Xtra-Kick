package n3;

public final class x0 extends a1 {

    /* renamed from: b  reason: collision with root package name */
    public static final x0 f11553b = new x0();

    private x0() {
        super(false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x0) || this.f11039a != ((x0) obj).f11039a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f11039a ? 1231 : 1237;
    }

    public final String toString() {
        return "Loading(endOfPaginationReached=" + this.f11039a + ')';
    }
}
