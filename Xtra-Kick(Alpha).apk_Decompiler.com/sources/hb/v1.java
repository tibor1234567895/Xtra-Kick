package hb;

import h3.u1;

public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f7867a = new u1("COMPLETING_ALREADY", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final u1 f7868b = new u1("COMPLETING_WAITING_CHILDREN", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final u1 f7869c = new u1("COMPLETING_RETRY", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final u1 f7870d = new u1("TOO_LATE_TO_CANCEL", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final u1 f7871e = new u1("SEALED", 2);

    /* renamed from: f  reason: collision with root package name */
    public static final r0 f7872f = new r0(false);

    /* renamed from: g  reason: collision with root package name */
    public static final r0 f7873g = new r0(true);

    public static final Object a(Object obj) {
        f1 f1Var;
        g1 g1Var = obj instanceof g1 ? (g1) obj : null;
        return (g1Var == null || (f1Var = g1Var.f7796a) == null) ? obj : f1Var;
    }
}
