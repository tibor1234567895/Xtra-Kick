package sb;

import wa.a;
import wb.j;

public final class b extends a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f14461e = 1;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a f14462f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(String str, j jVar) {
        super(str, true);
        this.f14462f = jVar;
    }

    public final long a() {
        int i10 = this.f14461e;
        a aVar = this.f14462f;
        switch (i10) {
            case 0:
                aVar.b();
                return -1;
            default:
                return ((Number) aVar.b()).longValue();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(String str, boolean z10, a aVar) {
        super(str, z10);
        this.f14462f = aVar;
    }
}
