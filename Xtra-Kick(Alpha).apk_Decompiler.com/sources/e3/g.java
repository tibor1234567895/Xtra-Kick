package e3;

public final class g implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public final int f5018h;

    /* renamed from: i  reason: collision with root package name */
    public final c f5019i;

    public g(int i10, c cVar) {
        this.f5018h = i10;
        this.f5019i = cVar;
    }

    public final int compareTo(Object obj) {
        return Integer.compare(this.f5018h, ((g) obj).f5018h);
    }
}
