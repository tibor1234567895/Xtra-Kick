package t9;

import android.support.v4.media.h;
import java.util.ArrayList;
import java.util.List;
import la.i;
import ma.j0;
import ma.s;
import p9.b;
import p9.d;
import p9.f;
import p9.p;
import p9.r;
import p9.u;
import q9.e;

public final class j implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14860h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f14861i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f14862j;

    public /* synthetic */ j(Object obj, int i10, Object obj2) {
        this.f14860h = i10;
        this.f14861i = obj;
        this.f14862j = obj2;
    }

    public final void run() {
        switch (this.f14860h) {
            case 0:
                i iVar = ((k) this.f14861i).f14865j;
                if (iVar != null) {
                    List<i> list = (List) this.f14862j;
                    ArrayList arrayList = new ArrayList(s.i(list));
                    for (i iVar2 : list) {
                        e eVar = (e) ((b) iVar2.f9799h);
                        eVar.getClass();
                        u uVar = new u(eVar.f13435j, eVar.f13436k);
                        uVar.f12723i = eVar.f13437l;
                        uVar.f12724j.putAll(eVar.f13439n);
                        p pVar = eVar.f13444s;
                        xa.j.g("<set-?>", pVar);
                        uVar.f12726l = pVar;
                        r rVar = eVar.f13438m;
                        xa.j.g("<set-?>", rVar);
                        uVar.f12725k = rVar;
                        d dVar = eVar.f13447v;
                        xa.j.g("<set-?>", dVar);
                        uVar.f12728n = dVar;
                        uVar.f12722h = eVar.f13448w;
                        uVar.f12729o = eVar.f13449x;
                        y9.j jVar = eVar.f13450y;
                        xa.j.g("value", jVar);
                        uVar.f12731q = new y9.j(j0.g(jVar.f17264h));
                        int i10 = eVar.f13451z;
                        if (i10 >= 0) {
                            uVar.f12730p = i10;
                            arrayList.add(new i(uVar, iVar2.f9800i));
                        } else {
                            throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
                        }
                    }
                    iVar.a(arrayList);
                    return;
                }
                return;
            case 1:
                ((k) this.f14861i).f14866k.a((f) this.f14862j);
                return;
            case 2:
                i iVar3 = ((k) this.f14861i).f14865j;
                if (iVar3 != null) {
                    iVar3.a((List) this.f14862j);
                    return;
                }
                return;
            case 3:
                ((k) this.f14861i).f14866k.a((f) this.f14862j);
                return;
            case 4:
                i iVar4 = ((l) this.f14861i).f14872l;
                if (iVar4 != null) {
                    iVar4.a((List) this.f14862j);
                    return;
                }
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((l) this.f14861i).f14873m.a((f) this.f14862j);
                return;
            case 6:
                i iVar5 = ((l) this.f14861i).f14872l;
                if (iVar5 != null) {
                    iVar5.a((List) this.f14862j);
                    return;
                }
                return;
            case 7:
                ((l) this.f14861i).f14873m.a((f) this.f14862j);
                return;
            default:
                synchronized (((z5.i) this.f14861i).f17664b) {
                    h.y(this.f14862j);
                    throw null;
                }
        }
    }
}
