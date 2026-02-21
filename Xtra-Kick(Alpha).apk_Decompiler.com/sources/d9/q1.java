package d9;

public final class q1 extends j0 {

    /* renamed from: p  reason: collision with root package name */
    public static final q1 f4650p = new q1();

    /* renamed from: k  reason: collision with root package name */
    public final transient Object f4651k;

    /* renamed from: l  reason: collision with root package name */
    public final transient Object[] f4652l;

    /* renamed from: m  reason: collision with root package name */
    public final transient int f4653m;

    /* renamed from: n  reason: collision with root package name */
    public final transient int f4654n;

    /* renamed from: o  reason: collision with root package name */
    public final transient q1 f4655o;

    private q1() {
        this.f4651k = null;
        this.f4652l = new Object[0];
        this.f4653m = 0;
        this.f4654n = 0;
        this.f4655o = this;
    }

    public final t1 b() {
        return new t1(this, this.f4652l, this.f4653m, this.f4654n);
    }

    public final u1 c() {
        return new u1(this, new v1(this.f4653m, this.f4654n, this.f4652l));
    }

    public final void e() {
    }

    public final q1 g() {
        return this.f4655o;
    }

    public final Object get(Object obj) {
        Object i10 = w1.i(this.f4651k, this.f4652l, this.f4654n, this.f4653m, obj);
        if (i10 == null) {
            return null;
        }
        return i10;
    }

    public final int size() {
        return this.f4654n;
    }

    public q1(int i10, Object[] objArr) {
        this.f4652l = objArr;
        this.f4654n = i10;
        this.f4653m = 0;
        int h10 = i10 >= 2 ? u0.h(i10) : 0;
        this.f4651k = w1.g(objArr, i10, h10, 0);
        this.f4655o = new q1(w1.g(objArr, i10, h10, 1), objArr, i10, this);
    }

    public q1(Object obj, Object[] objArr, int i10, q1 q1Var) {
        this.f4651k = obj;
        this.f4652l = objArr;
        this.f4653m = 1;
        this.f4654n = i10;
        this.f4655o = q1Var;
    }
}
