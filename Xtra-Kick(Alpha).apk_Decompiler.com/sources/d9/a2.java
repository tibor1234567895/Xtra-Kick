package d9;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class a2 extends e2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Set f4590h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Set f4591i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a2(u0 u0Var, u0 u0Var2) {
        super(0);
        this.f4590h = u0Var;
        this.f4591i = u0Var2;
    }

    public final w0 a() {
        return new w0(this);
    }

    public final boolean contains(Object obj) {
        return this.f4590h.contains(obj) && this.f4591i.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        return this.f4590h.containsAll(collection) && this.f4591i.containsAll(collection);
    }

    public final boolean isEmpty() {
        return Collections.disjoint(this.f4591i, this.f4590h);
    }

    public final Iterator iterator() {
        return new w0(this);
    }

    public final int size() {
        int i10 = 0;
        for (Object contains : this.f4590h) {
            if (this.f4591i.contains(contains)) {
                i10++;
            }
        }
        return i10;
    }
}
