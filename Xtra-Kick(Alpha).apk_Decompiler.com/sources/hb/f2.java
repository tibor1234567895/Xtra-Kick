package hb;

public final class f2 {

    /* renamed from: a  reason: collision with root package name */
    public static final f2 f7793a = new f2();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f7794b = new ThreadLocal();

    private f2() {
    }

    public static s0 a() {
        ThreadLocal threadLocal = f7794b;
        s0 s0Var = (s0) threadLocal.get();
        if (s0Var != null) {
            return s0Var;
        }
        g gVar = new g(Thread.currentThread());
        threadLocal.set(gVar);
        return gVar;
    }
}
