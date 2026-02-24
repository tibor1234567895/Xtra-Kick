package r3;

import u3.f;
import wa.l;
import xa.j;
import xa.k;

public final class c extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13661h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f13662i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i10, int i11) {
        super(1);
        this.f13661h = i11;
        this.f13662i = i10;
    }

    public final Object invoke(Object obj) {
        int i10 = this.f13661h;
        int i11 = this.f13662i;
        switch (i10) {
            case 0:
                f fVar = (f) obj;
                j.f("db", fVar);
                fVar.o(i11);
                return null;
            default:
                ((Number) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i11 + '.');
        }
    }
}
