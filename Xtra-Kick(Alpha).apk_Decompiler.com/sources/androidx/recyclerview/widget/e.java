package androidx.recyclerview.widget;

import java.util.List;

public final class e extends t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f1968a;

    public e(f fVar) {
        this.f1968a = fVar;
    }

    public final boolean a(int i10, int i11) {
        f fVar = this.f1968a;
        Object obj = ((List) fVar.f1975j).get(i10);
        Object obj2 = ((List) fVar.f1976k).get(i11);
        if (obj != null && obj2 != null) {
            return ((w) ((h) fVar.f1978m).f2034b.f430k).a(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        throw new AssertionError();
    }

    public final boolean b(int i10, int i11) {
        f fVar = this.f1968a;
        Object obj = ((List) fVar.f1975j).get(i10);
        Object obj2 = ((List) fVar.f1976k).get(i11);
        if (obj != null && obj2 != null) {
            return ((w) ((h) fVar.f1978m).f2034b.f430k).b(obj, obj2);
        }
        if (obj == null && obj2 == null) {
            return true;
        }
        return false;
    }

    public final Object c(int i10, int i11) {
        f fVar = this.f1968a;
        Object obj = ((List) fVar.f1975j).get(i10);
        Object obj2 = ((List) fVar.f1976k).get(i11);
        if (obj == null || obj2 == null) {
            throw new AssertionError();
        }
        ((w) ((h) fVar.f1978m).f2034b.f430k).getClass();
        return null;
    }

    public final int d() {
        return ((List) this.f1968a.f1976k).size();
    }

    public final int e() {
        return ((List) this.f1968a.f1975j).size();
    }
}
