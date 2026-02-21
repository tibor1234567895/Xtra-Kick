package l6;

import a7.e;
import android.support.v4.media.session.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i1;
import n3.v3;
import n3.x3;
import xa.j;
import z6.d;
import z6.f;
import z6.g;

public final class w extends i1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9677a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9679c;

    public /* synthetic */ w(Object obj, int i10, Object obj2) {
        this.f9677a = i10;
        this.f9678b = obj;
        this.f9679c = obj2;
    }

    public final void d(int i10, int i11) {
        int i12 = this.f9677a;
        Object obj = this.f9679c;
        Object obj2 = this.f9678b;
        switch (i12) {
            case 0:
                x3 x3Var = (x3) obj2;
                x3Var.unregisterAdapterDataObserver(this);
                x3Var.registerAdapterDataObserver(new v3(1, (RecyclerView) obj));
                return;
            case 1:
                g gVar = (g) obj2;
                d dVar = gVar.f17756q0;
                if (dVar != null) {
                    dVar.unregisterAdapterDataObserver(this);
                    d dVar2 = gVar.f17756q0;
                    if (dVar2 != null) {
                        dVar2.registerAdapterDataObserver(new f((u) obj, 0));
                        return;
                    } else {
                        j.l("adapter");
                        throw null;
                    }
                } else {
                    j.l("adapter");
                    throw null;
                }
            default:
                e eVar = (e) obj2;
                a7.d dVar3 = eVar.f280q0;
                if (dVar3 != null) {
                    dVar3.unregisterAdapterDataObserver(this);
                    a7.d dVar4 = eVar.f280q0;
                    if (dVar4 != null) {
                        dVar4.registerAdapterDataObserver(new f((u) obj, 1));
                        return;
                    } else {
                        j.l("adapter");
                        throw null;
                    }
                } else {
                    j.l("adapter");
                    throw null;
                }
        }
    }
}
