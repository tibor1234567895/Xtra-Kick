package z4;

import h5.i0;
import h5.j0;
import h5.q0;
import pb.f1;
import pb.h;

public final class c implements j0 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f1 f17575b;

    /* renamed from: a  reason: collision with root package name */
    public final h f17576a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c() {
        this(f17575b);
        if (f17575b == null) {
            synchronized (c.class) {
                if (f17575b == null) {
                    f17575b = new f1();
                }
            }
        }
    }

    public final i0 a(q0 q0Var) {
        return new d(0, this.f17576a);
    }

    public final void b() {
    }

    public c(f1 f1Var) {
        this.f17576a = f1Var;
    }
}
