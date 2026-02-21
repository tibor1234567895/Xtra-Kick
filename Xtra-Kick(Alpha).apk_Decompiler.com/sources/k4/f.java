package k4;

import dc.f0;
import fb.l;
import java.io.Closeable;
import la.v;

public final class f implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final e f9094h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9095i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ i f9096j;

    public f(i iVar, e eVar) {
        this.f9096j = iVar;
        this.f9094h = eVar;
    }

    public final f0 c(int i10) {
        if (!this.f9095i) {
            return (f0) this.f9094h.f9087c.get(i10);
        }
        throw new IllegalStateException("snapshot is closed".toString());
    }

    public final void close() {
        if (!this.f9095i) {
            this.f9095i = true;
            i iVar = this.f9096j;
            synchronized (iVar) {
                e eVar = this.f9094h;
                int i10 = eVar.f9092h - 1;
                eVar.f9092h = i10;
                if (i10 == 0 && eVar.f9090f) {
                    l lVar = i.f9099x;
                    iVar.a0(eVar);
                }
                v vVar = v.f9814a;
            }
        }
    }
}
