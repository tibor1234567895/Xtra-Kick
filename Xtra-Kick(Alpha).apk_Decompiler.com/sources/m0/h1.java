package m0;

import android.view.ViewGroup;
import eb.h;
import eb.i;
import java.util.Iterator;
import q.m;
import qa.d;
import wa.p;
import xa.j;

public final class h1 implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10087a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10088b;

    public /* synthetic */ h1(int i10, Object obj) {
        this.f10087a = i10;
        this.f10088b = obj;
    }

    public final Iterator iterator() {
        int i10 = this.f10087a;
        Object obj = this.f10088b;
        switch (i10) {
            case 0:
                ViewGroup viewGroup = (ViewGroup) obj;
                j.f("<this>", viewGroup);
                return new m(1, viewGroup);
            case 1:
                return ((Iterable) obj).iterator();
            case 2:
                p pVar = (p) obj;
                j.f("block", pVar);
                i iVar = new i();
                iVar.f5348k = d.a(iVar, iVar, pVar);
                return iVar;
            default:
                return (Iterator) obj;
        }
    }
}
