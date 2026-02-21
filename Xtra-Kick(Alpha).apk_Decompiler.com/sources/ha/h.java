package ha;

import androidx.lifecycle.b2;
import androidx.lifecycle.w1;
import b1.f;
import ga.d;
import java.util.Set;

public final class h implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final Set f7771a;

    /* renamed from: b  reason: collision with root package name */
    public final b2 f7772b;

    /* renamed from: c  reason: collision with root package name */
    public final f f7773c;

    public h(Set set, b2 b2Var, d dVar) {
        this.f7771a = set;
        this.f7772b = b2Var;
        this.f7773c = new f(dVar);
    }

    public final w1 a(Class cls) {
        return this.f7771a.contains(cls.getName()) ? this.f7773c.a(cls) : this.f7772b.a(cls);
    }

    public final w1 b(Class cls, f fVar) {
        return this.f7771a.contains(cls.getName()) ? this.f7773c.b(cls, fVar) : this.f7772b.b(cls, fVar);
    }
}
