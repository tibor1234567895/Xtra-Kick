package lb;

import hb.f0;
import hb.h0;
import java.util.ArrayList;
import jb.a;
import jb.q;
import jb.r;
import jb.s;
import kb.i;
import kb.j;
import la.v;
import ma.z;
import pa.e;
import pa.k;
import pa.l;

public abstract class f implements q {

    /* renamed from: h  reason: collision with root package name */
    public final k f9832h;

    /* renamed from: i  reason: collision with root package name */
    public final int f9833i;

    /* renamed from: j  reason: collision with root package name */
    public final a f9834j;

    public f(k kVar, int i10, a aVar) {
        this.f9832h = kVar;
        this.f9833i = i10;
        this.f9834j = aVar;
    }

    public Object b(j jVar, e eVar) {
        Object H = h0.H(new d((e) null, jVar, this), eVar);
        return H == qa.a.COROUTINE_SUSPENDED ? H : v.f9814a;
    }

    public final i d(k kVar, int i10, a aVar) {
        k kVar2 = this.f9832h;
        k I0 = kVar.I0(kVar2);
        a aVar2 = a.SUSPEND;
        a aVar3 = this.f9834j;
        int i11 = this.f9833i;
        if (aVar == aVar2) {
            if (i11 != -3) {
                if (i10 != -3) {
                    if (i11 != -2) {
                        if (i10 != -2) {
                            i10 += i11;
                            if (i10 < 0) {
                                i10 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i10 = i11;
            }
            aVar = aVar3;
        }
        return (xa.j.a(I0, kVar2) && i10 == i11 && aVar == aVar3) ? this : g(I0, i10, aVar);
    }

    public String e() {
        return null;
    }

    public abstract Object f(r rVar, e eVar);

    public abstract f g(k kVar, int i10, a aVar);

    public i i() {
        return null;
    }

    public s j(f0 f0Var) {
        int i10 = this.f9833i;
        if (i10 == -3) {
            i10 = -2;
        }
        e eVar = new e(this, (e) null);
        q qVar = new q(h0.g1(f0Var, this.f9832h), h0.a(i10, this.f9834j, 4));
        qVar.e0(3, qVar, eVar);
        return qVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String e10 = e();
        if (e10 != null) {
            arrayList.add(e10);
        }
        l lVar = l.f12754h;
        k kVar = this.f9832h;
        if (kVar != lVar) {
            arrayList.add("context=" + kVar);
        }
        int i10 = this.f9833i;
        if (i10 != -3) {
            arrayList.add("capacity=" + i10);
        }
        a aVar = a.SUSPEND;
        a aVar2 = this.f9834j;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + '[' + z.y(arrayList, ", ", (String) null, (String) null, (androidx.fragment.app.k) null, 62) + ']';
    }
}
