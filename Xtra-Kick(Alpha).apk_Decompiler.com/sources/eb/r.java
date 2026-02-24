package eb;

import java.util.Iterator;
import wa.a;
import wa.l;
import xa.j;

public final class r implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5351a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5352b;

    /* renamed from: c  reason: collision with root package name */
    public final l f5353c;

    public r(h hVar, l lVar, int i10) {
        this.f5351a = i10;
        if (i10 != 1) {
            j.f("sequence", hVar);
            j.f("predicate", lVar);
            this.f5352b = hVar;
            this.f5353c = lVar;
            return;
        }
        j.f("sequence", hVar);
        j.f("transformer", lVar);
        this.f5352b = hVar;
        this.f5353c = lVar;
    }

    public final Iterator iterator() {
        switch (this.f5351a) {
            case 0:
                return new e(this);
            case 1:
                return new s(this);
            default:
                return new g(this);
        }
    }

    public r(a aVar, l lVar) {
        this.f5351a = 2;
        j.f("getNextValue", lVar);
        this.f5352b = aVar;
        this.f5353c = lVar;
    }
}
