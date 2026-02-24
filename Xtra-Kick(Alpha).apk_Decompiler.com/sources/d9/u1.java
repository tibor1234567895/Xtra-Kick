package d9;

public final class u1 extends u0 {

    /* renamed from: k  reason: collision with root package name */
    public final transient t0 f4679k;

    /* renamed from: l  reason: collision with root package name */
    public final transient r0 f4680l;

    public u1(t0 t0Var, v1 v1Var) {
        this.f4679k = t0Var;
        this.f4680l = v1Var;
    }

    public final r0 a() {
        return this.f4680l;
    }

    public final int b(int i10, Object[] objArr) {
        return this.f4680l.b(i10, objArr);
    }

    public final boolean contains(Object obj) {
        return this.f4679k.get(obj) != null;
    }

    public final boolean f() {
        return true;
    }

    /* renamed from: g */
    public final i2 iterator() {
        return this.f4680l.listIterator(0);
    }

    public final int size() {
        return this.f4679k.size();
    }
}
