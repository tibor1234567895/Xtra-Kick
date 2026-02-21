package n3;

import kb.i;
import kb.j;
import kb.x;
import la.v;
import pa.e;
import qa.a;
import xa.s;

public final class n2 implements i {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11350h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f11351i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f11352j;

    public /* synthetic */ n2(i iVar, int i10, int i11) {
        this.f11350h = i11;
        this.f11351i = iVar;
        this.f11352j = i10;
    }

    public final Object b(j jVar, e eVar) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11350h;
        i iVar = this.f11351i;
        int i11 = this.f11352j;
        switch (i10) {
            case 0:
                Object b10 = iVar.b(new e2(jVar, i11, 1), eVar);
                if (b10 == aVar) {
                    return b10;
                }
                return v.f9814a;
            default:
                Object b11 = iVar.b(new x(new s(), i11, jVar), eVar);
                if (b11 == aVar) {
                    return b11;
                }
                return v.f9814a;
        }
    }
}
