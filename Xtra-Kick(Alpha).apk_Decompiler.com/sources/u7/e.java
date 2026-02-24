package u7;

public final class e implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public int f15390h;

    /* renamed from: i  reason: collision with root package name */
    public int f15391i;

    private e() {
    }

    public /* synthetic */ e(int i10) {
        this();
    }

    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        int i10 = this.f15391i;
        int i11 = eVar.f15391i;
        if (i10 != i11) {
            return i10 - i11;
        }
        return this.f15390h - eVar.f15390h;
    }

    public final String toString() {
        return "Order{order=" + this.f15391i + ", index=" + this.f15390h + '}';
    }
}
